package practise.ObjectMapper;

import lombok.Data;

import java.util.List;

@Data
public class tog {
    private dog dog;

    @Data
    public static class dog{
        private List<Name> name;
    }
    @Data
    private static class Name{
        private String name1;
        private String name2;
    }
}
