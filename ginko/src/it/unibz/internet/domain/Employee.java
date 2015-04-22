package it.unibz.internet.domain;


/**
 * Domain object Employee. An employee is the user who inserted the order, this
 * this is normally an employee of the hospital.
 *
 * @author Werner Frei <freiwe@gmail.com>
 */
public class Employee  {

    private String userId;
    private String name;

    public Employee() {
    }

    public Employee(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }


    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}