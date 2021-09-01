import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.opencsv.CSVReader; 

public class ParseCSV {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line; String file_path;
		System.out.println("Default file path is \"CsvExample.csv\"\nEnter file path without quotes if you would like to parse another file\nOtherwise, press enter to parse default file");
		line = br.readLine();
		//sets which file to parse
		if("".equals(line))
			file_path="CsvExample.csv";
		else
			file_path=line;
		//parse
		CSVReader reader = null;
		try{
			
			reader = new CSVReader(new FileReader(file_path));
			String[] nextLine;
			nextLine = reader.readNext();
			while((nextLine = reader.readNext()) != null) {
				for(String token: nextLine) {
					System.out.println(token);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
