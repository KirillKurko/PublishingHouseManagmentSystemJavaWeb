package model.beans.project;

public class Project {

    private int id;
    private int pagesAmount;
    private double pagePrice;
    private int booksAmount;
    private int leadEditorId;
    private int bookId;

    public Project() {
        id = 0;
        pagesAmount = 0;
        pagePrice = 0.0;
        booksAmount = 0;
        leadEditorId = 0;
        bookId = 0;
    }

    public Project(int pagesAmount, double pagePrice, int booksAmount, int leadEditorId, int bookId) {
        this.pagesAmount = pagesAmount;
        this.pagePrice = pagePrice;
        this.booksAmount = booksAmount;
        this.leadEditorId = leadEditorId;
        this.bookId = bookId;
    }

    public Project(int id, int pagesAmount, double pagePrice, int booksAmount, int leadEditorId, int bookId) {
        this.id = id;
        this.pagesAmount = pagesAmount;
        this.pagePrice = pagePrice;
        this.booksAmount = booksAmount;
        this.leadEditorId = leadEditorId;
        this.bookId = bookId;
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

    public int getLeadEditorId() {
        return leadEditorId;
    }

    public void setLeadEditorId(int leadEditorId) {
        this.leadEditorId = leadEditorId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
