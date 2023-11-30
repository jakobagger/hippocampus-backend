package memgrp.memorize.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import memgrp.memorize.dto.MemberRequest;
import memgrp.security.entity.UserWithRoles;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "USER_TYPE")
public class Member extends UserWithRoles {

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @OneToMany(mappedBy = "member")
    List<Quiz> quizList;

    @OneToMany(mappedBy = "member")
    List<Score> scoreList;

    public void addScore(Score score) {
        if(scoreList==null) {
            scoreList = new ArrayList<>();
        }
        scoreList.add(score);
    }

    public void addQuiz(Quiz quiz) {
        if(quizList == null) {
            quizList = new ArrayList<>();
        }
        quizList.add(quiz);
    }

    public static Member getMemberEntity(MemberRequest request) {
        Member member = new Member();
        member.setUsername(request.getUsername());
        member.setPassword(request.getPassword());
        member.setEmail(request.getEmail());
        return member;
    }

    public Member(String username, String password, String email) {
        super(username,password,email);
    }

}
