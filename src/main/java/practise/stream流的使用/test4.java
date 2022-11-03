package practise.stream流的使用;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class test4 {
    public static void main(String[] args) {
        List<userVO> list = new ArrayList<>();
        userVO u1 = new userVO("hanyaqun","1");
        userVO u2 = new userVO("changyaru","2");
        userVO u3 = new userVO("fanxingchen","3");
        userVO u4 = new userVO("suping","4");
        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);
        List<user2> list2 = list.stream().map(li -> {
            user2 k = new user2();
            k.setNickName(li.getName());
            return k;
        }).collect(Collectors.toList());
        List<String> res = list.stream().map(userVO::getId).collect(Collectors.toList());
    }
}

class userVO{
    private String name;
    private String id;

    public userVO(String name, String id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        userVO userVO = (userVO) o;
        return Objects.equals(name, userVO.name) &&
                Objects.equals(id, userVO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

class user2{
    private String nickName;

    public user2(String nickName) {
        this.nickName = nickName;
    }

    public user2(){}

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "user2{" +
                "nickName='" + nickName + '\'' +
                '}';
    }
}
