package Model;

public class ContactModel {
    private int id;
    private String fullName;
    private String group;
    private String address;
    private String phone;

    public ContactModel() {
    }

    
    public ContactModel(int id, String fullName, String group, String address, String phone) {
        this.id = id;
        this.fullName = fullName;
        this.group = group;
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGroup() {
        return group;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
    
    private String getFirstName() {
        String[] nameParts = fullName.split(" ");
    return nameParts.length > 1 ? nameParts[0] : nameParts[2];
    }

    private String getLastName() {
        String[] nameParts = fullName.split(" ");
        if (nameParts.length > 2) {
            return nameParts[2];
        } else {
            return nameParts[1];
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    
    @Override
    public String toString() {
        return String.format("%-2d\t%-20s\t%-10s\t%-10s\t%-10s\t%-30s\t%-10s",
                id, fullName, getFirstName(), getLastName(), group, address, phone);
    }
}
