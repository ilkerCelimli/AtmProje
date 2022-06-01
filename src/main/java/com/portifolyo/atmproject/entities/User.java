package com.portifolyo.atmproject.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "users")
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseEntity {


   @Column
   private String name;
   @Column
   private String surname;
   @Column
   private String email;
   @Column
   private String password;
   @Column
   private String secretQuestion;
   @Column
   private String secretAnswer;
   @Column
   private Date birtday;


}
