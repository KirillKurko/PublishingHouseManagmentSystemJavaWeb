package controller.projectController;

import controller.services.projectServices.ProjectService;
import model.beans.employees.User;
import model.beans.employees.employeesImplementations.Employee;
import model.beans.employees.employeesImplementations.LeadEditor;
import model.beans.project.Book;
import model.beans.project.Project;
import model.dao.projectDAOs.implementations.BookDAOImplementation;
import model.dao.projectDAOs.implementations.ProjectDAOImplementation;
import model.dao.projectDAOs.interfaces.BookDAO;
import model.dao.projectDAOs.interfaces.ProjectDAO;
import model.dao.userDAOs.implementations.EmployeeDAOImplementation;
import model.dao.userDAOs.implementations.LeadEditorDAOImplementation;
import model.dao.userDAOs.implementations.UserDAOImplementation;
import model.dao.userDAOs.interfaces.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/projects")
public class ProjectController extends HttpServlet {

    private BookDAO bookDAO;
    private LeadEditorDAO leadEditorDAO;
    private EmployeeDAO employeeDAO;
    private UserDAO userDAO;
    private ProjectDAO projectDAO;
    private ProjectService projectService;

    @Override
    public void init() {
        bookDAO = new BookDAOImplementation();
        leadEditorDAO = new LeadEditorDAOImplementation();
        userDAO = new UserDAOImplementation();
        employeeDAO = new EmployeeDAOImplementation();
        projectDAO = new ProjectDAOImplementation();
        projectService = new ProjectService();
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("action");
        switch (method) {
            case "addProject":
                addProject(request, response);
                getProjects(request, response);
                break;
            case "deleteProject":
                deleteProject(request, response);
                getProjects(request, response);
                break;
            case "finishProject":
                finishProject(request, response);
                getProjects(request, response);
                break;
            case "getProjects":
                getProjects(request, response);
                break;
            case "getProject":
                getProject(request, response);
                break;
            case "editProject":
                editProject(request, response);
                getProject(request, response);
                break;
            case "getProjectInfo":
                getProjectInfo(request, response);
                break;
        }
    }

    private void addProject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pagesAmount = Integer.parseInt(request.getParameter("pagesAmount"));
        double pagePrice = Double.parseDouble(request.getParameter("pagePrice"));
        int booksAmount = Integer.parseInt(request.getParameter("booksAmount"));
        int leadEditorId = getLeadEditorIdFromRequest(request);
        int bookId = getBookIdFromRequest(request);
        projectDAO.insertProject(new Project(pagesAmount, pagePrice, booksAmount, leadEditorId, bookId));
    }

    private void deleteProject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int projectId = Integer.parseInt(request.getParameter("projectId"));
        projectDAO.deleteProject(projectId);
    }

    private void finishProject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        projectService.finishProject(request);
    }

    private void getProjects(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Project> projects = projectDAO.selectProjects();
        request.setAttribute("projects", projects);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/projects/mainProjectPage.jsp");
        requestDispatcher.forward(request, response);
    }

    private void getProject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int projectId = Integer.parseInt(request.getParameter("projectId"));
        Project project = projectDAO.selectProject(projectId);
        request.setAttribute("project", project);
        User user = projectService.getLeadEditorUser(project);
        request.setAttribute("user", user);
        Book book = bookDAO.selectBook(project.getBookId());
        request.setAttribute("book", book);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/projects/editProjectPage.jsp");
        requestDispatcher.forward(request, response);
    }

    private void getProjectInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int projectId = Integer.parseInt(request.getParameter("projectId"));
        Project project = projectDAO.selectProject(projectId);
        request.setAttribute("project", project);
        LeadEditor leadEditor = leadEditorDAO.selectLeadEditor(project.getLeadEditorId());
        request.setAttribute("leadEditor", leadEditor);
        Employee employee = employeeDAO.selectEmployee(leadEditor.getEmployeeID());
        request.setAttribute("employee", employee);
        Book book = bookDAO.selectBook(project.getBookId());
        request.setAttribute("book", book);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/projects/projectPage.jsp");
        requestDispatcher.forward(request, response);
    }

    private void editProject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int projectId = Integer.parseInt(request.getParameter("projectId"));
        int pagesAmount = Integer.parseInt(request.getParameter("pagesAmount"));
        double pagePrice = Double.parseDouble(request.getParameter("pagePrice"));
        int booksAmount  = Integer.parseInt(request.getParameter("booksAmount"));
        int leadEditorId = getLeadEditorIdFromRequest(request);
        int bookId = getBookIdFromRequest(request);
        projectDAO.updateProject(new Project(projectId, pagesAmount, pagePrice, booksAmount, leadEditorId, bookId));
    }

    private int getLeadEditorIdFromRequest(HttpServletRequest request) {
        String leadEditorLogin = request.getParameter("leadEditorLogin");
        User user = userDAO.selectUserByLogin(leadEditorLogin);
        int userId = user.getId();
        Employee employee = employeeDAO.selectEmployeeByUserId(userId);
        int employeeId = employee.getId();
        LeadEditor leadEditor = leadEditorDAO.selectLeadEditorByEmployeeId(employeeId);
        return leadEditor.getId();
    }

    private int getBookIdFromRequest(HttpServletRequest request) {
        String bookName = request.getParameter("bookName");
        Book book = bookDAO.selectBookByName(bookName);
        return book.getId();
    }
}
