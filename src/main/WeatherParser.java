import java.io.*;
import java.util.*;

public class WeatherParser {
	BufferedReader reader;
	BufferedWriter writer;

	public WeatherParser(File file) throws IOException {
		this.reader = new BufferedReader(new FileReader(file));
		this.writer = new BufferedWriter(new FileWriter(Configuration.outputFileName));
	}

	public WeatherParserResult getResult() throws IOException {

		Map<String,String> serviceData = parseServiceData();

		List<WeatherRecord> weatherRecords = parseWeatherRecords();

		return new WeatherParserResult(
				serviceData.get("location"),
				Double.parseDouble(serviceData.get("lat")),
				Double.parseDouble(serviceData.get("lon")),
				serviceData.get("unit"),
				weatherRecords);
	}

	public Map<String, String> parseServiceData() throws IOException {
		Map<String, String> serviceData = new HashMap<>();

		String[] data = reader.readLine().split(",");

		while (!data[0].equals("timestamp")){
			serviceData.put(data[0], data[1]);
			data = reader.readLine().split(",");
		}

		return serviceData;
	}

	private List<WeatherRecord> parseWeatherRecords() throws IOException {
		List<WeatherRecord> weatherRecords = new ArrayList<>();

		String[] data = reader.readLine().split(",");

		while(!data[0].equals("")){
			weatherRecords.add(
					new WeatherRecord(
							data[0],
							Double.parseDouble(data[1]),
							Double.parseDouble(data[2]),
							Double.parseDouble(data[3]),
							Double.parseDouble(data[4]))
			);

			try {
				data = reader.readLine().split(",");
			} catch (NullPointerException e){
				data = new String[]{""};
			}
		}

		return weatherRecords;
	}

	public void close() throws IOException {
		reader.close();
		writer.close();
	}
}
