package com.example.sns.DataModel;

import java.util.List;

public class DataModelBoard {

    private String location;
    private String board_type;
    private String date_created;
    private String photo_id;
    private String user_id;
    private List<DataModelLike> likes;
    private List<DataModelComment> comments;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBoard_type() {
        return board_type;
    }

    public void setBoard_type(String board_type) {
        this.board_type = board_type;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(String photo_id) {
        this.photo_id = photo_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public List<DataModelLike> getLikes() {
        return likes;
    }

    public void setLikes(List<DataModelLike> likes) {
        this.likes = likes;
    }

    public List<DataModelComment> getComments() {
        return comments;
    }

    public void setComments(List<DataModelComment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "DataModelBoard{" +
                "location='" + location + '\'' +
                ", board_type='" + board_type + '\'' +
                ", date_created='" + date_created + '\'' +
                ", photo_id='" + photo_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", likes=" + likes +
                ", comments=" + comments +
                '}';
    }
}
