import java.util.Scanner;


public class EmployeeManager {
    public static void main(String[] args) {
        int index = 0;
        String konfirm;

        Employee[] employee = new Employee[index + 1];
        Employee[] temp = new Employee[index+2]; // untuk menyimpan data karyawan sementara

        while(true){
            Scanner input = new Scanner(System.in);

            tampilkanPilihan();
            int pilihan = input.nextInt();
            input.nextLine(); //kalo ga pake ini nextLine() selanjutnya ke skip

            switch (pilihan){
                case 1:
                    konfirm = "n";
                    System.out.println("\n=====MENAMBAH DATA KARYAWAN=====");

                    while (konfirm.equals("n")){
                        System.out.print("\nMasukan nama karyawan: ");
                        String nameInput = input.nextLine();

                        System.out.print("Masukan posisi karyawan: ");
                        String positionInput = input.nextLine();

                        System.out.print("Masukan salary karyawan: ");
                        int salaryInput = input.nextInt();
                        input.nextLine();

                        employee[index] = new Employee(nameInput, positionInput, salaryInput);

                        System.out.println("\nKaryawan baru:");
                        System.out.println("Nama: " + employee[index].name);
                        System.out.println("Posisi: " + employee[index].position);
                        System.out.println("Salary: " + employee[index].salary);

                        System.out.print("Apakah data sudah benar? (y/n): ");
                        konfirm = input.nextLine();
                    }

                    for(int i = 0;i<employee.length;i++){
                        temp[i] = employee[i];
                    }

                    index++;
                    employee = new Employee[index+1];

                    for(int i = 0;i<employee.length;i++){
                        employee[i] = temp[i];
                    }

                    temp = new Employee[index+2];
                    break;
                case 2:
                    if (index != 0){
                        System.out.println("\n=====MENAMPILKAN DATA KARYAWAN=====");
                        for(int i = 0;i<employee.length-1;i++){
                            System.out.println("\nKaryawan index ke-" + i);
                            System.out.println("Nama: " + employee[i].name);
                            System.out.println("Posisi: " + employee[i].position);
                            System.out.println("Salary: " + employee[i].salary);
                        }
                        pause();
                    } else{
                        System.out.println("\nData belum ada");
                        pause();
                    }
                    break;
                case 3:
                    konfirm = "n";
                    System.out.println("\n=====MENGEDIT DATA KARYAWAN=====");
                    System.out.print("Masukan index karyawan yang ingin diedit: ");
                    int indexKaryawan = input.nextInt();
                    input.nextLine();
                    while(!konfirm.equals("y") && konfirm.equals("n")){
                        if(index != 0){
                            System.out.println("\nData karyawan index ke-" + indexKaryawan);
                            System.out.println("Nama: " + employee[indexKaryawan].name);
                            System.out.println("Posisi: " + employee[indexKaryawan].position);
                            System.out.println("salary: " + employee[indexKaryawan].salary);

                            System.out.print("\nUbah nama: ");
                            String namaBaru = input.nextLine();

                            System.out.print("Ubah posisi: ");
                            String posisiBaru = input.nextLine();

                            System.out.print("Ubah salary: ");
                            int salaryBaru = input.nextInt();
                            input.nextLine();

                            employee[indexKaryawan].editData(namaBaru, posisiBaru, salaryBaru);

                            System.out.println("\nData baru karyawan index ke-" + indexKaryawan);
                            System.out.println("Nama: " + employee[indexKaryawan].name);
                            System.out.println("Posisi: " + employee[indexKaryawan].position);
                            System.out.println("salary: " + employee[indexKaryawan].salary);

                            System.out.print("Apakah data baru sudah benar? (y/n): ");
                            konfirm = input.nextLine();
                        } else{
                            System.out.println("Belum ada Data");
                            pause();
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("=====MENGHAPUS DATA KARYAWAN=====");
                    System.out.print("Masukan index karyawan yang ingin di hapus: ");
                    indexKaryawan = input.nextInt();
                    input.nextLine();

                    System.out.println("\nData karyawan index ke-" + indexKaryawan);
                    System.out.println("Nama: " + employee[indexKaryawan].name);
                    System.out.println("Posisi: " + employee[indexKaryawan].position);
                    System.out.println("salary: " + employee[indexKaryawan].salary);

                    System.out.println("Apakah kamu yakin ingin menghapusnya? (y/n): ");
                    konfirm = input.nextLine();
                    if (konfirm.equals("y")){

                    }
                    break;
                default:
                    System.out.println("\nPilihan tidak tersedia");
                    System.out.print("Tekan enter untuk melanjutkan");
                    input.nextLine();

            }

        }
    }

    static void tampilkanPilihan(){
        System.out.println("\nPilihan:");
        System.out.println("1. Add Employee");
        System.out.println("2. View Employees");
        System.out.println("3. Edit Employee");
        System.out.println("4. Delete Employee");
        System.out.print("Pilih salah satu fitur (1-4): ");
    }

    static void pause(){
        Scanner input = new Scanner(System.in);
        System.out.print("Tekan enter untuk lanjut");
        input.nextLine();
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

    void editData(String name, String position, int salary){
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
}