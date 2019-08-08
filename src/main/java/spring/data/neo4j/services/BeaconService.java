package spring.data.neo4j.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.data.neo4j.model.Adjacent;
import spring.data.neo4j.model.Beacon;
import spring.data.neo4j.repositories.BeaconRepository;

import java.util.List;

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
        List<Beacon> l = beaconRepository.findaBeacons();
        return l;
    }

    @Transactional(readOnly = true)
    public List<Adjacent> findAdj(){
        List<Adjacent> l = beaconRepository.findaRelationship();
        return l;
    }

    @Transactional(readOnly = true)
    public List<Beacon> findS(){
        List<Beacon> l = beaconRepository.findashortest();
        return l;
    }


}
