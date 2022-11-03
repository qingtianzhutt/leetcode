package practise.Optional;

import lombok.Data;

@Data
public class PersonTest {
    private String name;
    private String age;
    private String height;

    public PersonTest(String name, String age, String height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }
}
