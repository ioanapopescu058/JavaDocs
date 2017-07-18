package ro.teamnet.zth.web;

/**
 * Created by Ioana.Popescu on 7/18/2017.
 */
public class Person
{
    private String firstName;
    private String lastName;
    private Integer age;
    private Boolean married;

    public Person(String firstName, String lastName, Integer age, Boolean married) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.married = married;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    @Override
    public String toString() {
        return "First Name: " + firstName + " Last Name: " + lastName + " Age: " + age + " Married: " + married;
    }
}
