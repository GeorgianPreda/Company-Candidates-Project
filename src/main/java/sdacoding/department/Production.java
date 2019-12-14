package sdacoding.department;

import sdacoding.candidate.Candidate;
import sdacoding.candidate.CandidateStatus;

public class Production extends Department {

    private static Production instance = new Production();

    private Production() {

        super(DepartmentName.PRODUCTION, 8, 4);
    }

    public static Production getInstance() {
        return new Production();
    }

    @Override
    public CandidateStatus evaluateBasedOnCompetenceLevel(Candidate candidate) {

        return null;
    }
}
