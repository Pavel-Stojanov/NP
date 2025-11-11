package lab3.EnrollmentSystem3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Faculty {
    private String shortName;
    private List<String> appropriateSubjects;
    private List<StudyProgramme> studyProgrammes;

    public Faculty(String name) {
        shortName = name;
        appropriateSubjects = new ArrayList<>();
        studyProgrammes = new ArrayList<>();
    }

    public String getShortName() {
        return shortName;
    }

    public List<String> getAppropriateSubjects() {
        return appropriateSubjects;
    }

    public List<StudyProgramme> getStudyProgrammes() {
        return studyProgrammes;
    }

    public void addSubject(String subject) {
        appropriateSubjects.add(subject);
    }

    public void addStudyProgramme(StudyProgramme programme) {
        studyProgrammes.add(programme);
    }

    @Override
    public String toString() {
        Comparator<StudyProgramme> studyProgrammeComparator = Comparator
                .comparingInt((StudyProgramme sp) -> sp.getFaculty().getAppropriateSubjects().size())
                .thenComparing(StudyProgramme::getSuccessRate, Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        sb.append("Faculty: ").append(shortName).append("\n");
        sb.append("Subjects: ").append(appropriateSubjects).append("\n");
        sb.append("Study Programmes: \n");
        studyProgrammes.stream()
                .sorted(studyProgrammeComparator)
                .forEach(sp -> sb.append(sp.toString()));

        return sb.toString();
    }
}
