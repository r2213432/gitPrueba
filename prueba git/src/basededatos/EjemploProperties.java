package basededatos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class EjemploProperties {

	public static void main(String[] args) {
		Properties properties = new Properties();
		try {
			FileInputStream f = new FileInputStream("");
			properties.load(f);
			System.out.println(properties.get("user"));
			System.out.println(properties.get("bd"));
			System.out.println(properties.getOrDefault("noexiste", "pordefecto"));
			
			//cambiar valor
			properties.setProperty(null, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
