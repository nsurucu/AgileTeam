package com.example.dao;

import com.example.model.Squat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on Mart, 2019
 * @author nazifs
 */
@Repository
public interface SquatDao extends JpaRepository<Squat, Long> {


}
