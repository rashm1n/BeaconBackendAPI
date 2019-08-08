package spring.data.neo4j.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.data.neo4j.model.Adjacent;
import spring.data.neo4j.repositories.AdjacentRepository;

@Service
public class AdjacentService {

    private final AdjacentRepository adjacentRepository;

    public AdjacentService(AdjacentRepository adjacentRepository) {
        this.adjacentRepository = adjacentRepository;
    }

    @Transactional(readOnly = true)
    public Adjacent findAdjj(){
        Adjacent l = adjacentRepository.findaRelationshipp();
        return l;
    }
}
