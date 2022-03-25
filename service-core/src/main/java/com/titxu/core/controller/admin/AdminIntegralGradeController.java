package com.titxu.core.controller.admin;


import com.titxu.common.result.R;
import com.titxu.core.convert.IntegralGradeConvert;
import com.titxu.core.mapper.IntegralGradeMapper;
import com.titxu.core.pojo.dto.IntegralGradeDTO;
import com.titxu.core.pojo.entity.IntegralGrade;
import com.titxu.core.pojo.vo.IntegralGradeVO;
import com.titxu.core.service.IntegralGradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 积分等级表 前端控制器
 * </p>
 *
 * @author Lxue
 * @since 2022-03-22
 */
@Api(tags = "积分等级管理")
@RestController
@RequestMapping("admin/core/integralGrade")
@Slf4j
@CrossOrigin
public class AdminIntegralGradeController {

    private IntegralGradeService service;
    private IntegralGradeConvert convert;

    @ApiOperation("获取积分等级列表")
    @GetMapping("list")
    public R<List<IntegralGradeVO>> getIntegralGrades() {
        List<IntegralGradeDTO> list = service.getIntegralGradeList();
        return R.ok().data(convert.toVOs(list));
    }

    @ApiOperation("根据id获取积分等级")
    @GetMapping("get/{id}")
    public R<IntegralGradeVO> getIntegralGradeById(Integer id) {
        IntegralGradeDTO integralGrade = service.getIntegralGradeById(id);
        return R.ok().data(convert.toVO(integralGrade));
    }

    @Autowired
    public void setService(IntegralGradeService service) {
        this.service = service;
    }

    @Autowired
    public void setConvert(IntegralGradeConvert convert) {
        this.convert = convert;
    }
}

