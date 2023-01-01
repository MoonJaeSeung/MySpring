package hello.hellospring.Controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        System.out.println(member.getName());

        memberService.join(member);

        return "redirect:/";
    }


}
