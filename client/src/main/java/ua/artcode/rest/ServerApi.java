package ua.artcode.rest;

/**
 * Created by serhii on 9/25/16.
 */
public interface ServerApi {


    String login(String text, String pass);


    String getProduct(int id);
}
