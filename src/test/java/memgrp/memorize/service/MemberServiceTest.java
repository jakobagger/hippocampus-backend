package memgrp.memorize.service;

import memgrp.memorize.dto.MemberRequest;
import memgrp.memorize.dto.MemberResponse;
import memgrp.memorize.entity.Member;
import memgrp.memorize.repository.MemberRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {

    @InjectMocks
    private MemberService memberService;
    @Mock
    private MemberRepository memberRepository;

    @BeforeEach
    void setUp() {
        memberService = new MemberService(memberRepository);
    }

    private Member makeMember(String username, String password, String email) {
        Member member = new Member(username, password, email);
        return new Member(username, password, email);
    }

    @Test
    public void testGetMembers() {
        Member m1 = makeMember("bruger1", "1234", "bruger1@mail.com");
        Member m2 = makeMember("bruger2", "1234", "bruger2@mail.com");
        Member m3 = makeMember("bruger3", "1234", "bruger3@mail.com");
        when(memberRepository.findAll()).thenReturn(List.of(m1, m2, m3));
        List<MemberResponse> members = memberService.getMembers();

        assertEquals(3, members.size());
        assertEquals("bruger1", members.get(0).getUsername());
    }

    @Test
    public void testAddMember_Success() {
        MemberRequest request = new MemberRequest("bruger1", "1234", "newMember@mail.com");
        Member newMember = makeMember("bruger1", "1234", "newMember@mail.com");
        when(memberRepository.existsById(request.getUsername())).thenReturn(false);
        when(memberRepository.save(any(Member.class))).thenReturn(newMember);

        MemberResponse response = memberService.addMember(request);

        assertNotNull(response);
        assertEquals("bruger1", response.getUsername());
    }

    @Test
    public void testAddMember_UserExists() {
        MemberRequest request = new MemberRequest("bruger1", "1234", "newMember@mail.com");
        when(memberRepository.existsById(request.getUsername())).thenReturn(true);

        assertThrows(ResponseStatusException.class, () -> {
            memberService.addMember(request);
        });
    }
}










