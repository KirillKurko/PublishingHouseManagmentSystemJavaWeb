package controller.projectController;

import controller.services.EditService;
import model.beans.project.Book;
import model.dao.projectDAOs.implementations.BookDAOImplementation;
import model.dao.projectDAOs.interfaces.BookDAO;
import utilities.Checker;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/books")
public class BookController extends HttpServlet {

    private BookDAO bookDAO;
    private EditService editService;

    @Override
    public void init() {
        bookDAO = new BookDAOImplementation();
        editService = new EditService();
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("action");
        switch (method) {
            case "getBooks":
                getBooks(request, response);
                break;
            case "getBook":
                getBook(request, response);
                break;
            case "addBook":
                addBook(request, response);
                getBooks(request, response);
            case "editBook":
                editBook(request, response);
                getBooks(request, response);
                break;
        }
    }

    private void getBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bookDAO.selectBooks();
        request.setAttribute("books", books);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/projects/books/mainBookPage.jsp");
        requestDispatcher.forward(request, response);
    }

    private void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        Book book = bookDAO.selectBook(bookId);
        request.setAttribute("book", book);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/projects/books/editBookPage.jsp");
        requestDispatcher.forward(request, response);
    }

    private void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String title = request.getParameter("title");
        String fileLink = request.getParameter("link");
        if (Checker.checkBookNameValid(name)) {
            bookDAO.insertBook(new Book(name, title, fileLink));
        }
    }

    private void editBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        editService.editBook(request, response);
    }
}
