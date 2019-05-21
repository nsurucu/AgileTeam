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
@Table(name = "BOARD")
public class Board {
    @Id
    @GeneratedValue
    @Column
    Long id;
    @Column
    String name;
    @Transient
    private List<Job> jobs;

}

