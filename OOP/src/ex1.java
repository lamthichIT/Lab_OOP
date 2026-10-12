import java.util.Scanner;

class Student {
    private int year;
    private String name;

    // phuong thuc khoi dung
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
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Student khac = (Student) obj;
        return this.year == khac.year && this.name.equals(khac.name);
    }
}

public class ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap so SV:");
        int n = sc.nextInt();
        sc.nextLine();

        Student[] cls = new Student[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap SV thu" + (i + 1));
            System.out.println("Name:");
            String name = sc.nextLine();
            System.out.println("Year:");
            int year = sc.nextInt();
            sc.nextLine();
            cls[i] = new Student(year, name);
        }
        int sum = 0;
        System.out.println("\nDanh sach lop:");
        for (int i = 0; i < n; i++) {
            sum += 2012 - cls[i].getYear();
            System.out.println(cls[i].getName());
        }
        System.out.println("Tong so tuoi:" + sum);

        System.out.println("\n--Kiem tra equals---");
        Student test1 = new Student(2004, "Nam");
        Student test2 = new Student(2004, "Nam");
        Student test3 = new Student(2005, "Hai");
        System.out.println("test1 co giong test2 khong? " + test1.equals(test2)); // Sẽ in ra true

        System.out.println("test1 co giong test3 khong? " + test1.equals(test3)); // Sẽ in ra false
        sc.close();
    }
}







