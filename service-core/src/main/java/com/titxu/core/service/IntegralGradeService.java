package com.titxu.core.service;

import com.titxu.core.pojo.dto.IntegralGradeDTO;
import com.titxu.core.pojo.entity.IntegralGrade;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 积分等级表 服务类
 * </p>
 *
 * @author Lxue
 * @since 2022-03-22
 */
public interface IntegralGradeService extends IService<IntegralGrade> {


    /**
     * 获取所有积分等级
     * @return
     */
    List<IntegralGradeDTO> getIntegralGradeList();


    IntegralGradeDTO getIntegralGradeById(Integer id);

}
