package person;

public class Main {
    public static void main(String[] args) {
        Person john = new Person(true, "John");
        Person ann = new Person(false, "Ann");
        john.marry(ann);
        System.out.println(john.getName() + " is married to " + john.getSpouse().getName() + ".");
        Person mary = new Person(false, "Mary");
        john.marry(mary);
        System.out.println("Now " + john.getName() + " is married to " + john.getSpouse().getName() + ".");
        if (ann.getSpouse() == null) {
            System.out.println("So " + ann.getName() + " is alone.");
        }
    }
}
