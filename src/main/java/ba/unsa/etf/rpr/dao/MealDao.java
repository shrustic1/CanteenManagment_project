package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Meal;
import ba.unsa.etf.rpr.exceptions.MyException;

public interface MealDao extends Dao<Meal>{
     Meal randomMeal() throws MyException;
}
