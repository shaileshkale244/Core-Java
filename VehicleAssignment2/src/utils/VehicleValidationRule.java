package utils;

import core.Color;
import core.Vehicle;
import exception.ColorNotSupportedException;
import exception.PollutionLevelException;

public class VehicleValidationRule {
	
	public static Color checkColor(String color)throws ColorNotSupportedException {
		for(Color c:Color.values()) {
			if(c.name().equals(color))
				return c;
		}
		throw new ColorNotSupportedException("Not Supported color ") ;
//		if( color.equals(Color.valueOf(color)))
//					
//		return Color.valueOf(color);
		
		 
	}
	
	public static void checkPollutionLevel(Vehicle v1) throws PollutionLevelException {
		if(v1.getPollutionLevel()>20) {
			throw new PollutionLevelException("Pollution level exceeded 20%");
		}
	}
	

}
