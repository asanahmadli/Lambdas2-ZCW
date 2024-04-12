import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {

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
            return Period.between(birthday,LocalDate.now()).getYears();
        }

        public void printPerson() {
            // ...
                System.out.println(this.name);
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

        @Override
        public String toString() {
                return getName() + " " + getBirthday() + " " + getGender() + " " + getEmailAddress();
        }

        public class genderDefiner implements CheckPerson{


                @Override
                public boolean test(Person p) {
                        switch (p.getGender()){
                                case MALE:
                                case FEMALE:
                                        return true;
                                default:
                                        return false;
                        }
                }
        }


        public class ageDefiner implements CheckPerson{

                @Override
                public boolean test(Person p) {
                       return p.getAge() >= 18 && p.getAge() <= 36;
                }
        }


        public class emailDefiner implements CheckPerson{

                @Override
                public boolean test(Person p) {
                        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
                        Matcher matcher = pattern.matcher(p.getEmailAddress());
                        try {
                               if(matcher.find()){
                                       return true;
                               }
                        } catch (Exception e) {
                                System.out.println("Invalid email type, please follow username@password type");
                        }
                    return false;
                }
        }

}
