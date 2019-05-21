package com.example.dto;

import com.example.model.Member;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created on Mart, 2019
 * @author nazifs
 */
@Data
@NoArgsConstructor
public class MemberDto {

    Long Id;

    String name;

    String title;

    String teamName;

    public MemberDto(Member member) {
        this.Id = member.getId();
        this.name = member.getName();
        this.title = member.getTitle();
        this.teamName = member.getTeamName();
    }
}
