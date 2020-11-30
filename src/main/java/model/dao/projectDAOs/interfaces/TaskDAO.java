package model.dao.projectDAOs.interfaces;

import model.beans.project.Task;

import java.util.List;

public interface TaskDAO {

    int insertTask(Task task);

    boolean updateTask(Task task);

    Task selectTask(int id);

    List<Task> selectTasksByCustomerName(String customerName);

    List<Task> selectTasksByEmployeeId(int employeeId);

    List<Task> selectTasks();

    boolean deleteTask(int id);

    void deleteTasksByEmployeeId(int employeeId);
}
