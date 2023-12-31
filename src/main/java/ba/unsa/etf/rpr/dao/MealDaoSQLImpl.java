package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Meal;
import ba.unsa.etf.rpr.domain.Student;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MealDaoSQLImpl extends AbstractDao<Meal> implements MealDao{

    private static MealDaoSQLImpl instance = null;
    private MealDaoSQLImpl(){
        super("Meals");
    }
    public static MealDaoSQLImpl getInstance() {
        if (instance == null) instance = new MealDaoSQLImpl();
        return instance;
    }
    public static void removeInstance(){
        if (instance!=null) instance = null;
    }

    @Override
    public Meal row2object(ResultSet rs) throws MyException {
        try {
            Meal meal = new Meal();
            meal.setId(rs.getInt("id"));
            meal.setDescription(rs.getString("description"));
            meal.setTaken(rs.getBoolean("taken"));
            meal.setCook(DaoFactory.cookDao().getById(rs.getInt("cook_id")));
            meal.setStudent(DaoFactory.studentDao().getById(rs.getInt("student_id")));
            return meal;
        } catch (SQLException e) {
            throw new MyException(e.getMessage(), e);
        }

    }

    @Override
    public Map<String, Object> object2row(Meal object) {
        Map<String, Object> item = new TreeMap<>();
        item.put("id", object.getId());
        item.put("description", object.getDescription());
        item.put("taken", object.getTaken());
        item.put("cook_id", object.getCook().getId());
        item.put("student_id", object.getStudent().getId());
        return item;
    }
    @Override
    public Meal randomMeal() throws MyException {
        return executeQueryUnique("SELECT * FROM Meals ORDER BY RAND() LIMIT 1", null);
    }

    @Override
    public List<Meal> searchByTaken(Boolean taken) throws MyException {
        return executeQuery("SELECT * FROM Meals WHERE taken = ?", new Object[]{taken});
    }

    @Override
    public List<Meal> searchByStudent(Student student) throws MyException {
        return executeQuery("SELECT * FROM Meals WHERE student_id = ?", new Object[]{student.getId()});
    }
}
