package com.titxu.core.mapper;

import com.titxu.core.pojo.entity.Dict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 数据字典 Mapper 接口
 * </p>
 *
 * @author Lxue
 * @since 2022-03-22
 */
public interface DictMapper extends BaseMapper<Dict> {

    Boolean insertBatch(List<Dict> dict);

}
