package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Student;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class StudentDaoSQLImpl extends AbstractDao<Student> implements StudentDao{
    private static StudentDaoSQLImpl instance = null;
    private StudentDaoSQLImpl() {
        super("Students");
    }
    public static StudentDao getInstance() {
        if (instance == null) instance = new StudentDaoSQLImpl();
        return instance;
    }

    @Override
    public Student row2object(ResultSet rs) throws MyException {
        try {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setSurname(rs.getString("surname"));
            student.setNumberOfTokens(rs.getInt("number_of_tokens"));
            return student;
        } catch (SQLException e) {
            throw new MyException(e.getMessage(), e);
        }

    }

    @Override
    public Map<String, Object> object2row(Student object) {
        return null;
    }

    @Override
    public List<Student> searchByName(String name) throws MyException {
        return null;
    }

    @Override
    public List<Student> searchBySurname(String surname) throws MyException {
        return null;
    }

    @Override
    public int searchByNumberOfTokens(int number) throws MyException {
        return 0;
    }

}
