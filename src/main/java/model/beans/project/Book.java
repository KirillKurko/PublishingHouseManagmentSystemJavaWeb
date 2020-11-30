package model.beans.project;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private int id;
    private String name;
    private String title;
    private String fileLink;

    public Book() {
        id = 0;
        name = "";
        title = "";
        fileLink = "";
    }

    public Book(int id, String name, String title, String fileLink) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.fileLink = fileLink;
    }

    public Book(String name, String title, String fileLink) {
        this.name = name;
        this.title = title;
        this.fileLink = fileLink;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFileLink() {
        return fileLink;
    }

    public void setFileLink(String fileLink) {
        this.fileLink = fileLink;
    }
}
