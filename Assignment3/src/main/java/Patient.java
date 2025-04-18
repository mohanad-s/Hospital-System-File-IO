
import java.util.Formatter;

/*
Name: Mohanad Al Dakheel
University ID: 2135847
Section: ZJ
Course: CPCS203
Assignment Number: #03
 */
public class Patient extends Person implements Comparable<Patient> {

    private String illness;
    private String bloodGroup;
    private Doctor doctor;
    private int toMedicine;
    private Medicine[] medicine;
    private Room room;

    public Patient(String illness, String bloodGroup, int id, String name, String nationality, char gender, int phone, int toMedicine) {
        super(id, name, nationality, gender, phone);
        this.illness = illness;
        this.bloodGroup = bloodGroup;
        this.toMedicine = toMedicine;
        this.medicine = new Medicine[toMedicine];
    }

    public int getTotalMedicine(Medicine[] medicine) {
        return medicine.length;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Medicine getMedicine(int index) {

        return medicine[index];
    }

    public void setMedicine(Medicine medicine, int index) {
        this.medicine[index] = medicine;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getToMedicine() {
        return toMedicine;
    }

    public void setToMedicine(int toMedicine) {
        this.toMedicine = toMedicine;
    }

    
//--------------------------------------------------------------------------        
// the following method prints out the medicines of each person in the bill
    public String medicineReturner() {
        double totalPrice = 0.0;
        StringBuilder medicineName = new StringBuilder("");
        for (int i = 0; i < this.getToMedicine(); i++) {
            this.getMedicine(i);
            String medicineNamee = "\tMedicine name: " + this.getMedicine(i).getName();
            String medicinePrice = "Price: " + this.getMedicine(i).getPrice() + " SR \n";
            Formatter f = new Formatter();
            f.format("%-28s %s", medicineNamee, medicinePrice);
            medicineName.append(f);
            if (i == this.getToMedicine() - 1) {
                return medicineName.toString();
            }
        }
        return null;
    }
//--------------------------------------------------------------------------    
  
    
    
//--------------------------------------------------------------------------    
// the following method calculates the total costs to be printed in the bill
    public double totalPrice() {
        double totalPrice = 0.0;
        for (int i = 0; i < this.getToMedicine(); i++) {
            totalPrice += this.getMedicine(i).getPrice();
        }
        totalPrice += this.doctor.getConsulationFees();
        return totalPrice + this.getRoom().getCharges();
    }
//--------------------------------------------------------------------------    
    
    @Override
    public int compareTo(Patient i) {
        if (this.id < i.id) {
            return -1;
        } else if (this.id > i.id) {
            return 1;
        } else {
            return 0;
        }
    }

    public String toString() {
        return "\nPatient Detail: \n"
                + " ID: " + super.getId() + " Name: " + super.getName() + "\n"
                + "\tDoctor : " + this.getDoctor().getName() + "   Doctor Consultation Fees: " + this.doctor.getConsulationFees() + " SR	\n"
                + "\tMedicines  are:  \n"
                + medicineReturner()
                + "\tRoom: " + this.getRoom().getRoomNo() + " Room Charge: " + this.getRoom().getCharges() + " SR  \n"
                + "                ==== Total Charges :" + totalPrice() + " SR ====\n"
                + "---------------------------------------------------------------";
    }

}
