import javax.swing.JOptionPane;
public class HelloNameDialog {
    public static void main(String[] args){
        String result;
        result = JOptionPane.showInputDialog("pls enter your name");
        JOptionPane.showMessageDialog(null, "hi " + result + "!");
        System.exit(0);
    }
}
