package ua.artcode.service;

import ua.artcode.exception.NoUserFoundExceptions;
import ua.artcode.model.Product;

/**
 * Created by serhii on 9/24/16.
 */
public interface UserService {


    Product addProduct(Product product);
    Product getProductById(long id);
    String login(String login, String pass) throws NoUserFoundExceptions;


    boolean isSession(String accessKey);
}
