package com.titxu.core.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.titxu.core.convert.DictConvert;
import com.titxu.core.listener.ExcelDictDTOLIstener;
import com.titxu.core.pojo.dto.DictDTO;
import com.titxu.core.pojo.dto.ExcelDictDTO;
import com.titxu.core.pojo.entity.Dict;
import com.titxu.core.mapper.DictMapper;
import com.titxu.core.service.DictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.titxu.core.utils.TreeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 数据字典 服务实现类
 * </p>
 *
 * @author Lxue
 * @since 2022-03-22
 */
@Slf4j
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

    private DictConvert convert;
    private TreeUtils treeUtils;

    @Override
    public List<ExcelDictDTO> getDictList() {
        List<Dict> dictList = getBaseMapper().selectList(null);
        return convert.toDictDTO(dictList);
    }

    @Override
    public void importDict(InputStream inputStream) {
        // 读取Excel文件
        EasyExcel.read(inputStream, ExcelDictDTO.class, new ExcelDictDTOLIstener(this)).sheet().doRead();
        log.info("数据字典读取完成");

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveDict(ExcelDictDTO dictDTO) {

        int insert = this.getBaseMapper().insert(convert.toDict(dictDTO));
        if (insert > 0) {
            log.info("保存数据字典成功");
            return true;
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveBatchDict(List<ExcelDictDTO> dictDTO) {
        log.info("批量保存数据字典");
        Boolean batch = this.getBaseMapper().insertBatch(convert.toEntity(dictDTO));
        if (batch) {
            log.info("批量保存数据字典成功");
            return true;
        }
        log.info("批量保存数据字典失败");
        return false;
    }

    /**
     * 把dict表中的数据根据parentId转换成树形结构
     * @return List<DictDTO>
     */
    @Override
    public List<DictDTO> getList() {
        List<Dict> dictList = getBaseMapper().selectList(null);
        List<DictDTO> dictDTOS = convert.toDTOs(dictList);
        List<DictDTO> dictDTOList = treeUtils.getTreeEX(dictList);
        // log.info("转换成树形结构{}", dictDTOList);
        return dictDTOList;
    }


    @Autowired
    public void setConvert(DictConvert convert) {
        this.convert = convert;
    }

    @Autowired
    public void setTreeUtils(TreeUtils treeUtils) {
        this.treeUtils = treeUtils;
    }
}
