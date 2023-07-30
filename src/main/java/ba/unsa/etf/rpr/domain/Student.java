package ba.unsa.etf.rpr.domain;

public class Student implements Idable{

    private int id;
    private String name;
    private String surname;
    private int numberOfTokens;

    @Override
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getNumberOfTokens() {
        return numberOfTokens;
    }
}
