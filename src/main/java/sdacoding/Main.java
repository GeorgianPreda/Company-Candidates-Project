package sdacoding;

import sdacoding.candidate.Candidate;
import sdacoding.candidate.CandidateStatus;
import sdacoding.department.Department;

import static sdacoding.candidate.Gender.F;
import static sdacoding.candidate.Gender.M;
import static sdacoding.department.DepartmentName.*;
import sdacoding.department.Marketing;
import sdacoding.department.Production;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        Candidate c1 = new Candidate("John", 10, MARKETING, M);
//        Candidate c2 = new Candidate("Ellen", 3, MARKETING, F);
//        Candidate c3 = new Candidate("Justin", 2, MARKETING, M);
//        Candidate c4 = new Candidate("Jessica", 11, MARKETING, F);
//        Candidate c5 = new Candidate("Brad", 9, MARKETING, M);
//        Candidate c6 = new Candidate("Johanna", 15, MARKETING, F);
//        Candidate c7 = new Candidate("Jane", 2, PRODUCTION, M);
//        Candidate c8 = new Candidate("Jane", 10, PRODUCTION, F);
////        Candidate c5 = new Candidate("Paul", 7, HR, M);

        Company company = new Company();
//        company.addCandidates(c1);
//        company.addCandidates(c2);
//        company.addCandidates(c3);
//        company.addCandidates(c4);
//        company.addCandidates(c5);
//        company.addCandidates(c6);
//        company.addCandidates(c5);

        company.recruiting();
//        for (Candidate c : company.getCandidates()) {
//            System.out.println(c);
//        }


//        HashSet<Department> deps = new HashSet<>();
//        Marketing m1 = Marketing.getInstance();
//        Marketing m2 = Marketing.getInstance();
//
//        deps.add(m1);
//        deps.add(m2);
//        System.out.println(deps.size());


//        List<Candidate> candidates = new ArrayList<>();
//        candidates.add(c1);
//        candidates.add(c2);
//        candidates.add(c3);
//        candidates.add(c4);
//        candidates.add(c5);
//        candidates.add(c6);
//
//        Company company = new Company();
//        company.setCandidates(candidates);
//
//        for (Candidate c : candidates) {
//            System.out.println(c);
//        }
    }
}
