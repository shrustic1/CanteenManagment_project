package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Cook;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.sql.ResultSet;
import java.util.Map;

public class CookDaoSQLImpl extends AbstractDao<Cook> implements CookDao{
    private static CookDaoSQLImpl instance = null;

    private CookDaoSQLImpl() {
        super("Cooks");
    }

    public static CookDao getInstance() {
    }

    @Override
    public Cook row2object(ResultSet rs) throws MyException {
        return null;
    }

    @Override
    public Map<String, Object> object2row(Cook object) {
        return null;
    }
}
