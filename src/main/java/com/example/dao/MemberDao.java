package com.example.dao;

import com.example.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on Mart, 2019
 * @author nazifs
 */
@Repository
public interface MemberDao extends JpaRepository<Member, Long> {


    public List<Member> findByTeamName(String teamName);

}
