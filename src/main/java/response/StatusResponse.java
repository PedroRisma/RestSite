package response;

public enum StatusResponse {

    SUCCESS ("SUCCESS"),
    ERROR ("ERROR"),
    NOT_FOUND("NOT FOUND");

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;

    StatusResponse(String status) {

        this.status = status;
    }

}
