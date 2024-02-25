package org.example;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Random;

public class Person {
    private static final String[] firstNames = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
    private static final String[] lastNames = new String[] { "СМИРНОВ", "ИВАНОВ", "КУЗНЕЦОВ", "ПОПОВ", "СОКОЛОВ", "ЛЕБЕДЕВ", "КОЗЛОВ", "НОВИКОВ", "МОРОЗОВ", "ПЕТРОВ" };
    private static final Random random = new Random();
    private String firstName;
    private String lastName;
    private  int age;
    public Person(){}

    private Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public static Person create(String firstName, String lastName, int age) throws RuntimeException{
        if (age < 0){
            new RuntimeException();
            return null;
        }else {
            return new Person(firstName,lastName,age);
        }
    }
    public static Person create(){
        return new  Person(firstNames[random.nextInt(firstNames.length)],
                lastNames[random.nextInt(lastNames.length)],
                random.nextInt( 18,36));
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return new EqualsBuilder()
                .append(age, person.age)
                .append(firstName, person.firstName)
                .append(lastName, person.lastName)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(firstName)
                .append(lastName)
                .append(age)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("age", age)
                .toString();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
