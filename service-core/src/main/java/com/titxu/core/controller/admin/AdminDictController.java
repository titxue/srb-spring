package com.titxu.core.controller.admin;


import com.titxu.common.exception.BusinessException;
import com.titxu.common.result.R;
import com.titxu.common.result.ResponseEnum;
import com.titxu.core.service.DictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 * 数据字典 前端控制器
 * </p>
 *
 * @author Lxue
 * @since 2022-03-22
 */
@Api(tags = "数据字典管理")
@RestController
@RequestMapping("admin/core/dict")
@Slf4j
@CrossOrigin
public class AdminDictController {
    private DictService dictService;


    @ApiOperation("上传字典文件") //swagger注解
    @PostMapping("importExcel")
    public R batchInsertDict(@ApiParam(value = "数据字典", required = true) @RequestPart("file") MultipartFile file) {
        try {
            InputStream stream = file.getInputStream();
            dictService.importDict(stream);
            return R.ok().msg("导入成功");
        }catch (Exception e){
            throw new BusinessException(ResponseEnum.UPLOAD_ERROR,e);
        }

    }

    @Autowired
    public void setDictService(DictService dictService) {
        this.dictService = dictService;
    }
}

