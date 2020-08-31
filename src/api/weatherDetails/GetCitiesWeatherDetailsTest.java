package api.weatherDetails;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import api.base.JsonPreparation;
import api.codes.StatusCodes;
import api.invokerServer.WeatherDetailsInvokerServer;
import io.restassured.response.Response;

public class GetCitiesWeatherDetailsTest  {
	
	public  WeatherDetailsInvokerServer  weatherDetailsInvokerServer;
	public JsonPreparation jp;
	public  String API_Key;
	@BeforeClass
	@Parameters({"baseURI","API_Key"})
	public void beforeClass(String baseURI,String API_Key) {
		weatherDetailsInvokerServer  = new WeatherDetailsInvokerServer(baseURI);
		jp = new JsonPreparation();

		this.API_Key = API_Key;
	}
	@DataProvider (name ="weather")
	public final Object [][]getWeatherDetailsPrams(){
		return new Object [] [] {
			{"Get weather details of the Londaon","city","London,uk","439d4b804bc8187953eb36d2a8c26a02",StatusCodes.SUCCESS_GET_PUT_DELETE},

			{"Get weather details of the Londaon","city.Error","","439d4b804bc8187953eb36d2a8c26a02",StatusCodes.RESOURCE_NOT_EXIST},


		};

	}


	@Test(dataProvider = "weather")
	public void getWeatherDetails(String Testcase,
			String typeOfPath,
			String params,String appid,int statusCode) {
		//additonalUrl
		String additonalUrl =weatherDetailsInvokerServer.additonalUrl(typeOfPath,params,appid);

		HashMap<String, Object> expdetail = jp.getWebDetails();

		weatherDetailsInvokerServer.getWeatherDetails(additonalUrl,expdetail,statusCode);
	
	}
}

