package practise.多态;

import java.io.Serializable;
import java.util.List;

public class ListPerson implements Serializable {


    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    private List<Person> persons;
}
