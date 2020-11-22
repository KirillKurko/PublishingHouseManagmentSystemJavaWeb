package model.beans.project;

import model.beans.employees.employeesImplementations.LeadEditor;

public class Project {

    private int id;
    private int pagesAmount;
    private double pagePrice;
    private int booksAmount;
    private LeadEditor leadEditor;
    private Book book;

    public Project() {
        id = 0;
        pagesAmount = 0;
        pagePrice = 0.0;
        booksAmount = 0;
        leadEditor = null;
        book = null;
    }

    public Project(int id, int pagesAmount, double pagePrice, int booksAmount, LeadEditor leadEditor, Book book) {
        this.id = id;
        this.pagesAmount = pagesAmount;
        this.pagePrice = pagePrice;
        this.booksAmount = booksAmount;
        this.leadEditor = leadEditor;
        this.book = book;
    }

    public Project(int pagesAmount, double pagePrice, int booksAmount, LeadEditor leadEditor, Book book) {
        this.pagesAmount = pagesAmount;
        this.pagePrice = pagePrice;
        this.booksAmount = booksAmount;
        this.leadEditor = leadEditor;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPagesAmount() {
        return pagesAmount;
    }

    public void setPagesAmount(int pagesAmount) {
        this.pagesAmount = pagesAmount;
    }

    public double getPagePrice() {
        return pagePrice;
    }

    public void setPagePrice(double pagePrice) {
        this.pagePrice = pagePrice;
    }

    public int getBooksAmount() {
        return booksAmount;
    }

    public void setBooksAmount(int booksAmount) {
        this.booksAmount = booksAmount;
    }

    public LeadEditor getLeadEditor() {
        return leadEditor;
    }

    public void setLeadEditor(LeadEditor leadEditor) {
        this.leadEditor = leadEditor;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
