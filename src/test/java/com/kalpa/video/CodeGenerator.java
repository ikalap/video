package com.kalpa.video;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Collections;

/**
 * mybatis代码生成器
 * https://github.com/baomidou/generator
 */
@Slf4j
public class CodeGenerator {

    // ================= 以下内容需要手动配置  =================
    /**
     * 数据库连接串
     */
    private static final DataSourceConfig DATA_SOURCE_CONFIG = new DataSourceConfig.Builder(
            "jdbc:mysql://124.223.74.95:3306/pet?characterEncoding=utf8&useSSL=false&autoReconnect=true",
            "root",
            "mysql_nr3e4t")
            .build();
    /**
     * 文件包目录
     */
    private final String parentPackageName = "com.kalpa.video";
    /**
     * 需要生成哪几张表
     */
    private final String[] tableNames = {"type"};

    // ================= 以上内容需要手动配置  =================

    private final String module_path = System.getProperty("user.dir") + "/src/main/";
    private final String mapperPath = module_path + "/resources/mapper/";//mapper.xml文件放的位置
    private final String author = "mybatisplus-generator";//代码的作者

    @Test
    public void generate() {
        execute(tableNames);
    }

    public void execute(final String[] tableNames) {
        new AutoGenerator(DATA_SOURCE_CONFIG)
                .global(new GlobalConfig.Builder()
                        .author(author)
                        .outputDir(module_path + "/java/")
                        .disableOpenDir().build()
                )
                .packageInfo(
                        new PackageConfig.Builder()
                                .parent(parentPackageName)
                                .controller("controller")
                                .service("service")
                                .mapper("repository.mapper")
                                .entity("repository.po")
                                .xml("mapper.xml")
                                .pathInfo(Collections.singletonMap(OutputFile.xml, mapperPath))
                                .build()
                )
                //自定义文件
                .injection(
                        new InjectionConfig.Builder()
                                .customFile(
                                        file -> file.fileName("DTO.java")
                                                .templatePath("/templates/dto.java.vm")
                                                .packageName("model")
                                )
                                .customFile(
                                        file -> file.fileName("Repository.java")
                                                .templatePath("/templates/dao.java.vm")
                                                .packageName("repository")
                                )
                                .build()
                )
                //策略配置
                .strategy(
                        new StrategyConfig.Builder().addInclude(tableNames)
//                            .addTablePrefix("t_")

                                // == controller
                                .controllerBuilder()
//                            .enableRestStyle()//生成的controller自带@RestController注解
//                            .enableHyphenStyle()//开启驼峰转连字符
//                            .enableFileOverride() //覆盖已生成文件

                                // == Service 层生成设置
                                .serviceBuilder()
                                .formatServiceFileName("%sService")
                                .formatServiceImplFileName("%sServiceImpl")
//                            .enableFileOverride()

                                // == mapper
                                .mapperBuilder()
                                .enableBaseResultMap()
                                .enableBaseColumnList()
                                .mapperBuilder()
//                                .enableFileOverride()

                                // == Entity
                                .entityBuilder()
                                .entityBuilder()//表示再次生成会覆盖，建议entity和mapper层覆盖
                                .enableChainModel()
                                .enableLombok()
                                .enableTableFieldAnnotation()
                                .logicDeletePropertyName("state")//逻辑删除
                                .versionColumnName("version") // 乐观锁
                                .formatFileName("%s")
//                                .enableFileOverride()
//                            .logicDeleteColumnName("deleted")
//                            .logicDeletePropertyName("state")
//                            .versionPropertyName("version")
//                            .addTableFills(new Column("create_at", FieldFill.INSERT))
//                            .addTableFills(new Column("updated_at", FieldFill.INSERT_UPDATE))

                                .build()
                ).execute();

    }
}
