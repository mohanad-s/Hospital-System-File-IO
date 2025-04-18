/*
Name: Mohanad Al Dakheel
University ID: 2135847
Section: ZJ
Course: CPCS203
Assignment Number: #03
 */
public abstract class Staff extends Person {

    private String specialization;
    private String staffID;

    public Staff(String specialization, String staffID, int id, String name, String nationality, char gender, int phone) {
        super(id, name, nationality, gender, phone);
        this.specialization = specialization;
        this.staffID = staffID;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    @Override
    public String toString() {
        return "Staff{" + "specialization=" + specialization + ", staffID=" + staffID + '}';
    }

}
