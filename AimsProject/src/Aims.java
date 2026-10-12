public class Aims {
    public static void main(String[] args) {
        // Tạo một giỏ hàng mới
        Cart anOrder = new Cart();

        // Tạo các đối tượng DVD mới và thêm vào giỏ hàng
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin",
                "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        // In tổng chi phí ban đầu của các sản phẩm trong giỏ
        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());

        // Kiểm thử chức năng xóa sản phẩm (Mục 11)
        System.out.println("\n--- Testing removal of an item ---");
        anOrder.removeDigitalVideoDisc(dvd2);

        System.out.println("Total Cost after removing Star Wars is: ");
        System.out.println(anOrder.totalCost());
    }
}