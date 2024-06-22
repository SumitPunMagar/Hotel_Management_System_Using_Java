package hotel_management_system;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class addDriver extends JFrame implements ActionListener {

    JLabel titleLabel, nameLabel, ageLabel, genderLabel, carCompanyLabel, carModelLabel, availableLabel, locationLabel;

    JTextField nameField, ageField, carCompanyField, carModelField, locationField;
    JComboBox genderBox, availableBox;

    JButton addDriverBtn, cancelBtn;

    // constructor
    addDriver(){

        // logo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hotel/Images/Driver.jpg"));
        Image image = i1.getImage().getScaledInstance(370,300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image);

        JLabel logoLabel = new JLabel(i2);
        logoLabel.setBounds(400,110,370,300);
        add(logoLabel);


        // title

        titleLabel = new JLabel("Add Driver");
        titleLabel.setBounds(100,40,120,25);
        titleLabel.setForeground(Color.black);
        titleLabel.setFont(new Font("Raleway",Font.BOLD,17));
        add(titleLabel);

        // name

        nameLabel = new JLabel("Name");
        nameLabel.setBounds(40,100,150,25);
        nameLabel.setForeground(Color.black);
        nameLabel.setFont(new Font("Raleway",Font.BOLD,16));
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(220,95,150,35);
        nameField.setForeground(Color.black);
        nameField.setFont(new Font("Raleway",Font.PLAIN,16));
        add(nameField);


        // age

        ageLabel = new JLabel("Age");
        ageLabel.setBounds(40,150,150,25);
        ageLabel.setForeground(Color.black);
        ageLabel.setFont(new Font("Raleway",Font.BOLD,16));
        add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(220,145,150,35);
        ageField.setForeground(Color.black);
        ageField.setFont(new Font("Raleway",Font.PLAIN,16));
        add(ageField);


        // gender

        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(40,200,150,25);
        genderLabel.setForeground(Color.black);
        genderLabel.setFont(new Font("Raleway",Font.BOLD,16));
        add(genderLabel);

        String[] genderArr = {"Male", "Female"};

        genderBox = new JComboBox(genderArr);
        genderBox.setBounds(220,195,150,35);
        genderBox.setForeground(Color.black);
        genderBox.setFont(new Font("Raleway",Font.PLAIN,16));
        add(genderBox);


        // car company

        carCompanyLabel = new JLabel("Car Company");
        carCompanyLabel.setBounds(40,250,150,25);
        carCompanyLabel.setForeground(Color.black);
        carCompanyLabel.setFont(new Font("Raleway",Font.BOLD,16));
        add(carCompanyLabel);

        carCompanyField = new JTextField();
        carCompanyField.setBounds(220,245,150,35);
        carCompanyField.setForeground(Color.black);
        carCompanyField.setFont(new Font("Raleway",Font.PLAIN,16));
        add(carCompanyField);


        // car model

        carModelLabel = new JLabel("Car Model");
        carModelLabel.setBounds(40,300,150,25);
        carModelLabel.setForeground(Color.black);
        carModelLabel.setFont(new Font("Raleway",Font.BOLD,16));
        add(carModelLabel);


        carModelField = new JTextField();
        carModelField.setBounds(220,295,150,35);
        carModelField.setForeground(Color.black);
        carModelField.setFont(new Font("Raleway",Font.PLAIN,16));
        add(carModelField);


        // available status

        availableLabel = new JLabel("Available");
        availableLabel.setBounds(40,350,150,25);
        availableLabel.setForeground(Color.black);
        availableLabel.setFont(new Font("Raleway",Font.BOLD,16));
        add(availableLabel);

        String[] availableArr = {"Available", "Occupied"};

        availableBox = new JComboBox(availableArr);
        availableBox.setBounds(220,345,150,35);
        availableBox.setForeground(Color.black);
        availableBox.setFont(new Font("Raleway",Font.PLAIN,16));
        add(availableBox);


        // location

        locationLabel = new JLabel("Location");
        locationLabel.setBounds(40,400,150,25);
        locationLabel.setForeground(Color.black);
        locationLabel.setFont(new Font("Raleway",Font.BOLD,16));
        add(locationLabel);


        locationField = new JTextField();
        locationField.setBounds(220,395,150,35);
        locationField.setForeground(Color.black);
        locationField.setFont(new Font("Raleway",Font.PLAIN,16));
        add(locationField);

        // Add room button

        addDriverBtn = new JButton("Add Driver");
        addDriverBtn.setBounds(55,465,120,37);
        addDriverBtn.setForeground(Color.black);
        addDriverBtn.setBackground(Color.CYAN);
        addDriverBtn.setFocusable(false);
        addDriverBtn.setFont(new Font("Raleway",Font.PLAIN,17));
        // Set rounded border
        addDriverBtn.setBorder(new RoundedBorder(15)); // 15 is the radius of the border
        addDriverBtn.addActionListener(this);
        add(addDriverBtn);


        // cancel button

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(230,465,120,37);
        cancelBtn.setForeground(Color.black);
        cancelBtn.setBackground(Color.CYAN);
        cancelBtn.setFocusable(false);
        cancelBtn.setFont(new Font("Raleway",Font.PLAIN,17));
        // Set rounded border
        cancelBtn.setBorder(new RoundedBorder(15)); // 15 is the radius of the border
        cancelBtn.addActionListener(this);
        add(cancelBtn);




        setSize(800,580);
        setTitle("Add Room");
        getContentPane().setBackground(Color.white);
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

        if (e.getSource() == addDriverBtn){

            String name = nameField.getText();
            String age = ageField.getText();
            String carCompany = carCompanyField.getText();
            String carModel = carModelField.getText();
            String location = locationField.getText();

            String available = (String) availableBox.getSelectedItem();
            String gender = (String) genderBox.getSelectedItem();



            try {
                Conn c = new Conn();
                String query = "insert into driver values('"+name+"', '"+age+"', '"+gender+"', '"+carCompany+"', '"+carModel+"', '"+available+"', '"+location+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Driver added successfully");
                setVisible(false);
                new dashboard();

            } catch (SQLException e3){
                System.out.println(e3);
            }

        } else {
            setVisible(false);
        }



    }

    public static void main(String[] args) {
        new addDriver();
    }
}
