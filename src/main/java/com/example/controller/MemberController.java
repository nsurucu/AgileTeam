package com.example.controller;

import com.example.dao.MemberDao;
import com.example.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Created on Mart, 2019
 * @author nazifs
 */
//@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class MemberController {

    @Autowired
    MemberDao memberDao;



    @PostMapping("/adduser")
    public String addUser(@Valid Member user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }

        memberDao.save(user);
        model.addAttribute("users", memberDao.findAll());
        return "index";
    }

    @GetMapping("/member/{id}")
    public Optional<Member> getMember(@PathVariable Long id) throws Exception {
        Optional<Member> member = memberDao.findById(id);
        if (!member.isPresent()) {
            throw new Exception();
        }

        return member;
    }

    @PutMapping("/member/{id}")
    public Member updateMember(@PathVariable Long id,@Valid @RequestBody Member member) {
        Optional<Member> optionalMember=memberDao.findById(id);
        if(!optionalMember.isPresent()){
            return null;
        }
        member.setId(id);

        return this.memberDao.save(member);

    }

    @GetMapping("/member-list")
    public Iterable<Member> getMemberList() {
        return  memberDao.findAll();
    }

    @PostMapping("/create-member")
    public Member createMember(@Valid @RequestBody Member member) {

        return this.memberDao.save(member);

    }

    @DeleteMapping("/member/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberDao.deleteById(id);
    }


}




