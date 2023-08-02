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
    public void update(Student student) throws MyException{
        DaoFactory.studentDao().update(student);
    }
    public List<Student> searchByName(String name) throws MyException{
        return DaoFactory.studentDao().searchByName(name);
    }
    public List<Student> searchBySurname(String surname) throws MyException{
        return DaoFactory.studentDao().searchBySurname(surname);
    }
}
