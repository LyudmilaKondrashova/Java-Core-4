package InternetShop;

public class Enums {

    enum gender{male, female};

    enum discount{
        disc_0(0), disc_5(5), disc_10(10), disc_15(15), disc_20(20);
        public final int count;
        discount(int count) {
            this.count = count;
        }
    };

    enum category{STANDART, PREMIUM};

}
