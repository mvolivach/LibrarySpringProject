package ua.volivach.library.models;

import jakarta.validation.constraints.*;

public class Book {
    private int id;

    @NotEmpty(message = "Name should not be empty")
    private String name;

    @NotEmpty(message = "Author should not be empty")
    @Pattern(regexp = "[A-Z][a-z]+ [A-Z][a-z]+ [A-Z][a-z]+", message = "Author should be valid in next format: Name Surname Patronymic")
    private String author;

    @Min(value = 0, message = "Year should be greater than 0")
    @Max(value = 2025, message = "Birth year should be not greater than 2025")
    private int year;

    public Book(int id, String name, String author, int year) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public Book(){}

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
