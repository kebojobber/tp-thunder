package com.thunder.base;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.BeetlTemplateEngine;
import org.springframework.util.StringUtils;

import java.util.Scanner;

/**
 * @author Willard
 * @date 2019/10/15
 */
public class MybatisPlusGenerator {

    public static String DBURL = "jdbc:mysql://10.1.16.190:3306/zx_product?useUnicode=true&characterEncoding=utf8&useSSL=false&allowMultiQueries=true&serverTimezone=Asia/Shanghai";
    public static String DBUSERNAME = "root";
    public static String DBPASSWORD = "groot";

    public static String MODULENAME = "base";

    public static void main(String[] args) {

        /**
         * 生成器全局配置
         */
        GlobalConfig globalConfig = new GlobalConfig();

        //项目路径
        String projectPath = System.getProperty("user.dir");
        String daoProjectPath = "/thunder-base/base-dao";
        globalConfig.setOutputDir(projectPath + daoProjectPath + "/src/main/java");
        globalConfig.setAuthor("thunder");
        globalConfig.setOpen(false);
        globalConfig.setFileOverride(true);
        globalConfig.setDateType(DateType.ONLY_DATE);
        /**
         * 数据源配置
         */
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setUrl(DBURL);
        //dsc.setSchemaName("public");
        dsConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dsConfig.setUsername(DBUSERNAME);
        dsConfig.setPassword(DBPASSWORD);

        /**
         * 输入模块名称
         */
        String moduleName;
        if (StringUtils.isEmpty(MODULENAME)) {
            moduleName = scanner("模块名");
        } else {
            moduleName = MODULENAME;
        }
        /**
         * 输入表名
         */
        String tableNames = scanner("表名");

        for (String tableName : tableNames.split(",")) {

            //代码生成器
            AutoGenerator generator = new AutoGenerator();
            //切换模板引擎
            generator.setTemplateEngine(new BeetlTemplateEngine());
            generator.setGlobalConfig(globalConfig);
            generator.setDataSource(dsConfig);

            /**
             * 包配置
             */
            PackageConfig packageConfig = new PackageConfig();
            packageConfig.setParent("com.thunder." + moduleName);

            packageConfig.setEntity("domain");
            packageConfig.setMapper("mapper");
            packageConfig.setService("service");
            packageConfig.setServiceImpl("service.impl");
            packageConfig.setXml("mapper");
            generator.setPackageInfo(packageConfig);
            /**
             * 设置模板引擎
             */
            TemplateConfig tpc = new TemplateConfig();
            //不生成controller，mapper,xml,service等也可以同理生成
            tpc.setController(null);
            generator.setTemplate(tpc);

            /**
             * 策略配置
             */
            StrategyConfig strategy = new StrategyConfig();
            //下划线转驼峰
            strategy.setNaming(NamingStrategy.underline_to_camel);
            strategy.setColumnNaming(NamingStrategy.underline_to_camel);
            strategy.setEntityLombokModel(true);
            strategy.setRestControllerStyle(false);
            strategy.setInclude(tableName);
            strategy.setControllerMappingHyphenStyle(true);
            strategy.setTablePrefix(packageConfig.getModuleName() + "-");

            generator.setStrategy(strategy);
            generator.setTemplateEngine(new BeetlTemplateEngine());

            generator.execute();

        }

    }


    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + ":");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (!StringUtils.isEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "!");
    }
}
