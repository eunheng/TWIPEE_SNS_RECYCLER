package com.example.sns.DataModel;

import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model_SNS_Post implements Serializable {
    private String PostType;
    private String CreatedData;
    private String PublisherID;
    private String Body;
    private String MapImage;
    private String Step;
    private String Period;
    private String MemberNumber;
    private String Cost;
    private String Traffic;
    private int LikeCount = 0;
    private int CommentCount = 0;

    HashMap<String, String> Photo = new HashMap<>();
    HashMap<String, String> Category = new HashMap<>();

    public Model_SNS_Post() {
        //super();
    }

    public Model_SNS_Post(String PostType, String CreatedData, String PublisherID, String Body, String MapImage, String Step, String Period, String MemberNumber,
                          String Cost, String Traffic, HashMap<String, String> Photo, HashMap<String, String> Category, int LikeCount, int CommentCount) {
        this.PostType = PostType;
        this.CreatedData = CreatedData;
        this.PublisherID = PublisherID;
        this.Body = Body;
        this.MapImage = MapImage;
        this.Step = Step;
        this.Period = Period;
        this.MemberNumber = MemberNumber;
        this.Cost = Cost;
        this.Traffic = Traffic;

        this.LikeCount = LikeCount;
        this.CommentCount = CommentCount;
        this.Photo = Photo;
        this.Category = Category;
    }

    public String getPostType() {
        return PostType;
    }

    public void setPostType(String postType) {
        PostType = postType;
    }

    public String getCreatedData() {
        return CreatedData;
    }

    public void setCreatedData(String createdData) {
        CreatedData = createdData;
    }

    public String getPublisherID() {
        return PublisherID;
    }

    public void setPublisherID(String publisherID) {
        PublisherID = publisherID;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    public String getMapImage() {
        return MapImage;
    }

    public void setMapImage(String mapImage) {
        MapImage = mapImage;
    }

    public String getStep() {
        return Step;
    }

    public void setStep(String step) {
        Step = step;
    }

    public String getPeriod() {
        return Period;
    }

    public void setPeriod(String period) {
        Period = period;
    }

    public String getMemberNumber() {
        return MemberNumber;
    }

    public void setMemberNumber(String memberNumber) {
        MemberNumber = memberNumber;
    }

    public String getCost() {
        return Cost;
    }

    public void setCost(String cost) {
        Cost = cost;
    }

    public String getTraffic() {
        return Traffic;
    }

    public void setTraffic(String traffic) {
        Traffic = traffic;
    }

    public int getLikeCount() {
        return LikeCount;
    }

    public void setLikeCount(int likeCount) {
        LikeCount = likeCount;
    }

    public int getCommentCount() {
        return CommentCount;
    }

    public void setCommentCount(int commentCount) {
        CommentCount = commentCount;
    }

    public HashMap<String, String> getPhoto() {
        return Photo;
    }

    public void setPhoto(HashMap<String, String> photo) {
        Photo = photo;
    }

    public HashMap<String, String> getCategory() {
        return Category;
    }

    public void setCategory(HashMap<String, String> category) {
        Category = category;
    }

    @Exclude
    public Map<String, Object> SNStoMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("PostType", PostType);
        result.put("CreatedData", CreatedData);
        result.put("PublisherID", PublisherID);
        result.put("Body", Body);
        result.put("MapImage", MapImage);
        result.put("Step", Step);
        result.put("Period", Period);
        result.put("MemberNumber", MemberNumber);
        result.put("Cost", Cost);
        result.put("Traffic", Traffic);
        result.put("LikeCount", LikeCount);
        result.put("CommentCount", CommentCount);
        result.put("Photo", Photo);
        result.put("Category", Category);
        return result;
    }
}
