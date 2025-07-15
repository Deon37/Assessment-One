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
        System.out.println("The health professional details are:");
        super.PrintDetails();
        System.out.println("Specialisation: " + this.specialisation);
        System.out.println("Type: General Practitioner");
    }
}

class SpecialistDoctor extends HealthProfessional {
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
        System.out.println("The health professional details are:");
        super.PrintDetails();
        System.out.println("Field: " + this.field);
        System.out.println("Type: Specialist Doctor");
    }
}

public class AssignmentOne
 {
    public static void main(String[] args) 
    {
        HealthProfessional hp = new HealthProfessional(4, "Wren Casement", "General Nursing");
        hp.PrintDetails();

        System.out.println();

        GeneralPractitioner gp = new GeneralPractitioner(2, "Dr. Caitlin Witt", "Family Medicine", "Women's Health");
        gp.PrintDetails();

        System.out.println();

        SpecialistDoctor sd = new SpecialistDoctor(3, "Dr. Tom Lucena", "Diagnostics", "Human Behaviour & Psychology");
        sd.PrintDetails();
    }
}