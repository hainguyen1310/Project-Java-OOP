package Model;

public class DoctorModel {
    private String code;
    private String name;
    private String specialization;
    private int availability;

    public DoctorModel() {
    }

    public DoctorModel(String code, String name, String specialization, int availability) {
        this.code = code;
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }
    
    @Override
    public String toString() {
        return String.format("%-8s%-16s%-24s%-15s", code, name, specialization, availability);
    }
}

