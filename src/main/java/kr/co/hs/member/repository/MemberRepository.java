package kr.co.hs.member.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.co.hs.member.model.MemberModel;

@Mapper
public interface MemberRepository {

	int MemberJoin(MemberModel memberModel);
	
	int loginOk(@Param("userId")String userId,@Param("pwd")String pwd);
}
