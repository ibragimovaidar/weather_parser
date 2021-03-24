public class WeatherUtilsTests {

	public static void main(String[] args) {
		WeatherUtilsTests weatherUtilsTests = new WeatherUtilsTests();

		System.out.println("isAngleBetweenLimitsTest_angleRangeDoesNotContainZero_true " +
				weatherUtilsTests.isAngleBetweenLimitsTest_angleRangeContainsZero_true());

		System.out.println("isAngleBetweenLimitsTest_angleRangeDoesNotContainZero_true " +
				weatherUtilsTests.isAngleBetweenLimitsTest_angleRangeDoesNotContainZero_true());
	}


	public boolean isAngleBetweenLimitsTest_angleRangeDoesNotContainZero_true(){
		return WeatherUtils.isAngleBetweenLimits(45, 20, 230);
	}
	public boolean isAngleBetweenLimitsTest_angleRangeContainsZero_true(){
		return WeatherUtils.isAngleBetweenLimits(2, 345, 15);
	}
}
