//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    IO.println(String.format("Hello and welcome!"));

    for (int i = 1; i <= 5; i++) {
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
        IO.println("i = " + i);
    }
}
public class Vector {
    // Thuộc tính 3 chiều x, y, z (được đóng gói private)
    private double x;
    private double y;
    private double z;

    // Phương thức khởi tạo mặc định
    public Vector() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }

    // Phương thức khởi tạo có tham số
    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Các phương thức Get và Set
    public double getX() { return x; }
    public void setX(double x) { this.x = x; }

    public double getY() { return y; }
    public void setY(double y) { this.y = y; }

    public double getZ() { return z; }
    public void setZ(double z) { this.z = z; }

    // Cộng 2 vector
    public Vector add(Vector v) {
        return new Vector(this.x + v.x, this.y + v.y, this.z + v.z);
    }

    // Trừ 2 vector
    public Vector subtract(Vector v) {
        return new Vector(this.x - v.x, this.y - v.y, this.z - v.z);
    }

    // Nhân vector với một hằng số c
    public Vector multiply(double c) {
        return new Vector(this.x * c, this.y * c, this.z * c);
    }

    // Nhân vô hướng 2 vector (Dot product)
    public double dotProduct(Vector v) {
        return (this.x * v.x) + (this.y * v.y) + (this.z * v.z);
    }

    // Phương thức hỗ trợ hiển thị tọa độ vector cho đẹp
    public void printVector() {
        System.out.println("(" + x + ", " + y + ", " + z + ")");
    }
}
public class Main {
    public static void main(String[] args) {
        // Tạo 2 vector v1 và v2
        Vector v1 = new Vector(1.0,2.0,3.0);
        Vector v2 = new Vector(4.0, 5.0, 6.0);

        System.out.print("Vector v1: ");
        v1.printVector();

        System.out.print("Vector v2: ");
        v2.printVector();

        // 1. Thử nghiệm cộng 2 vector
        Vector vSum = v1.add(v2);
        System.out.print("Tong v1 + v2 = ");
        vSum.printVector();

        // 2. Thử nghiệm trừ 2 vector
        Vector vSub = v1.subtract(v2);
        System.out.print("Hieu v1 - v2 = ");
        vSub.printVector();

        // 3. Thử nghiệm nhân vector với hằng số (ví dụ nhân với 2.0)
        Vector vMul = v1.multiply(2.0);
        System.out.print("Nhan v1 với 2.0 = ");
        vMul.printVector();

        // 4. Thử nghiệm tích vô hướng 2 vector
        double dot = v1.dotProduct(v2);
        System.out.println("Tich vô hướng v1 . v2 = " + dot);
    }
}
