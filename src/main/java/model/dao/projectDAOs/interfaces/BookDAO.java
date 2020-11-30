package model.dao.projectDAOs.interfaces;

import model.beans.project.Book;

import java.util.List;

public interface BookDAO {

    int insertBook(Book book);

    boolean updateBook(Book book);

    Book selectBook(int id);

    Book selectBookByName(String name);

    List<Book> selectBooks();

    boolean deleteBook(int id);
}
