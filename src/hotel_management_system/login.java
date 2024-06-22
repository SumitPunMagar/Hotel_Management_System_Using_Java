package hotel_management_system;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class login extends JFrame implements ActionListener {

    JLabel usernameLabel, passwordLabel;
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginBtn, cancelBtn;

    // constructor
    login(){

        // logo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hotel/Images/login_Icon.png"));
        Image image = i1.getImage().getScaledInstance(200,100,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image);

        JLabel logoLabel = new JLabel(i2);
        logoLabel.setBounds(500,40,200,100);
        add(logoLabel);

        // username

        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(40,52,100,25);
        usernameLabel.setForeground(Color.black);
        usernameLabel.setFont(new Font("Raleway",Font.BOLD,17));
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(200,47,250,35);
        usernameField.setForeground(Color.black);
        usernameField.setFont(new Font("Raleway",Font.PLAIN,17));
        add(usernameField);


        // password

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(40,103,100,25);
        passwordLabel.setForeground(Color.black);
        passwordLabel.setFont(new Font("Raleway",Font.BOLD,17));
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(200,100,250,35);
        passwordField.setForeground(Color.black);
        passwordField.setFont(new Font("Raleway",Font.PLAIN,17));
        add(passwordField);


        // login button

        loginBtn = new JButton("Login");
        loginBtn.setBounds(100,180,105,37);
        loginBtn.setForeground(Color.black);
        loginBtn.setBackground(Color.CYAN);
        loginBtn.setFocusable(false);
        loginBtn.setFont(new Font("Raleway",Font.PLAIN,20));
        // Set rounded border
        loginBtn.setBorder(new RoundedBorder(15)); // 15 is the radius of the border
        loginBtn.addActionListener(this);
        add(loginBtn);




        // cancel button

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(270,180,105,37);
        cancelBtn.setForeground(Color.black);
        cancelBtn.setBackground(Color.RED);
        cancelBtn.setFocusable(false);
        cancelBtn.setFont(new Font("Raleway",Font.PLAIN,20));
        // Set rounded border
        cancelBtn.setBorder(new RoundedBorder(15)); // 15 is the radius of the border
        cancelBtn.addActionListener(this);
        add(cancelBtn);





        setSize(750,300);
        setTitle("Login Page");
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }




    // Custom border class for rounding the button
    class RoundedBorder implements Border {
        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.setColor(c.getBackground());
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginBtn){
            String username = usernameField.getText();
            String password = passwordField.getText();

            Conn c = new Conn();
            String query = "select * from hotellogin where username = '"+username+"' and password = '"+password+"'";

            try {

                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()){
                    setVisible(false);
                    new dashboard().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }

            } catch (SQLException e1){
                System.out.println(e1);
            }
        } else if (e.getSource() == cancelBtn) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new login();
    }
}
