import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class EmailDefinerTest {
    @Test
    public void test1(){
        String email = "asan@gmail.com";
        Person.EmailDefiner emailDefiner = new Person.EmailDefiner();
        Person person = new Person("asan", LocalDate.parse("1992-12-30"), Person.Sex.FEMALE,email);
        Assert.assertTrue(emailDefiner.test(person));
    }
}
