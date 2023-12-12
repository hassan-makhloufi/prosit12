import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.*;
import java.util.stream.Stream;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        // Création de quelques étudiants
        Etudiant etudiant1 = new Etudiant(1, "Alice", 20);
        Etudiant etudiant2 = new Etudiant(2, "Bob", 22);
        Etudiant etudiant3 = new Etudiant(3, "Charlie", 21);

        // Ajout des étudiants à une liste
        List<Etudiant> studentsList = new ArrayList<>();
        studentsList.add(etudiant1);
        studentsList.add(etudiant2);
        studentsList.add(etudiant3);

        // Création d'une instance de StudentManagement
        StudentManagement studentManagement = new StudentManagement();

        // Affichage de tous les étudiants
        System.out.println("Affichage de tous les étudiants:");
        studentManagement.displayStudents(studentsList, System.out::println);

        // Filtrage et affichage des étudiants de moins de 22 ans
        System.out.println("\nAffichage des étudiants de moins de 22 ans:");
        studentManagement.displayStudentsByFilter(studentsList, student -> student.getAge() < 22, System.out::println);

        // Création d'un nouvel étudiant à partir d'un Supplier
        Etudiant newStudent = studentManagement.createStudent(() -> new Etudiant(4, "David", 23));
        System.out.println("\nNouvel étudiant créé: " + newStudent);

        // Tri des étudiants par ID
        List<Etudiant> sortedStudents = studentManagement.sortStudentsById(studentsList, Comparator.comparingInt(Etudiant::getId));
        System.out.println("\nListe des étudiants triée par ID:");
        studentManagement.displayStudents(sortedStudents, System.out::println);

        // Conversion de la liste d'étudiants en stream et affichage
        System.out.println("\nConversion de la liste d'étudiants en stream et affichage:");
        Stream<Etudiant> studentStream = studentManagement.convertToStream(studentsList);
        studentStream.forEach(System.out::println);
    }
}
