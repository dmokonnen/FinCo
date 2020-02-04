package project.framework.controller;

import project.framework.model.Address;
import project.framework.model.ICustomer;
import project.framework.model.Organization;
import project.framework.model.Person;

import java.util.Date;

/**
 * @author Demisew Mokonnen
 * @2020
 */
public class CustomerFactory {
    public ICustomer createOrganization(String name, String email, Address address){
        return new Organization(name,email,address);
    }
    public ICustomer createPerson(String name, Date date, String email, Address address){
        return new Person(name,date,email,address);
    }

}
