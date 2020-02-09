package spring.data.neo4j.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.data.neo4j.model.Adjacent;
import spring.data.neo4j.model.Beacon;
import spring.data.neo4j.model.InitialRel;
import spring.data.neo4j.repositories.BeaconRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BeaconService {

    private final BeaconRepository beaconRepository;
    public BeaconService(BeaconRepository beaconRepository) {
        this.beaconRepository = beaconRepository;
    }

//    @Transactional(readOnly = true)
//    public UserQueryResult findBeacon(){
//        UserQueryResult b = beaconRepository.findaBeacon();
//        return b;
//    }

    @Transactional
    public Beacon getBeacon(String m){
        return beaconRepository.findByMAC(m);
    }

    @Transactional
    public Beacon findBeacon(String m){
        return beaconRepository.findaBeacon(m);
    }

    @Transactional
    public Beacon createBeacon(String s,String d,String l){
        return beaconRepository.createBeacon(s, d, l);
    }

    @Transactional
    public String createBeacons(List<Beacon> b){
        beaconRepository.saveAll(b);
        return "saved";
    }

    @Transactional(readOnly = true)
    public List<Beacon> findBeacons(){
        return beaconRepository.findaBeacons();

    }

    @Transactional(readOnly = true)
    public Adjacent findAdj(String m1,String m2){
        return beaconRepository.findaRelationship(m1, m2);
    }

    @Transactional(readOnly = true)
    public InitialRel findIniAdj(String m1, String m2){
        return beaconRepository.findaIniRelationship(m1, m2);
    }

    @Transactional(readOnly = true)
    public Iterable<Map<String, Object>> findS(String s,String d){
        return beaconRepository.findashortest(s,d);

    }

    @Transactional
    public ResponseEntity cbb(ArrayList<Beacon> b){
        beaconRepository.saveAll(b);
        return ResponseEntity.ok().build();
    }

    @Transactional(readOnly = true)
    public List<Beacon> getDestinations(){
        return beaconRepository.getAllDestinations();

    }

}
