package com.ems.litrals;


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
