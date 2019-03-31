package java8.examPreparation;

public class PigLatin {

    public static void main(String[] args) {
        String word = "Enrich";
        SuffixFunction suffixFunc = () -> System.out.println(word+" life");
        suffixFunc.call();
    }
}
