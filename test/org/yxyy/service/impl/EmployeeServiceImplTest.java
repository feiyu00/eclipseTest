package org.yxyy.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeServiceImplTest {

	@Test
	public void testLogin() {
		EmployeeServiceImpl eImpl = new EmployeeServiceImpl();
		boolean login = eImpl.login("admin", "1234561");
		System.out.println(login);
	}

}
