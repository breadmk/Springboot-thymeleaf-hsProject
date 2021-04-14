package kr.co.hs.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.codehaus.groovy.classgen.ReturnAdder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.tools.sjavac.Log;

import kr.co.hs.member.model.MemberModel;
import kr.co.hs.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;

	@GetMapping("/member/admin")
	public String memberAdmin(Model model) {
		List<MemberModel> list = memberService.getAll();
		model.addAttribute("memberList", list);
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
	public String loginPost(String userId, String pwd, HttpSession session) {
		int result = 0;
		result = memberService.loginOk(userId, pwd);
		if (result == 1) {
			session.setAttribute("userId", userId);
			return "redirect:/index";
		} else if (result == 0) {
			return "/view/member/login";
		}
		return "/view/member/login";
	}

	@GetMapping("/member/join")
	public String getJoin() {

		return "/view/member/join";
	}

	@ResponseBody
	@PostMapping("/member/join")
	public void postJoin(@RequestBody MemberModel memberModel, PrintWriter out) {
		memberService.MemberJoin(memberModel);
		out.print("success");
	}
	
	@GetMapping("/member/info/{no}")
	public String memberInfo(@PathVariable int no,Model model) {
		MemberModel vo = memberService.getOne(no);		
		model.addAttribute("vo",vo);
		return "/view/member/info";
	}
	
	@GetMapping("/member/update/{no}")
	public String getMemberUpdate(@PathVariable int no,Model model) {
		MemberModel vo = memberService.getOne(no);		
		model.addAttribute("vo",vo);
		return "/view/member/update";
	}
	
	@PostMapping("/member/update")
	public String postMemberUpdate(MemberModel memberModel) {
		int no = memberModel.getNo();
		memberService.update(memberModel);
		return "redirect:/member/info/"+no;
	}
	
	@GetMapping("/member/deleteOk/{no}")
	public String deleteOk(@PathVariable int no) {
		memberService.deleteOk(no);
		return "redirect:/member/admin";
	}
	
}


















