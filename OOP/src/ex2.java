import java.util.Scanner;

class Nhanvien {
    private String name;
    private double luong;
    private double heso;

    private static int soLuongNhanVien = 0;

    public Nhanvien(String name , double luong, double heso){
        this.name=name;
        this.luong=luong;
        this.heso=heso;

        soLuongNhanVien++;
    }
    public double tinhluong(){
        return luong*heso;
    }
    public static int getSoLuongNhanVien() {
        return soLuongNhanVien;
    }
    public static double tinhTongLuong(Nhanvien... list ){
        double sum=0;
        for(Nhanvien nv : list){
            sum+=nv.tinhluong();
        }
        return sum;
    }
    public void inTTin() {
        System.out.println("Ten: "+ name +"| Luong: "+ tinhluong());
    }
}
public class ex2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap so luong nv: ");
        int n=sc.nextInt();
        sc.nextLine();

        Nhanvien[] ds = new Nhanvien[n];
        for(int i=0;i<n;i++) {
            System.out.println("\n--- Nhap thong tin nhan vien thu " + (i + 1) + "---");
            System.out.println("Ho va ten: ");
            String ten = sc.nextLine();
            System.out.println("Luong co ban: ");
            double sal = sc.nextDouble();
            sc.nextLine();
            System.out.println("He so luong: ");
            double hesoluong = sc.nextDouble();
            sc.nextLine();
            ds[i] = new Nhanvien(ten, sal, hesoluong);
        }
        System.out.println("So luong nhan vien da tao: "+Nhanvien.getSoLuongNhanVien());
        for(Nhanvien nv : ds) nv.inTTin();
        double tongLuong = Nhanvien.tinhTongLuong(ds);
        System.out.println("Tong luong:"+tongLuong);
    }
}