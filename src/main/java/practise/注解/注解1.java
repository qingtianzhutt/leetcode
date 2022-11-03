package practise.注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class 注解1 {
    /**
     * Created by wuzejian on 2017/5/18.
     * 表注解
     */
    @Target(ElementType.TYPE)//只能应用于类上
    @Retention(RetentionPolicy.RUNTIME)//保存到运行时
    public @interface DBTable {
        String name() default "";
    }


    /**
     * Created by wuzejian on 2017/5/18.
     * 注解Integer类型的字段
     */
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface SQLInteger {
        //该字段对应数据库表列名
        String name() default "";
        //嵌套注解
        Constraints constraint() default @Constraints;
    }


    /**
     * Created by wuzejian on 2017/5/18.
     * 注解String类型的字段
     */
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface SQLString {

        //对应数据库表的列名
        String name() default "";

        //列类型分配的长度，如varchar(30)的30
        int value() default 0;

        Constraints constraint() default @Constraints;
    }


    /**
     * Created by wuzejian on 2017/5/18.
     * 约束注解
     */

    @Target(ElementType.FIELD)//只能应用在字段上
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Constraints {
        //判断是否作为主键约束
        boolean primaryKey() default false;
        //判断是否允许为null
        boolean allowNull() default false;
        //判断是否唯一
        boolean unique() default false;
    }

    /**
     * Created by wuzejian on 2017/5/18.
     * 数据库表Member对应实例类bean
     */
    @DBTable(name = "MEMBER")
    public class Member {
        //主键ID
        @SQLString(name = "ID",value = 50, constraint = @Constraints(primaryKey = true))
        private String id;

        @SQLString(name = "NAME" , value = 30)
        private String name;

        @SQLInteger(name = "AGE")
        private int age;

        @SQLString(name = "DESCRIPTION" ,value = 150 , constraint = @Constraints(allowNull = true))
        private String description;//个人描述

        //省略set get.....
    }
}


