package sdacoding.department;

import sdacoding.candidate.Candidate;
import sdacoding.candidate.CandidateStatus;
import sdacoding.candidate.Gender;

public class Marketing extends Department {

    private static Marketing instance = new Marketing();
    private int maximNoOfOpenPositionsForMales = getOpenPositions() * 40 / 100;
    private int maximNoOfOpenPositionsForFemales = getOpenPositions() * 60 / 100;


    private Marketing() {

        super(DepartmentName.MARKETING, 5, 4);
    }

    public static Marketing getInstance() {
        return new Marketing();
    }

    @Override
    public CandidateStatus evaluateBasedOnCompetenceLevel(Candidate candidate) {
        if (candidate.getLevelOfCompetence() < this.getMinLevelOfCompetence()) {
            return CandidateStatus.REJECTED;
        } else {
            return CandidateStatus.ACCEPTED;
        }
    }

    @Override
    public CandidateStatus evaluateBasedOnOtherCriteria(Candidate candidate) {
         if (candidate.getGender().equals(Gender.M) && maximNoOfOpenPositionsForMales > 0) {
             maximNoOfOpenPositionsForMales = maximNoOfOpenPositionsForMales - 1;
             return CandidateStatus.ACCEPTED;
         } else if (candidate.getGender().equals(Gender.F) && maximNoOfOpenPositionsForFemales > 0) {
             maximNoOfOpenPositionsForFemales = maximNoOfOpenPositionsForFemales - 1;
             return CandidateStatus.ACCEPTED;
         }
         return CandidateStatus.REJECTED;
    }


}
