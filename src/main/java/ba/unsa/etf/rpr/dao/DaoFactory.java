package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Student;

public class DaoFactory {
    private static final CookDao cookDao= CookDaoSQLImpl.getInstance();
    private static final StudentDao studentDao = StudentDaoSQLImpl.getInstance();
    private static final MealDao mealDao = MealDaoSQLImpl.getInstance();

    private DaoFactory(){

    }
    public static CookDao cookDao(){
        return cookDao;
    }
    public static StudentDao studentDao(){
        return studentDao;
    }
    public static MealDao mealDao(){
        return mealDao;
    }

}
