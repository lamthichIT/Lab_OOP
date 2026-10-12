import javax.swing.JOptionPane;

public class ex5 {
    public static void main(String[] args){
        String strNum1, strNum2;

        strNum1 =  JOptionPane.showInputDialog(null,
                "pls enter the first number:","Input 1",
                JOptionPane.INFORMATION_MESSAGE);

        strNum2 = JOptionPane.showInputDialog(null,
                "pls enter the second number:","Input2",
                JOptionPane.INFORMATION_MESSAGE);

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        double sum = num1+num2;
        double diffrence = Math.abs(num1-num2);
        double product = num1*num2;
        String message = "Number 1: " + num1 + "\n"
                       + "Number 2: " + num2 + "\n"
                       + "Sum: " + sum + "\n"
                       + "Diff: " + diffrence + "\n"
                       + "Product: " + product + "\n";

        if(num2!=0) {
            double quot = num1 / num2;
            message += "Quotient: " + quot ;
        } else message +="ERROR";
        JOptionPane.showMessageDialog(null,message,
                "Calculation result", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}