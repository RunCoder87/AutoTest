package com.djk.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyHttpClient {
    @Test
    public void test1() throws IOException {
        HttpGet req = new HttpGet("http://www.baidu.com");
        String ret;
        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse resp = httpClient.execute(req);
        System.out.println(EntityUtils.toString(resp.getEntity()));
    }

    @Test
    public void testGetCookies() throws IOException {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet req = new HttpGet("http://localhost:8888/getCookies");
        HttpResponse resp = httpClient.execute(req);
        System.out.println(resp.getHeaders("Set-Cookie")[0]);
        System.out.println(EntityUtils.toString(resp.getEntity()));
    }
}
