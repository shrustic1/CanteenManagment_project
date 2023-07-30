package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Idable;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.io.IOException;
import java.sql.*;
import java.util.*;
public abstract class AbstractDao<T extends Idable> implements Dao<T> {

    private static Connection conn = null;
    private String tableName;

    public AbstractDao(String tableName) {
        this.tableName = tableName;
        createConnection();
    }

    private static void createConnection() {
        if (conn == null){
            try {
                Properties p = new Properties();
                p.load(ClassLoader.getSystemResource("application.properties").openStream());
                String url = p.getProperty("db.connection_string");
                String username = p.getProperty("db.username");
                String password = p.getProperty("db.password");
                conn = DriverManager.getConnection(url, username, password);
            } catch (Exception e) {
                e.printStackTrace();
            } finally{
                Runtime.getRuntime().addShutdownHook(new Thread(){
                    @Override
                    public void run(){
                        try {
                            conn.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    public static Connection getConnection(){
        return conn;
    }

    public abstract T row2object(ResultSet rs) throws MyException;

    public abstract Map<String, Object> object2row(T object);

    public T getById(int id) throws MyException{
        return executeQueryUnique("SELECT * FROM" + this.tableName + "WHERE id = ?", new Object[]{id});
    }

    public T executeQueryUnique (String query, Object[] params) throws MyException{
        List<T> result = executeQuery(query, params);
        if (result != null && result.size() == 1){
            return result.get(0);
        }else{
            throw new MyException("Object not found.");
        }
    }

    private List<T> executeQuery(String query, Object[] params) throws MyException {
        try {
            PreparedStatement stmt = getConnection().prepareStatement(query);
            if (params != null){
                for (int i=1; i<= params.length; i++){
                    stmt.setObject(i, params[i-1]);
                }
            }
            ResultSet rs = stmt.executeQuery();
            ArrayList<T> resultList = new ArrayList<T>();
            while (rs.next()){
                resultList.add(row2object(rs));
            }
            return resultList;
        } catch (SQLException e) {
            throw new MyException(e.getMessage(), e);
        }
    }

}
