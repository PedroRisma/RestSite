import com.google.gson.JsonElement;

public class StandarResponse {

    private StatusResponse statusResponse;
    private String message;
    private JsonElement data;

    public StatusResponse getStatusResponse() {
        return statusResponse;
    }

    public void setStatusResponse(StatusResponse statusResponse) {
        this.statusResponse = statusResponse;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JsonElement getData() {
        return data;
    }

    public void setData(JsonElement data) {
        this.data = data;
    }



    public StandarResponse()
    {

    }

    public StandarResponse(StatusResponse statusResponse)
    {
        this.statusResponse = statusResponse;
    }

    public StandarResponse(StatusResponse statusResponse, String message)
    {
        this.statusResponse = statusResponse;
        this.message = message;
    }

    public StandarResponse(StatusResponse statusResponse, JsonElement jsonElement)
    {
        this.statusResponse = statusResponse;
        this.data = jsonElement;
    }
}
