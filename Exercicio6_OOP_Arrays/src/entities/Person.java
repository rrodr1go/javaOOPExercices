package entities;

public class Person {
    private String person;
    private int age;
    private double height;

    public Person(String person, int age, double height) {
        this.person = person;
        this.age = age;
        this.height = height;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
