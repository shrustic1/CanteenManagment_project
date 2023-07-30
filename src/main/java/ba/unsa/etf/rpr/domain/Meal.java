package ba.unsa.etf.rpr.domain;

public class Meal implements Idable{
    private int id;
    private String description;
    private Boolean taken;

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getTaken() {
        return taken;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTaken(Boolean taken) {
        this.taken = taken;
    }
}
