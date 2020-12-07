package controller.projectController;

import controller.services.EditService;
import controller.services.projectServices.AuthorService;
import model.beans.project.Author;
import model.dao.projectDAOs.implementations.AuthorDAOImplementation;
import model.dao.projectDAOs.interfaces.AuthorDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/authors")
public class AuthorController extends HttpServlet {

    private AuthorDAO authorDAO;
    private AuthorService authorService;
    private EditService editService;

    @Override
    public void init() {
        authorDAO = new AuthorDAOImplementation();
        authorService = new AuthorService();
        editService = new EditService();
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("action");
        switch (method) {
            case "addAuthor":
                addAuthor(request, response);
                getAuthors(request, response);
                break;
            case "deleteAuthor":
                deleteAuthor(request, response);
                getAuthors(request, response);
                break;
            case "editAuthor":
                editAuthor(request, response);
                getAuthors(request, response);
                break;
            case "getAuthor":
                getAuthor(request, response);
                break;
            case "getAuthors":
                getAuthors(request, response);
                break;
        }
    }

    private void addAuthor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String bookName = request.getParameter("bookName");
        Author author = new Author(name, surname);
        authorService.addAuthor(author, bookName);
    }

    private void deleteAuthor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int authorId = Integer.parseInt(request.getParameter("authorId"));
        authorService.deleteAuthor(authorId);
    }

    private void editAuthor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        editService.editAuthor(request, response);
    }

    private void getAuthor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int authorId = Integer.parseInt(request.getParameter("authorId"));
        Author author = authorDAO.selectAuthor(authorId);
        request.setAttribute("author", author);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/projects/books/authors/editAuthorPage.jsp");
        requestDispatcher.forward(request, response);
    }

    private void getAuthors(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Author> authors = authorDAO.selectAuthors();
        request.setAttribute("authors", authors);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/projects/books/authors/mainAuthorPage.jsp");
        requestDispatcher.forward(request, response);
    }
}
