package java8.examPreparation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Cat {

    public static void main(String[] args) throws Exception {
        if (args.length<1){
            System.out.println("Usage : Cat <FileName>");
            System.exit(1);
        }else{
            System.out.println(System.getProperty("user.dir"));
            readFile(args[0]);
        }
    }

    private static void readFile(String arg) throws Exception {
        Path path = Paths.get(arg);
        Stream<String> lines = Files.lines(path);
        lines.forEach(System.out::println);
    }

    private static void readFile0(String arg) throws FileNotFoundException {
        int ch = 0;
        try(FileReader inputFile = new FileReader(new File(arg))){
            while ((ch = inputFile.read()) != -1){
                System.out.print((char)ch);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
