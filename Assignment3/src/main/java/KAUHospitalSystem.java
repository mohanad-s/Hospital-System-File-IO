/*
Name: Mohanad Al Dakheel
University ID: 2135847
Section: ZJ
Course: CPCS203
Assignment Number: #03
 */

import java.io.*;
import java.util.*;

public class KAUHospitalSystem {

    public static void main(String[] args) throws FileNotFoundException {
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------   
// the start of main method, which will create refrences to the IO files and call the methods that will deal with them

        //the creation of I/O files, Input Scanner & PrintWriter
        File inputFile = new File("C:\\Users\\the_e\\OneDrive\\Documents\\NetBeansProjects\\Assignment3\\src\\main\\java\\input.txt"); // refrence to the input file
        File outputFile = new File("C:\\Users\\the_e\\OneDrive\\Documents\\NetBeansProjects\\Assignment3\\src\\main\\java\\print.txt"); //refrence to the output file
        if (!(inputFile.exists())) // file availability checker
        {
            System.out.println(inputFile + " does not exist, please try again!");
        }
        PrintWriter fileWriter = new PrintWriter(outputFile); // a print writer for adding data to the output file
        Scanner input = new Scanner(inputFile).useLocale(Locale.US); // scanner for using data inside the input file
        fileWriter.print("--------------- Welcome to KAU Hospital System ---------------");



// the creation of arrays
        Room[] HRoom = new Room[input.nextInt()];
        Medicine[] HMedicine = new Medicine[input.nextInt()];
        Person[] HPerson = new Person[input.nextInt()];
        int[] medicines = new int[HMedicine.length];
        // the loop that guide the program through the methods
        String command;
        String command2;



// Array Counters
        int i = 0;
        int j = 0;
        int k = 0;
        int h = 0;
        int m = 0;
        do {

            command = input.next();

            if (command.equalsIgnoreCase("Add_Room")) {
                HRoom[i] = new Room(input.nextInt(), input.next(), input.next(), input.nextDouble());

                fileWriter.print("\nCommand " + command + ": Add a new room record in the System\n"
                        + "\tRoom No: " + HRoom[i].getRoomNo() + "\n"
                        + "\tLocated in floor: " + HRoom[i].getFloor() + "\n"
                        + "\tBlock :" + HRoom[i].getBlock() + "\n"
                        + "\tCharges: " + HRoom[i].getCharges() + "\n"
                        + "\n----------------------------------------------------------------");
                i++;

            } else if (command.equalsIgnoreCase("Add_Medicine")) {
                HMedicine[j] = new Medicine(input.nextInt(), input.next(), input.nextDouble());
                medicines[j] = HMedicine[j].getMedicineCode();
                fileWriter.print("\nCommand " + command + ": Add a new Medicine record in the System\n"
                        + "\tMedicine Code: " + HMedicine[j].getMedicineCode() + "\n"
                        + "\tName: " + HMedicine[j].getName() + "\n"
                        + "\tPrice :" + HMedicine[j].getPrice() + "\n"
                        + "\n"
                        + "----------------------------------------------------------------");
                j++;

            } else if (command.equalsIgnoreCase("Add_Doctor")) {
                HPerson[k] = new Doctor(input.nextDouble(), input.next(), input.next(), input.nextInt(), input.next(),
                        input.next(), input.next().charAt(0), input.nextInt());
                fileWriter.print("\nCommand " + command + ": Add a new doctor record in the System\n"
                        + "\tID: " + HPerson[k].getId() + "\n"
                        + "\tName: " + HPerson[k].getName() + "\n"
                        + "\tNationality :" + HPerson[k].getNationality() + "\n"
                        + "\tGender: " + HPerson[k].getGender() + "\n"
                        + "\tPhone: " + HPerson[k].getPhone() + "\n"
                        + "\tSpecilaization: " + ((Staff) HPerson[k]).getSpecialization() + "\n"
                        + "\tStaff ID: " + ((Staff) HPerson[k]).getStaffID() + "\n"
                        + "\tConsultation Fees :" + ((Doctor) HPerson[k]).getConsulationFees() + "\n"
                        + "\n"
                        + "----------------------------------------------------------------");
                k++;

            } else if (command.equalsIgnoreCase("Add_Nurse")) {
                HPerson[k] = new Nurse(input.nextInt(), input.next(), input.next(), input.nextInt(),
                        input.next(), input.next(), input.next().charAt(0), input.nextInt());
                fileWriter.print("\nCommand " + command + ": Add a new nurse record in the System\n"
                        + "\tID: " + HPerson[k].getId() + "\n"
                        + "\tName: " + HPerson[k].getName() + "\n"
                        + "\tNationality :" + HPerson[k].getNationality() + "\n"
                        + "\tGender: " + HPerson[k].getGender() + "\n"
                        + "\tPhone: " + HPerson[k].getPhone() + "\n"
                        + "\tSpecilaization: " + ((Staff) HPerson[k]).getSpecialization() + "\n"
                        + "\tStaff ID: " + ((Staff) HPerson[k]).getStaffID() + "\n"
                        + "\tExperience Year: " + ((Nurse) HPerson[k]).getExperience() + "\n"
                        + "\n"
                        + "----------------------------------------------------------------");
                k++;

            } else if (command.equalsIgnoreCase("Add_Patient")) {
                m += h;
                HPerson[k] = new Patient(input.next(), input.next(), input.nextInt(),
                        input.next(), input.next(), input.next().charAt(0), input.nextInt(), input.nextInt());
                fileWriter.print("\nCommand " + command + ": \nAdd a new Patient record in the System\n"
                        + "\tID: " + HPerson[k].getId() + "\n"
                        + "\tName: " + HPerson[k].getName() + "\n"
                        + "\tNationality :" + HPerson[m].getNationality() + "\n"
                        + "\tGender: " + HPerson[k].getGender() + "\n"
                        + "\tPhone: " + HPerson[k].getPhone() + "\n"
                        + "-------------------------------------------------------------------------------------------\n"
                        + "Illness: " + ((Patient) HPerson[k]).getIllness() + ", Blood Group: " + ((Patient) HPerson[k]).getBloodGroup() + "\n"
                        + "-------------------------------------------------------------------------------------------\n"
                        + "\n"
                        + "-------------------------------------------------------------------------------");
                k++;

            } else if (command.equalsIgnoreCase("Assign_Doctor_Patient")) {
                int ID1 = input.nextInt();
                int ID2 = input.nextInt();

                if (!availabilityD(HPerson, ID1)) {
                    fileWriter.print("\nCommand " + command + ":\n"
                            + "Doctor " + ID1 + " NOT FOUND \n"
                            + "-------------------------------------------------------------------------------");
                } else if (!availabilityD(HPerson, ID2)) {
                    fileWriter.print("\nCommand Assign_Doctor_Patient:\n"
                            + "Patient " + ID2 + " NOT FOUND \n"
                            + "-------------------------------------------------------------------------------");
                } else if (availabilityD(HPerson, ID1) && availabilityD(HPerson, ID2)) {

                    fileWriter.print("\nCommand " + command + ":\n"
                            + "Successfully Processed by the System:\n"
                            + "Following are the details:\n"
                            + "\t\tPatient: " + AssignerDP(ID1, ID2, HPerson, fileWriter).getName() + "\n"
                            + "\t\tAssigned to Doctor: " + ((Patient)AssignerDP(ID1, ID2, HPerson, fileWriter)).getDoctor().getName() + "\n"
                            + "-------------------------------------------------------------------------------");
                }

            } else if (command.equalsIgnoreCase("Assign_Room_Patient")) {
                int ID1 = input.nextInt();
                int ID2 = input.nextInt();

                if (!availabilityR(HRoom, ID1)) {
                    fileWriter.print("\nCommand " + command + ":\n"
                            + "Room " + ID1 + " NOT FOUND \n"
                            + "---------------------------------------------------------------------------------");
                } else if (!availabilityD(HPerson, ID2)) {
                    fileWriter.print("\nCommand " + command + ":\n"
                            + "Patient " + ID2 + " NOT FOUND \n"
                            + "---------------------------------------------------------------------------------");
                } else if (availabilityR(HRoom, ID1) && availabilityD(HPerson, ID2)) {

                    fileWriter.print("\nCommand " + command + ":\n"
                            + "Successfully Processed by the System:\n"
                            + "Following are the details:\n"
                            + "\tPatient: " + HPerson[AssignerRP(ID1, ID2, HRoom, HPerson, fileWriter)[1]].getName() + "\n"
                            + "\tAssigned to Room:\tRoom No: " + ((Patient) HPerson[AssignerRP(ID1, ID2, HRoom, HPerson, fileWriter)[1]]).getRoom().getRoomNo() + "\n"
                            + "\tLocated in floor: " + ((Patient) HPerson[AssignerRP(ID1, ID2, HRoom, HPerson, fileWriter)[1]]).getRoom().getFloor() + "\n"
                            + "\tBlock :" + ((Patient) HPerson[AssignerRP(ID1, ID2, HRoom, HPerson, fileWriter)[1]]).getRoom().getBlock() + "\n"
                            + "\tCharges: " + ((Patient) HPerson[AssignerRP(ID1, ID2, HRoom, HPerson, fileWriter)[1]]).getRoom().getCharges() + "\n"
                            + "\n"
                            + "---------------------------------------------------------------------------------");

                }
            } else if (command.equalsIgnoreCase("Assign_Medicine_Patient")) {

                int ID1 = input.nextInt();
                int count = input.nextInt();

                fileWriter.print("\nCommand " + command + ":\n");

                if (!availabilityD(HPerson, ID1)) {
                    fileWriter.print("Patient " + ID1 + " NOT FOUND \n");
                } else if (Mismatch(HPerson, ID1, count, fileWriter)) {

                } else if (availabilityD(HPerson, ID1) && !Mismatch(HPerson, ID1, count, fileWriter)) {
                    AssignerMP(ID1, HMedicine, HPerson, input, fileWriter, count);
                }

                fileWriter.print("-----------------------------------------------------------------------------");

            } else if (command.equalsIgnoreCase("Print_Bill")) {
                printBill(fileWriter , HPerson);
            }

        } while (!(command.equalsIgnoreCase("Quit")));
        fileWriter.flush();
        fileWriter.close();
    }// end of main method
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 
    
    
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//THE FOLLOWING METHODS ARE AVAILABILITY CHECKERS, THEY TURN TRUE IF THEY FIND TARGEET (availabilityD for any person) and (availabilityR for rooms)    
    public static boolean availabilityD(Person[] person, int ID) {
        for (int x = 0; x < person.length; x++) {
            if (person[x].getId() == ID) {
                return true;
            }
        }

        return false;
    }

