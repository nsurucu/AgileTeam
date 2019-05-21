package com.example.dto;

import com.example.model.Squat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created on Mart, 2019
 * @author nazifs
 */
@Data
@NoArgsConstructor
public class TeamDto {

    Long Id;
    String teamName;
    List<MemberDto> memberList;


    public TeamDto(Squat team) {

        this.Id = team.getId();
        this.teamName = team.getTeamName();

        if (!CollectionUtils.isEmpty(team.getMemberList())) {

            final List<MemberDto> memberDtoList = team.getMemberList()
                    .stream()
                    .filter(Objects::nonNull)
                    .map(member -> new MemberDto(member))
                    .collect(Collectors.toList());

            this.setMemberList(memberDtoList);
        }


    }


}
