import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class GenderDefinerTest {
    @Test
    public void test1(){
        Person.Sex gender = Person.Sex.valueOf("FEMALE");
        Person.GenderDefiner genderDefiner = new Person.GenderDefiner();
        Person person = new Person("coni", LocalDate.parse("1982-12-30"), gender,"asan@gmail.com");
        Assert.assertTrue(genderDefiner.test(person));
    }
}
