package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Meal;
import ba.unsa.etf.rpr.domain.Student;
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
    public void add(Meal meal) throws MyException{
        DaoFactory.mealDao().add(meal);
    }
    public Meal randomMeal() throws MyException{
        return DaoFactory.mealDao().randomMeal();
    }
    public List<Meal> searchByStudent(Student student) throws MyException{
        return DaoFactory.mealDao().searchByStudent(student);
    }
    public List<Meal> searchByTaken(Boolean taken) throws MyException{
        return DaoFactory.mealDao().searchByTaken(taken);
    }
}
