package InternetShop;

public class Customer {

    private String firstName;
    private String lastName;
    private int age;
    private String phone;
    private Enums.gender gender;

    public Customer(String firstName, String lastName, int age, String phone, Enums.gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Enums.gender getGender() {
        return gender;
    }

    public void setGender(Enums.gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return firstName +
                " " + lastName +
                ", age: " + age +
                ", gender: " + gender +
                ", phone: " + phone;
    }
}
