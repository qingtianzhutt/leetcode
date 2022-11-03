package practise.拷贝;

import org.springframework.beans.BeanUtils;

public class copyTest {
    public static void main(String[] args) {
        Computer c = new Computer("hong", "66");
        Room r = new Room();
        System.out.println(c);
        System.out.println(r);
        BeanUtils.copyProperties(c, r);
        System.out.println(r);
    }
}
