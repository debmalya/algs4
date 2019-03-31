package java8.examPreparation;

import java.util.stream.Stream;

public class Reduce {
    public static void main(String[] args) {
        int len = Stream.of("one","two","three").mapToInt(String::length).reduce(0,(len1,len2)->len1+len2);
        System.out.println(len);
    }
}
