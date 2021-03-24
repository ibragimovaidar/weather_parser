import java.util.List;

public class WeatherParserResult {
	private String location;
	private double latitude;
	private double longitude;
	private String unit;

	private List<WeatherRecord> weatherRecords;

	public WeatherParserResult(String location, double latitude, double longitude, String unit, List<WeatherRecord> weatherRecords) {
		this.location = location;
		this.latitude = latitude;
		this.longitude = longitude;
		this.unit = unit;
		this.weatherRecords = weatherRecords;
	}

	public String getLocation() {
		return location;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public String getUnit() {
		return unit;
	}

	public List<WeatherRecord> getWeatherRecords() {
		return weatherRecords;
	}
}
