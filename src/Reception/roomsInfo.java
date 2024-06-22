package Reception;


import hotel_management_system.Conn;
import hotel_management_system.reception;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class roomsInfo extends JFrame implements ActionListener {

    JTable table;
    JLabel roomNumLabel, statusLabel, cleaningStatusLabel, priceLabel, bedTypeLabel;
    JButton backBtn;

    // constructor
    public roomsInfo(){


        // room number
        roomNumLabel = new JLabel("Room_Number");
        roomNumLabel.setBounds(20,40,150,25);
        roomNumLabel.setForeground(Color.black);
        roomNumLabel.setFont(new Font("Raleway",Font.BOLD,12));
        add(roomNumLabel);

        // status
        statusLabel = new JLabel("Status");
        statusLabel.setBounds(180,40,150,25);
        statusLabel.setForeground(Color.black);
        statusLabel.setFont(new Font("Raleway",Font.BOLD,12));
        add(statusLabel);

        // cleaning status
        cleaningStatusLabel = new JLabel("Cleaning_Status");
        cleaningStatusLabel.setBounds(340,40,150,25);
        cleaningStatusLabel.setForeground(Color.black);
        cleaningStatusLabel.setFont(new Font("Raleway",Font.BOLD,12));
        add(cleaningStatusLabel);

        // price
        priceLabel = new JLabel("Price");
        priceLabel.setBounds(500,40,150,25);
        priceLabel.setForeground(Color.black);
        priceLabel.setFont(new Font("Raleway",Font.BOLD,12));
        add(priceLabel);

        // bed type
        bedTypeLabel = new JLabel("Bed_Type");
        bedTypeLabel.setBounds(660,40,150,25);
        bedTypeLabel.setForeground(Color.black);
        bedTypeLabel.setFont(new Font("Raleway",Font.BOLD,12));
        add(bedTypeLabel);


        // table
        table = new JTable();
        table.setBounds(20,65,800,400);
        add(table);

        Conn c = new Conn();
        String query = "select * from room";
        try {
            ResultSet rs = c.s.executeQuery(query);

            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            System.out.println(e);
        }


        backBtn = new JButton("Back");
        backBtn.setBounds(20,500,120,37);
        backBtn.setForeground(Color.black);
        backBtn.setBackground(Color.CYAN);
        backBtn.setFocusable(false);
        backBtn.setFont(new Font("Raleway",Font.PLAIN,17));
        // Set rounded border
        backBtn.setBorder(new RoundedBorder(15)); // 15 is the radius of the border
        backBtn.addActionListener(this);
        add(backBtn);




        setSize(900,600);
        setTitle("Room Info");
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

        setVisible(false);
        new reception();
    }

    public static void main(String[] args) {
        new roomsInfo();
    }
}
