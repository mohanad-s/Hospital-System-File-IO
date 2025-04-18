/*
Name: Mohanad Al Dakheel
University ID: 2135847
Section: ZJ
Course: CPCS203
Assignment Number: #03
 */
public class Nurse extends Staff {

    private int experience;

    public Nurse(int experience, String staffID, String specialization, int id, String name, String nationality, char gender, int phone) {
        super(specialization, staffID, id, name, nationality, gender, phone);
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Nurse{" + "experience=" + experience + '}';
    }

}
