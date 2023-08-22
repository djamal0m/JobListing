package com.djamal0m.joblisting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "JobListing")
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private String profile;
    private String desc;
    private int exp;
    private String[] techs;
    private String levelOfEducation;
    private String location;
}

