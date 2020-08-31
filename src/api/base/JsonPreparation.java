package api.base;

import java.util.HashMap;

public class JsonPreparation {

	
	/**
	 * Compose the get weather details expected details
	 * @author Nagamalleswari.Sykam
	 * @return
	 */
	public HashMap<String, Object>getWebDetails(){
		
		HashMap<String, Object> details = new HashMap<>();
		
		details.put("temp", 280.32);
		details.put("pressure", 1012);
		details.put("humidity", 81);
		details.put("temp_min", 280.32);
		details.put("temp_max", 281.15);
		
		 return details;
	}
}
