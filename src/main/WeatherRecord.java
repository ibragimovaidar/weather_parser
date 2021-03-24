import java.util.Comparator;

public class WeatherRecord{

	String timestamp;
	Double temperature;
	Double relativeHumidity;
	Double windSpeed;
	Double windDirection;

	public WeatherRecord(String timestamp, Double temperature, Double relativeHumidity, Double windSpeed, Double windDirection) {
		this.timestamp = timestamp;
		this.temperature = temperature;
		this.relativeHumidity = relativeHumidity;
		this.windSpeed = windSpeed;
		this.windDirection = windDirection;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public Double getTemperature() {
		return temperature;
	}

	public Double getRelativeHumidity() {
		return relativeHumidity;
	}

	public Double getWindSpeed() {
		return windSpeed;
	}

	public Double getWindDirection() {
		return windDirection;
	}

	/** returns datetime in the following form: "yyyy-mm-dd hh:mm" */
	public String dateTimeString() {
		return timestamp.substring(0,4) + "-" +
				timestamp.substring(4,6) + "-" +
				timestamp.substring(6,8) + " " +
				timestamp.substring(9,11) + ":" +
				timestamp.substring(11);
	}

	@Override
	public String toString() {
		return "WeatherRecord{" +
				"timestamp='" + timestamp + '\'' +
				'}';
	}

	static class ComparatorByTemperature implements Comparator<WeatherRecord>{

		@Override
		public int compare(WeatherRecord o1, WeatherRecord o2) {
			return o1.getTemperature().compareTo(o2.getTemperature());
		}
	}

	static class ComparatorByWindSpeed implements Comparator<WeatherRecord>{

		@Override
		public int compare(WeatherRecord o1, WeatherRecord o2) {
			return o1.getWindSpeed().compareTo(o2.getWindSpeed());
		}
	}

	static class ComparatorByRelativeHumidity implements Comparator<WeatherRecord>{

		@Override
		public int compare(WeatherRecord o1, WeatherRecord o2) {
			return o1.getRelativeHumidity().compareTo(o2.getRelativeHumidity());
		}
	}
}