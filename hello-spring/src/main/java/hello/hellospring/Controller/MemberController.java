package hello.hellospring.Controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

   private MemberService memberService;

//   @Autowired
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }
    @Autowired
    // autowired가 되어있으면 컨테이너에 있는 MemberService와 자동으로 연결 시켜준다.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
