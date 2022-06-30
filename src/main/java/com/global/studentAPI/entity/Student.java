package com.global.studentAPI.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.util.*;

// use lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// to make this class table in database
@Entity(name = "student")
@Table
public class Student {


    @Id   //to make id a pk in database
    @SequenceGenerator(
            // to make id auto increment
            name = "Student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(name = "id")
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone_number")
    private String phone;

    @Column(name = "age")
    private String age;

    @Column(name = "address")
    private String address;

    @CreationTimestamp
    @Column(name = "date_created")
    private Date dateCreated;

    @UpdateTimestamp
    @Column(name = "date_updated")
    private Date dateUpdated;


}