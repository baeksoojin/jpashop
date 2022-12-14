package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor //final 이용 생성자 만들기
public class MemberService {

    private final MemberRepository memberRepository; //생성자를 통해서 세팅 후에 변경할 일이 없음 -> final로 설정하기 : 컴파일 시점에 잡아주는 장점도 있음

    /**
     * 회원가입
     */
    @Transactional
    public Long join(Member member){
        validateDuplicatemember(member);
        memberRepository.save(member);
        return member.getId();
    }//등록

    private void validateDuplicatemember(Member member){
        //exception
        List<Member> findMember = memberRepository.findByName(member.getName());
        if (!findMember.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }

    }

    //회원 전체 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }//조회

    //회원 단건 조회
    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }//조회


}
