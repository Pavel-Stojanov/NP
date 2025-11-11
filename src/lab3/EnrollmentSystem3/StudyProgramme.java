package lab3.EnrollmentSystem3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudyProgramme {
    private String code;
    private String name;
    private Faculty faculty;
    private int numPublicQuota;
    private int numPrivateQuota;
    private int enrolledInPublicQuota;
    private int enrolledInPrivateQuota;
    List<Applicant> applicants;


    public StudyProgramme(String code, String name, Faculty faculty, int numPublicQuota, int numPrivateQuota) {
        this.code = code;
        this.name = name;
        this.faculty = faculty;
        this.numPublicQuota = numPublicQuota;
        this.numPrivateQuota = numPrivateQuota;
        this.enrolledInPublicQuota = 0;
        this.enrolledInPrivateQuota = 0;
        this.applicants = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public List<Applicant> getApplicants() {
        return applicants;
    }

    public void addApplicant(Applicant applicant) {
        applicants.add(applicant);
    }

    public void calculateEnrollmentNumbers() {
        List<Applicant> sortedApp = applicants.stream()
                .sorted(Comparator.comparingDouble(Applicant::calculatePoints).reversed())
                .collect(Collectors.toList());
        for (Applicant a : sortedApp) {
            if (enrolledInPublicQuota < numPublicQuota) {
                enrolledInPublicQuota++;
            } else if (enrolledInPrivateQuota < numPrivateQuota) {
                enrolledInPrivateQuota++;
            }else{
                break;
            }
        }
    }

    public double getSuccessRate() {
        int totalEnrolled = enrolledInPublicQuota + enrolledInPrivateQuota;
        int totalQuota = numPublicQuota + numPrivateQuota;
        return ((double) totalEnrolled / totalQuota) * 100;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("\n");
        List<Applicant> sortedApp = applicants.stream()
                .sorted(Comparator.comparingDouble(Applicant::calculatePoints).reversed())
                .collect(Collectors.toList());
        sb.append("Public Quota: \n");
        List<Applicant> publicEnrolled = sortedApp.stream()
                .limit(enrolledInPublicQuota)
                .collect(Collectors.toList());
        if (!publicEnrolled.isEmpty()){
            for (Applicant a : publicEnrolled) {
                sb.append(String.format("Id: %d, Name: %s, GPA: %.1f - %s \n", a.getId(), a.getName(), a.getGpa(), a.calculatePoints()));
            }
        }
        sb.append("Private Quota: \n");
        List<Applicant> privateEnrolled = sortedApp.stream()
                .skip(enrolledInPublicQuota)
                .limit(enrolledInPrivateQuota)
                .collect(Collectors.toList());
        if (!privateEnrolled.isEmpty()){
            for (Applicant a : privateEnrolled) {
                sb.append(String.format("Id: %d, Name: %s, GPA: %.1f - %s \n", a.getId(), a.getName(), a.getGpa(), a.calculatePoints()));
            }
        }
        sb.append("Rejected: \n");
        List<Applicant> rejected = sortedApp.stream()
                .skip(enrolledInPublicQuota + enrolledInPrivateQuota)
                .collect(Collectors.toList());
        if (!rejected.isEmpty()){
            for (Applicant a : rejected) {
                sb.append(String.format("Id: %d, Name: %s, GPA: %.1f - %s \n", a.getId(), a.getName(), a.getGpa(), a.calculatePoints()));
            }
        }
        sb.append("\n");

        return sb.toString();

    }
}
