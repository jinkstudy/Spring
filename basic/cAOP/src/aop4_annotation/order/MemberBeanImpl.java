package aop4_annotation.order;

import org.springframework.stereotype.Component;

@Component("targetBean")
public class MemberBeanImpl implements MemberBean {

	@Override
	public void register() {
		System.out.println("register 함수 호출");
		
	}

	@Override
	public boolean update(String name) {
		System.out.println(name + "님 update 호출");
		return false;
	}


	}


