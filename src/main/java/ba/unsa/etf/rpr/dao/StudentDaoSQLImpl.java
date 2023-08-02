package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Student;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class StudentDaoSQLImpl extends AbstractDao<Student> implements StudentDao{
    private static StudentDaoSQLImpl instance = null;
    private StudentDaoSQLImpl() {
        super("Students");
    }


}
