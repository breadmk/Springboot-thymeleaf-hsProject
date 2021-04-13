package kr.co.hs.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.hs.member.model.MemberModel;
import kr.co.hs.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/member/admin")
	public String memberAdmin(Model model) {
		List<MemberModel> list = memberService.getAll();
		model.addAttribute("memberList",list);
		return "/view/member/admin";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/index";
	}
	
	@GetMapping("/member/login")
	public String login() {
		
		return "/view/member/login";
	}
	
	@PostMapping("/member/login")
	public String loginPost(String userId,String pwd,HttpSession session) {
		int result=0;
		result = memberService.loginOk(userId, pwd);
		if(result==1) {
			session.setAttribute("userId",userId);
			return "redirect:/index";
		}else if(result==0) {
			return "/view/member/login";
		}
		return "/view/member/login";
	}
	
	@GetMapping("/member/join")
	public String joinGet() {
		
		return "/view/member/join";
	}
	
	@ResponseBody
	@PostMapping("/member/join")
	public void joinPost(@RequestBody MemberModel memberModel,PrintWriter out) {
		System.out.println(memberModel);
		memberService.MemberJoin(memberModel);
		out.print("success");
	}
}


















