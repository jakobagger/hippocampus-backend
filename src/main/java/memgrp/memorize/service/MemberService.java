package memgrp.memorize.service;

import memgrp.memorize.dto.MemberRequest;
import memgrp.memorize.dto.MemberResponse;
import memgrp.memorize.entity.Member;
import memgrp.memorize.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MemberService {

    MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<MemberResponse> getMembers() {
            List<Member> members = memberRepository.findAll();
            return members.stream().map((member -> new MemberResponse(member, false, false))).toList();

    }

    public MemberResponse addMember(MemberRequest request) {

        if (memberRepository.existsById(request.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Member with this username already exist");
        }
        Member member = Member.getMemberEntity(request);
        memberRepository.save(member);

        return new MemberResponse(member, false, false);
    }
}
