package ba.unsa.etf.rpr.domain;

public class Meal implements Idable{
    private int id;
    private String description;
    private Boolean taken;
    private Cook cook;
    private Student student;

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getTaken() {
        return taken;
    }

    public Cook getCook() {
        return cook;
    }

    public Student getStudent() {
        return student;
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

    public void setCook(Cook cook) {
        this.cook = cook;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
