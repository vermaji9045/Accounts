package com.School.SchoolValleyProject.Services;

import com.School.SchoolValleyProject.Constants.ValleyPublicConst;
import com.School.SchoolValleyProject.Model.Contact;
import com.School.SchoolValleyProject.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
//@RequestScope
//@SessionScop
@ApplicationScope
public class ServiceContact {


    @Autowired
    private ContactRepository contactRepository;

    public boolean saveMessage(Contact contact){
        boolean isSaved = false;
        contact.setStatus(ValleyPublicConst.OPEN);
        Contact savedContact = contactRepository.save(contact);
        if(null != savedContact && savedContact.getContactId()>0) {
            isSaved = true;
        }
        return isSaved;
    }

    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactMsgs = contactRepository.findByStatus(ValleyPublicConst.OPEN);
        return contactMsgs;
    }

    public boolean UpdateMsgStatus(int contactId){
        boolean isUpdated = false;
        Optional<Contact> contact = contactRepository.findById(contactId);
        contact.ifPresent(contact1 -> {
            contact1.setStatus(ValleyPublicConst.CLOSE);
        });
        Contact updatedContact = contactRepository.save(contact.get());
        if(null != updatedContact && updatedContact.getUpdatedBy()!=null) {
            isUpdated = true;
        }
        return isUpdated;
    }

}
