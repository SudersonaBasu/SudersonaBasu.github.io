package com.example.api.tests;

import com.example.api.base.BaseTest;
import com.example.api.pojos.Post;
import com.example.api.utils.RequestUtils;
import com.example.api.utils.ResponseUtils;
import io.restassured.response.Response;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ApiTest extends BaseTest {

    @Test
    public void testGetPosts() {
        Response response = RequestUtils.get("/posts");
        ResponseUtils.validateStatusCode(response, 200);
        ResponseUtils.validateResponseBodyNotNull(response);
    }

    @Test
    public void testPostCreation() {
        String requestBody = "{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }";
        Response response = RequestUtils.post("/posts", requestBody);
        ResponseUtils.validateStatusCode(response, 201);
        Post post = response.getBody().as(Post.class);
        assertNotNull(post);
        assertEquals(post.getTitle(), "foo");
    }

    @Test
    public void testPatchUpdate() {
        String requestBody = "{ \"title\": \"foo updated\" }";
        Response response = RequestUtils.patch("/posts/1", requestBody);
        ResponseUtils.validateStatusCode(response, 200);
        Post post = response.getBody().as(Post.class);
        assertNotNull(post);
        assertEquals(post.getTitle(), "foo updated");
    }

    @Test
    public void testDeletePost() {
        Response response = RequestUtils.delete("/posts/1");
        ResponseUtils.validateStatusCode(response, 200);
    }
}
