import javax.swing.JOptionPane;

public class ex6 {
    public static void main(String[] args) {
        String[] options = {"1. Phương trình bậc nhất (ax + b = 0)",
                "2. Hệ phương trình 2 ẩn",
                "3. Phương trình bậc hai (ax^2 + bx + c = 0)"};

        String choiceStr = (String) JOptionPane.showInputDialog(
                null,
                "Chọn loại phương trình bạn muốn giải:",
                "Giải phương trình",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);

        if (choiceStr == null) return;

        if (choiceStr.equals(options[0])) {
            solveLinearEquation();
        } else if (choiceStr.equals(options[1])) {
            solveLinearSystem();
        } else if (choiceStr.equals(options[2])) {
            solveQuadraticEquation();
        }

        System.exit(0);
    }

    // 1. Giải phương trình bậc nhất: ax + b = 0
    public static void solveLinearEquation() {
        String strA = JOptionPane.showInputDialog(null, "Nhập hệ số a:", "Phương trình bậc nhất", JOptionPane.INFORMATION_MESSAGE);
        String strB = JOptionPane.showInputDialog(null, "Nhập hệ số b:", "Phương trình bậc nhất", JOptionPane.INFORMATION_MESSAGE);

        double a = Double.parseDouble(strA);
        double b = Double.parseDouble(strB);

        String result;
        if (a == 0) {
            if (b == 0) {
                result = "Phương trình có vô số nghiệm.";
            } else {
                result = "Phương trình vô nghiệm.";
            }
        } else {
            double x = -b / a;
            result = "Nghiệm của phương trình là x = " + x;
        }
        JOptionPane.showMessageDialog(null, result, "Kết quả", JOptionPane.INFORMATION_MESSAGE);
    }

    // 2. Giải hệ phương trình 2 ẩn dùng định thức (Determinants)
    public static void solveLinearSystem() {
        JOptionPane.showMessageDialog(null, "Nhập hệ số cho hệ phương trình:\na11*x1 + a12*x2 = b1\na21*x1 + a22*x2 = b2");

        double a11 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a11:"));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a12:"));
        double b1  = Double.parseDouble(JOptionPane.showInputDialog("Nhập b1:"));

        double a21 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a21:"));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a22:"));
        double b2  = Double.parseDouble(JOptionPane.showInputDialog("Nhập b2:"));

        double d = a11 * a22 - a21 * a12;
        double d1 = b1 * a22 - b2 * a12;
        double d2 = a11 * b2 - a21 * b1;

        String result;
        if (d != 0) {
            double x1 = d1 / d;
            double x2 = d2 / d;
            result = "Hệ phương trình có nghiệm duy nhất:\nx1 = " + x1 + "\nx2 = " + x2;
        } else {
            if (d1 == 0 && d2 == 0) {
                result = "Hệ phương trình có vô số nghiệm.";
            } else {
                result = "Hệ phương trình vô nghiệm.";
            }
        }
        JOptionPane.showMessageDialog(null, result, "Kết quả", JOptionPane.INFORMATION_MESSAGE);
    }

    // 3. Giải phương trình bậc hai: ax^2 + bx + c = 0
    public static void solveQuadraticEquation() {
        String strA = JOptionPane.showInputDialog(null, "Nhập hệ số a:", "Phương trình bậc hai", JOptionPane.INFORMATION_MESSAGE);
        String strB = JOptionPane.showInputDialog(null, "Nhập hệ số b:", "Phương trình bậc hai", JOptionPane.INFORMATION_MESSAGE);
        String strC = JOptionPane.showInputDialog(null, "Nhập hệ số c:", "Phương trình bậc hai", JOptionPane.INFORMATION_MESSAGE);

        double a = Double.parseDouble(strA);
        double b = Double.parseDouble(strB);
        double c = Double.parseDouble(strC);

        String result;
        if (a == 0) {
            // Quay về phương trình bậc nhất bx + c = 0
            if (b == 0) {
                result = (c == 0) ? "Phương trình vô số nghiệm." : "Phương trình vô nghiệm.";
            } else {
                double x = -c / b;
                result = "Vì a = 0, phương trình trở thành bậc nhất. Nghiệm x = " + x;
            }
        } else {
            double delta = b * b - 4 * a * c;
            if (delta < 0) {
                result = "Phương trình vô nghiệm (trên tập số thực) vì Delta = " + delta;
            } else if (delta == 0) {
                double x = -b / (2 * a);
                result = "Phương trình có nghiệm kép: x1 = x2 = " + x;
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                result = "Phương trình có 2 nghiệm phân biệt:\nx1 = " + x1 + "\nx2 = " + x2;
            }
        }
        JOptionPane.showMessageDialog(null, result, "Kết quả", JOptionPane.INFORMATION_MESSAGE);
    }
}