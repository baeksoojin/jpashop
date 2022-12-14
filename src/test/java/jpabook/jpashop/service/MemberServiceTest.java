package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional //rollback
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception{
        //given
        Member member = new Member();
        member.setName("baek");
        //when
        Long saveId = memberService.join(member);
        Member findMember = memberRepository.findOne(saveId);

        //then
        assertEquals(member, findMember); //같은 transaction에서 pk가 같으면 같은 영속성 context로 true가 나옴
    }

    @Test(expected = IllegalStateException.class)
    public void 중복회원예외() throws Exception{
        //given
        Member member1 = new Member();
        member1.setName("baek");
        Member member2 = new Member();
        member2.setName("baek");

        //when
        memberService.join(member1);
//        try{
//            memberService.join(member2);
//        }catch(IllegalStateException e){
//            return;
//        } //annotation으로 처리
        memberService.join(member2);

        //then
        fail("예외가 발생해야함.");
    }

}