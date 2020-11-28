package model.dao.userDAOs.interfaces;

import model.beans.employees.employeesImplementations.ChiefEditor;

import java.util.List;

public interface ChiefEditorDAO {

    int insertChiefEditor(ChiefEditor chiefEditor);

    boolean updateChiefEditor(ChiefEditor chiefEditor);

    ChiefEditor selectChiefEditor(int id);

    List<ChiefEditor> selectChiefEditors();

    ChiefEditor selectChiefEditorByEmployeeId(int employeeId);

    boolean deleteChiefEditor(int id);

    boolean deleteChiefEditorByEmployeeId(int id);
}
