/*
Name: Mohanad Al Dakheel
University ID: 2135847
Section: ZJ
Course: CPCS203
Assignment Number: #03
 */
public class Doctor extends Staff {

    private double consulationFees;

    public Doctor(double consulationFees, String staffID, String specialization, int id, String name, String nationality, char gender, int phone) {
        super(specialization, staffID, id, name, nationality, gender, phone);
        this.consulationFees = consulationFees;
    }

    public double getConsulationFees() {
        return consulationFees;
    }

    public void setConsulationFees(double consulationFees) {
        this.consulationFees = consulationFees;
    }

    @Override
    public String toString() {
        return "Doctor{" + "consulationFees=" + consulationFees + '}';
    }

}
