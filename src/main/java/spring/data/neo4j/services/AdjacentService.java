package spring.data.neo4j.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.data.neo4j.model.Adjacent;
import spring.data.neo4j.model.Beacon;
import spring.data.neo4j.repositories.AdjacentRepository;
import spring.data.neo4j.repositories.BeaconRepository;

@Service
public class AdjacentService {

    private final AdjacentRepository adjacentRepository;
    private final BeaconRepository beaconRepository;

    public AdjacentService(AdjacentRepository adjacentRepository, BeaconRepository beaconRepository) {
        this.adjacentRepository = adjacentRepository;
        this.beaconRepository = beaconRepository;
    }

    @Transactional
    public Adjacent createRel(String m1,String m2,int a,int c){

//        Beacon b1 = beaconRepository.findaBeacon(m1);
//        Beacon b2 = beaconRepository.findaBeacon(m2);
//
//        System.out.println(b1.getDescription());
//
//            Adjacent adjacent = new Adjacent();
//            adjacent.setStartBeacon(b1);
//        adjacent.setEndBeacon(b2);
//        adjacent.setCost(c);
//        adjacent.setAngle(a);
//            adjacentRepository.save(adjacent);


//        Beacon beacon = new Beacon();
//        beacon.setMAC(m1);
//        Beacon beacon1 = new Beacon();
//        beacon1.setMAC(m2);
//        Adjacent adjacent = new Adjacent();
//        adjacent.setStartBeacon(beacon);
//        adjacent.setEndBeacon(beacon1);
//        adjacent.setCost(c);
//        adjacent.setAngle(a);
//        return adjacentRepository.save(adjacent);
        return adjacentRepository.createRelationship(m1, m2, a, c);
//        return adjacentRepository.save(adjacent);
    }

    @Transactional(readOnly = true)
    public Adjacent findAdjj(){
        Adjacent l = adjacentRepository.findaRelationshipp();
        return l;
    }
}
