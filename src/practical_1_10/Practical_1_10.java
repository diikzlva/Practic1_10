package practical_1_10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Practical_1_10 {

    public static void main(String[] args) {
       System.out.println ("Козлова Динара Артёмовна, РИБО-01-22, Вариант 2, ");
       
       Scanner scanner = new Scanner(System.in);
        
        System.out.println("Введите полный путь к исходному файлу: ");
        String inputFilePath = scanner.nextLine();

        File inputFile = new File(inputFilePath);
        if (!inputFile.exists()) {
            System.out.println("Файл не найден");
            return;
        }

        StringBuilder output = new StringBuilder();
        try (Scanner fileScanner = new Scanner(inputFile)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
        
                StringBuilder reversedLine = new StringBuilder();
                for (int i = line.length() - 1; i >= 0; i--) {
                    reversedLine.append(line.charAt(i));
                }
                output.append(reversedLine).append("\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка при чтении файла!");
            return;
        }

        String outputFilePath = inputFilePath.substring(0, inputFilePath.lastIndexOf('.')) + "_reversed.txt";

        try (FileWriter fileWriter = new FileWriter(outputFilePath)) {
            fileWriter.write(output.toString());
            System.out.println("Файл успешно модифицирован. Перевернутые строки сохранены в файле: " + outputFilePath);
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлами: " + e.getMessage());
        }
    }
}



