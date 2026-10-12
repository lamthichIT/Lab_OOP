import java.util.Scanner;
class Student {
    private int year;
    private String name;

    public Student(int year, String name) {
        this.year = year;
        this.name = name;
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Student studentKhac = (Student) obj;

        return this.year == studentKhac.year && this.name.equals(studentKhac.name);
    }
}

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap so SV:");
        int N = scanner.nextInt();

        Student[] cls = new Student[N];

        for (int i = 0; i < N; ++i) {
            System.out.println("Nhap SV thu " + (i + 1));
            System.out.println("Name: ");
            String name = scanner.next();
            System.out.println("Year: ");
            int year = scanner.nextInt();

            cls[i] = new Student(year, name);
        }

        int total = 0;
        System.out.println("\nDanh sach lop: ");
        for (int i = 0; i < N; ++i) {
            total += 2012 - cls[i].getYear();
            System.out.println(cls[i].getName());
        }

        System.out.println("Tong so tuoi: " + total);

        System.out.println("\n--- Kiem tra equals ---");
        Student test1 = new Student(2004, "Nam");
        Student test2 = new Student(2004, "Nam");
        Student test3 = new Student(2005, "Hai");

        System.out.println("test1 co giong test2 khong? " + test1.equals(test2)); // Sẽ in ra true
        System.out.println("test1 co giong test3 khong? " + test1.equals(test3)); // Sẽ in ra false

        scanner.close();
    }
}