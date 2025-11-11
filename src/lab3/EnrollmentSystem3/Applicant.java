package lab3.EnrollmentSystem3;

import java.util.ArrayList;
import java.util.List;

public class Applicant {
    private int id;
    private String name;
    private double gpa;
    List<SubjectWithGrade> subjectsWithGrade;
    private StudyProgramme studyProgramme;

    public Applicant(int id, String name, double gpa, StudyProgramme studyProgramme) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
        this.studyProgramme = studyProgramme;
        subjectsWithGrade = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public StudyProgramme getStudyProgramme() {
        return studyProgramme;
    }

    public void addSubjectAndGrade(String subject, int grade){
        subjectsWithGrade.add(new SubjectWithGrade(subject, grade));
    }

    public double calculatePoints(){
        double points = 0;
        Faculty faculty = studyProgramme.getFaculty();
        for (SubjectWithGrade sg : subjectsWithGrade){
            if (faculty.getAppropriateSubjects().contains(sg.getSubject())){
                points += sg.getGrade()*2.0;
            }else{
                points += sg.getGrade()*1.2;
            }
        }
        points+=gpa*12;
        return points;
    }

}
