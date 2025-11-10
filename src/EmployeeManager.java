import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManager {
    public static void main(String[] args) {
        ArrayList<Employee> listEmployees = new ArrayList<Employee>();
        Employee employee;
        Scanner input = new Scanner(System.in);
        int index = 0;

        while(true){
            int pilihan = milih();
            switch (pilihan){
                case 1:
                    System.out.println("\n=====MENAMBAH KARYAWAN BARU=====");
                    while (true){
                        String nameInput = tanyaNama();
                        String positionInput = tanyaJabatan();
                        int salaryInput = tanyaGaji();

                        System.out.println("\nKaryawan baru:");
                        tampil(nameInput, positionInput, salaryInput);

                        System.out.print("Apakah data sudah benar? (y/n): ");
                        String konfirm = input.nextLine();
                        if(konfirm.equals("y")){
                            employee = new Employee(nameInput, positionInput, salaryInput);
                            listEmployees.add(employee);
                            index++;
                            break;
                        }
                    }
                    break;
                case 2:
                    if(!listEmployees.isEmpty()){
                        for (int i = 0; i < listEmployees.size(); i++){
                            System.out.println("\nKaryawan index ke-" + i);
                            tampil(listEmployees.get(i).name,
                                    listEmployees.get(i).position,
                                    listEmployees.get(i).salary);
                        }
                    } else{
                        dataKosong();
                    }
                    pause();
                    break;
                case 3:
                    if(!listEmployees.isEmpty()){
                        System.out.println("\n=====MENGEDIT DATA KARYAWAN=====");
                        int indexKaryawan = tanyaIndex();

                        if (indexKaryawan < listEmployees.size()){
                            System.out.println("\nKaryawan index ke-" + indexKaryawan);
                            tampil(listEmployees.get(indexKaryawan).name,
                                    listEmployees.get(indexKaryawan).position,
                                    listEmployees.get(indexKaryawan).salary);

                            System.out.println("\nData baru:");
                            String nameInput = tanyaNama();
                            String positionInput = tanyaJabatan();
                            int salaryInput = tanyaGaji();

                            Employee newEmployee = new Employee(nameInput, positionInput, salaryInput);
                            listEmployees.set(indexKaryawan, newEmployee);

                            System.out.println("\nKaryawan index ke-" + indexKaryawan + " telah diperbaharui");
                        } else {
                            outOfBound();
                        }
                    } else {
                        dataKosong();
                    }
                    pause();
                    break;
                case 4:
                    if (!listEmployees.isEmpty()){
                        System.out.println("\n=====MENGHAPUS KARYAWAN=====");
                        int indexKaryawan = tanyaIndex();

                        if (indexKaryawan < listEmployees.size()){

                            System.out.println("\nKaryawan index ke-" + indexKaryawan);
                            tampil(listEmployees.get(indexKaryawan).name,
                                    listEmployees.get(indexKaryawan).position,
                                    listEmployees.get(indexKaryawan).salary);

                            System.out.print("Apakah kamu yakin mau gitmenghapusnya? (y/n): ");
                            String konfirm = input.nextLine();

                            if(konfirm.equals("y")){
                                listEmployees.remove(indexKaryawan);
                                System.out.println("\nKaryawan ke-" + indexKaryawan + "telah dihapus");
                            }
                        } else{
                            outOfBound();
                        }
                    } else{
                        dataKosong();
                    }
                    pause();
                    break;
                default:
                    System.out.println("\nPilihan tidak tersedia");
                    pause();
            }

        }
    }

    static int milih(){
        Scanner input= new Scanner(System.in);
        System.out.println("\nPilihan:");
        System.out.println("1. Add Employee");
        System.out.println("2. View Employees");
        System.out.println("3. Edit Employee");
        System.out.println("4. Delete Employee");
        System.out.print("Pilih salah satu fitur (1-4): ");
        int pilihan = input.nextInt();
        input.nextLine(); //kalo ga pake ini nextLine() selanjutnya ke skip
        return pilihan;
    }

    static void pause(){
        Scanner input = new Scanner(System.in);
        System.out.print("\nTekan enter untuk melanjutkan");
        input.nextLine();
    }

    static int tanyaIndex(){
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan index karyawan: ");
        int indexKaryawan = input.nextInt();
        input.nextLine();
        return indexKaryawan;
    }

    static String tanyaNama(){
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan nama: ");
        String nameInput = input.nextLine();
        return nameInput;
    }

    static String tanyaJabatan(){
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan jabatan: ");
        String positionInput = input.nextLine();
        return positionInput;
    }

    static int tanyaGaji(){
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan gaji: ");
        int salaryInput = input.nextInt();
        input.nextLine();
        return salaryInput;
    }

    static void tampil(String nama, String jabatan, int gaji){
        System.out.println("Nama: " + nama);
        System.out.println("Jabatan: " + jabatan);
        System.out.println("Gaji: " + gaji);
    }

    static void dataKosong(){
        System.out.println("\nData belum ada");
    }

    static void outOfBound(){
        System.out.println("\nIndex tidak ditemukan");
    }
}