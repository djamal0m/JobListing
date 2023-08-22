package com.djamal0m.joblisting.dto;

public class PostDTO {
    private String profile;
    private String desc;
    private int exp;
    private String[] techs;
    private String levelOfEducation;
    private String location;

    public String getProfile() {
        return profile;
    }

    public String getDesc() {
        return desc;
    }

    public int getExp() {
        return exp;
    }

    public String[] getTechs() {
        return techs;
    }

    public String getLevelOfEducation() {
        return levelOfEducation;
    }

    public String getLocation() {
        return location;
    }
}
