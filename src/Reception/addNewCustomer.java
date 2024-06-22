package Reception;

import hotel_management_system.Conn;
import hotel_management_system.reception;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import java.sql.SQLException;

public class addNewCustomer extends JFrame implements ActionListener {


    JLabel titleLabel, nameLabel, idLabel, numberLabel, genderLabel, countryLabel, roomNumberLabel, checkInTimeLabel, dateLabel, depositLabel;

    JTextField nameField, numberField, countryField, depositField;
    JComboBox idBox, genderBox;
    Choice roomNameId;

    JButton addBtn, backBtn;

    // constructor
    public addNewCustomer(){

        // logo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hotel/Images/customer.jpg"));
        Image image = i1.getImage().getScaledInstance(400,380,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image);

        JLabel logoLabel = new JLabel(i2);
        logoLabel.setBounds(400,95,400,380);
        add(logoLabel);


        // title

        titleLabel = new JLabel("Add New Customer");
        titleLabel.setBounds(100,40,200,25);
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


        // ID

        idLabel = new JLabel("ID");
        idLabel.setBounds(40,150,150,25);
        idLabel.setForeground(Color.black);
        idLabel.setFont(new Font("Raleway",Font.BOLD,16));
        add(idLabel);

        String[] idArr = {"Citizenship Card", "Voter ID", "Passport", "Driving License"};

        idBox = new JComboBox(idArr);
        idBox.setBounds(220,145,150,35);
        idBox.setForeground(Color.black);
        idBox.setFont(new Font("Raleway",Font.PLAIN,16));
        add(idBox);


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


        // country

        countryLabel = new JLabel("Country");
        countryLabel.setBounds(40,250,150,25);
        countryLabel.setForeground(Color.black);
        countryLabel.setFont(new Font("Raleway",Font.BOLD,16));
        add(countryLabel);

        countryField = new JTextField();
        countryField.setBounds(220,245,150,35);
        countryField.setForeground(Color.black);
        countryField.setFont(new Font("Raleway",Font.PLAIN,16));
        add(countryField);


        // room number

        roomNumberLabel = new JLabel("Room Number");
        roomNumberLabel.setBounds(40,300,150,25);
        roomNumberLabel.setForeground(Color.black);
        roomNumberLabel.setFont(new Font("Raleway",Font.BOLD,16));
        add(roomNumberLabel);


        roomNameId = new Choice();
        roomNameId.setBounds(220,295,150,35);
        roomNameId.setForeground(Color.black);
        roomNameId.setFont(new Font("Raleway",Font.PLAIN,16));
        add(roomNameId);

        try {

            Conn c = new Conn();
            String query = "select * from room where status = 'Available'";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()){
                roomNameId.add(rs.getString("room_number"));
            }

        } catch (SQLException e){
            System.out.println(e);
        }


        // check in time

        checkInTimeLabel = new JLabel("Check in Time");
        checkInTimeLabel.setBounds(40,350,150,25);
        checkInTimeLabel.setForeground(Color.black);
        checkInTimeLabel.setFont(new Font("Raleway",Font.BOLD,16));
        add(checkInTimeLabel);

        Date date = new Date();

        dateLabel = new JLabel("" + date);
        dateLabel.setBounds(220,345,150,35);
        dateLabel.setForeground(Color.black);
        dateLabel.setFont(new Font("Raleway",Font.PLAIN,12));
        add(dateLabel);


        // number

        numberLabel = new JLabel("ID Number");
        numberLabel.setBounds(40,400,150,25);
        numberLabel.setForeground(Color.black);
        numberLabel.setFont(new Font("Raleway",Font.BOLD,16));
        add(numberLabel);


        numberField = new JTextField();
        numberField.setBounds(220,395,150,35);
        numberField.setForeground(Color.black);
        numberField.setFont(new Font("Raleway",Font.PLAIN,16));
        add(numberField);


        // deposit

        depositLabel = new JLabel("Deposit");
        depositLabel.setBounds(40,450,150,25);
        depositLabel.setForeground(Color.black);
        depositLabel.setFont(new Font("Raleway",Font.BOLD,16));
        add(depositLabel);


        depositField = new JTextField();
        depositField.setBounds(220,445,150,35);
        depositField.setForeground(Color.black);
        depositField.setFont(new Font("Raleway",Font.PLAIN,16));
        add(depositField);

        // Add button

        addBtn = new JButton("Add");
        addBtn.setBounds(55,515,120,37);
        addBtn.setForeground(Color.black);
        addBtn.setBackground(Color.CYAN);
        addBtn.setFocusable(false);
        addBtn.setFont(new Font("Raleway",Font.PLAIN,17));
        // Set rounded border
        addBtn.setBorder(new RoundedBorder(15)); // 15 is the radius of the border
        addBtn.addActionListener(this);
        add(addBtn);


        // back button

        backBtn = new JButton("Back");
        backBtn.setBounds(230,515,120,37);
        backBtn.setForeground(Color.black);
        backBtn.setBackground(Color.CYAN);
        backBtn.setFocusable(false);
        backBtn.setFont(new Font("Raleway",Font.PLAIN,17));
        // Set rounded border
        backBtn.setBorder(new RoundedBorder(15)); // 15 is the radius of the border
        backBtn.addActionListener(this);
        add(backBtn);




        setSize(830,620);
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

        if (e.getSource() == addBtn){

            String name = nameField.getText();
            String number = numberField.getText();
            String country = countryField.getText();
            String deposit = depositField.getText();


            String id = (String) idBox.getSelectedItem();
            String gender = (String) genderBox.getSelectedItem();

            String room = roomNameId.getSelectedItem();

            String date = dateLabel.getText();



            try {
                Conn c = new Conn();
                String query = "insert into customer values('"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+room+"', '"+date+"', '"+deposit+"')";
                String query1 = "update room set status = 'occupied' where room_number = '"+room+"'";
                c.s.executeUpdate(query);
                c.s.executeUpdate(query1);


                JOptionPane.showMessageDialog(null, "Customer added successfully");
                setVisible(false);
                new reception();

            } catch (SQLException e3){
                System.out.println(e3);
            }

        } else {
            setVisible(false);
            new reception();
        }
//


    }

    public static void main(String[] args) {
        new addNewCustomer();
    }
}
