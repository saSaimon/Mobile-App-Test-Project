import java.sql.SQLOutput;

public class Person {
    String name;
    int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void sayHello(){
        System.out.println("Hello, my name is "+name+" and I am "+age+" year");
    }

    Person john = new Person("John", 30);
}



