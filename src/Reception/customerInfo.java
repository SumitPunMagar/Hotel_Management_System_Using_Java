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

public class customerInfo extends JFrame implements ActionListener {

    JTable table;
    JLabel documentLabel, numberLabel, nameLabel, genderLabel, countryLabel, roomLabel, checkInTimeLabel, depositLabel;
    JButton backBtn;

    // constructor
    public customerInfo(){


        // document
        documentLabel = new JLabel("Document");
        documentLabel.setBounds(20,40,150,25);
        documentLabel.setForeground(Color.black);
        documentLabel.setFont(new Font("Raleway",Font.BOLD,12));
        add(documentLabel);

        // number
        numberLabel = new JLabel("Number");
        numberLabel.setBounds(150,40,150,25);
        numberLabel.setForeground(Color.black);
        numberLabel.setFont(new Font("Raleway",Font.BOLD,12));
        add(numberLabel);

        // name
        nameLabel = new JLabel("Name");
        nameLabel.setBounds(270,40,150,25);
        nameLabel.setForeground(Color.black);
        nameLabel.setFont(new Font("Raleway",Font.BOLD,12));
        add(nameLabel);

        // gender
        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(400,40,150,25);
        genderLabel.setForeground(Color.black);
        genderLabel.setFont(new Font("Raleway",Font.BOLD,12));
        add(genderLabel);

        // country
        countryLabel = new JLabel("Country");
        countryLabel.setBounds(500,40,150,25);
        countryLabel.setForeground(Color.black);
        countryLabel.setFont(new Font("Raleway",Font.BOLD,12));
        add(countryLabel);

        // room
        roomLabel = new JLabel("Room");
        roomLabel.setBounds(620,40,150,25);
        roomLabel.setForeground(Color.black);
        roomLabel.setFont(new Font("Raleway",Font.BOLD,12));
        add(roomLabel);

        // check in time
        checkInTimeLabel = new JLabel("Check_In_Time");
        checkInTimeLabel.setBounds(735,40,150,25);
        checkInTimeLabel.setForeground(Color.black);
        checkInTimeLabel.setFont(new Font("Raleway",Font.BOLD,12));
        add(checkInTimeLabel);


        // deposit
        depositLabel = new JLabel("Deposit");
        depositLabel.setBounds(860,40,150,25);
        depositLabel.setForeground(Color.black);
        depositLabel.setFont(new Font("Raleway",Font.BOLD,12));
        add(depositLabel);


        // table
        table = new JTable();
        table.setBounds(20,65,950,400);
        add(table);

        Conn c = new Conn();
        String query = "select * from customer";
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




        setSize(1000,600);
        setTitle("Customer Info");
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
        new customerInfo();
    }
}
