package ua.artcode.view;

import ua.artcode.rest.ServerApi;

import javax.swing.*;
import java.awt.*;

/**
 * Created by serhii on 9/25/16.
 */
public class LoginFrame extends JFrame {

    private JLabel loginLable;
    private JTextField loginText;
    private JLabel passLable;
    private JPasswordField passField;
    private JButton acceptButton;
    private JButton cancelButton;

    private ServerApi serverApi;

    private String accessToken = "";

    public LoginFrame(ServerApi api) throws HeadlessException {

        this.serverApi = api;

        setTitle("Authorization");
        setSize(450, 100);
        init();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void init() {
        GridLayout gridLayout = new GridLayout(3, 2);

        JPanel centralPanel = new JPanel(gridLayout);
        //setLayout(gridLayout);

        loginLable = new JLabel("Login: ");
        loginText = new JTextField();

        passLable = new JLabel("Password: ");
        passField = new JPasswordField();

        acceptButton = new JButton("Accept");
        acceptButton.addActionListener(e -> {
            accessToken = serverApi.login(loginText.getText(), new String(passField.getPassword()));
            JOptionPane.showMessageDialog(getParent(), "Access-Token:" + accessToken);
        });

        cancelButton = new JButton("Cancel");

        cancelButton.addActionListener(e -> {
            dispose();
            //new MainFrame().setVisible(true);
        });

        centralPanel.add(loginLable);
        centralPanel.add(loginText);
        centralPanel.add(passLable);
        centralPanel.add(passField);
        centralPanel.add(acceptButton);
        centralPanel.add(cancelButton);

        getContentPane().add(centralPanel, BorderLayout.CENTER);

        JTextField productIdField = new JTextField();
        Button getProductButton = new Button("Get Product");
        getProductButton.addActionListener((e) -> {
            String product = serverApi.getProduct(Integer.parseInt(productIdField.getText()));
            JOptionPane.showMessageDialog(getParent(), product);
        });


        JPanel southPanel = new JPanel(new GridLayout(1,2));
        southPanel.add(getProductButton);
        southPanel.add(productIdField);
        getContentPane().add(southPanel, BorderLayout.SOUTH);

    }
}
