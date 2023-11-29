package memgrp.memorize.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import memgrp.memorize.entity.Member;
import memgrp.security.entity.Role;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemberResponse {

    private String username;
    private String email;
    private String firstName;
    private String lastName;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime created;

    private boolean enabled;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private List<Role> roles;

    public MemberResponse(Member m, boolean includeAll, boolean includeAccountStatus) {
        this.username = m.getUsername();
        this.email = m.getEmail();
        if (includeAccountStatus) {
            this.enabled = m.isEnabled();
            this.accountNonExpired = m.isAccountNonExpired();
            this.accountNonLocked = m.isAccountNonLocked();
        }
        if (includeAll) {
            this.created = m.getCreated();
            this.roles = m.getRoles();
        }
    }

    public MemberResponse(Member m) {
        this.username = m.getUsername();
        this.email = m.getEmail();
    }
}
