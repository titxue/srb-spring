package com.titxu.core.service.impl;

import com.titxu.core.convert.IntegralGradeConvert;
import com.titxu.core.pojo.dto.IntegralGradeDTO;
import com.titxu.core.pojo.entity.IntegralGrade;
import com.titxu.core.mapper.IntegralGradeMapper;
import com.titxu.core.service.IntegralGradeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 积分等级表 服务实现类
 * </p>
 *
 * @author Lxue
 * @since 2022-03-22
 */
@Service
public class IntegralGradeServiceImpl extends ServiceImpl<IntegralGradeMapper, IntegralGrade> implements IntegralGradeService {

    private IntegralGradeConvert convert;

    @Override
    public List<IntegralGradeDTO> getIntegralGradeList() {
        List<IntegralGrade> integralGrades = this.getBaseMapper().selectList(null);
        System.out.println(integralGrades);
        return convert.toDTOs(integralGrades);
    }

    @Override
    public IntegralGradeDTO getIntegralGradeById(Integer id) {
        return convert.toDTO(this.getBaseMapper().selectById(id));
    }


    @Autowired
    public void setConvert(IntegralGradeConvert convert) {
        this.convert = convert;
    }
}
