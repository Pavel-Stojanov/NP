package lab4.Faculty;

import java.util.List;

public class Student {
    private String id;
    private List<Integer> grades;

    public Student(String id, List<Integer> grades) {
        this.id = id;
        this.grades = grades;
    }

    public String getId() {
        return id;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double getAvgGrade() {
        return grades.stream().mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public long getPassed() {
        return grades.stream().filter(g -> g > 5).count();
    }

    @Override
    public String toString() {
        return String.format("Student{id='%s', grades=%s}", id, grades);
    }
}
