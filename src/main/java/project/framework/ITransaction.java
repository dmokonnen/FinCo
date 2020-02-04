package project.framework;

import java.util.Date;

public interface ITransaction {
    void setName(String name);
    void setAmount(Double amount);
    void setDate(Date date);
}
