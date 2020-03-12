package com.example.sns.DataModel;

import java.util.List;

public class DataModelComment {
    private String comment;

    public DataModelComment(String comment, String user_id, List<DataModelLike> likes, String date_created) {
        this.comment = comment;
        this.user_id = user_id;
        this.likes = likes;
        this.date_created = date_created;
    }

    private String user_id;
    private List<DataModelLike> likes;
    private String date_created;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    @Override
    public String toString() {
        return "DataModelComment{" +
                "comment='" + comment + '\'' +
                ", user_id='" + user_id + '\'' +
                ", likes=" + likes +
                ", date_created='" + date_created + '\'' +
                '}';
    }
}
