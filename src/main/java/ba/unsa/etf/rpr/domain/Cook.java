package ba.unsa.etf.rpr.domain;

public class Cook implements Idable{

    private int id;
    private String name;
    private String surname;
    private String phoneNumber;
    private int numberOfMealsMade;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getNumberOfMealsMade() {
        return numberOfMealsMade;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setNumberOfMealsMade(int numberOfMealsMade) {
        this.numberOfMealsMade = numberOfMealsMade;
    }
}
