package project.framework.model;

import java.util.Date;

public interface IPerson extends ICustomer {
    void setBirthDate(Date date);
    Date getBirthDate();
}
