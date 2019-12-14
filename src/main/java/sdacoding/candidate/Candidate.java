package sdacoding.candidate;

import sdacoding.department.DepartmentName;

public class Candidate {
    private String name;
    private int levelOfCompetence;
    private CandidateStatus status;
    private DepartmentName departmentName; // to do change type ?
    private Gender gender;

    public Candidate() {
    }

    public Candidate(String name, int levelOfCompetence, DepartmentName departmentName, Gender gender) {
        this.name = name;
        this.levelOfCompetence = levelOfCompetence;
        this.departmentName = departmentName;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "name='" + name + '\'' +
                ", levelOfCompetence=" + levelOfCompetence +
                ", status=" + status +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevelOfCompetence() {
        return levelOfCompetence;
    }

    public void setLevelOfCompetence(int levelOfCompetence) {
        this.levelOfCompetence = levelOfCompetence;
    }

    public CandidateStatus getStatus() {
        return status;
    }

    public void setStatus(CandidateStatus status) {
        this.status = status;
    }

    public DepartmentName getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(DepartmentName departmentName) {
        this.departmentName = departmentName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }
}
