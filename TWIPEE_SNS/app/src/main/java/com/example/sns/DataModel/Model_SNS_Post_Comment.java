package com.example.sns.DataModel;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Model_SNS_Post_Comment{
    private String Body;
    private String PublisherID;
    private String CreatedDate;
    public Model_SNS_Post_Comment() {
        //super();
    }
    public Model_SNS_Post_Comment(String Body, String PublisherID, String CreatedDate){
        this.Body = Body;
        this.PublisherID = PublisherID;
        this.CreatedDate = CreatedDate;
    }

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

    @Exclude
    public Map<String, Object> SNS_Post_CommenttoMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("CreatedDate", CreatedDate);
        result.put("PublisherID", PublisherID);
        result.put("Body", Body);
        return result;
    }
}
