package dao.userDAOs.interfaces;

import beans.employees.employeesImplementations.LeadEditor;

public interface LeadEditorDAO {

    int insertChiefEditor(LeadEditor chiefEditor);

    boolean updateChiefEditor(LeadEditor chiefEditor);

    LeadEditor selectChiefEditor(int id);

    boolean deleteChiefEditor(int id);
}
