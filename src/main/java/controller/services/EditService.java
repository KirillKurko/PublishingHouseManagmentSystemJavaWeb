package controller.services;

import model.beans.employees.User;
import model.beans.employees.employeesImplementations.ChiefEditor;
import model.beans.employees.employeesImplementations.Employee;
import model.beans.employees.employeesImplementations.LeadEditor;
import model.beans.project.Author;
import model.beans.project.Book;
import model.dao.projectDAOs.implementations.AuthorDAOImplementation;
import model.dao.projectDAOs.implementations.BookDAOImplementation;
import model.dao.projectDAOs.implementations.ReviewDAOImplementation;
import model.dao.projectDAOs.interfaces.AuthorDAO;
import model.dao.projectDAOs.interfaces.BookDAO;
import model.dao.projectDAOs.interfaces.ReviewDAO;
import model.dao.userDAOs.implementations.ChiefEditorDAOImplementation;
import model.dao.userDAOs.implementations.EmployeeDAOImplementation;
import model.dao.userDAOs.implementations.LeadEditorDAOImplementation;
import model.dao.userDAOs.implementations.UserDAOImplementation;
import model.dao.userDAOs.interfaces.ChiefEditorDAO;
import model.dao.userDAOs.interfaces.EmployeeDAO;
import model.dao.userDAOs.interfaces.LeadEditorDAO;
import model.dao.userDAOs.interfaces.UserDAO;
import utilities.Checker;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditService {

    private final UserDAO userDAO;
    private final EmployeeDAO employeeDAO;
    private final LeadEditorDAO leadEditorDAO;
    private final ChiefEditorDAO chiefEditorDAO;
    private final BookDAO bookDAO;
    private final ReviewDAO reviewDAO;
    private final AuthorDAO authorDAO;

    public EditService() {
        userDAO = new UserDAOImplementation();
        employeeDAO = new EmployeeDAOImplementation();
        leadEditorDAO = new LeadEditorDAOImplementation();
        chiefEditorDAO = new ChiefEditorDAOImplementation();
        bookDAO = new BookDAOImplementation();
        reviewDAO = new ReviewDAOImplementation();
        authorDAO = new AuthorDAOImplementation();

    }

    public void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String login = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        if (Checker.checkUsernameValid(login, id)) {
            userDAO.updateUser(new User(id, login, password, email, role));
        }
    }

    public void editEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        int experience = Integer.parseInt(request.getParameter("experience"));
        double salary = Double.parseDouble(request.getParameter("salary"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        employeeDAO.updateEmployee(new Employee(id, name, surname, experience, salary, userId));
    }

    public void editLeadEditor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int finishedProjectsAmount = Integer.parseInt(request.getParameter("finishedProjectsAmount"));
        String mainGenre = request.getParameter("mainGenre");
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        leadEditorDAO.updateLeadEditor(new LeadEditor(id, finishedProjectsAmount, mainGenre, employeeId));
    }

    public void editChiefEditor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int finishedProjectsAmount = Integer.parseInt(request.getParameter("finishedProjectsAmount"));
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        chiefEditorDAO.updateChiefEditor(new ChiefEditor(id, finishedProjectsAmount, employeeId));
    }

    public void editBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("bookId"));
        String name = request.getParameter("name");
        String title = request.getParameter("title");
        String fileLink = request.getParameter("link");
        reviewDAO.updateReviewsBookNameByBookId(name, id);
        bookDAO.updateBook(new Book(id, name, title, fileLink));
    }

    public void editAuthor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("authorId"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        authorDAO.updateAuthor(new Author(id, name, surname));
    }
}
