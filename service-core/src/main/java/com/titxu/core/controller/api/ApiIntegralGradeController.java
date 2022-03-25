package com.titxu.core.controller.api;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 积分等级表 前端控制器
 * </p>
 *
 * @author Lxue
 * @since 2022-03-22
 */
@Api(tags = "积分等级接口")
@RestController
@RequestMapping("api/integralGrade")
public class ApiIntegralGradeController {

    @GetMapping("test")
    public String test(){
        return "test";
    }

}

