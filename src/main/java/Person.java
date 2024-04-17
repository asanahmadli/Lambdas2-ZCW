import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person implements CheckPerson {

    @Override
    public boolean test(Person p) {
        return true;
    }

    public enum Sex {
        MALE, FEMALE
    }

    private String name;
    private LocalDate birthday;
    private Sex gender;
    private String emailAddress;
    private List<Person> roster;

    public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public int getAge() {
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    public void printPerson() {
        System.out.println(toString());
    }

    public static void printPersons(
            List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<Person> getRoster() {
        return roster;
    }

    public void setRoster(List<Person> roster) {
        this.roster = roster;
    }

    @Override
    public String toString() {
        return getName() + " " + getBirthday() + " " + getGender() + " " + getEmailAddress();
    }

    public static class GenderDefiner implements CheckPerson {

        @Override
        public boolean test(Person p) {
            switch (p.getGender()) {
                case MALE:
                case FEMALE:
                    return true;
                default:
                    return false;
            }
        }
    }


    public static class AgeDefiner implements CheckPerson {

        @Override
        public boolean test(Person p) {
            return p.getAge() >= 18 && p.getAge() <= 36;
        }

    }


    public static class EmailDefiner implements CheckPerson {

        @Override
        public boolean test(Person p) {
            Pattern pattern = Pattern.compile("^(.+)@(.+)$");

            try {
                Matcher matcher = pattern.matcher(p.getEmailAddress());
                if (matcher.find()) {
                    return true;
                }
            } catch (Exception e) {
                System.out.println("Invalid email type, please follow username@password type");
            }
            return false;
        }
    }

    public static void main(String[] args) {
        String name = "asan";
        String reverseName = "";
        for (int i = name.length() - 1; i >= 0; i--) {
            reverseName += name.charAt(i);
        }
        System.out.println(reverseName);


        //find occurence
        String s1 = "aabbaccddee";  //3a2b2c2d2e
        String s2 = "";
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            count = 0;
            if (!s2.contains(s1.charAt(i) + "")) {
                for (int j = 0; j < s1.length(); j++) {
                    if (s1.charAt(i) == s1.charAt(j)) {
                        count++;
                    }
                }
            }
            if (count > 0) {
                s2 += count + (s1.charAt(i) + "");
            }


        }
        System.out.println(s2);

    }
}
