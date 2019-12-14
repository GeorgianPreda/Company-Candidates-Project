package sdacoding.department;

import sdacoding.candidate.Candidate;
import sdacoding.candidate.CandidateStatus;

public class Department implements Evaluator{
    private DepartmentName name;
    private int minLevelOfCompetence;
    private int openPositions;

    public Department(DepartmentName name, int minLevelOfCompetence, int openPositions) {
        this.name = name;
        this.minLevelOfCompetence = minLevelOfCompetence;
        this.openPositions=openPositions;
    }

    public CandidateStatus evaluateBasedOnCompetenceLevel(Candidate candidate) {
        return CandidateStatus.AWAITING_RESPONSE;
    }

    @Override
    public CandidateStatus evaluateBasedOnOtherCriteria(Candidate candidate) {
        return CandidateStatus.AWAITING_RESPONSE;
    }

    public DepartmentName getName() {
        return name;
    }

    public void setName(DepartmentName name) {
        this.name = name;
    }

    public int getMinLevelOfCompetence() {
        return minLevelOfCompetence;
    }

    public void setMinLevelOfCompetence(int minLevelOfCompetence) {
        this.minLevelOfCompetence = minLevelOfCompetence;
    }

    public int getOpenPositions() {
        return openPositions;
    }

    public void setOpenPositions(int openPositions) {
        this.openPositions = openPositions;
    }
}
