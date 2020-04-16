package com.example.sns.DataModel;

public class Model_SNS_Post_Comment {
    private String Body;
    private String PublisherID;
    private String CreatedDate;

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    public String getPublisherID() {
        return PublisherID;
    }

    public void setPublisherID(String publisherID) {
        PublisherID = publisherID;
    }

    public String getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(String createdDate) {
        CreatedDate = createdDate;
    }
}
