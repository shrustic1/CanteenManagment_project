package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.Dao;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Meal;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.util.List;

public class MealManager {
    public List<Meal> getAll() throws MyException{
        return DaoFactory.mealDao().getAll();
    }

    public void delete(int id) throws MyException{
        DaoFactory.mealDao().delete(id);
    }
    public Meal getById(int id) throws MyException{
        return DaoFactory.mealDao().getById(id);
    }
    public void update(Meal meal) throws MyException{
        DaoFactory.mealDao().update(meal);
    }

}
