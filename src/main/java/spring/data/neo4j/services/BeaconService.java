package spring.data.neo4j.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.data.neo4j.model.Adjacent;
import spring.data.neo4j.model.Beacon;
import spring.data.neo4j.repositories.BeaconRepository;

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

    @Transactional(readOnly = true)
    public List<Beacon> findBeacons(){
        return beaconRepository.findaBeacons();

    }

    @Transactional(readOnly = true)
    public List<Adjacent> findAdj(){
        return beaconRepository.findaRelationship();
    }

    @Transactional(readOnly = true)
    public Iterable<Map<String, Object>> findS(String s,String d){
        return beaconRepository.findashortest(s,d);

    }

    @Transactional(readOnly = true)
    public List<Beacon> getDestinations(){
        return beaconRepository.getAllDestinations();

    }

}
