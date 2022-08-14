package com.tianlisir.util;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;

/**
 * 代码生成器
 * @author Another
 */
public class CodeGenerator {
    public static void main(String[] args) {
        //设置数据库相关配置
        DataSourceConfig dataSource = new DataSourceConfig.Builder("jdbc:mysql://localhost:3306/tianli-sir?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC","root","root").build();
        //设置全局配置
        GlobalConfig globalConfig = new GlobalConfig.Builder().disableOpenDir().disableOpenDir()
                .outputDir(System.getProperty("user.dir")+"/TianLi-Sir-Starter/src/main/java/CodeGenerator").author("Another")
                .enableSwagger().dateType(DateType.TIME_PACK).commentDate("yyyy/MM/dd").build();
        //包名相关配置
        PackageConfig packageConfig = new PackageConfig.Builder().parent("com.tianlisir").entity("entity").service("service").serviceImpl("service.impl")
                .mapper("dao").xml("dao.xml").controller("controller").build();
        //注入配置
//        TemplateConfig templateConfig = new TemplateConfig.Builder()..build();

        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig.Builder().enableCapitalMode()
                .enableSkipView()
                // .likeTable(new LikeTable("USER"))
                // .addInclude("t_simple")
                .disableSqlFilter().addTablePrefix("tab_","tianli_")
                //addTableSuffix
                //addFieldPrefix
                //addFieldSuffix
                .build()
                //#Entity 策略配置
                .entityBuilder()
                .enableLombok()
                .enableRemoveIsPrefix()
                .enableTableFieldAnnotation()
//                .enableActiveRecord()
                .versionColumnName("version")
                .versionPropertyName("version")
                .logicDeleteColumnName("is_history")
                .logicDeletePropertyName("deleteFlag")
                .naming(NamingStrategy.no_change)
                .columnNaming(NamingStrategy.underline_to_camel)
                .addTableFills(new Column("create_time", FieldFill.INSERT))
                .addTableFills(new Property("updateTime", FieldFill.INSERT_UPDATE))
                .idType(IdType.ASSIGN_ID)
                //.formatFileName("%sEntity")
                .enableFileOverride()
                .build()
                //#Controller 策略配置
                .controllerBuilder().enableHyphenStyle()
                .enableRestStyle()
                .formatFileName("%sController")
                .enableFileOverride()
                .build()
                //#Service 策略配置
                .serviceBuilder()
                .formatServiceFileName("%sService")
                .formatServiceImplFileName("%sServiceImpl")
                .enableFileOverride()
                .build()
                //#Mapper 策略配置
                .mapperBuilder()
                .enableMapperAnnotation()
                .enableBaseResultMap()
                .enableBaseColumnList()
                .formatMapperFileName("%sDao")
                .formatXmlFileName("%sXml")
                .enableFileOverride()
                .build();

        //获取代码生成的对象
        AutoGenerator generator = new AutoGenerator(dataSource);

        //全局配置
        generator.global(globalConfig);
        //指定包配置信息
        generator.packageInfo(packageConfig);
        //策略配置
        generator.strategy(strategyConfig);
        //执行操作
        generator.execute();



    }
}
