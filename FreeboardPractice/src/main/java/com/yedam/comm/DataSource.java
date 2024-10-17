package com.yedam.comm;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource {
	
	//mybatis에서 db와 상호작용하기 위한 SqlSessionFactory인스턴스를 생성하는 역할을 함
//	public static SqlSessionFactory getInstance() {
//		//mybatis의 설정파일의 경로 지정
//		String resource = "config/mybatis-config.xml";
//		//아래 sqlsessionFactoryBulider에 들어가는 해당 변수가 초기값이 없어서 그럼
//		InputStream inputStream = null;
//		try {
//			//getResourceAsStream(resource);메소드를 사용해서 mybatis설정 파일을 읽음 그리고 inputStream변수에 저장
//			inputStream = Resources.getResourceAsStream(resource);
//			//파일을 찾지 못하면 IOException이 발생함
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		//읽은 mybatis설정을 바탕으로 sqlSessionFactory타입의 객체를 생성함
//		//이 객체는 my batis의 세션을 생성하는데 사용됨.
//		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//		
//		return sqlSessionFactory;
//	}
	
	public static SqlSessionFactory getInstance() {
		String resource = "config/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}
}
