package controller;

import model.beans.employees.User;
import model.beans.employees.employeesImplementations.Employee;
import model.beans.project.Task;
import model.dao.projectDAOs.implementations.TaskDAOImplementation;
import model.dao.projectDAOs.interfaces.TaskDAO;
import model.dao.userDAOs.implementations.EmployeeDAOImplementation;
import model.dao.userDAOs.implementations.UserDAOImplementation;
import model.dao.userDAOs.interfaces.EmployeeDAO;
import model.dao.userDAOs.interfaces.UserDAO;
import utilities.Checker;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/tasks")
public class TaskController extends HttpServlet  {

    private TaskDAO taskDAO;
    private EmployeeDAO employeeDAO;
    private UserDAO userDAO;

    @Override
    public void init() {
        taskDAO = new TaskDAOImplementation();
        employeeDAO = new EmployeeDAOImplementation();
        userDAO = new UserDAOImplementation();
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("action");
        switch (method) {
            case "getTasks":
                getTasks(request, response);
                break;
            case "addTask":
                addTask(request, response);
                getTasks(request, response);
                break;
            case "finishTask":
                finishTask(request, response);
                getTasks(request, response);
                break;
            case "getAppointedTasks":
                getAppointedTasks(request, response);
                break;
            case "getReceivedTasks":
                getReceivedTasks(request, response);
                break;
        }
    }

    private void getTasks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Task> tasks = taskDAO.selectTasks();
        request.setAttribute("tasks", tasks);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/tasks/mainTaskPage.jsp");
        requestDispatcher.forward(request, response);
    }

    private void addTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String customerName = getCustomerName(request);
        String executorName = request.getParameter("employee");
        if (Checker.checkUsernameExists(executorName)) {
            int employeeId = getEmployeeId(executorName);
            taskDAO.insertTask(new Task(name, description, customerName, executorName, employeeId));
        }
    }

    private void finishTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int taskId = Integer.parseInt(request.getParameter("taskId"));
        if (canFinishTask(taskId, request)) {
            taskDAO.deleteTask(taskId);
        }
    }

    private void getAppointedTasks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = (int) request.getSession().getAttribute("userId");
        User user = userDAO.selectUser(userId);
        String login = user.getLogin();
        List<Task> tasks = taskDAO.selectTasksByCustomerName(login);
        request.setAttribute("tasks", tasks);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/tasks/mainTaskPage.jsp");
        requestDispatcher.forward(request, response);
    }

    private void getReceivedTasks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employeeId = (int) request.getSession().getAttribute("employeeId");
        List<Task> tasks = taskDAO.selectTasksByEmployeeId(employeeId);
        request.setAttribute("tasks", tasks);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/tasks/mainTaskPage.jsp");
        requestDispatcher.forward(request, response);
    }

    private String getCustomerName(HttpServletRequest request) {
        int userId = (int) request.getSession().getAttribute("userId");
        User user = userDAO.selectUser(userId);
        return user.getLogin();
    }

    private int getEmployeeId(String login) {
        User user = userDAO.selectUserByLogin(login);
        int userId = user.getId();
        Employee employee = employeeDAO.selectEmployeeByUserId(userId);
        return employee.getId();
    }

    private boolean canFinishTask(int taskId, HttpServletRequest request) {
        Task task = taskDAO.selectTask(taskId);
        int userId = (int) request.getSession().getAttribute("userId");
        User user = userDAO.selectUser(userId);
        String login = user.getLogin();
        return login.equals(task.getCustomerName()) || login.equals(task.getExecutorName());
    }
}
