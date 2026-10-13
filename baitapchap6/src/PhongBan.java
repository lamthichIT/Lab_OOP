public class PhongBan {
    private String tenPhongBan;
    private byte soNhanVien;

    public static final byte SO_NV_MAX = 100;
    private NhanVien[] dsNhanVien; // Mảng lưu danh sách nhân viên

    // Constructor với số lượng tham số cần thiết
    public PhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
        this.soNhanVien = 0;
        this.dsNhanVien = new NhanVien[SO_NV_MAX];
    }

    // Thêm nhân viên theo cơ chế Stack (Push)
    public boolean themNV(NhanVien nv) {
        if (soNhanVien < SO_NV_MAX) {
            dsNhanVien[soNhanVien] = nv;
            soNhanVien++;
            return true;
        }
        return false; // Phòng đã đầy
    }

    // Xóa nhân viên theo cơ chế Stack (Pop)
    public NhanVien xoaNV() {
        if (soNhanVien > 0) {
            soNhanVien--;
            NhanVien nvBiXoa = dsNhanVien[soNhanVien];
            dsNhanVien[soNhanVien] = null; // Giải phóng ô nhớ
            return nvBiXoa;
        }
        return null; // Danh sách rỗng
    }

    // Tính tổng lương của các nhân viên trong phòng
    public double tongLuong() {
        double tong = 0;
        for (int i = 0; i < soNhanVien; i++) {
            tong += dsNhanVien[i].tinhLuong();
        }
        return tong;
    }

    // Hiển thị thông tin của phòng và thông tin của các nhân viên trong phòng
    public void inTTin() {
        System.out.println("------------------------------------------");
        System.out.println("Tên phòng ban: " + tenPhongBan);
        System.out.println("Số lượng nhân viên hiện tại: " + soNhanVien + "/" + SO_NV_MAX);
        System.out.println("Danh sách nhân viên:");

        if (soNhanVien == 0) {
            System.out.println("  (Chưa có nhân viên nào trong phòng)");
        } else {
            for (int i = 0; i < soNhanVien; i++) {
                System.out.print("  " + (i + 1) + ". ");
                dsNhanVien[i].inTTin();
            }
        }
        System.out.println(">> Tổng lương phòng ban: " + tongLuong() + " VNĐ");
        System.out.println("------------------------------------------");
    }
}