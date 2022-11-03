package practise.注解.annotation;


import java.lang.annotation.*;

@Target(ElementType.FIELD)   //注解用在什么地方
@Retention(RetentionPolicy.RUNTIME)//定义注解的生命周期
@Documented //是否将注解信息添加在java文档中
public @interface FruitName {
    String value() default "";
}
