package com.titxu.storage.controller;


import com.titxu.common.result.R;
import com.titxu.storage.convert.FileConvert;
import com.titxu.storage.convert.FileUploadConvert;
import com.titxu.storage.pojo.dto.FileUploadRequest;
import com.titxu.storage.service.FileService;
import com.titxu.storage.pojo.vo.FileUploadVo;
import com.titxu.storage.pojo.vo.FileVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/file")
public class FileController {

    private FileService fileService;

    private FileConvert fileConvert;

    private FileUploadConvert fileUploadConvert;


    @PostMapping("getSign")
    public R<FileUploadVo> getSignature(@RequestBody @Validated FileUploadRequest fileUploadRequest){
        return R.ok().data(fileUploadConvert.toVO(fileService.getSignature(fileUploadRequest)));
    }


    @PostMapping("{id}/finish")
    public FileVo finish(@PathVariable Long id) {
        return fileConvert.toVO(fileService.finish(id));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Long id) {
        return R.ok().data(fileConvert.toVO(fileService.delete(id)));
    }

    @Autowired
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    @Autowired
    public void setFileConvert(FileConvert fileConvert) {
        this.fileConvert = fileConvert;
    }

    @Autowired
    public void setFileUploadMapper(FileUploadConvert fileUploadConvert) {
        this.fileUploadConvert = fileUploadConvert;
    }
}
