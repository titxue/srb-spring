package com.titxu.core;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class CodeGenerator {

    @Test
    public void genCode() {

        String projectPath = System.getProperty("user.dir");
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/srb?serverTimezone=GMT%2B8&characterEncoding=utf-8", "root", "159919")
                .globalConfig(builder -> {
                    builder.author("lxue") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(projectPath + "/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.titxu.core") // 设置父包名
                            .moduleName("service-core") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "src/main/resources/mapper")); // 设置mapperXml生成路径
                })
                // .strategyConfig(builder -> {
                //     builder.addInclude("t_simple") // 设置需要生成的表名
                //             .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                // })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }
}