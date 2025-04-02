package ua.volivach.library.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class Person {
    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Pattern(regexp = "[A-Z][a-z]+ [A-Z][a-z]+ [A-Z][a-z]+", message = "Full name should be valid in next format: Name Surname Patronymic")
    private String fullName;

    @NotEmpty(message = "Birth year should not be empty")
    @Min(value = 1900, message = "Birth year should be greater than 1900")
    private int birthYear;

    public Person(int id, String fullName, int birthYear) {
        this.id = id;
        this.fullName = fullName;
        this.birthYear = birthYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
}
