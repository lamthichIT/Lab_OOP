import java.util.Scanner;

public class input {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        int age = sc.nextInt();
        double gpa = sc.nextDouble();
        System.out.println("name: "+name);
        System.out.println("age: "+age);
        System.out.println("GPA: "+gpa);
    }
}