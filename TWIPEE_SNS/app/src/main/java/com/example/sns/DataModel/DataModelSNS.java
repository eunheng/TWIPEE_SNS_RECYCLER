package com.example.sns.DataModel;

import java.util.ArrayList;
import java.util.List;

public class DataModelSNS {
    private String type;
    private String data_created;
    private String user_id;

    //int형 말고 String으로
    private String people;
    private String content;
    private String image_path;
    private String photo_id;
    private String step;
    private String cost;
    private String period;
    private String traffic;
    private ArrayList<String> category;

    private ArrayList<DataModelLike> likes;
    private ArrayList<DataModelComment> comments;

    public DataModelSNS() {
        //super();
    }

    public DataModelSNS(String type, String data_created, String user_id, String people,
                        String content, String image_path, String photo_id, String step,
                        String cost, String period, String traffic, ArrayList<String> category,
                        ArrayList<DataModelLike> likes, ArrayList<DataModelComment> comments) {
        this.type = type;
        this.data_created = data_created;
        this.user_id = user_id;
        this.people = people;
        this.content = content;
        this.image_path = image_path;
        this.photo_id = photo_id;
        this.step = step;
        this.cost = cost;
        this.period = period;
        this.traffic = traffic;
        this.category = category;
        this.likes = likes;
        this.comments = comments;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getData_created() {
        return data_created;
    }

    public void setData_created(String data_created) {
        this.data_created = data_created;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(String photo_id) {
        this.photo_id = photo_id;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(ArrayList<String> category) {
        this.category = category;
    }

    public List<DataModelLike> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<DataModelLike> likes) {
        this.likes = likes;
    }

    public List<DataModelComment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<DataModelComment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "DataModelSNS{" +
                "type='" + type + '\'' +
                ", data_created='" + data_created + '\'' +
                ", user_id='" + user_id + '\'' +
                ", people=" + people +
                ", content='" + content + '\'' +
                ", image_path='" + image_path + '\'' +
                ", photo_id='" + photo_id + '\'' +
                ", step='" + step + '\'' +
                ", cost='" + cost + '\'' +
                ", period='" + period + '\'' +
                ", traffic='" + traffic + '\'' +
                ", category=" + category +
                ", likes=" + likes +
                ", comments=" + comments +
                '}';
    }
}
