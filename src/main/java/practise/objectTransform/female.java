package practise.objectTransform;

import lombok.Data;

import java.util.List;

@Data
public class female {
    private String height;
    private boolean name ;
    private List<Finger> finger;

    @Data
    public static class Finger {
        private String length;
        private String weight;
    }

}
