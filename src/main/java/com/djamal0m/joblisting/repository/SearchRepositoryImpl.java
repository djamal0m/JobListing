package com.djamal0m.joblisting.repository;

import com.djamal0m.joblisting.model.Post;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.AllArgsConstructor;
import org.bson.Document;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class SearchRepositoryImpl implements SearchRepository {

        private final MongoClient mongoClient;
        private final MongoConverter mongoConverter;

        @Override
        public List<Post> findByText(String text) {
                final List<Post> posts = new ArrayList<>();
                MongoDatabase database = mongoClient.getDatabase("joblisting-db");
                MongoCollection<Document> collection = database.getCollection("JobListing");
                AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                                new Document("text",
                                                new Document("query", text)
                                                                .append("path", Arrays.asList("techs", "desc",
                                                                                "profile")))),
                                new Document("$sort",
                                                new Document("exp", 1L)),
                                new Document("$limit", 5L)));
                result.forEach(doc -> posts.add(mongoConverter.read(Post.class, doc)));
                return posts;
        }
}
