package com.example.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created on Mart, 2019
 * @author nazifs
 */

@Data
@Entity
@Table(name = "JOB")
public class Job {
    @Id
    @GeneratedValue
    @Column
    Long Id;
    @Column
    String name;

    @Column
    String BoardName;



}
