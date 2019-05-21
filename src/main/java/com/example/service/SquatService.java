package com.example.service;

import com.example.dao.MemberDao;
import com.example.dao.SquatDao;
import com.example.model.Squat;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

/**
 * Created on Mart, 2019
 * @author nazifs
 */
@Service
@AllArgsConstructor
public class SquatService {

    private SquatDao teamDao;

    private MemberDao memberDao;

    public List<Squat> getAllTeams() {

        final List<Squat> teams = teamDao.findAll();

        if (!CollectionUtils.isEmpty(teams)) {

            teams.stream()
                    .filter(Objects::nonNull)
                    .forEach(team -> team.setMemberList(memberDao.findByTeamName(team.getTeamName())));
        }

        return teams;
    }


}
