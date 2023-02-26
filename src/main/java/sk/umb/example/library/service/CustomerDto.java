package sk.umb.example.library.service;

public class CustomerDto {

    private String name;

    private Long ID ;
    private String dirstName;
    private String lastname;
    private String contact;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getDirstName() {
        return dirstName;
    }

    public void setDirstName(String dirstName) {
        this.dirstName = dirstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
