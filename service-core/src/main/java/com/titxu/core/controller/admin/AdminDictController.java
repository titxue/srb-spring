package com.titxu.core.controller.admin;


import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.titxu.common.exception.BusinessException;
import com.titxu.common.result.R;
import com.titxu.common.result.ResponseEnum;
import com.titxu.base.aop.cache.Cacheable;
import com.titxu.core.convert.DictConvert;
import com.titxu.core.pojo.dto.ExcelDictDTO;
import com.titxu.core.pojo.vo.DictVo;
import com.titxu.core.service.DictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@RequestMapping("admin/dict")
@Slf4j
@CrossOrigin
public class AdminDictController {
    private DictService dictService;

    private DictConvert convert;


    @ApiOperation("上传字典文件") //swagger注解
    @PostMapping("importExcel")
    public R batchInsertDict(@ApiParam(value = "数据字典", required = true) @RequestPart("file") MultipartFile file) {
        try {
            InputStream stream = file.getInputStream();
            dictService.importDict(stream);
            return R.ok().msg("导入成功");
        } catch (Exception e) {
            throw new BusinessException(ResponseEnum.UPLOAD_ERROR, e);
        }

    }

    @Cacheable(key = "dict:all")
    @GetMapping
    public R<List<DictVo>> dictList(){
        return R.ok().data(convert.toVo(dictService.getList()));
    }



    /**
     * 文件下载并且失败的时候返回json（默认失败了会返回一个有部分数据的Excel）
     *
     * @since 2.1.1
     */
    @ApiOperation("下载字典文件") //swagger注解
    @GetMapping("download")
    public void downloadFailedUsingJson(HttpServletResponse response) throws IOException {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        try {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            // 生成5位随机数
            String randomNumber ="r"+ (int) (Math.random() * 10000);
            String fileName = URLEncoder.encode(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE) + randomNumber, "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
            // 这里需要设置不关闭流
            EasyExcel.write(response.getOutputStream(), ExcelDictDTO.class).autoCloseStream(Boolean.FALSE).sheet("数据字典")
                    .doWrite(dictService.getDictList());
        } catch (Exception e) {
            // 重置response
            response.reset();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            Map<String, String> map = new HashMap<String, String>();
            map.put("status", "failure");
            map.put("message", "下载文件失败" + e.getMessage());
            response.getWriter().println(JSON.toJSONString(map));
        }
    }

    @Autowired
    public void setDictService(DictService dictService) {
        this.dictService = dictService;
    }

    @Autowired
    public void setConvert(DictConvert convert) {
        this.convert = convert;
    }
}

