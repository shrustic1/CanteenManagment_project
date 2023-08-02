package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Meal;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.util.List;

public class MealManager {
    public List<Meal> getAll() throws MyException{
        return DaoFactory.mealDao().getAll();
    }


}
