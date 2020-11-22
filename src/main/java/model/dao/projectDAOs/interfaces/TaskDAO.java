package model.dao.projectDAOs.interfaces;

import model.beans.project.Task;

public interface TaskDAO {

    int insertTask(Task task);

    boolean updateTask(Task task);

    Task selectTask(int id);

    boolean deleteTask(int id);
}
