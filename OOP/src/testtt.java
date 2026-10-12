public class testtt {
    public static int plus(int... arr) {
        int result = 0;
        for (int i : arr) {
            result += i;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(plus(1, 2, 3, 4, 5));
    }
}