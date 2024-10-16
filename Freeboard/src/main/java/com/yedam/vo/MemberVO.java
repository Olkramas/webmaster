package com.yedam.vo;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//lombok 활용
//1.롬복을 이클립스에 설치 2.라이브러리?

@Getter
@Setter
@ToString

public class MemberVO{
	private String memberId;
	private String password;
	private String memberName;
	private String phone;
	private String responsibility;
	private Date creation_date;
	
	
	
}
