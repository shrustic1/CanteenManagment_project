package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Meal;
import ba.unsa.etf.rpr.domain.Student;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.util.List;

public interface MealDao extends Dao<Meal>{
     Meal randomMeal() throws MyException;
     List<Meal> searchByTaken(Boolean taken) throws MyException;

     List<Meal> searchByStudent(Student student) throws MyException;
}
