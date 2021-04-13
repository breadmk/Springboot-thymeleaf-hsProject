package kr.co.hs.member.service;

import java.util.List;

import kr.co.hs.member.model.MemberModel;

public interface MemberService {

	public int MemberJoin(MemberModel memberModel);
	
	int loginOk(String userId,String pwd);
	
	public List<MemberModel> getAll();
}
