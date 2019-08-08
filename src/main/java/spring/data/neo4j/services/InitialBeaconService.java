package spring.data.neo4j.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.data.neo4j.model.Busyness;
import spring.data.neo4j.model.IniBeacon;
import spring.data.neo4j.repositories.IniBeaconRepository;

import java.util.List;
import java.util.Map;

@Service
public class InitialBeaconService {
    @Autowired
    private IniBeaconRepository iniBeaconRepository;

    @Transactional
    public List<IniBeacon> getIniBeacons(){
        return iniBeaconRepository.initialBeaconList();
    }

    @Transactional
    public Busyness getBusyness(){
        return iniBeaconRepository.business();
    }

}
