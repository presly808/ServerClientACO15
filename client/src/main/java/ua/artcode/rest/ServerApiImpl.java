package ua.artcode.rest;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import ua.artcode.client.utils.IOUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by serhii on 9/25/16.
 */
public class ServerApiImpl implements ServerApi {

    public static final String BASE_URL = "http://localhost:8080";

    @Override
    public String login(String login, String pass) {


        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(BASE_URL + "/login");

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("login", login));
        urlParameters.add(new BasicNameValuePair("pass", pass));

        try {
            post.setEntity(new UrlEncodedFormEntity(urlParameters));

            HttpResponse response = client.execute(post);
            System.out.println("Response Code : "
                    + response.getStatusLine().getStatusCode());


            InputStream content = response.getEntity().getContent();

            String result = IOUtils.readAll(content);

            return result;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public String getProduct(int id) {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(BASE_URL + "/product/get?id=" + id);

// add request header
        try {
            HttpResponse response = client.execute(request);
            System.out.println("Response Code : "
                    + response.getStatusLine().getStatusCode());

            String product = IOUtils.readAll(response.getEntity().getContent());
            return product;

        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

}
