package spring.data.neo4j.model;

public class Breakpoint {
    String msg;
    int steps;

    public Breakpoint(String msg, int steps) {
        this.msg = msg;
        this.steps = steps;
    }

    public Breakpoint() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }
}
