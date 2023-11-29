package memgrp.memorize.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberRequest {

    protected String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;

    public MemberRequest(String username, String password, String email) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

}
