package ba.unsa.etf.rpr.domain;

public class Cook implements Idable{

    private int Id;
    private String name;
    private String surname;
    private String phoneNumber;
    private int numberOfMealsMade;

    @Override
    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getNumberOfMealsMade() {
        return numberOfMealsMade;
    }

}
