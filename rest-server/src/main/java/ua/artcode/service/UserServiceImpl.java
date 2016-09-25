package ua.artcode.service;

import ua.artcode.exception.NoUserFoundExceptions;
import ua.artcode.model.Product;
import ua.artcode.model.User;
import ua.artcode.utils.SecurityUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by serhii on 9/24/16.
 */
public class UserServiceImpl implements UserService {

    public static final UUID UUID_INSTANCE = UUID.randomUUID();
    // todo think about multithreading

    private Map<Long, Product> productMap;
    private Map<String, User> userMap;
    private long count;
    private Map<String, User> sessionMap;

    public UserServiceImpl() {
        productMap = new HashMap<>();
        productMap.put(-1L, new Product(-1, "Samsung", 400));
        productMap.put(-2L, new Product(-1, "Samsung", 400));

        sessionMap = new HashMap<>();

        userMap = new HashMap<>();
        userMap.put("admin", new User(1,"admin", SecurityUtils.hash("admin")));
    }

    @Override
    public Product addProduct(Product product) {
        product.setId(count);
        productMap.put(count, product);
        count++;
        return product;
    }

    @Override
    public Product getProductById(long id) {
        return productMap.get(id);
    }

    @Override
    public String login(String login, String pass) throws NoUserFoundExceptions {

        User user = userMap.get(login);

        if(user == null || !user.getPass().equals(SecurityUtils.hash(pass))){
            throw new NoUserFoundExceptions("Wrong login or pass");
        }

        String accessKey = UUID_INSTANCE.toString();
        sessionMap.put(accessKey, user);

        return accessKey;
    }

    @Override
    public boolean isSession(String accessKey){
        return sessionMap.containsKey(accessKey);
    }


}
