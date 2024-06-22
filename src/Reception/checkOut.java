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
import java.util.Date;

public class checkOut extends JFrame implements ActionListener {

    JLabel titleLabel, customerIdLabel, roomLabel, checkOutTimeLabel, checkInTimeLabel;

    JTextField checkOutTimeField, roomField, checkInTimeField;

    Choice customerIdChoice;

    JButton checkBtn, checkOutBtn, backBtn;

    // constructor
    public checkOut(){

        // logo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hotel/Images/checkOut.png"));
        Image image = i1.getImage().getScaledInstance(370,200,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image);

        JLabel logoLabel = new JLabel(i2);
        logoLabel.setBounds(400,95,370,200);
        add(logoLabel);


        // title

        titleLabel = new JLabel("Check Out");
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


        // check in time

        checkInTimeLabel = new JLabel("Checkin Time");
        checkInTimeLabel.setBounds(40,200,150,25);
        checkInTimeLabel.setForeground(Color.black);
        checkInTimeLabel.setFont(new Font("Raleway",Font.BOLD,16));
        add(checkInTimeLabel);


        checkInTimeField = new JTextField();
        checkInTimeField.setBounds(220,195,150,35);
        checkInTimeField.setForeground(Color.black);
        checkInTimeField.setFont(new Font("Raleway",Font.PLAIN,16));
        add(checkInTimeField);


        // check out time

        checkOutTimeLabel = new JLabel("Checkin Time");
        checkOutTimeLabel.setBounds(40,250,150,25);
        checkOutTimeLabel.setForeground(Color.black);
        checkOutTimeLabel.setFont(new Font("Raleway",Font.BOLD,16));
        add(checkOutTimeLabel);

        Date date = new Date();

        checkOutTimeField = new JTextField("" + date);
        checkOutTimeField.setBounds(220,245,150,35);
        checkOutTimeField.setForeground(Color.black);
        checkOutTimeField.setFont(new Font("Raleway",Font.PLAIN,16));
        add(checkOutTimeField);





        // check button

        checkBtn = new JButton("Check");
        checkBtn.setBounds(55,335,120,37);
        checkBtn.setForeground(Color.black);
        checkBtn.setBackground(Color.CYAN);
        checkBtn.setFocusable(false);
        checkBtn.setFont(new Font("Raleway",Font.PLAIN,17));
        // Set rounded border
        checkBtn.setBorder(new RoundedBorder(15)); // 15 is the radius of the border
        checkBtn.addActionListener(this);
        add(checkBtn);


        // check out button

        checkOutBtn = new JButton("Checkout ");
        checkOutBtn.setBounds(230,335,120,37);
        checkOutBtn.setForeground(Color.black);
        checkOutBtn.setBackground(Color.CYAN);
        checkOutBtn.setFocusable(false);
        checkOutBtn.setFont(new Font("Raleway",Font.PLAIN,17));
        // Set rounded border
        checkOutBtn.setBorder(new RoundedBorder(15)); // 15 is the radius of the border
        checkOutBtn.addActionListener(this);
        add(checkOutBtn);


        // back button

        backBtn = new JButton("Back");
        backBtn.setBounds(405,335,120,37);
        backBtn.setForeground(Color.black);
        backBtn.setBackground(Color.CYAN);
        backBtn.setFocusable(false);
        backBtn.setFont(new Font("Raleway",Font.PLAIN,17));
        // Set rounded border
        backBtn.setBorder(new RoundedBorder(15)); // 15 is the radius of the border
        backBtn.addActionListener(this);
        add(backBtn);




        setSize(800,460);
        setTitle("Check Out");
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
                    checkInTimeField.setText(rs.getString("check_in_time"));

                }


            } catch (SQLException e3){
                System.out.println(e3);
            }

        } else if (e.getSource() == checkOutBtn){

            String customerId = customerIdChoice.getSelectedItem();
            String room = roomField.getText();

            try {
                Conn c = new Conn();
                c.s.executeUpdate("delete from customer where id_number = '"+customerId+"'");
                c.s.executeUpdate("update room set status = 'Available' where room_number = '"+room+"'");

                JOptionPane.showMessageDialog(null, "Checked Out Successfully");

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
        new checkOut();
    }
}
