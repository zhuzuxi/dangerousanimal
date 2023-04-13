package com.dangerousanimal.Config;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class Generator {


    public static void main(String[] args) {

        AutoGenerator autoGenerator = new AutoGenerator();
//        数据源配置
        DataSourceConfig dataSourceConfig=new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/dangerousanimal?serverTimezone=GMT%2B8&useSSL=true");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");
        autoGenerator.setDataSource(dataSourceConfig);

//        设置全局变量
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(System.getProperty("user.dir")+"/src/main/java");//生成模板
        globalConfig.setOpen(false);//生成文件之后是否打开资源管理器
        globalConfig.setAuthor("zzs");//设置作者名
        globalConfig.setFileOverride(false);//是否覆盖同名文件
        globalConfig.setMapperName("%sDao");//设置Mapper的名称 这里叫做xxxDao
        globalConfig.setIdType(IdType.ASSIGN_ID);//MyBatis-Plus 会在插入数据时使用雪花算法生成全局唯一的 ID 作为主键。
        autoGenerator.setGlobalConfig(globalConfig);


//        包相关配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.dangerousanimal");//设置父包名
        packageConfig.setEntity("Entity");//实体类存放的包名为Entity
        packageConfig.setMapper("Dao");//Mapper类存放的包名为Dao
        packageConfig.setController("Controller");//Controller类存放的包名为Controller
        autoGenerator.setPackageInfo(packageConfig);

//        策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
//        strategyConfig.setInclude("user");
        strategyConfig.setInclude("order_desc");//其中输入需要代码生成器需要生成的数据库中的表名
        strategyConfig.setEntityLombokModel(true);//是否为实体类进行Lombok的注解
        strategyConfig.setRestControllerStyle(true);//是否生成Restful风格的Controller
        strategyConfig.setLogicDeleteFieldName("deleted");//在生成的实体类中添加一个名为 "deleted" 的逻辑删除字段，并在进行数据库操作时将其自动处理为相应的 SQL 语句。
        strategyConfig.setVersionFieldName("version");
        autoGenerator.setStrategy(strategyConfig);
        autoGenerator.execute();
    }
}
