class HealthProfessional 
{
    private int id;
    private String name;
    private String department;

    public HealthProfessional() {
        this.id = 0;
        this.name = "Unknown";
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

public class AssignmentOne 
{
    public static void main(String[] args) throws Exception 
    {
        HealthProfessional hp = new HealthProfessional(1, "Dr. Alice", "General Medicine");
        hp.PrintDetails();
    }
}