package ua.artcode.endpoint;

import org.springframework.web.bind.annotation.*;
import ua.artcode.exception.NoUserFoundExceptions;
import ua.artcode.model.Message;
import ua.artcode.model.Product;
import ua.artcode.service.UserService;
import ua.artcode.service.UserServiceImpl;

/**
 * Created by serhii on 9/24/16.
 */
@RestController
public class UserEndpoint {

    private UserService userService;

    public UserEndpoint() {
        userService = new UserServiceImpl();
    }

    // localhost:8080/user/product/get?id=2
    @RequestMapping(value = {"/product/get"}, method = RequestMethod.GET)
    public Product getProduct(@RequestParam(value = "id") long id){
        return userService.getProductById(id);
    }

    @RequestMapping(value = {"/product/add"}, method = RequestMethod.POST)
    public Message addProduct(@RequestBody Product product, @RequestHeader("Access-Token") String accessKey){
        if(accessKey == null  || !userService.isSession(accessKey)){
            return new Message("permission is denied ", "need to login");
        }

        Product createdWithId = userService.addProduct(product);
        return new Message("Operation successful", "Created product id is " + createdWithId.getId());
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("login") String login,@RequestParam("pass") String pass){
        try {
            String accessKey = userService.login(login,pass);
            return accessKey;
        } catch (NoUserFoundExceptions noUserFoundExceptions) {
            noUserFoundExceptions.printStackTrace();
            return noUserFoundExceptions.getMessage();
        }
    }

}
