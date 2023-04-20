package com.School.SchoolValleyProject.Model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Holidays")
public class Holiday extends BaseEntity {

    @Id
    private  String day;
    private  String reason;
    @Enumerated(EnumType.STRING)
    private  Type type;

    public enum Type {
        FESTIVAL, FEDERAL
    }

}
