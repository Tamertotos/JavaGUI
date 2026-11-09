import model.User;
import processing.ObjectProcessor;

public class Main {
    public static void main(String[] args) {
        ObjectProcessor processor = new ObjectProcessor();
        System.out.println("CASE 1: VALID OBJECT");
        User validUser = new User(1,"JanKowalski"
                ,"jan.kowalski@example.com",30,"superSecret123");
        System.out.println(processor.process(validUser));
        System.out.println("======================================");

        System.out.println("CASE 2: VALIDATION ERROR (BLANK USERNAME)");
        User invalidUserBlankName = new User(2,"","anna.nowak@example.com",25,"password");
        System.out.println(processor.process(invalidUserBlankName));


        System.out.println("======================================");
        System.out.println("CASE 3: VALIDATION ERROR (AGE OUT OF RANGE)");
        User invalidUserAge = new User(3,"PiortZielnski","piotr.z@example.com",16,"anotherPass");
        System.out.println(processor.process(invalidUserAge));
    }
}
