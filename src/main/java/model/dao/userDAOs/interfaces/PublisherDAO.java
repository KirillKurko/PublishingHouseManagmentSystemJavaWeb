package model.dao.userDAOs.interfaces;

import model.beans.employees.employeesImplementations.Publisher;

public interface PublisherDAO {

    int insertPublisher(Publisher publisher);

    boolean updatePublisher(Publisher publisher);

    Publisher selectPublisher(int id);

    boolean deletePublisher(int id);

    boolean deletePublisherByEmployeeId(int id);
}
