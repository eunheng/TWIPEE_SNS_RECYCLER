package com.example.sns.DataModel;

import java.util.List;

public class DataModelDistribution {
    private String location;
    private List<String> user_id;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<String> getUser_id() {
        return user_id;
    }

    public void setUser_id(List<String> user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "DataModelDistribution{" +
                "location='" + location + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
