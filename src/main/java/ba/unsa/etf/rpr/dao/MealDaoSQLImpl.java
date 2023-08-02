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

}
