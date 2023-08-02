package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Student;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.util.List;

public class StudentManager {
    public List<Student> getAll() throws MyException{
        return DaoFactory.studentDao().getAll();
    }
    public void add(Student student) throws MyException{
        DaoFactory.studentDao().add(student);
    }
    public void delete(int id) throws MyException{
        DaoFactory.studentDao().delete(id);
    }


}
