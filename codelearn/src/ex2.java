import java.util.Scanner;

class Nhanvien {
    private String name;
    private double luong;
    private double heso;

    private static int soLuongNhanVien = 0;

    public Nhanvien(String name, double luong, double heso) {
        this.name = name;
        this.luong = luong;
        this.heso = heso;

        soLuongNhanVien++;
    }

    public double tinhLuong() return luong*heso;

    public static int getSoLuongNhanVien() return soLuongNhanVien;

    public static double tinhTongLuong(Nhanvien... list) {
        double sum = 0;
        for (Nhanvien nv : list) {
            sum += nv.tinhLuong();
        }
        return sum;
    }

    public void inTTin() System.out.println("Ten: "+name+"|Luong: "+

    tinhLuong());
}
public class ex2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong nhan vien: ");
        int n = sc.nextInt();
        sc.nextLine();
        Nhanvien[] ds = new Nhanvien[n];
        for(int i=0;i<n;i++){
            System.out.println("\n---Nhap thong tin nhan vien thu "+i+"---");
            System.out.println("Ho va ten:");
            String ten =  sc.nextLine();
            System.out.println("Luong co ban:");
            double sal = sc.nextDouble();
            sc.nextLine();

        }
    }
}