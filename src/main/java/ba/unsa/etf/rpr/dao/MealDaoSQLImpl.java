package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Meal;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.sql.ResultSet;
import java.sql.SQLException;
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

}
