package com.School.SchoolValleyProject.Rest;


import com.School.SchoolValleyProject.Model.Contact;
import com.School.SchoolValleyProject.Model.Response;
import com.School.SchoolValleyProject.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;


@Slf4j
@RestController

@RequestMapping(path="/api/contact")
public class RestContactController {

    @Autowired
    ContactRepository contactRepository;

    @GetMapping("/getMessagesByStatus")
    public List<Contact> getMessagesByStatus(@RequestParam(name = "status") String status)
    {
        return contactRepository.findByStatus(status);
    }



    @GetMapping("/getAllMsgsByStatus")
    public List<Contact> getAllMsgsByStatus(@RequestBody Contact contact){
        if(null != contact && null != contact.getStatus()){
            return contactRepository.findByStatus(contact.getStatus());
        }else{
            return null;
        }
    }

    @PostMapping("/saveMsg")
    public ResponseEntity<Response> saveMsg(@RequestHeader("invocationFrom") String invocationFrom,
                                           @Valid @RequestBody  Contact contact)
    {
        log.info(String.format("Header invocation from=%s",invocationFrom));
        contactRepository.save(contact);
        Response response=new Response();
        response.setStatusCode("200");
        response.setStatusMsg("Msg saved");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("isMsgSaved","true")
                .body(response);

    }
}
