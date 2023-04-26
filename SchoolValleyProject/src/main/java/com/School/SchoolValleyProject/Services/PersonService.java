package com.School.SchoolValleyProject.Services;

import com.School.SchoolValleyProject.Constants.ValleyPublicConst;
import com.School.SchoolValleyProject.Model.Person;
import com.School.SchoolValleyProject.Model.Roles;
import com.School.SchoolValleyProject.repository.PersonRepository;
import com.School.SchoolValleyProject.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    RoleRepository roleRepository;

    public boolean CreateNewUser(Person person) {
        boolean issave = false;

        Roles roles = roleRepository.getByRoleName(ValleyPublicConst.STUDENT_ROLE);

        person.setRoles(roles);

        person = personRepository.save(person);
        if (null != person && person.getPersonid() > 0) {
            issave = true;
        }
        return issave;

    }
}
