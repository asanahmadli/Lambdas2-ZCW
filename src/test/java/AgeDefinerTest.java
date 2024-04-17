import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class AgeDefinerTest {

    @Test
    public void test1(){
        LocalDate  localDate = LocalDate.parse("1992-12-30");
        Person.AgeDefiner ageDefiner = new Person.AgeDefiner();
        Person person = new Person("asan", localDate, Person.Sex.FEMALE,"asan@gmail.com");
        Assert.assertTrue(ageDefiner.test(person));
    }

}
