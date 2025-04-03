package ua.volivach.library.models;

import jakarta.validation.constraints.*;

public class Person {
    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Pattern(regexp = "[A-Z][a-z]+ [A-Z][a-z]+ [A-Z][a-z]+", message = "Full name should be valid in next format: Name Surname Patronymic")
    private String fullname;

    @Min(value = 1900, message = "Birth year should be greater than 1900")
    @Max(value = 2025, message = "Birth year should be not greater than 2025")
    @NotNull
    private int birthyear;

    public Person(int id, String fullname, int birthyear) {
        this.id = id;
        this.fullname = fullname;
        this.birthyear = birthyear;
    }

    public Person(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getBirthyear() {
        return birthyear;
    }

    public void setBirthyear(int birthyear) {
        this.birthyear = birthyear;
    }
}
