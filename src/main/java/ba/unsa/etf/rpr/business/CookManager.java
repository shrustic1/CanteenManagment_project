package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Cook;
import ba.unsa.etf.rpr.exceptions.MyException;

public class CookManager {
    public void add (Cook cook) throws MyException{
        DaoFactory.cookDao().add(cook);
    }
    public void delete(int id) throws MyException{
        DaoFactory.cookDao().delete(id);
    }
    public void update(Cook cook) throws MyException{
        DaoFactory.cookDao().update(cook);
    }

}
