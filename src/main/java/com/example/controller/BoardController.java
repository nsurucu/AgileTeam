package com.example.controller;

import com.example.dao.BoardDao;
import com.example.model.Board;
import com.example.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created on Mart, 2019
 * @author nazifs
 */
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@RestController()
public class BoardController {


    @Autowired
    BoardDao boardDao;

    @GetMapping("/board/{id}")
    public Optional<Board> getMember(@PathVariable Long id) throws Exception {
        Optional<Board> board = boardDao.findById(id);
        if (!board.isPresent()) {
            throw new Exception();
        }

        return board;
    }

    @GetMapping("/board/joblist/{id}")
    public List<Job> get(@PathVariable Long id) throws Exception {
        List<Job> listOfJob = boardDao.findAllById(id);
        if (!listOfJob.isEmpty()) {
            throw new Exception();
        }

        return listOfJob;
    }


    @PostMapping("/create-board")
    public Board createTeam(@Valid @RequestBody Board board) {
        return this.boardDao.save(board);
    }

}
