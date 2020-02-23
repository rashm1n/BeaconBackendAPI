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

    @Transactional
    public Beacon createBeacon(Beacon b){
        return beaconRepository.save(b);
    }

    @Transactional
    public String deleteBeacon(String mac){
        Beacon b = getBeacon(mac);
        try {
            beaconRepository.delete(b);
            return "deleted";
        }catch (NullPointerException n){
            return "no such beacon";
        }
    }

    @Transactional(readOnly = true)
    public List<Beacon> findBeacons(){
        return beaconRepository.findaBeacons();

    }

    @Transactional(readOnly = true)
    public Adjacent findAdj(String l1,String l2){
        return beaconRepository.findaRelationship(l1, l2);
    }

    @Transactional(readOnly = true)
    public InitialRel findIniAdj(String m1, String l2){
        return beaconRepository.findaIniRelationship(m1, l2);
    }

    @Transactional(readOnly = true)
    public Iterable<Map<String, Object>> findS(String l1,String l2){
        return beaconRepository.findashortest(l1,l2);

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
