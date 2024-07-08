package support.enums;

public enum ApiPath {

    PATH_API_CAT("/v1/votes"),
    PATH_API_CAT_GETID("/v1/votes/"),
    PATH_CAT_STUB("/catsficticios/");
    private String path;
    ApiPath(String path){
        this.path=path;
    }
    public String getPath(){
        return path;
    }
}
