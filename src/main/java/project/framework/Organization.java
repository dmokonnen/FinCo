package project.framework;

import java.util.ArrayList;
import java.util.List;

public class Organization extends Customer implements IOrganization {
    private final List<IPerson> employees;
    public Organization() {
        employees = new ArrayList<>();
    }
    @Override
    public void addEmployee(IPerson employee) {
        employees.add(employee);
    }

    @Override
    public void removeEmployee(IPerson employee) {
        employees.remove(employee);
    }

    @Override
    public int getNoOfEmployees() {
        return employees.size();
    }
}
