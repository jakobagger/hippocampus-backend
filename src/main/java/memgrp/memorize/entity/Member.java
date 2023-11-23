package memgrp.memorize.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import memgrp.memorize.dto.MemberRequest;
import memgrp.security.entity.UserWithRoles;

@Getter
@Setter
@NoArgsConstructor
@Entity

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "USER_TYPE")
public class Member extends UserWithRoles {

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

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
