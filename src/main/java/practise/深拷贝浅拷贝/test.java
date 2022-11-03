package practise.深拷贝浅拷贝;

public class test {
    public static void main(String[] args) {
        Pen p = new Pen();
        p.setCol("y");
        p.setLen("10");
        Student s = new Student();
        s.setPen(p);
        //这里修改颜色，影响到了引用对象的值，是浅拷贝。
        p.setCol("r");
        System.out.println(s);
    }
}
