package Capstone.Project.service;


import java.util.List;



import Capstone.Project.model.Session;
import Capstone.Project.repository.ConferenceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class ConferenceService {

    @Autowired
    ConferenceRepository conferenceRepository;

    public List<Session> findAllSession(){
        return conferenceRepository.findAll();
    }

}
