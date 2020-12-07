package model.dao.userDAOs.interfaces;

import model.beans.employees.employeesImplementations.Publisher;

import java.util.List;

public interface PublisherDAO {

    int insertPublisher(Publisher publisher);

    boolean updatePublisher(Publisher publisher);

    Publisher selectPublisher(int id);

    List<Publisher> selectPublishers();

    boolean deletePublisher(int id);

    boolean deletePublisherByEmployeeId(int id);
}
