package Reception;

import hotel_management_system.Conn;
import hotel_management_system.reception;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class updateRoomStatus extends JFrame implements ActionListener {

    JLabel titleLabel, customerIdLabel, roomLabel, availabilityLabel, cleaningStatusLabel;

    JTextField availabilityField, roomField, cleaningStatusField;

    Choice customerIdChoice;

    JButton checkBtn, updateBtn, backBtn;

    // constructor
    public updateRoomStatus(){

        // logo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hotel/Images/cleaning.jpg"));
        Image image = i1.getImage().getScaledInstance(300,185,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image);

        JLabel logoLabel = new JLabel(i2);
        logoLabel.setBounds(400,95,300,185);
        add(logoLabel);


        // title

        titleLabel = new JLabel("Update Room Status");
        titleLabel.setBounds(100,40,200,25);
        titleLabel.setForeground(Color.black);
        titleLabel.setFont(new Font("Raleway",Font.BOLD,17));
        add(titleLabel);

        // customer id

        customerIdLabel = new JLabel("Customer Id");
        customerIdLabel.setBounds(40,100,150,25);
        customerIdLabel.setForeground(Color.black);
        customerIdLabel.setFont(new Font("Raleway",Font.BOLD,16));
        add(customerIdLabel);

        customerIdChoice = new Choice();
        customerIdChoice.setBounds(220,95,150,35);
        customerIdChoice.setForeground(Color.black);
        customerIdChoice.setFont(new Font("Raleway",Font.PLAIN,16));
        add(customerIdChoice);

        try {
            Conn c = new Conn();
            String query = "select * from customer";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()){
                customerIdChoice.add(rs.getString("id_number"));
            }

        } catch (Exception e){
            System.out.println(e);
        }


        // room number

        roomLabel = new JLabel("Room Number");
        roomLabel.setBounds(40,150,150,25);
        roomLabel.setForeground(Color.black);
        roomLabel.setFont(new Font("Raleway",Font.BOLD,16));
        add(roomLabel);

        roomField = new JTextField();
        roomField.setBounds(220,145,150,35);
        roomField.setForeground(Color.black);
        roomField.setFont(new Font("Raleway",Font.PLAIN,16));
        add(roomField);


        // Availability

        availabilityLabel = new JLabel("Availability");
        availabilityLabel.setBounds(40,200,150,25);
        availabilityLabel.setForeground(Color.black);
        availabilityLabel.setFont(new Font("Raleway",Font.BOLD,16));
        add(availabilityLabel);


        availabilityField = new JTextField();
        availabilityField.setBounds(220,195,150,35);
        availabilityField.setForeground(Color.black);
        availabilityField.setFont(new Font("Raleway",Font.PLAIN,16));
        add(availabilityField);


        // cleaning status

        cleaningStatusLabel = new JLabel("Cleaning Status");
        cleaningStatusLabel.setBounds(40,250,150,25);
        cleaningStatusLabel.setForeground(Color.black);
        cleaningStatusLabel.setFont(new Font("Raleway",Font.BOLD,16));
        add(cleaningStatusLabel);

        cleaningStatusField = new JTextField();
        cleaningStatusField.setBounds(220,245,150,35);
        cleaningStatusField.setForeground(Color.black);
        cleaningStatusField.setFont(new Font("Raleway",Font.PLAIN,16));
        add(cleaningStatusField);





        // check button

        checkBtn = new JButton("Check");
        checkBtn.setBounds(55,320,120,37);
        checkBtn.setForeground(Color.black);
        checkBtn.setBackground(Color.CYAN);
        checkBtn.setFocusable(false);
        checkBtn.setFont(new Font("Raleway",Font.PLAIN,17));
        // Set rounded border
        checkBtn.setBorder(new RoundedBorder(15)); // 15 is the radius of the border
        checkBtn.addActionListener(this);
        add(checkBtn);


        // update button

        updateBtn = new JButton("Update");
        updateBtn.setBounds(230,320,120,37);
        updateBtn.setForeground(Color.black);
        updateBtn.setBackground(Color.CYAN);
        updateBtn.setFocusable(false);
        updateBtn.setFont(new Font("Raleway",Font.PLAIN,17));
        // Set rounded border
        updateBtn.setBorder(new RoundedBorder(15)); // 15 is the radius of the border
        updateBtn.addActionListener(this);
        add(updateBtn);


        // back button

        backBtn = new JButton("Back");
        backBtn.setBounds(405,320,120,37);
        backBtn.setForeground(Color.black);
        backBtn.setBackground(Color.CYAN);
        backBtn.setFocusable(false);
        backBtn.setFont(new Font("Raleway",Font.PLAIN,17));
        // Set rounded border
        backBtn.setBorder(new RoundedBorder(15)); // 15 is the radius of the border
        backBtn.addActionListener(this);
        add(backBtn);




        setSize(730,440);
        setTitle("Add Room Status");
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

        if (e.getSource() == checkBtn){

            String customerId = customerIdChoice.getSelectedItem();



            try {
                Conn c = new Conn();
                String query = "select * from customer where id_number = '"+customerId+"'";
                ResultSet rs = c.s.executeQuery(query);

                while (rs.next()){
                    roomField.setText(rs.getString("room"));

                }


                String room = roomField.getText();

                String query1 = "select * from room where room_number = '"+room+"'";
                ResultSet rs1 = c.s.executeQuery(query1);


                while (rs1.next()){
                    availabilityField.setText(rs1.getString("status"));
                    cleaningStatusField.setText(rs1.getString("cleaning_status"));

                }



            } catch (SQLException e3){
                System.out.println(e3);
            }

        } else if (e.getSource() == updateBtn){

            String roomNumber = roomField.getText();
            String availability = availabilityField.getText();
            String cleaningStatus = cleaningStatusField.getText();


            try {
                Conn c = new Conn();
                c.s.executeUpdate("update room set status = '"+availability+"', cleaning_status = '"+cleaningStatus+"' where room_number = '"+roomNumber+"'");

                JOptionPane.showMessageDialog(null, "Data updated successfully");

                setVisible(false);
                new reception();

            } catch (Exception e2){
                System.out.println(e2);
            }



        } else {
            setVisible(false);
            new reception();
        }



    }

    public static void main(String[] args) {
        new updateRoomStatus();
    }
}
