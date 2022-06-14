import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionListener;



public class GUI implements ActionListener {

        private static JLabel userlabel;
        private static JTextField userText;
        private static JLabel passwordLabel;
        private static JPasswordField passwordText;
        private static JButton button;
        private static JLabel success;



    public static void main(String[] args) {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);

        panel.setLayout(null);

        userlabel = new JLabel("User");
        userlabel.setBounds(10, 20, 80, 25);
        panel.add(userlabel);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        button = new JButton("Login");
        button.setBounds (10, 80, 80, 25);
        button.addActionListener(new GUI());
        panel.add(button);

        success = new JLabel ("");
        success.setBounds(10, 100, 300, 25);
        panel.add(success);


        frame.setVisible(true);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        String password = passwordText.getText();
        System.out.println(user + "," + password);

        if(user.equals("sarenaphonngavong") && password.equals ("thisismypassword123")) {
            success.setText("Login successful!");
        }

    }
}
