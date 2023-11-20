package memgrp.memorize.api;

import memgrp.memorize.dto.MemberRequest;
import memgrp.memorize.dto.MemberResponse;
import memgrp.memorize.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/member")
public class MemberController {

    MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public List<MemberResponse> getMembers() {
        return memberService.getMembers();
    }

    @PostMapping
    MemberResponse addMember(@RequestBody MemberRequest request) {

        MemberResponse response = memberService.addMember(request);

        return response;
    }
}
