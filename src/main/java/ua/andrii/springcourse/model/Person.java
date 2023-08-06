package ua.andrii.springcourse.model;


import javax.validation.constraints.*;

public class Person {
    private int id;
    @NotEmpty(message = "Name could not be empty")
    @Size(min = 2, max = 30, message = "Name size should be between 2 and 30 characters")
    private String name;
    @Min(value = 2, message = "Age should be between 2 and 120")
    @Max(value = 120, message = "Age should be between 2 and 120")
    private int age;
    @NotEmpty(message = "Email could not be empty")
    @Email(message = "This is not an email")
    private String email;

    public Person() {
    }

    public Person(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
