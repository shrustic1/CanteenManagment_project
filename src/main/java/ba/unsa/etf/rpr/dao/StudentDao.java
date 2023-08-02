package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Student;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.util.List;

public interface StudentDao extends Dao<Student> {
    List<Student> searchByName(String name) throws MyException;
    List<Student> searchBySurname(String surname) throws MyException;

}
