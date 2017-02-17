package com.foray.bankjee.utils;

import com.foray.bankjee.db.User;

public enum UserType
{
	CUSTOMER, ADVISOR, ADMINISTRATOR;
	
	public static UserType Convert(User user)
	{
		UserType type = null;
		switch(user.getType())
		{
		case 0:
			type = CUSTOMER;
			break;
		case 1:
			type = ADVISOR;
			break;
		case 2:
			type = ADMINISTRATOR;
			break;
		}
		
		return type;
	}
}
