package com.medontology.shexmap.validator;

import com.medontology.shexmap.validator.solution.Solution;

import java.util.ArrayList;
import java.util.List;

public class SolutionSet {
    private String type; //Turn this into an enum. Need all possible statuses.
    private List<Solution> solutions = new ArrayList<>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Solution> getSolutions() {
        return solutions;
    }

    public void setSolutions(List<Solution> solutions) {
        this.solutions = solutions;
    }

    public void addSolution(Solution solution) {
        this.solutions.add(solution);
    }

    public void reset() {
        if(solutions != null) {
            solutions.clear();
        } else {
            solutions = new ArrayList<>();
        }
    }
}
