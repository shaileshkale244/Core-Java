package utils;
import static core.Vehicle.getCount;
import java.text.SimpleDateFormat;
import java.util.Date;
import core.Color;
import core.Vehicle;
import custom_exception.*;

public class VehicleValidationRule {
	public static String isChasisNoUnique(Vehicle[] arr, String chasisNo)throws DuplicateChasisNumberException  {
		for( int i=0;i<getCount();i++ ) {
			if(arr[i].getChasisNo().equals(chasisNo))
				throw new DuplicateChasisNumberException("Chasis Number Already exist. Enter New Chasis Number!!");
		}
		return chasisNo;
	}

	public static Color checkColor(String color) throws ColorNotSupportedException {
		for (Color c : Color.values()) {
			if (c.name().equals(color))
				return c;
		}
		throw new ColorNotSupportedException("Not Supported color!! ");
	}

	public static void checkPollutionLevel(Vehicle v1) throws PollutionLevelException {
		if (v1.getPollutionLevel() > 20) {
			throw new PollutionLevelException("Pollution level exceeded 20%");
		}
	}
	
	public static Date checkManufacturingDate(Date manfactureDate) throws ManufactureDateException {
		Date date = new Date();
		if (date.compareTo(manfactureDate) <= 0)
			throw new ManufactureDateException("Manufacture date must be smaller than Date: "+new SimpleDateFormat("yyyy-MM-dd").format(date));
		return manfactureDate;
	}
	
	public static Date checkInsuranceExpDate(Date manfactureDate, Date date) throws InsuranceExpiryDateException {
		if (manfactureDate.compareTo(date) > 0)
			throw new InsuranceExpiryDateException("Insurance Expiry Date must greater than Manufacturing Date!!");
		return date;
	}

}
