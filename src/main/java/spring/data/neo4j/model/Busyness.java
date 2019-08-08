package spring.data.neo4j.model;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Busyness {
    @Id
    private int id;
    private Long first;
    private Long second;
    private Long third;
    private Long fourth;
    private Long fifth;
    private Long sixth;

    @Relationship(type = "HAS",direction = Relationship.INCOMING)
    private IniBeacon iniBeacon;

    public Busyness() {
    }

    public Busyness(int id, Long first, Long second, Long third, Long fourth, Long fifth, Long sixth, IniBeacon iniBeacon) {
        this.id = id;
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
        this.sixth = sixth;
        this.iniBeacon = iniBeacon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getFirst() {
        return first;
    }

    public void setFirst(Long first) {
        this.first = first;
    }

    public Long getSecond() {
        return second;
    }

    public void setSecond(Long second) {
        this.second = second;
    }

    public Long getThird() {
        return third;
    }

    public void setThird(Long third) {
        this.third = third;
    }

    public Long getFourth() {
        return fourth;
    }

    public void setFourth(Long fourth) {
        this.fourth = fourth;
    }

    public Long getFifth() {
        return fifth;
    }

    public void setFifth(Long fifth) {
        this.fifth = fifth;
    }

    public Long getSixth() {
        return sixth;
    }

    public void setSixth(Long sixth) {
        this.sixth = sixth;
    }

    public IniBeacon getIniBeacon() {
        return iniBeacon;
    }

    public void setIniBeacon(IniBeacon iniBeacon) {
        this.iniBeacon = iniBeacon;
    }
}
