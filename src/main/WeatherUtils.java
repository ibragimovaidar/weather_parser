public class WeatherUtils {
	public static String windDirectionByWorldSides(double windDirectionByDegrees){

		if (isAngleBetweenLimits(windDirectionByDegrees, 345,15)){
			return "North";
		}
		if (isAngleBetweenLimits(windDirectionByDegrees, 15,75)){
			return "North-East";
		}
		if (isAngleBetweenLimits(windDirectionByDegrees, 75, 105)){
			return "East";
		}
		if (isAngleBetweenLimits(windDirectionByDegrees,105,165)){
			return "South-East";
		}
		if (isAngleBetweenLimits(windDirectionByDegrees, 165,195)){
			return "South";
		}
		if (isAngleBetweenLimits(windDirectionByDegrees, 195,255)){
			return "South-West";
		}
		if (isAngleBetweenLimits(windDirectionByDegrees,255,285)){
			return "West";
		}
		if (isAngleBetweenLimits(windDirectionByDegrees,285,345)){
			return "North-West";
		}

		return null;
	}

	public static boolean isAngleBetweenLimits(double angle, double lowerLimit, double higherLimit) {
		if (lowerLimit > higherLimit && angle < lowerLimit){
			return angle<=higherLimit;
		}
		if (lowerLimit > higherLimit && angle > lowerLimit){
			return true;
		}
		if (lowerLimit < higherLimit){
			return angle>=lowerLimit && angle<=higherLimit;
		}
		if (lowerLimit == higherLimit){
			return angle == lowerLimit;
		}
		return false;
	}
}
