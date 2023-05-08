package com.myshop.shop.member.command.application;

import com.myshop.shop.member.MemberId;
import com.myshop.shop.member.command.domain.Member;
import com.myshop.shop.member.command.domain.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BlockMemberService {

    private MemberRepository memberRepository;

    public BlockMemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void block(String memberId) {
        Member member = memberRepository.findById(new MemberId(memberId))
                .orElseThrow(NoMemberException::new);
        member.block();
    }
}
