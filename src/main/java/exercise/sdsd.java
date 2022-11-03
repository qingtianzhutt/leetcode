package exercise;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import netscape.javascript.JSObject;

import javax.annotation.sql.DataSourceDefinition;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class sdsd {
    public static void main(String[] args) {
       Person p = new Person("123", "1231", "123");
       Object qin = (Object)p;
       System.out.println(qin);
       Person p2 = (Person) qin;
        System.out.println(p2);
        Person2 p3 = (Person2)qin;
        System.out.println(p3);

    }
}


class Person{
    private String name;
    private String age;
    private String bir;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", bir='" + bir + '\'' +
                '}';
    }

    public Person(String name, String age, String bir) {
        this.name = name;
        this.age = age;
        this.bir = bir;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBir() {
        return bir;
    }

    public void setBir(String bir) {
        this.bir = bir;
    }
}
class Person2{
    private String name;
    private String age;
    private String bir;
    private String qin;

    public Person2(String name, String age, String bir, String qin) {
        this.name = name;
        this.age = age;
        this.bir = bir;
        this.qin = qin;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", bir='" + bir + '\'' +
                ", qin='" + qin + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBir() {
        return bir;
    }

    public void setBir(String bir) {
        this.bir = bir;
    }

    public String getQin() {
        return qin;
    }

    public void setQin(String qin) {
        this.qin = qin;
    }
}
class Persion3{

}