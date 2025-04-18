/*
Name: Mohanad Al Dakheel
University ID: 2135847
Section: ZJ
Course: CPCS203
Assignment Number: #03
 */
public class Medicine {

    private int medicineCode;
    private String name;
    private double price;

    public Medicine(int medicineCode, String name, double price) {
        this.medicineCode = medicineCode;
        this.name = name;
        this.price = price;
    }

    public int getMedicineCode() {
        return medicineCode;
    }

    public void setMedicineCode(int medicineCode) {
        this.medicineCode = medicineCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Medicine{" + "medicineCode=" + medicineCode + ", name=" + name + ", price=" + price + '}';
    }

}
