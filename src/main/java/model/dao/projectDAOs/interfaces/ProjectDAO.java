package model.dao.projectDAOs.interfaces;

import model.beans.project.Project;

import java.util.List;

public interface ProjectDAO {

    int insertProject(Project project);

    boolean updateProject(Project project);

    Project selectProject(int id);

    List<Project> selectProjects();

    boolean deleteProject(int id);
}
