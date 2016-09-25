package ua.artcode.run;

import ua.artcode.rest.ServerApiImpl;
import ua.artcode.view.LoginFrame;

/**
 * Created by serhii on 9/25/16.
 */
public class RunClient {

    public static void main(String[] args) {
        new LoginFrame(new ServerApiImpl());
    }
}
