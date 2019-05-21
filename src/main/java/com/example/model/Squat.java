package com.example.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created on Mart, 2019
 * @author nazifs
 */
@Data
@Entity
@Table(name = "SQUAT")
public class Squat {
    @Id
    @GeneratedValue
    @Column
    Long Id;
    @Column
    String teamName;


    @Transient
    private List<Member> memberList;

}
