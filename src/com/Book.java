package com;

import ua.Invokable;
import ua.Reset;

import java.util.Objects;

public class Book  {

    private String title;
    @Reset(name = "Unknown")
    @Deprecated
    protected String author;
    private int year;
    private int circulation;
    private int pageNumber;



    public Book(String title, String author, int year, int circulation, int pageNumber) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.circulation = circulation;
        this.pageNumber = pageNumber;
    }

    @Override
    @Invokable
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", circulation=" + circulation +
                ", pageNumber=" + pageNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pageNumber == book.pageNumber &&
                title.equals(book.title) &&
                author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, pageNumber);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getCirculation() {
        return circulation;
    }

    public void setCirculation(int circulation) {
        this.circulation = circulation;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