    public static boolean availabilityR(Room[] room, int ID) {
        for (int x = 0; x < room.length; x++) {
            if (room[x].getRoomNo() == ID) {
                return true;
            }
        }

        return false;
    }
// end of availability checkers
//---------------------------------------------------------------------------------------------------------------------------------------------  
  
    
    
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//the following methods are assigners:   
// AssignerDP-> ASSIGNS DOCTOR TO PATIENT
// AssignerRP-> ASSIGNS ROOM TO PATIENT
// AssignerMP-> ASSIGNS MEDICINES TO PATIENT    
    public static Person AssignerDP(int ID1, int ID2, Person[] person, PrintWriter output) {
     
        for (int x = 0; x < person.length; x++) {

            boolean ans = person[x].getId() == ID1; // this line will help us get the exact patient we want
            if (ans) {
               
                for (int j = 0; j < person.length; j++) {
                    ans = person[j].getId() == ID2;// this line will help us get the exact Doctor we want
                    if (ans) {
                      
                        ((Patient) person[j]).setDoctor(((Doctor) person[x])); // the assignment happens here through the set method 
                        
                        return ((Patient) person[j]);// it returns the desired person
                    }
                }
            }

        }

        return null;
    }

    public static int[] AssignerRP(int ID1, int ID2, Room[] room, Person[] person, PrintWriter output) {
        int ID1Index = 0;
        int ID2Index = 0;
        int[] desiredIndices = {ID1Index, ID2Index};
        for (int x = 0; x < room.length; x++) {

            boolean ans = room[x].getRoomNo() == ID1; // this line will help us get the exact room we want
            if (ans) {
                ID1Index = x;
                for (int j = 0; j < person.length; j++) {
                    ans = person[j].getId() == ID2; // this line will help us get the exact patient we want
                    if (ans) {
                        ID2Index = j;
                        ((Patient) person[j]).setRoom(room[x]); // the assignment happens here through the set method
                        desiredIndices[0] = x;
                        desiredIndices[1] = j;
                        return desiredIndices; 
                    }
                }
            }

        }

        return null;
    }

