package com.djk.httpclient.cookies;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
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

    // 使用cookies访问其他接口
    @Test(dependsOnMethods = "test1")
    public void test2() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String uri = bundle.getString("getWithCookie.uri");
        HttpGet get = new HttpGet(url+uri);

        CloseableHttpResponse resp = httpClient.execute(get, clientContext);
        //获取响应状态码
        int statusCode = resp.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode, 200);

    }
}
