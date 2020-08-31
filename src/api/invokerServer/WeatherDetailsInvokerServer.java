package api.invokerServer;

import java.util.HashMap;

import org.testng.Assert;



import api.codes.StatusCodes;
import api.invoker.WeatherDetailsInvoker;
import io.restassured.response.Response;


public class WeatherDetailsInvokerServer {

	private WeatherDetailsInvoker weatherDetailsInvoker;

	public WeatherDetailsInvokerServer(String baseURI) {
		weatherDetailsInvoker = new WeatherDetailsInvoker(baseURI);
	}

	/**
	 * @author Nagamalleswari.Sykam
	 * @param additonalURL
	 * @param statusCode
	 * @return
	 */
	public void  getWeatherDetails( String additonalURL,HashMap<String, Object> expdetail,int statusCode) {

		Response response = weatherDetailsInvoker.getWeatherDetials(additonalURL);
		if(statusCode==StatusCodes.SUCCESS_GET_PUT_DELETE) {

			HashMap<String, Object>actDetails = response.then().extract().path("main");
			
			for(int i =0;i<expdetail.size();i++) {
				for(int j=0;j<actDetails.size();j++) {
					Assert.assertEquals(expdetail.get("temp").toString(), actDetails.get("temp").toString());
					Assert.assertEquals(expdetail.get("pressure").toString(), actDetails.get("pressure").toString());
					Assert.assertEquals(expdetail.get("humidity").toString(), actDetails.get("humidity").toString());
					}
			}
		}else {
			//checkResponseStausCode(response,statusCode);
			
			String statuscode = response.then().extract().path("error");
			System.out.println(statuscode);
		}
	}

	/**
	 * @author Nagamalleswari.Sykam
	 * @param response
	 * @param statusCode
	 */
	/*
	 * public void checkResponseStausCode(Response response,int statusCode) {
	 * 
	 * response.then().statusCode(statusCode); }
	 */
	
	public String additonalUrl(String typeOfPath,String params, String appid) {

		String additonalUrl = null;
		String url = null;
		if((typeOfPath.contains("city")&&(params!=""||params!=null))) {
			additonalUrl = "q=" + params;
		}else if((typeOfPath.contains("box")&&(params!=""||params!=null))) {
			additonalUrl = "bbox=" + params;
		}else if((typeOfPath.contains("id")&&(params!=""||params!=null))) {
			additonalUrl = "id=" + params;
		}
		if ((appid != "" || appid != null)&&params!= "") {
			additonalUrl = additonalUrl + "&" + "appid=" + appid;
		}else {
			additonalUrl ="appid=" + appid;
		}

		return additonalUrl;
	}

	public String AdditinationalURL( String appid) {
		String additonalUrl = null;
		String url = null;
		if ((appid != "" || appid != null)) {
			additonalUrl = url + "&" + "appid=" + appid;
		}else {
			additonalUrl ="appid=" + appid;
		}

		return additonalUrl ;
	}
}
