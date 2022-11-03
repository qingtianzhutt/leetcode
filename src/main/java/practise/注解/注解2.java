//package practise.注解;
//
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
//
///**
// * Java 8中注解增强  @Repeatable
// * 可以在同一个位置重复相同的注解。
// */
//    //Java8前无法这样使用
//    @FilterPath("/web/update")
//    @FilterPath("/web/add")
//    public class A {}
//
//    @Target(ElementType.TYPE)
//    @Retention(RetentionPolicy.RUNTIME)
//    public @interface FilterPath {
//        String [] value();
//    }
//
//    //使用
//    @FilterPath({"/update","/add"})
//    public class A { }
//
//    @Target(ElementType.TYPE)
//    @Retention(RetentionPolicy.RUNTIME)
//    @interface FilterPaths {
//        FilterPath[] value();
//    }
//
//    //使用案例
//    @FilterPath("/web/update")
//    @FilterPath("/web/add")
//    @FilterPath("/web/delete")
//    class AA{ }
//
