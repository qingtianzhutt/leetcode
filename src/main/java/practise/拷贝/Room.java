package practise.拷贝;

import lombok.Data;

@Data
public class Room {
    private String color;
    private String size;

    public Room(String color, String size) {
        this.color = color;
        this.size = size;
    }

    public Room() {
    }
}
