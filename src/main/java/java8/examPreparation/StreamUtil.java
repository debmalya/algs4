package java8.examPreparation;

import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class StreamUtil {

    public static void main(String[] args) {
        Stream<String> words = Stream.of("Silence","Darkness","Solitude","Happiness","Fearless");
        String boxedString = words.collect(joining(",",
                "[",
                "]"));
        System.out.println(boxedString);
    }
}
