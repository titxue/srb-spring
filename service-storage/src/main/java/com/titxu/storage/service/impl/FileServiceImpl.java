package com.titxu.storage.service.impl;

import com.titxu.common.exception.Assert;
import com.titxu.common.exception.BusinessException;
import com.titxu.common.result.ResponseEnum;
import com.titxu.storage.convert.FileConvert;
import com.titxu.storage.mapper.FileMapper;
import com.titxu.storage.pojo.dto.FileDTO;
import com.titxu.storage.pojo.dto.FileUploadDto;
import com.titxu.storage.pojo.dto.FileUploadRequest;
import com.titxu.storage.pojo.entity.File;
import com.titxu.storage.pojo.enums.FileStatus;
import com.titxu.storage.pojo.enums.Storage;
import com.titxu.storage.service.FileService;
import com.titxu.storage.service.StorageService;
import com.titxu.storage.utils.FileTypeTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;


@Service
@Slf4j
public class FileServiceImpl implements FileService {

    private FileMapper fileMapper;

    private FileConvert fileConvert;

    private Map<String, StorageService> storageServices;


    @Transactional
    @Override
    public FileUploadDto getSignature(FileUploadRequest fileUploadRequest) {
        // 创建file实体
        File file = fileConvert.createEntity(fileUploadRequest);
        // 获取文件类型,并设置到文件实体
        file.setType(FileTypeTransformer.getFileTypeFromExt(fileUploadRequest.getExt()));
        // 获取储存服务类型
        file.setStorage(getDefaultStorage());
        // 填充日期,创建人等数据
        setBaseData(file);

        // 创建新的数据
        fileMapper.insert(file);


        // 获取STS
        FileUploadDto fileUploadDto = storageServices.get(file.getStorage().name()).getScrip();

        fileUploadDto.setFileKey(file.getFileKey());
        fileUploadDto.setFileId(file.getId());
        // log.info(fileUploadDto.toString());
        return fileUploadDto;
    }

    @Transactional
    @Override
    public FileDTO finish(Long id) {
        Optional<File> fileOptional = Optional.ofNullable(fileMapper.selectById(id));

        // 文件不存在 抛出异常
        Assert.isTrue(fileOptional.isPresent(), ResponseEnum.FILE_NOT_FOUND);

        File file = fileOptional.get();
        file.setStatus(FileStatus.UPLOADED);
        fileMapper.updateById(file);
        log.info("file:{}", file);
        return fileConvert.toDto(file);
    }

    @Transactional
    @Override
    public FileDTO delete(Long id) {
        Optional<File> fileOptional = Optional.ofNullable(fileMapper.selectById(id));

        // 文件不存在 抛出异常
        Assert.isTrue(fileOptional.isPresent(), ResponseEnum.FILE_NOT_FOUND);
        File file = fileOptional.get();

        // 删除远程对象储存的文件

        // 删除文件数据库记录
        int i = fileMapper.deleteById(file);
        Assert.isTrue(i == 1, ResponseEnum.FILE_DELETE_FAIL);


        return fileConvert.toDto(file);
    }

    // TODO: 填充日期,创建人等数据
    private void setBaseData(File file) {
        // 临时测试数据
        LocalDateTime now = LocalDateTime.now();
        file.setCreateBy("test");
        file.setCreateTime(now);
        file.setUpdateBy("test");
        file.setUpdateTime(now);
    }

    // Todo: 后台设置当前Storage
    private Storage getDefaultStorage() {
        return Storage.OSS;
    }

    @Autowired
    public void setFileMapper(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    @Autowired
    public void setFileConvert(FileConvert fileConvert) {
        this.fileConvert = fileConvert;
    }

    @Autowired
    public void setStorageService(Map<String, StorageService> storageServices) {
        this.storageServices = storageServices;
    }
}
