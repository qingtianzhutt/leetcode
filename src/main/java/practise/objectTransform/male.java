package practise.objectTransform;

import lombok.Data;

import java.util.List;

@Data
public class male {
    private String age;
    private String name;
    private List<Finger> finger;

    @Data
    public static class Finger {
        private String length;
        private String weight;
    }

}
