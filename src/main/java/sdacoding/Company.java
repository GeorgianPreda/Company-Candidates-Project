package sdacoding;

import com.fasterxml.jackson.databind.ObjectMapper;
import sdacoding.Exceptions.EvaluationIncapacityException;
import sdacoding.candidate.Candidate;
import sdacoding.candidate.CandidateStatus;
import sdacoding.candidate.Gender;
import sdacoding.department.Department;
import sdacoding.department.DepartmentName;
import sdacoding.department.Marketing;
import sdacoding.department.Production;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Company {

    private List<Department> departments = new ArrayList<>();
    private List<Candidate> candidates = new ArrayList<>();

    public Company() {
        departments.add(Marketing.getInstance());
        departments.add(Production.getInstance());
    }

    public void addCandidates(Candidate candidate) {
        this.candidates.add(candidate);
    }


    public void recruiting() {

        readCandidatesFromJsonFile();


        // Sort List Before
        Collections.sort(candidates, new Comparator<Candidate>() {
            @Override
            public int compare(Candidate o1, Candidate o2) {
                if (o1.getLevelOfCompetence() > o2.getLevelOfCompetence()) {
                    return -1;
                } else if (o1.getLevelOfCompetence() < o2.getLevelOfCompetence()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        // Get Candidates in marketing and production
        List<Candidate> candidatesInMarketing = new ArrayList<>();
        List<Candidate> candidatesInProd = new ArrayList<>();

        for (Candidate candidate : candidates) {
            if (candidate.getDepartmentName().equals(DepartmentName.MARKETING)) {
                candidatesInMarketing.add(candidate);
            } else if (candidate.getDepartmentName().equals(DepartmentName.PRODUCTION)) {
                candidatesInProd.add(candidate);
            } else {
                throw new EvaluationIncapacityException();
            }
        }
        List<Candidate> candidatesAccepted = getCandidatesInMarketing(candidatesInMarketing);

        writeCandidatesToJsonFile(candidatesAccepted);
        readCandidatesFromJsonFile();
    }


    public int getNumberOfFemale() {
        // 1

        int count = 0;

        for (Candidate c : this.candidates) {
            if (c.getGender().equals(Gender.F)) {
                count++;
            }
        }
        return count;
    }

    public int getNumberOfFemalesUsingStreams() {
        return this.candidates.stream()
                .filter(candidate -> candidate.getGender().equals(Gender.F))
                .collect(Collectors.toList()).size();
    }


    public int getNumberOfMalesUsingStreams() {
        return (int) this.candidates.stream()
                .filter(candidate -> candidate.getGender().equals(Gender.M))
                .collect(Collectors.toList()).size();
    }


    private List<Candidate> getCandidatesInMarketing(List<Candidate> candidatesForMarketing) {
        Marketing marketing = Marketing.getInstance();
        List<Candidate> finalCandidates = new ArrayList<>();

        if (candidatesForMarketing.isEmpty()) {
            System.out.println("No candidates applied for marketing");
            return finalCandidates;
        }
        for (Candidate c : candidatesForMarketing) {
            CandidateStatus firstResponse = marketing.evaluateBasedOnCompetenceLevel(c);
            c.setStatus(firstResponse); // is it right here ?
            if (firstResponse.equals(CandidateStatus.ACCEPTED)) {
                CandidateStatus finalResponse = marketing.evaluateBasedOnOtherCriteria(c);
                if (finalResponse.equals(CandidateStatus.ACCEPTED)) {
                    finalCandidates.add(c);
                }
            }
        }
//        System.out.println(finalCandidates);
        return finalCandidates;
    }


    private void writeCandidatesToJsonFile(List<Candidate> candidates) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("candidati-acceptati.json"), candidates);
        } catch (Exception e) {
            System.out.println("Writing to json file failed.");
        }
    }

    private List<Candidate> readCandidatesFromJsonFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // ceea ce am citit din fisier
            String input = new String(Files.readAllBytes(Paths.get("candidati-initiali.json")));
            // object mapper - din String transforma in lista de candidati
            List<Candidate> candidates = objectMapper
                    .readValue(input,
                            objectMapper.getTypeFactory()
                                    .constructCollectionType(List.class, Candidate.class));
            System.out.println(candidates);
            return candidates;
        } catch (IOException e) {
            System.out.println("Reading from file failed.");
            return null;
        }
    }


        public List<Department> getDepartments () {
            return departments;
        }


        public List<Candidate> getCandidates () {
            return candidates;
        }

        public void setCandidates (List < Candidate > candidates) {
            this.candidates = candidates;
        }



    }
