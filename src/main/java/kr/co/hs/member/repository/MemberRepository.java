package kr.co.hs.member.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.co.hs.member.model.MemberModel;

@Mapper
public interface MemberRepository {

	public int MemberJoin(MemberModel memberModel);
	
	public int loginOk(@Param("userId")String userId,@Param("pwd")String pwd);
	
	public List<MemberModel> getAll();
	
	public MemberModel getOne(@Param("no") int no);

	public int update(MemberModel memberModel);
	
	public int deleteOk(@Param("no") int no);
}
