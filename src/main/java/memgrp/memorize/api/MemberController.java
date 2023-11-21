package memgrp.memorize.api;

import memgrp.memorize.dto.MemberRequest;
import memgrp.memorize.dto.MemberResponse;
import memgrp.memorize.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/members")
public class MemberController {

    MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping
    public List<MemberResponse> getMembers() {
        List<MemberResponse> responses = memberService.getMembers();
        return responses;
    }

    @PostMapping
    ResponseEntity<Boolean> addMember(@RequestBody MemberRequest request) {

        ResponseEntity<Boolean> response = memberService.addMember(request);

        return response;
    }

}
