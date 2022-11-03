package practise.多态;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Cat {
    @JsonProperty("qin")
    private String col;
    @JsonProperty("tao")
    private String age;
}
