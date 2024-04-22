package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {
    MemberRepository memberRepository=MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
        //test 한번하면 클리어
    }
    @Test
    void save(){
        Member member=new Member("hello",20);

        Member savemember=memberRepository.save(member);
        //저장한 맴버

        Member findMember=memberRepository.findById(savemember.getId());
        //찾은 맴버 비교
        assertThat(findMember).isEqualTo(savemember);
        assert findMember.equals(savemember);
        //java에서 기본적으로 제공하는 assert 근데 기능이 부족하다
    }
    @Test
    void findAll(){
        Member member1 = new Member("member1", 20);
        Member memeber2 = new Member("memeber2", 30);
        memberRepository.save(member1);
        memberRepository.save(memeber2);//저장

        List<Member> all = memberRepository.findAll();
        //저장된 모든 맴버 조회

        assertThat(all.size()).isEqualTo(2);
        //맴버가 2개냐
        assertThat(all).contains(member1,memeber2);
        //맴버가 a,b와 같냐

    }
}