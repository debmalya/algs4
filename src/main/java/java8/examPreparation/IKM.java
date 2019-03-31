package java8.examPreparation;

import java.util.stream.Stream;

public class IKM {

    public static void main(String[] args){
//        Nothing printed in the console , as limit is a terminal operation. Not a console operation.
        Stream.of("ace","jack","queen","king","joker")
                .mapToInt(card->card.length())
                .filter(len->len>3)
                .peek(System.out::print)
                .limit(2);

        // Then how to print ?
        Stream.of("ace","jack","queen","king","joker")
                .mapToInt(card->card.length())
                .filter(len->len>3)
                .limit(2)
                .forEach(k->{
                    System.out.println(String.format("%s",k));
                });

    }
}
