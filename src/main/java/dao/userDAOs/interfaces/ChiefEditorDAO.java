package dao.userDAOs.interfaces;

import beans.employees.employeesImplementations.ChiefEditor;
import beans.employees.employeesImplementations.Employee;

public interface ChiefEditorDAO {

    int insertChiefEditor(ChiefEditor chiefEditor);

    boolean updateChiefEditor(ChiefEditor chiefEditor);

    ChiefEditor selectChiefEditor(int id);

    boolean deleteChiefEditor(int id);
}
