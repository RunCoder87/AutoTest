package com.djk.httpclient.cookies;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.activation.MimeType;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {
    String url;
    ResourceBundle bundle;
    BasicCookieStore cookieStore;
    HttpClientContext clientContext;

    @BeforeClass
    public void beforeTest() {
        // 读取配置文件
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
        // 创建cookieStore对象
        this.cookieStore = new BasicCookieStore();
        // 创建clientContext对象, 将cookieStore对象设置到clientContext中
        this.clientContext = new HttpClientContext();
        clientContext.setCookieStore(cookieStore);
    }
    /**
     * 获取cookies
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        String uri = bundle.getString("getCookies.uri");
        HttpGet get = new HttpGet(url + uri);

        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse resp = httpClient.execute(get, clientContext);
        System.out.println(EntityUtils.toString(resp.getEntity()));

        //获取cookie
        cookieStore.getCookies().forEach(cookie -> {
            System.out.println(cookie.getName() + ":" + cookie.getValue());
        });
    }


    @Test(dependsOnMethods = "test1")
    public void test2() throws IOException {
        String uri = bundle.getString("postWithParam.uri");
        HttpPost post = new HttpPost(url + uri);
        String name = "lucy";
        String age = "18";
        //设置请求头
        post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        //构造请求体
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "lucy");
        jsonObject.put("age","18");
        String jsonString = JSON.toJSONString(jsonObject);
        post.setEntity(new StringEntity(jsonString, "UTF-8"));

        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse resp = httpClient.execute(post, clientContext);

        System.out.println(EntityUtils.toString(resp.getEntity()));
        //获取响应体
        Assert.assertEquals(resp.getStatusLine().getStatusCode(), 200);
    }

}
