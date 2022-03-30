package com.titxu.core.service;

import com.titxu.core.pojo.dto.DictDTO;
import com.titxu.core.pojo.dto.ExcelDictDTO;
import com.titxu.core.pojo.entity.Dict;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * 数据字典 服务类
 * </p>
 *
 * @author Lxue
 * @since 2022-03-22
 */
public interface DictService extends IService<Dict> {

    /**
     * 获取数据字典列表
     * @return
     */
    List<ExcelDictDTO> getDictList();

    /**
     * 读取导入的数据字典
     */
    void importDict(InputStream inputStream);


    /**
     * 保存到数据库
     * @param dictDTO
     * @return
     */
    Boolean saveDict(ExcelDictDTO dictDTO);

    /**
     * 批量保存到数据库
     * @param dictDTO
     * @return
     */
    Boolean saveBatchDict(List<ExcelDictDTO> dictDTO);

    List<DictDTO> getList();
}
