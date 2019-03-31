package java8.examPreparation;

public class EnumCheck  {
    public static void main(String[] args) {
        if (AnEnum.ONLY_MEM instanceof AnEnum){
            System.out.println("Yes instance of AnEnum");
        }
        if (AnEnum.ONLY_MEM instanceof EnumBase){
            System.out.println("Yes instance of EnumBase");
        }
        if (AnEnum.ONLY_MEM instanceof Enum){
            System.out.println("Yes instance of Enum");
        }

    }
}
