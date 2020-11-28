package model.dao.userDAOs.interfaces;

import model.beans.employees.employeesImplementations.LeadEditor;

import java.util.List;

public interface LeadEditorDAO {

    int insertLeadEditor(LeadEditor chiefEditor);

    boolean updateLeadEditor(LeadEditor chiefEditor);

    LeadEditor selectLeadEditor(int id);

    List<LeadEditor> selectLeadEditors();

    LeadEditor selectLeadEditorByEmployeeId(int employeeId);

    boolean deleteLeadEditor(int id);

    boolean deleteLeadEditorByEmployeeId(int id);
}
