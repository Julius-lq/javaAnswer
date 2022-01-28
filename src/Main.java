import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Object object = new Object();
        System.out.println(object);
        System.out.println(object.hashCode());
        System.out.println(Objects.hash(object));
    }
}
