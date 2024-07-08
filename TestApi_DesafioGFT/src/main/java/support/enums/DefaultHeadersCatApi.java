package support.enums;

public enum DefaultHeadersCatApi {
    USER_API_KEY("live_4KymEb4IPbxX6a6IhzdRwbc5SciTRhnEG9HbHfOHv41vQPGhL4PTuFCvTuJocdU2");
    private String key;

    DefaultHeadersCatApi(String key){
        this.key=key;
    }
    public String getKey() {
        return key;
    }
}
