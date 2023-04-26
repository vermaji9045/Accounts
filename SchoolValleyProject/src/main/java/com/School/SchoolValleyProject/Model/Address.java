package com.School.SchoolValleyProject.Model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
public class Address extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private int addressid;

    @NotBlank(message = "Address must not be Blank")
    @Size(min = 10,message = "Address must be 5 characters")
    private String address1;
    private String address2;

    @NotBlank(message = "City must not be Blank")
    @Size(min = 5,message = "City must be 5 characters")
    private String city;

    @NotBlank(message = "State must not be Blank")
    @Size(min = 5,message = "State must be 5 characters")
    private String state;

    @NotBlank(message = "ZipCode must not be Blank")
    @Pattern(regexp = "(^$|(0-9){6})",message = "Zip Code must have 6 gigits")
    private int zipcode;



}
