package kr.co.hs.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.hs.member.model.MemberModel;
import kr.co.hs.member.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberRepository memberRepository;

	@Override
	public int MemberJoin(MemberModel memberModel) {
		return memberRepository.MemberJoin(memberModel);
	}

	@Override
	public int loginOk(String userId, String pwd) {
		return memberRepository.loginOk(userId, pwd);
	}

	@Override
	public List<MemberModel> getAll() {
		return memberRepository.getAll();
	}

	@Override
	public MemberModel getOne(int no) {
		return memberRepository.getOne(no);
	}

	@Override
	public int update(MemberModel memberModel) {
		return memberRepository.update(memberModel);
	}

	@Override
	public int deleteOk(int no) {
		return memberRepository.deleteOk(no);
	}

	
}
