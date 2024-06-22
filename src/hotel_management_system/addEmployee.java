package hotel_management_system;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.ResultSet;

public class addEmployee extends JFrame implements ActionListener {

    JLabel nameLabel, ageLabel, genderLabel, jobLabel, salaryLabel, phoneLabel, emailLabel;
    JTextField nameField, ageField, salaryField, phoneField, emailField;
    JRadioButton maleBtn, femaleBtn;
    JComboBox jobBox;
    JButton submitBtn;

    // constructor
    addEmployee(){

        // logo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hotel/Images/employee.png"));
        Image image = i1.getImage().getScaledInstance(225,225,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image);

        JLabel logoLabel = new JLabel(i2);
        logoLabel.setBounds(500,100,225,225);
        add(logoLabel);

        // name

        nameLabel = new JLabel("Name");
        nameLabel.setBounds(40,52,100,25);
        nameLabel.setForeground(Color.black);
        nameLabel.setFont(new Font("Raleway",Font.BOLD,16));
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(160,47,250,35);
        nameField.setForeground(Color.black);
        nameField.setFont(new Font("Raleway",Font.PLAIN,16));
        add(nameField);

        // age

        ageLabel = new JLabel("Age");
        ageLabel.setBounds(40,107,100,25);
        ageLabel.setForeground(Color.black);
        ageLabel.setFont(new Font("Raleway",Font.BOLD,16));
        add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(160,102,250,35);
        ageField.setForeground(Color.black);
        ageField.setFont(new Font("Raleway",Font.PLAIN,16));
        add(ageField);


//        x -- 55    &&  y --  55
        // gender

        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(40,162,100,25);
        genderLabel.setForeground(Color.black);
        genderLabel.setFont(new Font("Raleway",Font.BOLD,16));
        add(genderLabel);


        maleBtn = new JRadioButton("Male");
        maleBtn.setBounds(160,162,100,25);
        maleBtn.setForeground(Color.black);
        maleBtn.setBackground(Color.white);
        maleBtn.setFocusable(false);
        maleBtn.setFont(new Font("Raleway",Font.BOLD,16));
        add(maleBtn);

        femaleBtn = new JRadioButton("Female");
        femaleBtn.setBounds(300,162,100,25);
        femaleBtn.setForeground(Color.black);
        femaleBtn.setBackground(Color.white);
        femaleBtn.setFocusable(false);
        femaleBtn.setFont(new Font("Raleway",Font.BOLD,16));
        add(femaleBtn);

        ButtonGroup group = new ButtonGroup();
        group.add(maleBtn);
        group.add(femaleBtn);


        // job

        jobLabel = new JLabel("Job");
        jobLabel.setBounds(40,217,100,25);
        jobLabel.setForeground(Color.black);
        jobLabel.setFont(new Font("Raleway",Font.BOLD,16));
        add(jobLabel);


        String[] jobArr = {"Front Desk Clarks", "Porters", "House Keeping", "Kitchen Staff", "Room Service", "Chef", "Waiter/Waitress", "Manager", "Accountant"};

        jobBox = new JComboBox(jobArr);
        jobBox.setBounds(160,212,250,35);
        jobBox.setForeground(Color.black);
        jobBox.setFocusable(false);
        jobBox.setFont(new Font("Raleway",Font.BOLD,16));
        add(jobBox);



        // salary

        salaryLabel = new JLabel("Salary");
        salaryLabel.setBounds(40,275,100,25);
        salaryLabel.setForeground(Color.black);
        salaryLabel.setFont(new Font("Raleway",Font.BOLD,16));
        add(salaryLabel);


        salaryField = new JTextField();
        salaryField.setBounds(160,272,250,35);
        salaryField.setForeground(Color.black);
        salaryField.setFont(new Font("Raleway",Font.BOLD,16));
        add(salaryField);


        // phone

        phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(40,332,100,25);
        phoneLabel.setForeground(Color.black);
        phoneLabel.setFont(new Font("Raleway",Font.BOLD,16));
        add(phoneLabel);


        phoneField = new JTextField();
        phoneField.setBounds(160,327,250,35);
        phoneField.setForeground(Color.black);
        phoneField.setFont(new Font("Raleway",Font.BOLD,16));
        add(phoneField);


        // email

        emailLabel = new JLabel("Email");
        emailLabel.setBounds(40,387,100,25);
        emailLabel.setForeground(Color.black);
        emailLabel.setFont(new Font("Raleway",Font.BOLD,16));
        add(emailLabel);


        emailField = new JTextField();
        emailField.setBounds(160,382,250,35);
        emailField.setForeground(Color.black);
        emailField.setFont(new Font("Raleway",Font.BOLD,16));
        add(emailField);


        // submit button

        submitBtn = new JButton("Submit");
        submitBtn.setBounds(160,452,105,37);
        submitBtn.setForeground(Color.black);
        submitBtn.setBackground(Color.CYAN);
        submitBtn.setFocusable(false);
        submitBtn.setFont(new Font("Raleway",Font.PLAIN,20));
        // Set rounded border
        submitBtn.setBorder(new RoundedBorder(15)); // 15 is the radius of the border
        submitBtn.addActionListener(this);
        add(submitBtn);



        setSize(800,560);
        setTitle("Add Employee");
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

        String name = nameField.getText();
        String age = ageField.getText();
        String salary = salaryField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();

        String gender = null;
        if (maleBtn.isSelected()){
            gender = "Male";
        } else if (femaleBtn.isSelected()){
            gender = "Female";
        }

        String job = (String) jobBox.getSelectedItem();


        try {
            Conn c = new Conn();
            String query = "insert into employee values('"+name+"', '"+age+"', '"+gender+"', '"+job+"', '"+salary+"', '"+phone+"', '"+email+"')";
            c.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Employee added successfully");
            setVisible(false);

        } catch (SQLException e2){
            System.out.println(e2);
        }

    }


    public static void main(String[] args) {
        new addEmployee();
    }
}