    public static void AssignerMP(int ID, Medicine[] medicine, Person[] person, Scanner input, PrintWriter output, int size) {
        Medicine[] heal = new Medicine[size]; // intialize array 
        boolean checker = false; // boolean checker
        int checkerelm = 0; // checker element
        for (int i = 0; i < size; i++) { // loop thru the size
            int elm = input.nextInt(); // take med
            checker = true;
            checkerelm = elm;
            for (int j = 0; j < medicine.length; j++) { // loop thru medicine array
                if (medicine[j].getMedicineCode() == elm) { // check if elm exists
                    heal[i] = medicine[j];
                    checker = false;
                    break;
                }
            }
        }
        if (checker) {
            output.print("Medicines " + checkerelm + " NOT FOUND \n"); // prints this message if checker is true

        } else {// otherwise, prints the details of the assigning process

            for (int i = 0; i < person.length; i++) {

                if (person[i] instanceof Patient) {
                    if (ID == person[i].getId()) {
                        output.print("Successfully Processed by the System:\n"
                                + "Following are the details:\n"
                                + "\tPatient: " + person[i].getName() + "\n");

                        for (int j = 0; j < size; j++) {
                            ((Patient) person[i]).setMedicine(heal[j], j);
                            output.print("\tMedicine Prescribed: " + ((Patient) person[i]).getMedicine(j).getName() + "\n");
                        }
                    }
                }
            }
        }
    }//END OF ASSIGNER METHODS
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------  
    
    
 
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// this method is mismatch checker, checks if the value of input(which determines the size of medicine array inside patient) is equal to the size already stored
    public static boolean Mismatch(Person[] person, int ID, int NoMeds, PrintWriter output) {
        for (int x = 0; x < person.length; x++) {
            if (person[x].getId() == ID) {
                if (((Patient) person[x]).getToMedicine() != NoMeds) {
                   // prints out the following message in case the value of input is not equal to the array size, and returns true in that case
                    output.print("Information mismatch: Patient " + person[x].getId() + "must have " + ((Patient) person[x]).getToMedicine() + " medicine not " + NoMeds + "\n");

                    return true;
                }
            }
        }
        return false;
    }
//end of mismatch checker
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------



//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// printBill method: it sorts patients according to their IDs and print their data    
    
    public static void printBill(PrintWriter output, Person[] person) {
     // Creating a new patient ArrayList that will save the same data saved in patients of HPerson array
        ArrayList<Patient> arraeList = new ArrayList<Patient>(); 
        
       String date = new Date().toString();

        output.print("\n\nCommand: Print_Bill\n"
                + "\n\n\n--------------- Welcome to KAU Hospital System ---------------\n"
                + "\n--------- Current Date :  " + date + "--------\n"
                + "\n==================================================================");
       
       for(int v = 0 ; v < person.length ; v++ ){
             if (person[v] instanceof Patient){
             arraeList.add(((Patient)person[v]));
             
             
             
             
             }
        }
Collections.sort(arraeList); //sorting the arrayList

   
output.print(arraeList.toString().replace("," , "-").replaceAll("[\\[\\]]", "")); // replace square brackets and commas with empty string
output.print("\nThank you for using KAU Hospital System, Good Bye!");
    }
//end of printBill
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 
    
}