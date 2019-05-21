package com.example.controller;

import com.example.dto.TeamDto;
import com.example.dao.MemberDao;
import com.example.dao.SquatDao;
import com.example.model.Squat;
import com.example.service.SquatService;
import lombok.AllArgsConstructor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created on Mart, 2019
 * @author nazifs
 */
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@RestController()
@AllArgsConstructor
public class SquatController {


    SquatService teamService;
    SquatDao teamDao;
    MemberDao memberDao;


    @GetMapping("/squat/{id}")
    public Optional<Squat> getTeam(@PathVariable Long id) throws Exception {
        Optional<Squat> squat = teamDao.findById(id);
        if (!squat.isPresent()) {
            throw new Exception();
        }

        return squat;

    }


    @PutMapping("/squat/{id}")
    public Squat updateTeam(@PathVariable Long id, @Valid @RequestBody Squat squat) {
        Optional<Squat> optionalTeam = teamDao.findById(id);
        if (!optionalTeam.isPresent()) {
            return null;
        }
        squat.setId(id);

        return this.teamDao.save(squat);

    }

    @GetMapping("/squat-list")
    public List<TeamDto> getTeamList() {

        final List<Squat> teams = teamService.getAllTeams();

        final List<TeamDto> teamDtos = new ArrayList<>(0);

        if (!CollectionUtils.isEmpty(teams)) {
            teams.forEach(squat -> teamDtos.add(new TeamDto(squat)));
        }

        return teamDtos;


    }


   @PostMapping("/create-squat")
    public Squat createTeam(@Valid @RequestBody Squat squat) {
        return this.teamDao.save(squat);
    }


    @DeleteMapping("/squat/{id}")
    public void deleteTeam(@PathVariable Long id) {

        teamDao.deleteById(id);
    }


}
