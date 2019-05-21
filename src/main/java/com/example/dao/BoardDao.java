package com.example.dao;

import com.example.model.Board;
import com.example.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on Mart, 2019
 * @author nazifs
 */
@Repository
public interface BoardDao extends JpaRepository<Board, Long> {


    public List<Job> findAllById(Long id);

}
