package practise.枚举;

public enum  Season1{
    //1.提供当前枚举类的对象，多个对象之间用","隔开，末尾用";",结束
    SPRING("春天","春暖花开"),
    SUMMER("夏天","夏日炎炎"),
    AUTUMN("秋天","秋高气爽"),
    WINTER("冬天","冰天雪地");
    //2.声明Season的属性 需用private final修饰
    private final String season1Name;
    private final String season1Desc;
    //3.私有化类的构造器 并给对象属性赋值
    private Season1(String season1Name,String season1Desc){
        this.season1Name=season1Name;
        this.season1Desc=season1Desc;
    }
    //4.获取枚举类对象的属性


    public String getSeason1Name() {
        return season1Name;
    }

    public String getSeason1Desc() {
        return season1Desc;
    }

}
