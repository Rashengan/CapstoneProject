package Capstone.Project.service;

import Capstone.Project.model.Attendee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Capstone.Project.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void CreateAttendee(Attendee att){ userRepository.createAttendee(att);}

}
