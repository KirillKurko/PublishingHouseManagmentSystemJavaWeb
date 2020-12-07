package model.dao.projectDAOs.interfaces;

import model.beans.project.Author;

import java.util.List;

public interface AuthorDAO {

    int insertAuthor(Author author);

    boolean updateAuthor(Author author);

    Author selectAuthor(int id);

    List<Author> selectAuthors();

    List<Author> selectAuthorsByBookId(int bookId);

    boolean deleteAuthor(int id);
}
