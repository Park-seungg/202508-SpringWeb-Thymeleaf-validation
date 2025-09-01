package com.back.member.member.controller;

import com.back.member.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class MemberController {
    private final MemberService memberService;
}
