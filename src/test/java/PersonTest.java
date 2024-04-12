import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonTest {

    @Test
    public void test1(){
        Person person = new Person("asan",LocalDate.parse("1992-12-30"), Person.Sex.MALE,"asan@gmail.com");
        List<Person> persons = new ArrayList<>();
        persons.add(person);
        Person.printPersons(persons, new CheckPerson() {
            @Override
            public boolean test(Person p) {
                return false;
            }
        });
    }
}
