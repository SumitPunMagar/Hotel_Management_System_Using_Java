package hotel_management_system;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class addRoom extends JFrame implements ActionListener {

    JLabel titleLabel, roomNumLabel, availableLabel, cleaningStatusLabel, priceLabel, bedTypeLabel;

    JTextField roomNumberField, priceField;
    JComboBox availableBox, cleaningStatusBox, bedTypeBox;

    JButton addRoomBtn, cancelBtn;

    // constructor
    addRoom(){

        // logo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hotel/Images/room.jpg"));
        Image image = i1.getImage().getScaledInstance(370,300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image);

        JLabel logoLabel = new JLabel(i2);
        logoLabel.setBounds(400,60,370,300);
        add(logoLabel);


        // title

        titleLabel = new JLabel("Add Room");
        titleLabel.setBounds(100,40,100,25);
        titleLabel.setForeground(Color.black);
        titleLabel.setFont(new Font("Raleway",Font.BOLD,17));
        add(titleLabel);

        // room number

        roomNumLabel = new JLabel("Room Number");
        roomNumLabel.setBounds(40,100,150,25);
        roomNumLabel.setForeground(Color.black);
        roomNumLabel.setFont(new Font("Raleway",Font.BOLD,16));
        add(roomNumLabel);

        roomNumberField = new JTextField();
        roomNumberField.setBounds(220,95,150,35);
        roomNumberField.setForeground(Color.black);
        roomNumberField.setFont(new Font("Raleway",Font.PLAIN,16));
        add(roomNumberField);


        // Available

        availableLabel = new JLabel("Available");
        availableLabel.setBounds(40,150,150,25);
        availableLabel.setForeground(Color.black);
        availableLabel.setFont(new Font("Raleway",Font.BOLD,16));
        add(availableLabel);

        String[] availableArr = {"Available", "Occupied"};

        availableBox = new JComboBox(availableArr);
        availableBox.setBounds(220,145,150,35);
        availableBox.setForeground(Color.black);
        availableBox.setFont(new Font("Raleway",Font.PLAIN,16));
        add(availableBox);


        // cleaning status

        cleaningStatusLabel = new JLabel("Cleaning Status");
        cleaningStatusLabel.setBounds(40,200,150,25);
        cleaningStatusLabel.setForeground(Color.black);
        cleaningStatusLabel.setFont(new Font("Raleway",Font.BOLD,16));
        add(cleaningStatusLabel);

        String[] cleaningStatusArr = {"Cleaned", "Dirty"};

        cleaningStatusBox = new JComboBox(cleaningStatusArr);
        cleaningStatusBox.setBounds(220,195,150,35);
        cleaningStatusBox.setForeground(Color.black);
        cleaningStatusBox.setFont(new Font("Raleway",Font.PLAIN,16));
        add(cleaningStatusBox);


        // price

        priceLabel = new JLabel("Price");
        priceLabel.setBounds(40,250,150,25);
        priceLabel.setForeground(Color.black);
        priceLabel.setFont(new Font("Raleway",Font.BOLD,16));
        add(priceLabel);

        priceField = new JTextField();
        priceField.setBounds(220,245,150,35);
        priceField.setForeground(Color.black);
        priceField.setFont(new Font("Raleway",Font.PLAIN,16));
        add(priceField);


        // bed type

        bedTypeLabel = new JLabel("Bed Type");
        bedTypeLabel.setBounds(40,300,150,25);
        bedTypeLabel.setForeground(Color.black);
        bedTypeLabel.setFont(new Font("Raleway",Font.BOLD,16));
        add(bedTypeLabel);

        String[] bedTypeArr = {"Single Bed", "Double Bed"};

        bedTypeBox = new JComboBox(bedTypeArr);
        bedTypeBox.setBounds(220,295,150,35);
        bedTypeBox.setForeground(Color.black);
        bedTypeBox.setFont(new Font("Raleway",Font.PLAIN,16));
        add(bedTypeBox);


        // Add room button

        addRoomBtn = new JButton("Add Room");
        addRoomBtn.setBounds(55,370,120,37);
        addRoomBtn.setForeground(Color.black);
        addRoomBtn.setBackground(Color.CYAN);
        addRoomBtn.setFocusable(false);
        addRoomBtn.setFont(new Font("Raleway",Font.PLAIN,17));
        // Set rounded border
        addRoomBtn.setBorder(new RoundedBorder(15)); // 15 is the radius of the border
        addRoomBtn.addActionListener(this);
        add(addRoomBtn);


        // cancel button

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(230,370,120,37);
        cancelBtn.setForeground(Color.black);
        cancelBtn.setBackground(Color.CYAN);
        cancelBtn.setFocusable(false);
        cancelBtn.setFont(new Font("Raleway",Font.PLAIN,17));
        // Set rounded border
        cancelBtn.setBorder(new RoundedBorder(15)); // 15 is the radius of the border
        cancelBtn.addActionListener(this);
        add(cancelBtn);




        setSize(800,500);
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

        if (e.getSource() == addRoomBtn){

            String roomNumber = roomNumberField.getText();
            String price = priceField.getText();

            String available = (String) availableBox.getSelectedItem();
            String cleaningStatus = (String) cleaningStatusBox.getSelectedItem();
            String bedType = (String) bedTypeBox.getSelectedItem();


            try {
                Conn c = new Conn();
                String query = "insert into room values('"+roomNumber+"', '"+available+"', '"+cleaningStatus+"', '"+price+"', '"+bedType+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Room added successfully");
                setVisible(false);

            } catch (SQLException e3){
                System.out.println(e3);
            }

        } else {
            setVisible(false);
        }



    }

    public static void main(String[] args) {
        new addRoom();
    }
}
