import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class StudentGrades {
    private final Map<String, Integer> grades;

    public StudentGrades() {
        grades = new HashMap<>();
    }

    public void addGrade(String student, int grade) {
        grades.put(student, grade);
        System.out.println("Оценка принята, ученик:  " + student);
    }

    public void updateGrade(String student, int grade) {
        if (grades.containsKey(student)) {
            grades.put(student, grade);
            System.out.println("Оценка обновлена, ученик: " + student);
        } else {
            System.out.println("Ученик " + student + " отсутствует в списке");
        }
    }

    public void removeGrade(String student) {
        if (grades.containsKey(student)) {
            grades.remove(student);
            System.out.println("Оценка удалена, ученик: " + student);
        } else {
            System.out.println("Ученик " + student + " отсутсвует в списке");
        }
    }

    public void viewGrades() {
        if (grades.isEmpty()) {
            System.out.println("Список оценок пуст");
        } else {
            System.out.println("Список оценок:");
            for (Map.Entry<String, Integer> entry : grades.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    public void viewGrades(String student) {
        if (grades.containsKey(student)) {
            System.out.println("Оценка ученика " + student + ": " + grades.get(student));
        } else {
            System.out.println("Ученик " + student + " отсутсвует в списке");
        }
    }

    public static void main(String[] args) {
        StudentGrades studentGrades = new StudentGrades();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.println("Выбер действия:");
            System.out.println("1. Добавьте нового ученика");
            System.out.println("2. Удалите ученика");
            System.out.println("3. Обновите оценку ученика");
            System.out.println("4. Просмотреть оценки всех учащихся");
            System.out.println("5. Просмотреть оценку конкретного учащегося");
            System.out.println("6. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine(); //  перенос

            switch (choice) {
                case 1 -> {
                    System.out.println("Добавьте нового ученика:");
                    String studentAdd = scanner.nextLine();
                    System.out.println("Введите оценку:");
                    int gradeAdd = scanner.nextInt();
                    scanner.nextLine();
                    studentGrades.addGrade(studentAdd, gradeAdd);
                }
                case 2 -> {
                    System.out.println("Введите имя ученика:");
                    String studentRemove = scanner.nextLine();
                    studentGrades.removeGrade(studentRemove);
                }
                case 3 -> {
                    System.out.println("Введите имя ученика:");
                    String studentUpdate = scanner.nextLine();
                    System.out.println("Введите новую оценку:");
                    int gradeUpdate = scanner.nextInt();
                    scanner.nextLine();
                    studentGrades.updateGrade(studentUpdate, gradeUpdate);
                }
                case 4 -> studentGrades.viewGrades();
                case 5 -> {
                    System.out.println("Введите имя ученика:");
                    String studentView = scanner.nextLine();
                    studentGrades.viewGrades(studentView);
                }
                case 6 -> exit = true;
            }
        }
    }
}