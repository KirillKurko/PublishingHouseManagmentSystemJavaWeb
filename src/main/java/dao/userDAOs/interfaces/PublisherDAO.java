package dao.userDAOs.interfaces;

import beans.employees.employeesImplementations.Publisher;

public interface PublisherDAO {

    int insertPublisher(Publisher publisher);

    boolean updatePublisher(Publisher publisher);

    Publisher selectPublisher(int id);

    boolean deletePublisher(int id);
}
