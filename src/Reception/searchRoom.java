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

public class searchRoom extends JFrame implements ActionListener {

    JTable table;
    JLabel roomNumLabel, statusLabel, cleaningStatusLabel, priceLabel, bedTypeLabel;
    JButton backBtn, searchBtn;
    JComboBox bedTypeBox;
    JCheckBox availableCheckBox;

    // constructor
    public searchRoom(){

        JLabel title = new JLabel("Search for Room");
        title.setBounds(350,20,200,25);
        title.setForeground(Color.black);
        title.setFont(new Font("Raleway",Font.BOLD,17));
        add(title);

        JLabel bedType = new JLabel("Bed Type:");
        bedType.setBounds(20,80,100,25);
        bedType.setForeground(Color.black);
        bedType.setFont(new Font("Raleway",Font.BOLD,12));
        add(bedType);

        bedTypeBox = new JComboBox(new String[]{"Single Bed", "Double Bed"});
        bedTypeBox.setBounds(120,80,150,25);
        bedTypeBox.setForeground(Color.black);
        bedTypeBox.setFont(new Font("Raleway",Font.BOLD,12));
        add(bedTypeBox);

        availableCheckBox = new JCheckBox("Only Display Available Rooms");
        availableCheckBox.setBounds(550,80,250,25);
        availableCheckBox.setForeground(Color.black);
        availableCheckBox.setBackground(Color.white);
        availableCheckBox.setFocusable(false);
        availableCheckBox.setFont(new Font("Raleway",Font.BOLD,12));
        add(availableCheckBox);


        // room number
        roomNumLabel = new JLabel("Room_Number");
        roomNumLabel.setBounds(20,140,150,25);
        roomNumLabel.setForeground(Color.black);
        roomNumLabel.setFont(new Font("Raleway",Font.BOLD,12));
        add(roomNumLabel);

        // status
        statusLabel = new JLabel("Status");
        statusLabel.setBounds(180,140,150,25);
        statusLabel.setForeground(Color.black);
        statusLabel.setFont(new Font("Raleway",Font.BOLD,12));
        add(statusLabel);

        // cleaning status
        cleaningStatusLabel = new JLabel("Cleaning_Status");
        cleaningStatusLabel.setBounds(340,140,150,25);
        cleaningStatusLabel.setForeground(Color.black);
        cleaningStatusLabel.setFont(new Font("Raleway",Font.BOLD,12));
        add(cleaningStatusLabel);

        // price
        priceLabel = new JLabel("Price");
        priceLabel.setBounds(500,140,150,25);
        priceLabel.setForeground(Color.black);
        priceLabel.setFont(new Font("Raleway",Font.BOLD,12));
        add(priceLabel);

        // bed type
        bedTypeLabel = new JLabel("Bed_Type");
        bedTypeLabel.setBounds(660,140,150,25);
        bedTypeLabel.setForeground(Color.black);
        bedTypeLabel.setFont(new Font("Raleway",Font.BOLD,12));
        add(bedTypeLabel);


        // table
        table = new JTable();
        table.setBounds(20,165,800,400);
        add(table);

        Conn c = new Conn();
        String query = "select * from room";
        try {
            ResultSet rs = c.s.executeQuery(query);

            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            System.out.println(e);
        }


        searchBtn = new JButton("Search");
        searchBtn.setBounds(250,600,120,37);
        searchBtn.setForeground(Color.black);
        searchBtn.setBackground(Color.CYAN);
        searchBtn.setFocusable(false);
        searchBtn.setFont(new Font("Raleway",Font.PLAIN,17));
        // Set rounded border
        searchBtn.setBorder(new RoundedBorder(15)); // 15 is the radius of the border
        searchBtn.addActionListener(this);
        add(searchBtn);


        backBtn = new JButton("Back");
        backBtn.setBounds(450,600,120,37);
        backBtn.setForeground(Color.black);
        backBtn.setBackground(Color.CYAN);
        backBtn.setFocusable(false);
        backBtn.setFont(new Font("Raleway",Font.PLAIN,17));
        // Set rounded border
        backBtn.setBorder(new RoundedBorder(15)); // 15 is the radius of the border
        backBtn.addActionListener(this);
        add(backBtn);




        setSize(845,700);
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



        if (e.getSource() == searchBtn){

            String bedType = (String) bedTypeBox.getSelectedItem();

            try {
                Conn c = new Conn();
                String query1 = "select * from room where bed_type = '" + bedType + "'";
                String query2 = "select * from room where bed_type = '" + bedType + "' and status = 'Available'";

                if (availableCheckBox.isSelected()) {

                    ResultSet rs =  c.s.executeQuery(query2);
                    table.setModel(DbUtils.resultSetToTableModel(rs));


                } else {

                    ResultSet rs =  c.s.executeQuery(query1);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                }

            }
            catch (SQLException ex) {
                System.out.println(ex);;
            }

        } else {
            setVisible(false);
            new reception();
        }

    }

    public static void main(String[] args) {
        new searchRoom();
    }
}
