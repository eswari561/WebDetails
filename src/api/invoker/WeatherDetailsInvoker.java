package api.invoker;





import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class WeatherDetailsInvoker {

	private String API_key;
	public String baseURI;

	public  void SetKey(String key) {
		this.API_key = key;
	}

	public String getKey() {
		return  API_key;
	}
	public String getBaseURL() {

		return RestAssured.baseURI;
	}


	public void setBaseURL(String baseURI) {

		RestAssured.baseURI = baseURI;
	}
	public WeatherDetailsInvoker(String baseURI) {
		RestAssured.baseURI = baseURI;

	}



	/**
	 * @author Nagamalleswari.Sykam
	 * @param API_key
	 * @param additionalURL
	 * @return
	 */

	public Response getWeatherDetials(String additionalURL) {
		
		String request_url = "/weather";

		if((additionalURL!="")&&(additionalURL!=null)) 
		{ request_url = request_url
				+"?"+additionalURL; }

		System.out.println("the URL "+RestAssured.baseURI+request_url);
		Response response = given()

				.get(request_url);


		response.then().log().all();
		return response;
	}
}
