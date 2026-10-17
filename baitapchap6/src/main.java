import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Nhập thông tin phòng ban từ bàn phím
        System.out.print("Nhập tên phòng ban: ");
        String tenPhongBan = scanner.nextLine();
        PhongBan pb = new PhongBan(tenPhongBan);

        int luaChon = 0;

        do {
            System.out.println("\n========== MENU QUẢN LÝ PHÒNG BÁN ==========");
            System.out.println("1. Thêm nhân viên vào phòng (Push Stack)");
            System.out.println("2. Xóa nhân viên khỏi phòng (Pop Stack)");
            System.out.println("3. In thông tin phòng ban và danh sách nhân viên");
            System.out.println("0. Thoát chương trình");
            System.out.print("Chủ động chọn chức năng (0-3): ");

            luaChon = Integer.parseInt(scanner.nextLine());

            switch (luaChon) {
                case 1:
                    System.out.println("\n--- NHẬP THÔNG TIN NHÂN VIÊN MỚI ---");
                    System.out.print("Nhập tên nhân viên: ");
                    String tenNV = scanner.nextLine();

                    System.out.print("Nhập hệ số lương (ví dụ: 2.5): ");
                    double heSoLuong = Double.parseDouble(scanner.nextLine());

                    // Tạo đối tượng nhân viên từ dữ liệu vừa nhập
                    NhanVien nvMoi = new NhanVien(tenNV, heSoLuong);

                    // Thêm vào phòng ban
                    if (pb.themNV(nvMoi)) {
                        System.out.println("=> Thêm nhân viên thành công!");
                    } else {
                        System.out.println("=> Thêm thất bại! Phòng ban đã đầy (tối đa 100 người).");
                    }
                    break;

                case 2:
                    System.out.println("\n--- XÓA NHÂN VIÊN (STACK POP) ---");
                    NhanVien nvDaXoa = pb.xoaNV();
                    if (nvDaXoa != null) {
                        System.out.println("=> Đã xóa nhân viên vừa thêm gần nhất: " + nvDaXoa.getTenNhanVien());
                    } else {
                        System.out.println("=> Phòng ban hiện tại đang rỗng, không thể xóa!");
                    }
                    break;

                case 3:
                    System.out.println("\n--- THÔNG TIN PHÒNG BÁN ---");
                    pb.inTTin();
                    break;

                case 0:
                    System.out.println("Đã thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
                    break;
            }
        } while (luaChon != 0);

        scanner.close();
    }
}