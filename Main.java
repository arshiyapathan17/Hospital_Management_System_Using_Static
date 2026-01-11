import java.util.Scanner;

class Hospital {

    // Static data members (shared memory)
    static String hospitalName = "City Care Hospital";
    static String emergencyNumber = "108";
    static String visitingHours = "10 AM to 6 PM";
    static int totalPatients = 0;

    // Non-static data members (unique for each object)
    int patientId;
    String patientName;
    String disease;

    // Constructor
    Hospital(int patientId, String patientName, String disease) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.disease = disease;
        totalPatients++;
    }

    // Static method
    static void showHospitalInfo() {
        System.out.println("\n------ Hospital Information ------");
        System.out.println("Hospital Name    : " + hospitalName);
        System.out.println("Emergency Number : " + emergencyNumber);
        System.out.println("Visiting Hours   : " + visitingHours);
        System.out.println("Total Patients   : " + totalPatients);
    }

    // Non-static method
    void showPatientDetails() {
        System.out.println("\n------ Patient Details ------");
        System.out.println("Patient ID   : " + patientId);
        System.out.println("Patient Name : " + patientName);
        System.out.println("Disease      : " + disease);
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Hospital[] patients = new Hospital[50]; // storing up to 50 patients
        int count = 0;
        int choice;

        do {
            System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM =====");
            System.out.println("1. Add New Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. View Hospital Information");
            System.out.println("4. Search Patient by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Patient ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();  // clear buffer

                    System.out.print("Enter Patient Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Disease: ");
                    String disease = sc.nextLine();

                    patients[count] = new Hospital(id, name, disease);
                    count++;

                    System.out.println("Patient added successfully!");
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("No patient records available.");
                    } else {
                        for (int i = 0; i < count; i++) {
                            patients[i].showPatientDetails();
                        }
                    }
                    break;

                case 3:
                    Hospital.showHospitalInfo();
                    break;

                case 4:
                    System.out.print("Enter Patient ID to search: ");
                    int searchId = sc.nextInt();
                    boolean found = false;

                    for (int i = 0; i < count; i++) {
                        if (patients[i].patientId == searchId) {
                            patients[i].showPatientDetails();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Patient not found!");
                    }
                    break;

                case 5:
                    System.out.println("Exiting System... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
