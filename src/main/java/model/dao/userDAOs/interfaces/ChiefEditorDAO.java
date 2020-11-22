package model.dao.userDAOs.interfaces;

import model.beans.employees.employeesImplementations.ChiefEditor;

public interface ChiefEditorDAO {

    int insertChiefEditor(ChiefEditor chiefEditor);

    boolean updateChiefEditor(ChiefEditor chiefEditor);

    ChiefEditor selectChiefEditor(int id);

    boolean deleteChiefEditor(int id);
}
