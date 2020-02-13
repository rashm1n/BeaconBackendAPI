package spring.data.neo4j.model;

import java.util.List;

public class Staircase {
    String msg;
    int numberOfSteps;
    List<Breakpoint> breakPoints;

    public Staircase(String msg, int numberOfSteps, List<Breakpoint> breakPoints) {
        this.msg = msg;
        this.numberOfSteps = numberOfSteps;
        this.breakPoints = breakPoints;
    }

    public Staircase() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getNumberOfSteps() {
        return numberOfSteps;
    }

    public void setNumberOfSteps(int numberOfSteps) {
        this.numberOfSteps = numberOfSteps;
    }

    public List<Breakpoint> getBreakPoints() {
        return breakPoints;
    }

    public void setBreakPoints(List<Breakpoint> breakPoints) {
        this.breakPoints = breakPoints;
    }
}
