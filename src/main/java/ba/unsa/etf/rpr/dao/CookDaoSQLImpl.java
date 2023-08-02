package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Cook;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class CookDaoSQLImpl extends AbstractDao<Cook> implements CookDao{
    private static CookDaoSQLImpl instance = null;

    private CookDaoSQLImpl() {
        super("Cooks");
    }

    public static CookDao getInstance() {
        if (instance == null) instance = new CookDaoSQLImpl();
        return instance;
    }

    @Override
    public Cook row2object(ResultSet rs) throws MyException {
        try {
            Cook cook = new Cook();
            cook.setId(rs.getInt("id"));
            cook.setName(rs.getString("name"));
            cook.setSurname(rs.getString("surname"));
            cook.setPhoneNumber(rs.getString("phone_number"));
            cook.setNumberOfMealsMade(rs.getInt("number_of_meals_made"));
            return cook;
        } catch (SQLException e) {
            throw new MyException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Cook object) {
        return null;
    }
}
