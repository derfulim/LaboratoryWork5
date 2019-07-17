package com;

import ua.Invokable;
import ua.Reset;

import java.util.Objects;

public class LibraryBook extends Book {

    private int inventoryNumber;
    @Reset(name = "Nobody")
    private String reader;

    public LibraryBook(String title, String author, int year, int circulation, int pageNumber, int inventoryNumber, String reader) {
        super(title, author, year, circulation, pageNumber);
        this.inventoryNumber = inventoryNumber;
        this.reader = reader;
    }

    public int getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(int inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public String getReader() {
        return reader;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LibraryBook that = (LibraryBook) o;
        return inventoryNumber == that.inventoryNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), inventoryNumber);
    }

    public void setReader(String reader) {
        this.reader = reader;
    }

    @Invokable
    @Override
    public String toString() {
        return  "LibraryBook{" + super.toString()+
                "inventoryNumber=" + inventoryNumber +
                ", reader='" + reader + '\'' +
                '}';


    }
}
