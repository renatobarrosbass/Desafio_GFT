package support.enums;

import java.util.Random;

public enum BodyRequest {
    BODY_POST(generateBodyPostCatApi()),
    BODY_WIREGET("{\n" +
            " \"id\": 1234567,\n" +
            " \"user_id\": \"user123\",\n" +
            " \"image_id\": \"img123\",\n" +
            " \"sub_id\": \"sub123\",\n" +
            " \"created_at\": \"2023-01-01T00:00:00Z\",\n" +
            " \"value\": 1,\n" +
            " \"country_code\": \"BR\",\n" +
            " \"image\": {\n" +
            " \"url\": \"http://example.com/image.jpg\",\n" +
            " \"width\": 800,\n" +
            " \"height\": 600\n" +
            " }\n" +
            "}");

    private final String body;

    BodyRequest(String body) {
        this.body = body;
    }

    public String getBody() {
        return this.body;
    }

    private static String generateBodyPostCatApi() {
        Random random = new Random();
        int randomNumber = random.nextInt(10000);
        String imageId = String.format("img%04d", randomNumber);

        return "{\n" +
                "\"image_id\": \"" + imageId + "\",\n" +
                "    \"sub_id\": \"my-user-1234\",\n" +
                "    \"value\": 1\n" +
                "}";
    }
}