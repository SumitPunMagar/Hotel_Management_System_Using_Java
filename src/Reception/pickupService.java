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

public class pickupService extends JFrame implements ActionListener {

    JTable table;
    JLabel nameLabel, ageLabel, genderLabel, carCompanyLabel, carModelLabel, availabilityLabel, locationLabel;
    JButton backBtn, searchBtn;

    Choice choice;

    JCheckBox availableCheckBox;

    // constructor
    public pickupService(){

        JLabel title = new JLabel("Search for Cars");
        title.setBounds(350,20,200,25);
        title.setForeground(Color.black);
        title.setFont(new Font("Raleway",Font.BOLD,17));
        add(title);

        JLabel carModel = new JLabel("Car Model:");
        carModel.setBounds(20,80,100,25);
        carModel.setForeground(Color.black);
        carModel.setFont(new Font("Raleway",Font.BOLD,12));
        add(carModel);

        choice = new Choice();
        choice.setBounds(120,80,150,25);
        choice.setForeground(Color.black);
        choice.setFont(new Font("Raleway",Font.BOLD,12));
        add(choice);

        try {
            Conn c = new Conn();
            String query = "select * from driver";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()){
                choice.add(rs.getString("car_company"));
            }

        } catch (Exception e){
            System.out.println(e);
        }

        availableCheckBox = new JCheckBox("Only Display Available Cars");
        availableCheckBox.setBounds(550,80,250,25);
        availableCheckBox.setForeground(Color.black);
        availableCheckBox.setBackground(Color.white);
        availableCheckBox.setFocusable(false);
        availableCheckBox.setFont(new Font("Raleway",Font.BOLD,12));
        add(availableCheckBox);


        // name
        nameLabel = new JLabel("Name");
        nameLabel.setBounds(20,140,150,25);
        nameLabel.setForeground(Color.black);
        nameLabel.setFont(new Font("Raleway",Font.BOLD,12));
        add(nameLabel);

        // age
        ageLabel = new JLabel("Age");
        ageLabel.setBounds(145,140,150,25);
        ageLabel.setForeground(Color.black);
        ageLabel.setFont(new Font("Raleway",Font.BOLD,12));
        add(ageLabel);

        // gender
        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(265,140,150,25);
        genderLabel.setForeground(Color.black);
        genderLabel.setFont(new Font("Raleway",Font.BOLD,12));
        add(genderLabel);

        // car company
        carCompanyLabel = new JLabel("Car Company");
        carCompanyLabel.setBounds(390,140,150,25);
        carCompanyLabel.setForeground(Color.black);
        carCompanyLabel.setFont(new Font("Raleway",Font.BOLD,12));
        add(carCompanyLabel);

        // car model
        carModelLabel = new JLabel("Car Model");
        carModelLabel.setBounds(520,140,150,25);
        carModelLabel.setForeground(Color.black);
        carModelLabel.setFont(new Font("Raleway",Font.BOLD,12));
        add(carModelLabel);

        // availability
        availabilityLabel = new JLabel("Availability");
        availabilityLabel.setBounds(630,140,150,25);
        availabilityLabel.setForeground(Color.black);
        availabilityLabel.setFont(new Font("Raleway",Font.BOLD,12));
        add(availabilityLabel);

        // location
        locationLabel = new JLabel("Location");
        locationLabel.setBounds(755,140,150,25);
        locationLabel.setForeground(Color.black);
        locationLabel.setFont(new Font("Raleway",Font.BOLD,12));
        add(locationLabel);


        // table
        table = new JTable();
        table.setBounds(20,165,855,400);
        add(table);

        Conn c = new Conn();
        String query = "select * from driver";
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




        setSize(900,700);
        setTitle("Search For Cars");
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

            String carType = choice.getSelectedItem();

            try {
                Conn c = new Conn();
                String query1 = "select * from driver where car_company = '" + carType + "'";
                String query2 = "select * from driver where car_company = '" + carType + "' and availability = 'Available'";

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
        new pickupService();
    }
}
