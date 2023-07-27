package com.School.SchoolValleyProject.repository;

import com.School.SchoolValleyProject.Model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository

public interface ContactRepository extends PagingAndSortingRepository<Contact, Integer>, CrudRepository<Contact, Integer> {


 List<Contact> findByStatus(String status);

 @Query("SELECT c FROM Contact c WHERE c.status = :status")
 //@Query(value = "SELECT *FROM contact_msg c WHERE c.status=:status",nativeQuery = true)
 Page<Contact> findByStatus(@Param("status") String status, Pageable pageable);

 @Transactional
 @Modifying
 @Query("UPDATE Contact c SET c.status=?1 where c.contactId=?2")
 int updateStatusById(String status,int id);

}
