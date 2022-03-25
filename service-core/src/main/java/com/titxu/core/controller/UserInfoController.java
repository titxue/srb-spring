package com.titxu.core.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户基本信息 前端控制器
 * </p>
 *
 * @author Lxue
 * @since 2022-03-22
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @GetMapping("/getUserInfo")
    public String getUserInfo(){
        return "getUserInfo";
    }

}

