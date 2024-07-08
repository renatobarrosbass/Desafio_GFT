package service;

import io.restassured.response.Response;
import support.enums.ApiBaseUri;
import support.enums.ApiPath;
import support.enums.BodyRequest;
import support.enums.DefaultHeadersCatApi;
import support.utils.LogConfig;
import support.utils.LogWriter;
import support.utils.RestContext;

import javax.swing.text.StyleContext;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class catApiService {
    private static String requestBody;


    public static Response enviarPostCatApi() {
        LogWriter logWriter = new LogWriter();
        LogConfig.setLogLevel(LogConfig.LogLevel.DEBUG);
        RestContext.initRequest();
        RestContext.setPath(ApiBaseUri.API_CAT.getPath(), ApiPath.PATH_API_CAT.getPath());

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("x-api-key", DefaultHeadersCatApi.USER_API_KEY.getKey());
        RestContext.setHeader(headers);

        requestBody = BodyRequest.BODY_POST.getBody(); // Armazenando o corpo da requisição
        RestContext.setBody(requestBody);
        RestContext.postRequest();

        Response response = RestContext.getResponse();
        logWriter.debug("Received response with status code: " + response.getStatusCode());
        logWriter.debug("Response body: " + response.getBody().asString());
        return response;
    }

    public static void validarPostCatApiCriado(Response response) {
        response.then().statusCode(201);

        // Extraindo o imageId do corpo da requisição armazenado
        String imageId = requestBody.split("\"image_id\": \"")[1].split("\"")[0];

        // Validar os campos específicos no response JSON
        response.then().assertThat()
                .body("message", equalTo("SUCCESS"))
                .body("id", notNullValue())
                .body("image_id", equalTo(imageId))
                .body("sub_id", equalTo("my-user-1234"))
                .body("value", equalTo(1))
                .body("country_code", equalTo("BR"));
    }

    public static Response enviarPostCatApiSemBody() {
        LogWriter logWriter = new LogWriter();
        LogConfig.setLogLevel(LogConfig.LogLevel.DEBUG);
        RestContext.initRequest();
        RestContext.setPath(ApiBaseUri.API_CAT.getPath(), ApiPath.PATH_API_CAT.getPath());

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("x-api-key", DefaultHeadersCatApi.USER_API_KEY.getKey());
        RestContext.setHeader(headers);

        RestContext.postRequest();
        Response response = RestContext.getResponse();
        logWriter.debug("Received response with status code: " + response.getStatusCode());
        logWriter.debug("Response body: " + response.getBody().asString());

        return response;
    }

    public static void validarRetornoPostCatApiSemBody(Response response) {
        response.then().statusCode(400);
        response.then().assertThat()
                .body(equalTo("\"image_id\" is required"));
    }

    public static Response enviarPostCatApiComBodyVazio() {
        LogWriter logWriter = new LogWriter();
        LogConfig.setLogLevel(LogConfig.LogLevel.DEBUG);
        RestContext.initRequest();
        RestContext.setPath(ApiBaseUri.API_CAT.getPath(), ApiPath.PATH_API_CAT.getPath());

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("x-api-key", DefaultHeadersCatApi.USER_API_KEY.getKey());
        RestContext.setHeader(headers);

        requestBody = BodyRequest.BODY_POST.getBody(); // Armazenando o corpo da requisição
        RestContext.setBody("{}");
        RestContext.postRequest();

        Response response = RestContext.getResponse();
        logWriter.debug("Received response with status code: " + response.getStatusCode());
        logWriter.debug("Response body: " + response.getBody().asString());

        return response;
    }

    public static Response enviarGetGeralCatApi() {
        LogWriter logWriter = new LogWriter();
        LogConfig.setLogLevel(LogConfig.LogLevel.DEBUG);
        RestContext.initRequest();
        RestContext.setPath(ApiBaseUri.API_CAT.getPath(), ApiPath.PATH_API_CAT.getPath());

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("x-api-key", DefaultHeadersCatApi.USER_API_KEY.getKey());
        RestContext.setHeader(headers);
        
        RestContext.getRequest();

        Response response = RestContext.getResponse();
        logWriter.debug("Received response with status code: " + response.getStatusCode());
        logWriter.debug("Response body: " + response.getBody().asString());

        return response;
    }

    public static void validarRetornoGetAllCatApi(Response response) {
        response.then().statusCode(200);
        response.then().body(matchesJsonSchemaInClasspath("Payloads/SchemaValidationGetAllCatApi.json"));
    }

    public static Response enviarGetIdCatApi() {
        int id = enviarPostCatApiReturnId();
        LogWriter logWriter = new LogWriter();
        LogConfig.setLogLevel(LogConfig.LogLevel.DEBUG);
        RestContext.initRequest();
        RestContext.setPath(ApiBaseUri.API_CAT.getPath(), (ApiPath.PATH_API_CAT_GETID.getPath() + id));

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("x-api-key", DefaultHeadersCatApi.USER_API_KEY.getKey());
        RestContext.setHeader(headers);

        RestContext.getRequest();

        Response response = RestContext.getResponse();
        logWriter.debug("Received response with status code: " + response.getStatusCode());
        logWriter.debug("Response body: " + response.getBody().asString());

        return response;
    }

    private static int enviarPostCatApiReturnId() {

        LogWriter logWriter = new LogWriter();
        LogConfig.setLogLevel(LogConfig.LogLevel.DEBUG);
        RestContext.initRequest();
        RestContext.setPath(ApiBaseUri.API_CAT.getPath(), ApiPath.PATH_API_CAT.getPath());

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("x-api-key", DefaultHeadersCatApi.USER_API_KEY.getKey());
        RestContext.setHeader(headers);

        requestBody = BodyRequest.BODY_POST.getBody(); // Armazenando o corpo da requisição
        RestContext.setBody(requestBody);
        RestContext.postRequest();

        Response response = RestContext.getResponse();
        logWriter.debug("Received response with status code: " + response.getStatusCode());
        logWriter.debug("Response body: " + response.getBody().asString());
        int id = Integer.parseInt(response.jsonPath().getString("id"));
        return id;
    }

    public static void validarGetCatApiPorId(Response response) {
        response.then().statusCode(200);

        // Extraindo o imageId do corpo da requisição armazenado
        String imageId = requestBody.split("\"image_id\": \"")[1].split("\"")[0];
        int id = Integer.parseInt(response.jsonPath().getString("id"));

        // Validar os campos específicos no response JSON
        response.then().assertThat()
                .body("id", equalTo(id))
                .body("image_id", equalTo(imageId))
                .body("sub_id", equalTo("my-user-1234"))
                .body("value", equalTo(1))
                .body("country_code", equalTo("BR"));
    }
}