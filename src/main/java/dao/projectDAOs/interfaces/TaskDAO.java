package dao.projectDAOs.interfaces;

import beans.project.Task;

public interface TaskDAO {

    int insertTask(Task task);

    boolean updateTask(Task task);

    Task selectTask(int id);

    boolean deleteTask(int id);
}
