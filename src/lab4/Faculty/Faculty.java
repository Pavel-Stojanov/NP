package lab4.Faculty;

import java.util.*;
import java.util.stream.Collectors;

public class Faculty {
    Map<String, Student> students;

    public Faculty() {
        students = new HashMap<>();
    }

    public void addStudent(String id, List<Integer> grades) throws Exception {
        if (students.containsKey(id)) {
            throw new Exception(String.format("Student with ID %s already exists", id));
        }
        students.put(id, new Student(id, grades));
    }

    public void addGrade(String id, int grade) {
        students.get(id).addGrade(grade);
    }

    public Set<Student> getStudentsSortedByAverageGrade() {
        return students.values().stream()
                .sorted(Comparator
                        .comparing(Student::getAvgGrade)
                        .thenComparing(Student::getPassed)
                        .thenComparing(Student::getId)
                        .reversed())
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Set<Student> getStudentsSortedByCoursesPassed() {
        return students.values().stream()
                .sorted(Comparator
                        .comparing(Student::getPassed)
                        .thenComparing(Student::getAvgGrade)
                        .thenComparing(Student::getId)
                        .reversed())
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

}
