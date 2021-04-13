package kr.co.hs.member.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberModel {
	
	private int no;
	
	private String userId;
	
	private String userName;
	
	private String pwd;
	
	private String email;
	
	private String zipcode;
	
	private String addr;
	
	private String addrDetail;
	
	
}
