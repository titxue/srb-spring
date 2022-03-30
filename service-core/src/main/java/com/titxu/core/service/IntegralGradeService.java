package com.titxu.core.service;

import com.titxu.core.pojo.dto.IntegralGradeRequest;
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
     * @return 积分等级列表
     */
    List<IntegralGradeDTO> getIntegralGradeList();


    /**
     * 根据id获取积分等级
     * @param id 积分等级id
     * @return 积分等级信息
     */
    IntegralGradeDTO getIntegralGradeById(Integer id);

    /**
     * 添加积分等级
     * @param request 积分等级请求实体
     * @return 添加结果
     */
    IntegralGradeDTO addIntegralGrade(IntegralGradeRequest request);

    /**
     * 修改积分等级
     * @param id 积分等级id
     * @param request 积分等级请求实体
     * @return 修改结果
     */
    IntegralGradeDTO updateIntegralGrade(Long id, IntegralGradeRequest request);

    /**
     * 删除积分等级
     * @param id 积分等级id
     */
    void deleteIntegralGrade(Long id);
}
