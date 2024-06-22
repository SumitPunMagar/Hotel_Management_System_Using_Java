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

public class updateStatus extends JFrame implements ActionListener {

    JLabel titleLabel, customerIdLabel, roomLabel, nameLabel, checkInTimeLabel, amountPaidLabel, pendingAmountLabel;

    JTextField nameField, roomField, checkInTimeField, amountPaidField, pendingAmountField;

    Choice customerIdChoice;

    JButton checkBtn, updateBtn, backBtn;

    // constructor
    public updateStatus(){

        // logo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hotel/Images/checkOut.png"));
        Image image = i1.getImage().getScaledInstance(370,285,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image);

        JLabel logoLabel = new JLabel(i2);
        logoLabel.setBounds(400,95,370,285);
        add(logoLabel);


        // title

        titleLabel = new JLabel("Update Status");
        titleLabel.setBounds(100,40,150,25);
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


        // name

        nameLabel = new JLabel("Name");
        nameLabel.setBounds(40,200,150,25);
        nameLabel.setForeground(Color.black);
        nameLabel.setFont(new Font("Raleway",Font.BOLD,16));
        add(nameLabel);


        nameField = new JTextField();
        nameField.setBounds(220,195,150,35);
        nameField.setForeground(Color.black);
        nameField.setFont(new Font("Raleway",Font.PLAIN,16));
        add(nameField);


        // check in time

        checkInTimeLabel = new JLabel("Checkin Time");
        checkInTimeLabel.setBounds(40,250,150,25);
        checkInTimeLabel.setForeground(Color.black);
        checkInTimeLabel.setFont(new Font("Raleway",Font.BOLD,16));
        add(checkInTimeLabel);

        checkInTimeField = new JTextField();
        checkInTimeField.setBounds(220,245,150,35);
        checkInTimeField.setForeground(Color.black);
        checkInTimeField.setFont(new Font("Raleway",Font.PLAIN,16));
        add(checkInTimeField);


        // amount paid

        amountPaidLabel = new JLabel("Amount Paid");
        amountPaidLabel.setBounds(40,300,150,25);
        amountPaidLabel.setForeground(Color.black);
        amountPaidLabel.setFont(new Font("Raleway",Font.BOLD,16));
        add(amountPaidLabel);


        amountPaidField = new JTextField();
        amountPaidField.setBounds(220,295,150,35);
        amountPaidField.setForeground(Color.black);
        amountPaidField.setFont(new Font("Raleway",Font.PLAIN,16));
        add(amountPaidField);


        // pending amount

        pendingAmountLabel = new JLabel("Pending Amount");
        pendingAmountLabel.setBounds(40,350,150,25);
        pendingAmountLabel.setForeground(Color.black);
        pendingAmountLabel.setFont(new Font("Raleway",Font.BOLD,16));
        add(pendingAmountLabel);


        pendingAmountField = new JTextField();
        pendingAmountField.setBounds(220,345,150,35);
        pendingAmountField.setForeground(Color.black);
        pendingAmountField.setFont(new Font("Raleway",Font.PLAIN,16));
        add(pendingAmountField);



        // check button

        checkBtn = new JButton("Check");
        checkBtn.setBounds(55,465,120,37);
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
        updateBtn.setBounds(230,465,120,37);
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
        backBtn.setBounds(405,465,120,37);
        backBtn.setForeground(Color.black);
        backBtn.setBackground(Color.CYAN);
        backBtn.setFocusable(false);
        backBtn.setFont(new Font("Raleway",Font.PLAIN,17));
        // Set rounded border
        backBtn.setBorder(new RoundedBorder(15)); // 15 is the radius of the border
        backBtn.addActionListener(this);
        add(backBtn);




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

        if (e.getSource() == checkBtn){



            String customerId = customerIdChoice.getSelectedItem();



            try {
                Conn c = new Conn();
                String query = "select * from customer where id_number = '"+customerId+"'";
                ResultSet rs = c.s.executeQuery(query);

                while (rs.next()){
                    roomField.setText(rs.getString("room"));
                    nameField.setText(rs.getString("name"));
                    checkInTimeField.setText(rs.getString("check_in_time"));
                    amountPaidField.setText(rs.getString("deposit"));

                }


                int amountPaid = Integer.parseInt(amountPaidField.getText());

                // to calculate pending amount

                String room = roomField.getText();

                String query1 = "select * from room where room_number = '"+room+"'";
                ResultSet rs1 = c.s.executeQuery(query1);

                String SroomPrice = "";

                while (rs1.next()){
                    SroomPrice = rs1.getString("price");
                }

                int roomPrice = Integer.parseInt(SroomPrice);

                int pendingAmount = roomPrice - amountPaid;

                pendingAmountField.setText("" + pendingAmount);



            } catch (SQLException e3){
                System.out.println(e3);
            }

        } else if (e.getSource() == updateBtn){

            String customerId = customerIdChoice.getSelectedItem();
            String name = nameField.getText();
            String room = roomField.getText();
            String checkInTime = checkInTimeField.getText();
            String amountPaid = amountPaidField.getText();

            try {
                Conn c = new Conn();
                c.s.executeUpdate("update customer set room = '"+room+"', name = '"+name+"', check_in_time = '"+checkInTime+"', deposit = '"+amountPaid+"' where id_number = '"+customerId+"'");

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
        new updateStatus();
    }
}
