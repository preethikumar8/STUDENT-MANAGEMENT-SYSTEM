package util;

import model.Student;
import java.io.*;
import java.util.List;

public class FileUtil {

    private static final String FILE_NAME = "students.txt";

    public static void saveToFile(List<Student> students) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                bw.write(s.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file");
        }
    }

    public static void loadFromFile(List<Student> students) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                students.add(new Student(
                        Integer.parseInt(data[0]),
                        data[1],
                        Integer.parseInt(data[2])
                ));
            }
        } catch (IOException e) {
            System.out.println("No previous data found");
        }
    }
}
