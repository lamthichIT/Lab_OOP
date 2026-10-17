public class NhanVien {
    private String tenNhanVien;
    private double heSoLuong;

    public static final double LUONG_CO_BAN = 750000.0;
    public static final double LUONG_MAX = 20000000.0;

    // Constructor
    public NhanVien(String tenNhanVien, double heSoLuong) {
        this.tenNhanVien = tenNhanVien;
        this.heSoLuong = heSoLuong;
    }

    // Getter và Setter
    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    // Phương thức tăng lương
    public boolean tangLuong(double heSoTang) {
        double heSoMoi = this.heSoLuong + heSoTang;
        if (heSoMoi * LUONG_CO_BAN <= LUONG_MAX) {
            this.heSoLuong = heSoMoi;
            return true;
        }
        return false;
    }

    // Phương thức tính lương
    public double tinhLuong() {
        return this.heSoLuong * LUONG_CO_BAN;
    }

    // Phương thức in thông tin nhân viên
    public void inTTin() {
        System.out.println("Tên NV: " + tenNhanVien
                + " | Hệ số lương: " + heSoLuong
                + " | Lương: " + tinhLuong() + " VNĐ");
    }
}