package java8.examPreparation;

public class Outer {
    private int mem = 10;

    class Inner{
        private int mem = new Outer().mem;
    }

    public static void main(String[] args) {
        System.out.println(new Outer().new Inner().mem);
    }
}
