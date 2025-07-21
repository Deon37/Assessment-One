import java.util.ArrayList;

// https://alstonville.clinic/

class HealthProfessional
{
    private int id;
    private String name;
    private String department;

    public HealthProfessional() {
        this.id = 0;
        this.name = "Unknown Name";
        this.department = "General";
    }

    public HealthProfessional(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public void PrintDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
    }
}

class GeneralPractitioner extends HealthProfessional
 {
    private String specialisation;

    public GeneralPractitioner() {
        super();
        this.specialisation = "Unknown Specialisation";
    }

    public GeneralPractitioner(int id, String name, String department, String specialisation) {
        super(id, name, department);
        this.specialisation = specialisation;
    }

    @Override
    public void PrintDetails() {
        System.out.println("The Health Professional Details Are:");
        super.PrintDetails();
        System.out.println("Specialisation: " + this.specialisation);
        System.out.println("Type: General Practitioner");
    }
}

class SpecialistDoctor extends HealthProfessional 
{
    private String field;

    public SpecialistDoctor() {
        super();
        this.field = "Unknown Specialty";
    }

    public SpecialistDoctor(int id, String name, String department, String field) {
        super(id, name, department);
        this.field = field;
    }

    @Override
    public void PrintDetails() {
        System.out.println("The Health Professional Details Are:");
        super.PrintDetails();
        System.out.println("Field: " + this.field);
        System.out.println("Type: Specialist Doctor");
    }
}

class Appointment
{
    private String patientName;
    public String patientMobile;
    private String preferredTime;
    private HealthProfessional selectedDoctor;

    public Appointment() {
        this.patientName = "Unknown";
        this.patientMobile = "0000000000";
        this.preferredTime = "00:00";
        this.selectedDoctor = null;
    }

    public Appointment(String patientName, String patientMobile, String preferredTime, HealthProfessional selectedDoctor) {
        this.patientName = patientName;
        this.patientMobile = patientMobile;
        this.preferredTime = preferredTime;
        this.selectedDoctor = selectedDoctor;
    }

    public void PrintDetails() 
    {
        if (patientName.isEmpty()) {
              System.out.println("Name Invalid");
              return;
        }

        if (patientMobile.isEmpty() || patientMobile.length() < 10) {
             System.out.println("Phone Invalid");
             return;
        }

        if (preferredTime.isEmpty()) {
             System.out.println("Time Invalid");
              return;
        }

        // 10:00

        String[] parts = preferredTime.split(":");
        int hour = Integer.parseInt(parts[0]);

        if (hour < 9 || hour > 17) {
            System.out.println("Failed To Book \nBusiness Hours 09:00 - 17:00\nPlease Book In Provided Hours");
            return;
        }

        if (selectedDoctor == null) {
             System.out.println("Doctor Invalid");
             return;
        }
        
        System.out.println("Patient Name: " + patientName);
        System.out.println("Patient Mobile: " + patientMobile);
        System.out.println("Preferred Time: " + preferredTime);

        System.out.println("------------------------------");
        System.out.println("Doctor Details:");
        selectedDoctor.PrintDetails();
    }
}

public class AssignmentOne
{
    static ArrayList<Appointment> appointments = new ArrayList<Appointment>();

    public static void createAppointment(String name, String mobile, String time, HealthProfessional doctor)
     {
        if (name == null || mobile == null || time == null || doctor == null) {
            System.out.println("Missing Fields, Please Ensure You Fill Everything Out");
            return;
        }

        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);

        if (hour < 9 || hour > 17) {
            System.out.println("Failed To Book \nBusiness Hours 09:00 - 17:00\nPlease Book In Provided Hours");
            return;
        }

        Appointment newAppt = new Appointment(name, mobile, time, doctor);
        appointments.add(newAppt);
        System.out.println("Appointment Successfully Created");
        System.out.println("------------------------------");
        newAppt.PrintDetails();
    }

    public static void printExistingAppointments() 
    {
        if (appointments.isEmpty()) {
            System.out.println("No Appointments Found");
            return;
        }

        for (Appointment appt : appointments) 
        {
            System.out.println("------------------------------");
            appt.PrintDetails();
        }

        System.out.println("------------------------------");
    }

     public static void cancelBooking(String patientMobile) 
     {
        int i = 0;
        int foundIndex = -1;

        while (i < appointments.size())
        {
            Appointment a = appointments.get(i);

            if (a.patientMobile.equals(patientMobile)) {
                foundIndex = i;
            }

            // i++
            i = i + 1;
        }

        if (foundIndex == -1) {
            System.out.println("No Appointment Found For Mobile " + patientMobile);
            System.out.println("------------------------------");
            return;
        }

        appointments.remove(foundIndex);
        System.out.println("Appointment For Mobile " + patientMobile + " Has Been Cancelled");
        System.out.println("------------------------------");
    }

    public static void main(String[] args)
    {
        // Part 3 – Using classes and objects
        GeneralPractitioner gp1 = new GeneralPractitioner(1, "Dr Tony Lembke", "General Practice", "Men's Health");
        GeneralPractitioner gp2 = new GeneralPractitioner(2, "Dr Caitlin Witt", "General Practice", "Women's Health");
        GeneralPractitioner gp3 = new GeneralPractitioner(3, "Dr Luke Hogan", "General Practice", "Family Medicine");

        SpecialistDoctor sd1 = new SpecialistDoctor(4, "Dr Vicki Liu", "Women's Health", "Obstetrics & Gynaecology");
        SpecialistDoctor sd2 = new SpecialistDoctor(5, "Dr Tom Lucena", "Diagnostics", "Psychology & Behavioural Health");

        gp1.PrintDetails();
        System.out.println("------------------------------");
        gp2.PrintDetails();
        System.out.println("------------------------------");
        gp3.PrintDetails();
        System.out.println("------------------------------");
        sd1.PrintDetails();
        System.out.println("------------------------------");
        sd2.PrintDetails();
        System.out.println("------------------------------");

        // Part 5 – Collection of appointments 
        createAppointment("Alice Smith", "0412345678", "09:30", gp1);  // GP
        createAppointment("Bob White", "0423456789", "10:30", gp2);    // GP
        createAppointment("Clara Green", "0434567890", "13:00", sd1);  // Specialist
        createAppointment("David Black", "0445678901", "15:00", sd2);  // Specialist

        System.out.println("Printing All Appointments:");
        printExistingAppointments();

        System.out.println("Cancelling Bob Whites Appointment:");
        cancelBooking("0423456789");

        System.out.println("Printing Appointments After Cancellation:");
        printExistingAppointments();
    }
}