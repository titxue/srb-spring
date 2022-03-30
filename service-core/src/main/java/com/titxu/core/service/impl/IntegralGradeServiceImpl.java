package com.titxu.core.service.impl;

import com.titxu.core.convert.IntegralGradeConvert;
import com.titxu.core.pojo.dto.IntegralGradeRequest;
import com.titxu.core.pojo.dto.IntegralGradeDTO;
import com.titxu.core.pojo.entity.IntegralGrade;
import com.titxu.core.mapper.IntegralGradeMapper;
import com.titxu.core.service.IntegralGradeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return convert.toDTOs(integralGrades);
    }

    @Override
    public IntegralGradeDTO getIntegralGradeById(Integer id) {
        return convert.toDTO(this.getBaseMapper().selectById(id));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public IntegralGradeDTO addIntegralGrade(IntegralGradeRequest request) {
        IntegralGrade integralGrade = getEntity(request);
        this.getBaseMapper().insert(integralGrade);
        return convert.toDTO(integralGrade);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public IntegralGradeDTO updateIntegralGrade(Long id, IntegralGradeRequest request) {
        IntegralGrade integralGrade = getEntity(request);
        integralGrade.setId(id);
        this.getBaseMapper().updateById(integralGrade);
        return convert.toDTO(integralGrade);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteIntegralGrade(Long id) {
        int delete = this.getBaseMapper().deleteById(id);
        if (delete == 0) {
            throw new RuntimeException("删除失败");
        }
    }

    /**
     * 获取实体
     * @param request 请求实体
     * @return 实体
     */
    protected IntegralGrade getEntity(IntegralGradeRequest request){
        return convert.toEntity(request);
    }


    @Autowired
    public void setConvert(IntegralGradeConvert convert) {
        this.convert = convert;
    }
}
