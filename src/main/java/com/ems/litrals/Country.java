package com.ems.litrals;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

enum Countries{
	AFGHANISTAN,
	BAHAMAS,
	CAMBODIA,
	DENMARK,
	ECUADOR,
	FIJI,
	GABON,
	HAITI,
	INDIA,
    JAPAN,
    KUWAIT,
    LUXEMBOURG,
    MYANMAR,
    NEPAL,
    PANAMA,
    QATAR,
    RUSSIA,
    SLOVAKIA,
    TURKEY,
    UNITEDKINGD,
    UNITEDSTATE,
    VIETNAM,
    YEMEN,
    ZIMBABWE
}

public class Country{ 
	public static Countries[] getCountries(){
		return Countries.values();
	}
}
