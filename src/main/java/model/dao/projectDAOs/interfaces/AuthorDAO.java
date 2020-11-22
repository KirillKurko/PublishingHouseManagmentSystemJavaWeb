package model.dao.projectDAOs.interfaces;

import model.beans.project.Author;

public interface AuthorDAO {

    int insertAuthor(Author author);

    boolean updateAuthor(Author author);

    Author selectAuthor(int id);

    boolean deleteAuthor(int id);
}
