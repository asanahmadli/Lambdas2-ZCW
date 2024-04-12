import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Person {

        public enum Sex {
            MALE, FEMALE
        }

        private String name;
        private LocalDate birthday;
        private Sex gender;
        private String emailAddress;
        private List<Person> roster;

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


}
