import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		WeatherParser weatherParser = new WeatherParser(new File("dataexport_20210320T064822.csv"));
		WeatherParserResult weatherData = weatherParser.getResult();
		weatherParser.close();

		WeatherRecord weatherRecordWithMaxTemperature = weatherData.getWeatherRecords().stream()
				.max(new WeatherRecord.ComparatorByTemperature()).get();

		WeatherRecord weatherRecordWithMinRelativeHumidity = weatherData.getWeatherRecords().stream()
				.min(new WeatherRecord.ComparatorByRelativeHumidity()).get();

		WeatherRecord weatherRecordWithMaxWindSpeed = weatherData.getWeatherRecords().stream()
				.max(new WeatherRecord.ComparatorByWindSpeed()).get();

		double temperatureSum = 0;
		double relativeHumiditySum = 0;
		double windSpeedSum = 0;
		double windDirectionSum = 0;

		for (WeatherRecord weatherRecord: weatherData.getWeatherRecords()){
			temperatureSum += weatherRecord.getTemperature();
			relativeHumiditySum += weatherRecord.getRelativeHumidity();
			windSpeedSum += weatherRecord.getWindSpeed();
			windDirectionSum += weatherRecord.getWindDirection();
		}

		double averageTemperature = temperatureSum/weatherData.getWeatherRecords().size();
		double averageRelativeHumidity = relativeHumiditySum/weatherData.getWeatherRecords().size();
		double averageWindSpeed =  windSpeedSum/weatherData.getWeatherRecords().size();
		double mostFrequentWindDirection = windDirectionSum/weatherData.getWeatherRecords().size();

		BufferedWriter writer = new BufferedWriter(new PrintWriter(Configuration.outputFileName));

		// TODO connect with google_sheets_processor

		writer.write("weatherRecordWithMaxTemperature," + weatherRecordWithMaxTemperature.dateTimeString() + "\n");
		writer.write("weatherRecordWithMinRelativeHumidity," +
				weatherRecordWithMinRelativeHumidity.dateTimeString() + "\n");
		writer.write("weatherRecordWithMaxWindSpeed," + weatherRecordWithMaxWindSpeed.dateTimeString() + "\n");
		writer.write("averageTemperature," + averageTemperature + "\n");
		writer.write("averageRelativeHumidity," + averageRelativeHumidity + "\n");
		writer.write("averageWindSpeed," +  averageWindSpeed + "\n");
		writer.write("mostFrequentWindDirection: " +
				WeatherUtils.windDirectionByWorldSides(mostFrequentWindDirection) + "\n");
		writer.flush();
		writer.close();
	}
}
