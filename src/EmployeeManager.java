import java.util.Scanner;


public class EmployeeManager {
    public static void main(String[] args) {
        while(true){
            Scanner input = new Scanner(System.in);
            int index = 0;

            System.out.println("\nPilihan:");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Edit Employee");
            System.out.println("4. Delete Employee");
            System.out.print("Pilih salah satu fitur (1-4): ");
            int pilihan = input.nextInt();
            input.nextLine(); //kalo ga pake ini nextLine() selanjutnya ke skip

            Employee[] employee = new Employee[index + 1];


            switch (pilihan){
                case 1:
                    String konfirm = "n";
                    System.out.println("\nMenambahkan karyawan baru");

                    while (konfirm.equals("n")){
                    System.out.print("Masukan nama karyawan: ");
                    String nameInput = input.nextLine();

                    System.out.print("Masukan posisi karyawan: ");
                    String positionInput = input.nextLine();

                    System.out.print("Masukan salary karyawan: ");
                    int salaryInput = input.nextInt();
                    input.nextLine();

                    employee[index] = new Employee(nameInput, positionInput, salaryInput);

                    System.out.println("\nKaryawan baru:");
                    System.out.println("Nama: " + employee[index].name);
                    System.out.println("Jabatan: " + employee[index].position);
                    System.out.println("Salary: " + employee[index].salary);

                    System.out.print("Apakah data sudah benar? (y/n): ");
                    konfirm = input.nextLine();
                    }
                    index++;
                    break;
                case 2:
                    for(int i = 0;i<employee.length;i++){
                        System.out.println("\nKaryawan index ke-" + i);
                        System.out.println("Nama: " + employee[i].name);
                        System.out.println("Posisi: " + employee[i].position);
                        System.out.println("Salary: " + employee[i].salary);
                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia");
            }

        }
    }
}

class Employee{
    String name;
    String position;
    int salary;

    Employee(String name, String position, int salary){
       this.name = name;
       this.position = position;
       this.salary = salary;
    }
}