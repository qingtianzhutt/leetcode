package practise.拷贝;

import lombok.Data;

@Data
public class Computer {
    private String color;
    private String hair;

    public Computer(String color, String hair) {
        this.color = color;
        this.hair = hair;
    }
}
