package InternetShop;

import java.util.Random;

public class Main {

    static Customer[] customers = null;
    static Product[] products = null;

    public static void main(String[] args)
            throws CustomerException, AmountException, ProductException, TooMuchSaleException {

        customers = new Customer[] {
            new Customer("Ivan", "Semenov", 25, "+79568254623", Enums.gender.male),
            new Customer("Petr", "Kozlov", 32, "+79095478216", Enums.gender.male),
            new Customer("Svetlana", "Strahova", 47, "+79098521346", Enums.gender.female),
        };

        products = new Product[] {
            new Product("Milk", 100.5f, Enums.category.STANDART),
            new Product("Bread", 70.8f, Enums.category.STANDART),
            new Product("Meat", 1000, Enums.category.PREMIUM),
            new Product("Chocolate", 225.6f, Enums.category.PREMIUM),
            new Product("Tea", 300, Enums.category.STANDART),
        };

        Order[] orders = new Order[5];
        String[] phones = {"+79568254623", "+79095478216", "+79095478216", "+79098521346", "+79568254623"};
        String[] productTitles = {"Milk", "Chocolate", "Tea", "Bread", "Meat"};
        int[] amounts = {4, 5, 11, 2, 1};
        int count = 0;

//        String[] phones = {"+79568254623", "+79095478216", "+794523614852", "+79095478216", "+79098521346"};
//        String[] productTitles = {"Milk", "Water", "Chocolate", "Meat", "Tea"};
//        int[] amounts = {4, 5, 101, 0, -1};
//        int count = 0;

//        ПОКУПКИ БЕЗ СКИДОК
//        for (int i = 0; i < 5; i++) {
//            try {
//                orders[i] = makePurchase(phones[i], productTitles[i], amounts[i]);
//                System.out.println("    Совершена покупка: " + orders[i].toString());
//                count++;
//            } catch (ProductException e) {
//                System.out.println(e.getMessage());
//            } catch (AmountException e) {
//                orders[i] = makePurchase(phones[i], productTitles[i], 1);
//                System.out.println("    Совершена покупка: " + orders[i].toString());
//                count++;
//            } catch (CustomerException e) {
//                System.out.println(e.getMessage());
//            }
//        }


//      ПОКУПКИ С РАНДОМНЫМИ СКИДКАМИ И КАТЕГОРИЯМИ
        for (int i = 0; i < 5; i++) {
            try {
                orders[i] = makePurchaseDiscount(phones[i], productTitles[i], amounts[i]);
                System.out.println("Совершена покупка: " + orders[i].toString());
                count++;
            } catch (ProductException e) {
                System.out.println(e.getMessage());
            } catch (AmountException e) {
                orders[i] = makePurchase(phones[i], productTitles[i], 1);
                System.out.println("Совершена покупка: " + orders[i].toString());
                count++;
            } catch (CustomerException e) {
                System.out.println(e.getMessage());
            } catch (TooMuchSaleException e) {
                System.out.println(e.getMessage());
                orders[i] = makePurchase(phones[i], productTitles[i], amounts[i]);
                System.out.println("Совершена покупка: " + orders[i].toString());
                count++;
            }
        }

        System.out.println("Количество совершенных покупок: " + count);
    }

    public static Order makePurchase(String phone, String title, int amount)
            throws CustomerException, ProductException, AmountException {
        Customer customer = null;
        Product product = null;

        for (Customer cust: customers) {
            if (cust.getPhone().equals(phone)) {
                customer = cust;
            }
        }
        for (Product prod: products) {
            if (prod.getTitle().equals(title)) {
                product = prod;
            }
        }

        if (customer == null) {
            throw new CustomerException("    Customer with phone " + phone + " not found");
        }
        if (product == null) {
            throw new ProductException("    Product " + title + " not found");
        }
        if (amount > 100 || amount < 1) {
            throw new AmountException("    Amount is not correct");
        }

        return new Order(customer, product, amount);
    }

    public static Order makePurchaseDiscount(String phone, String title, int amount)
            throws CustomerException, ProductException, AmountException {
        Customer customer = null;
        Product product = null;

        for (Customer cust: customers) {
            if (cust.getPhone().equals(phone)) {
                customer = cust;
            }
        }
        for (Product prod: products) {
            if (prod.getTitle().equals(title)) {
                product = makeDiscountCategory(prod);
            }
        }

        if (customer == null) {
            throw new CustomerException("    Customer with phone " + phone + " not found");
        }
        if (product == null) {
            throw new ProductException("    Product " + title + " not found");
        }
        if (amount > 100 || amount < 1) {
            throw new AmountException("    Amount is not correct");
        }

        return new Order(customer, product, amount);
    }

    public static Product makeDiscountCategory(Product product) throws TooMuchSaleException {
        Enums.discount[] discounts = Enums.discount.values();
        int number = new Random().nextInt(discounts.length);

        if (product.getCategory().equals(Enums.category.PREMIUM) &&
            discounts[number].count > 15) {
                throw new TooMuchSaleException("    The product " + product.getTitle() +
                        " is PREMIUM and discount is more than 15%");
        }

        System.out.print("    Скидка на товар " + product.getTitle() + " равна " + discounts[number].count + "%. ");
        if (discounts[number].count == 0) {
            System.out.println();
        } else {
            float newPrice = (float) (Math.ceil((float) (product.getPrice() * (1 - discounts[number].count * 0.01)) * Math.pow(10, 2)) / Math.pow(10, 2));
            System.out.print("Старая цена " + product.getPrice() + ", ");
            product.setPrice(newPrice);
            System.out.println("новая цена " + product.getPrice());
        }

        return product;
    }
}
