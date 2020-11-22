package model.dao.userDAOs.interfaces;

import model.beans.employees.employeesImplementations.LeadEditor;

public interface LeadEditorDAO {

    int insertLeadEditor(LeadEditor chiefEditor);

    boolean updateLeadEditor(LeadEditor chiefEditor);

    LeadEditor selectLeadEditor(int id);

    boolean deleteLeadEditor(int id);
}
