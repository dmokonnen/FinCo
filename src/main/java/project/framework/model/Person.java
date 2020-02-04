package project.framework.model;

import java.util.Date;

public class Person extends Customer implements IPerson {
    private Date birthDate;

    public Person(String name, Date birthDate, String email, Address address) {
        super(name, email, address);
        this.birthDate = birthDate;
    }

    @Override
    public void setBirthDate(Date date) {
        birthDate = date;
    }

    @Override
    public Date getBirthDate() {
        return birthDate;
    }
}
