package project.framework;

import java.util.Date;

public class Person extends Customer implements IPerson {
    private Date birthDate;
    @Override
    public void setBirthDate(Date date) {
        birthDate = date;
    }

    @Override
    public Date getBirthDate() {
        return birthDate;
    }
}
