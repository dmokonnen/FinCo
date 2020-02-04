package project.framework.model;

public interface IOrganization extends ICustomer {
    void addEmployee(IPerson employee);
    void removeEmployee(IPerson employee);
    int getNoOfEmployees();
}
