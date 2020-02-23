package spring.data.neo4j.model;

import com.google.gson.Gson;

public class ModelBeaconPathRequest {
    private String MAC;
    private String endMsg;
    private String juncMsg;
    private String location;
    private int angle;
    private Staircase staircase;
    private int isStaircase;
    private float meanNormalize1;
    private float meanNormalize2;
    private float stdNormalize1;
    private float stdNormalize2;



    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ModelBeaconPathRequest(String MAC, String endMsg, String juncMsg, int angle, Staircase staircase, int isStaircase, float meanNormalize1, float meanNormalize2, float stdNormalize1, float stdNormalize2,String location) {
        this.MAC = MAC;
        this.endMsg = endMsg;
        this.juncMsg = juncMsg;
        this.angle = angle;
        this.staircase = staircase;
        this.isStaircase = isStaircase;
        this.meanNormalize1 = meanNormalize1;
        this.meanNormalize2 = meanNormalize2;
        this.stdNormalize1 = stdNormalize1;
        this.stdNormalize2 = stdNormalize2;
        this.location = location;
    }

    public ModelBeaconPathRequest() {
    }

    public static Beacon convertToBeacon(ModelBeaconPathRequest modelBeaconPathRequest){
        Beacon beacon = new Beacon();
        beacon.setLocation(modelBeaconPathRequest.getLocation());
        beacon.setMAC(modelBeaconPathRequest.getMAC());
        beacon.setEndMsg(modelBeaconPathRequest.getEndMsg());
        beacon.setJuncMsg(modelBeaconPathRequest.getJuncMsg());
        beacon.setIsStaircase(modelBeaconPathRequest.getIsStaircase());
        beacon.setMeanNormalize1(modelBeaconPathRequest.getMeanNormalize1());
        beacon.setMeanNormalize2(modelBeaconPathRequest.getMeanNormalize2());
        beacon.setStdNormalize1(modelBeaconPathRequest.getStdNormalize1());
        beacon.setStdNormalize2(modelBeaconPathRequest.getStdNormalize2());
        Gson g = new Gson();
        beacon.setStaircase(g.toJson(modelBeaconPathRequest.getStaircase(),Staircase.class).toString());
        return beacon;
    }

    public String getMAC() {
        return MAC;
    }

    public void setMAC(String MAC) {
        this.MAC = MAC;
    }

    public String getEndMsg() {
        return endMsg;
    }

    public void setEndMsg(String endMsg) {
        this.endMsg = endMsg;
    }

    public String getJuncMsg() {
        return juncMsg;
    }

    public void setJuncMsg(String juncMsg) {
        this.juncMsg = juncMsg;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public Staircase getStaircase() {
        return staircase;
    }

    public void setStaircase(Staircase staircase) {
        this.staircase = staircase;
    }

    public int getIsStaircase() {
        return isStaircase;
    }

    public void setIsStaircase(int isStaircase) {
        this.isStaircase = isStaircase;
    }

    public float getMeanNormalize1() {
        return meanNormalize1;
    }

    public void setMeanNormalize1(float meanNormalize1) {
        this.meanNormalize1 = meanNormalize1;
    }

    public float getMeanNormalize2() {
        return meanNormalize2;
    }

    public void setMeanNormalize2(float meanNormalize2) {
        this.meanNormalize2 = meanNormalize2;
    }

    public float getStdNormalize1() {
        return stdNormalize1;
    }

    public void setStdNormalize1(float stdNormalize1) {
        this.stdNormalize1 = stdNormalize1;
    }

    public float getStdNormalize2() {
        return stdNormalize2;
    }

    public void setStdNormalize2(float stdNormalize2) {
        this.stdNormalize2 = stdNormalize2;
    }
}
