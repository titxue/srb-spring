package com.titxu.core.controller.admin;


import com.titxu.common.result.R;
import com.titxu.core.convert.IntegralGradeConvert;
import com.titxu.core.pojo.dto.IntegralGradeRequest;
import com.titxu.core.pojo.dto.IntegralGradeDTO;
import com.titxu.core.pojo.vo.IntegralGradeVO;
import com.titxu.core.service.IntegralGradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("admin/integralGrade")
@Slf4j
public class AdminIntegralGradeController {

    private IntegralGradeService service;
    private IntegralGradeConvert convert;

    @ApiOperation("获取积分等级列表")
    @GetMapping("core")
    public R<List<IntegralGradeVO>> getIntegralGrades() {
        List<IntegralGradeDTO> list = service.getIntegralGradeList();
        log.info("list:{}",list);
        return R.ok().data(convert.toVOs(list));
    }

    @ApiOperation("根据id获取积分等级")
    @GetMapping("core/{id}")
    public R<IntegralGradeVO> getIntegralGradeById(@PathVariable Integer id) {
        IntegralGradeDTO integralGrade = service.getIntegralGradeById(id);
        return R.ok().data(convert.toVO(integralGrade));
    }

    @ApiOperation("添加积分等级")
    @PostMapping("core")
    public R<IntegralGradeVO> addIntegralGrade(@RequestBody IntegralGradeRequest request) {
        IntegralGradeDTO integralGradeDTO = service.addIntegralGrade(request);
        return R.ok().data(convert.toVO(integralGradeDTO));
    }

    @ApiOperation("修改积分等级")
    @PutMapping("core/{id}")
    public R<IntegralGradeVO> updateIntegralGrade(@PathVariable("id") Long id,@RequestBody IntegralGradeRequest request) {
        IntegralGradeDTO integralGradeDTO = service.updateIntegralGrade(id,request);
        return R.ok().data(convert.toVO(integralGradeDTO));
    }

    @ApiOperation("删除积分等级")
    @DeleteMapping("core/{id}")
    public R<String> deleteIntegralGrade(@PathVariable("id") Long id) {
        service.deleteIntegralGrade(id);
        return R.ok();
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

