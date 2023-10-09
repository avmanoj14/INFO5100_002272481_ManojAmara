public class Exercise0 {
    public static void main(String[] args) {
        Book book1 = new Book("Harry Potter", "J K Rowling", "Fantasy", 2001, 350, "English", "GoodBooks");
        Book book2 = new Book("The Great Gatsby", "Scott Fitzgerald", "Fiction", 2005, 180, "English", "GoodBooks2");
        Book book3 = new Book("1984", "George Orwell", "Dystopian", 1999, 220, "English", "GoodBooks3");

        Chair chair1 = new Chair("Wood", "Brown", 4, false, false, 49.99, "Furniture Co.");
        Chair chair2 = new Chair("Metal", "Black", 5, true, true, 99.99, "Comfort Seating");
        Chair chair3 = new Chair("Plastic", "White", 3, true, false, 29.99, "Modern Designs");

        University university1 = new University("Northeastern", "San Jose", 1898, "A+", 1898, true, "Mr. Erica");
        University.Student student = university1.new Student("Manoj", 23, "ms", true, 32, true, "Ms Erica");
        University university2 = new University("Gitam", "Hyderabad", 1995, "A+", 1898, true, "Ram");
        University.Student student1 = university1.new Student("Alex", 23, "ms", true, 32, true, "Rattan");
        University university3 = new University("Northwestern", "CA", 1898, "A+", 1898, true, "Roy");
        University.Student student2 = university1.new Student("Danny", 23, "ms", true, 32, true, "Aice");

        Mobile mobile1 = new Mobile("Samsung", "Galaxy S21", 6.2, 128, true, true, 799.99);
        Mobile mobile2 = new Mobile("Apple", "iPhone 13", 6.1, 256, true, true, 999.99);
        Mobile mobile3 = new Mobile("Google", "Pixel 6", 6.4, 128, true, false, 699.99);

        Laptop laptop1 = new Laptop("Dell", "XPS 13", "Intel Core i7", 16, 512, true, 1299.99);
        Laptop laptop2 = new Laptop("HP", "Spectre x360", "Intel Core i5", 8, 256, true, 1099.99);
        Laptop laptop3 = new Laptop("Lenovo", "ThinkPad X1 Carbon", "Intel Core i7", 16, 1_024, false, 1599.99);

        Classroom classroom1 = new Classroom(30, true, true, "Main Building", 2);
        Classroom classroom2 = new Classroom(20, false, true, "Science Center", 1);
        Classroom classroom3 = new Classroom(40, true, false, "Engineering Building", 3);

        Bottle bottle1 = new Bottle(0.5, "Plastic", true, "Blue");
        Bottle bottle2 = new Bottle(1.0, "Glass", false, "Green");
        Bottle bottle3 = new Bottle(0.75, "Metal", true, "Silver");

        Headphones headphones1 = new Headphones("Sony", "WH-1000XM4", true, true, true, "Black", 349.99);
        Headphones headphones2 = new Headphones("Bose", "QuietComfort 35 II", true, true, true, "Silver", 299.99);
        Headphones headphones3 = new Headphones("Apple", "AirPods Pro", true, true, true, "White", 249.99);

        Car car1 = new Car("Toyota", "Camry", 2022, "Silver", 5000, true, 24999.99);
        Car car2 = new Car("Honda", "Civic", 2021, "Blue", 7000, false, 21999.99);
        Car car3 = new Car("Ford", "Mustang", 2023, "Red", 2000, true, 39999.99);

        Watch myWatch1 = new Watch("Casio", "G-Shock", "Resin", true, true, true, 80.0);
        Watch myWatch2 = new Watch("Rolex", "Submariner", "Stainless Steel", false, true, false, 60.0);
        Watch myWatch3 = new Watch("Apple", "Watch Series 7", "Aluminum", true, true, true, 95.0);

        book1.displayInfo();
        book2.displayInfo();
        book3.displayInfo();

        chair1.chairInfo();
        chair2.chairInfo();
        chair3.chairInfo();

        university1.admitStudent();
        student.graduate();
        university2.admitStudent();
        student1.graduate();
        university3.admitStudent();
        student2.graduate();

        mobile1.showDetails();
        mobile2.showDetails();
        mobile3.showDetails();

        laptop1.powerOn();
        laptop2.powerOn();
        laptop3.powerOn();

        classroom1.conductClass();
        classroom2.conductClass();
        classroom3.conductClass();

        bottle1.openBottle();
        bottle2.openBottle();
        bottle3.openBottle();

        headphones1.playMusic();
        headphones2.playMusic();
        headphones3.playMusic();

        car1.startEngine();
        car2.startEngine();
        car3.startEngine();

        myWatch1.checkBatteryStatus();
        myWatch2.checkBatteryStatus();
        myWatch3.checkBatteryStatus();
    }
}
