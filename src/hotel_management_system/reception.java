package hotel_management_system;

import Reception.addNewCustomer;
import Reception.roomsInfo;
import Reception.department;
import Reception.customerInfo;
import Reception.employeeInfo;
import Reception.managerInfo;
import Reception.searchRoom;
import Reception.updateStatus;
import Reception.updateRoomStatus;
import Reception.pickupService;
import Reception.checkOut;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class reception extends JFrame implements ActionListener {

    JButton newCustomerFormBtn, roomsBtn, departmentBtn, allEmployeeBtn, customerInfoBtn, managerInfoBtn, checkOutBtn, updateStatusBtn, updateRoomStatusBtn, pickupServiceBtn, searchRoomBtn, logoutBtn;

    // constructor
    public reception(){

        // logo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hotel/Images/reception.jpg"));
        Image image = i1.getImage().getScaledInstance(460,408,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image);

        JLabel logoLabel = new JLabel(i2);
        logoLabel.setBounds(280,60,460,408);
        add(logoLabel);

        // Add room button

        newCustomerFormBtn = new JButton("New Customer Form");
        newCustomerFormBtn.setBounds(20,30,200,30);
        newCustomerFormBtn.setForeground(Color.white);
        newCustomerFormBtn.setBackground(Color.black);
        newCustomerFormBtn.setFocusable(false);
        newCustomerFormBtn.setFont(new Font("Raleway",Font.PLAIN,15));
        newCustomerFormBtn.addActionListener(this);
        add(newCustomerFormBtn);

        // rooms button

        roomsBtn = new JButton("Rooms");
        roomsBtn.setBounds(20,70,200,30);
        roomsBtn.setForeground(Color.white);
        roomsBtn.setBackground(Color.black);
        roomsBtn.setFocusable(false);
        roomsBtn.setFont(new Font("Raleway",Font.PLAIN,15));
        roomsBtn.addActionListener(this);
        add(roomsBtn);

        // department button

        departmentBtn = new JButton("Department");
        departmentBtn.setBounds(20,110,200,30);
        departmentBtn.setForeground(Color.white);
        departmentBtn.setBackground(Color.black);
        departmentBtn.setFocusable(false);
        departmentBtn.setFont(new Font("Raleway",Font.PLAIN,15));
        departmentBtn.addActionListener(this);
        add(departmentBtn);

        // All Employee button

        allEmployeeBtn = new JButton("All Employees");
        allEmployeeBtn.setBounds(20,150,200,30);
        allEmployeeBtn.setForeground(Color.white);
        allEmployeeBtn.setBackground(Color.black);
        allEmployeeBtn.setFocusable(false);
        allEmployeeBtn.setFont(new Font("Raleway",Font.PLAIN,15));
        allEmployeeBtn.addActionListener(this);
        add(allEmployeeBtn);

        // customer info button

        customerInfoBtn = new JButton("Customer Info");
        customerInfoBtn.setBounds(20,190,200,30);
        customerInfoBtn.setForeground(Color.white);
        customerInfoBtn.setBackground(Color.black);
        customerInfoBtn.setFocusable(false);
        customerInfoBtn.setFont(new Font("Raleway",Font.PLAIN,15));
        customerInfoBtn.addActionListener(this);
        add(customerInfoBtn);

        // manager info button

        managerInfoBtn = new JButton("Manager Info");
        managerInfoBtn.setBounds(20,230,200,30);
        managerInfoBtn.setForeground(Color.white);
        managerInfoBtn.setBackground(Color.black);
        managerInfoBtn.setFocusable(false);
        managerInfoBtn.setFont(new Font("Raleway",Font.PLAIN,15));
        managerInfoBtn.addActionListener(this);
        add(managerInfoBtn);

        // check out button

        checkOutBtn = new JButton("Checkout");
        checkOutBtn.setBounds(20,270,200,30);
        checkOutBtn.setForeground(Color.white);
        checkOutBtn.setBackground(Color.black);
        checkOutBtn.setFocusable(false);
        checkOutBtn.setFont(new Font("Raleway",Font.PLAIN,15));
        checkOutBtn.addActionListener(this);
        add(checkOutBtn);

        // update status button

        updateStatusBtn = new JButton("Update Status");
        updateStatusBtn.setBounds(20,310,200,30);
        updateStatusBtn.setForeground(Color.white);
        updateStatusBtn.setBackground(Color.black);
        updateStatusBtn.setFocusable(false);
        updateStatusBtn.setFont(new Font("Raleway",Font.PLAIN,15));
        updateStatusBtn.addActionListener(this);
        add(updateStatusBtn);

        // update room status button

        updateRoomStatusBtn = new JButton("Update Room Status");
        updateRoomStatusBtn.setBounds(20,350,200,30);
        updateRoomStatusBtn.setForeground(Color.white);
        updateRoomStatusBtn.setBackground(Color.black);
        updateRoomStatusBtn.setFocusable(false);
        updateRoomStatusBtn.setFont(new Font("Raleway",Font.PLAIN,15));
        updateRoomStatusBtn.addActionListener(this);
        add(updateRoomStatusBtn);

        // pickup service button

        pickupServiceBtn = new JButton("Pickup Service");
        pickupServiceBtn.setBounds(20,390,200,30);
        pickupServiceBtn.setForeground(Color.white);
        pickupServiceBtn.setBackground(Color.black);
        pickupServiceBtn.setFocusable(false);
        pickupServiceBtn.setFont(new Font("Raleway",Font.PLAIN,15));
        pickupServiceBtn.addActionListener(this);
        add(pickupServiceBtn);

        // search room button

        searchRoomBtn = new JButton("Search Room");
        searchRoomBtn.setBounds(20,430,200,30);
        searchRoomBtn.setForeground(Color.white);
        searchRoomBtn.setBackground(Color.black);
        searchRoomBtn.setFocusable(false);
        searchRoomBtn.setFont(new Font("Raleway",Font.PLAIN,15));
        searchRoomBtn.addActionListener(this);
        add(searchRoomBtn);

        // log out button

        logoutBtn = new JButton("Logout");
        logoutBtn.setBounds(20,470,200,30);
        logoutBtn.setForeground(Color.white);
        logoutBtn.setBackground(Color.black);
        logoutBtn.setFocusable(false);
        logoutBtn.setFont(new Font("Raleway",Font.PLAIN,15));
        logoutBtn.addActionListener(this);
        add(logoutBtn);


        setSize(800,565);
        setTitle("Reception");
        getContentPane().setBackground(Color.white);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == newCustomerFormBtn){
            setVisible(false);
            new addNewCustomer();
        } else if (e.getSource() == roomsBtn){
            setVisible(false);
            new roomsInfo();
        } else if (e.getSource() == departmentBtn){
            setVisible(false);
            new department();
        } else if (e.getSource() == customerInfoBtn){
            setVisible(false);
            new customerInfo();
        } else if (e.getSource() == allEmployeeBtn){
            setVisible(false);
            new employeeInfo();
        } else if (e.getSource() == managerInfoBtn){
            setVisible(false);
            new managerInfo();
        } else if (e.getSource() == searchRoomBtn){
            setVisible(false);
            new searchRoom();
        } else if (e.getSource() == updateStatusBtn){
            setVisible(false);
            new updateStatus();
        } else if (e.getSource() == updateRoomStatusBtn){
            setVisible(false);
            new updateRoomStatus();
        } else if (e.getSource() == pickupServiceBtn){
            setVisible(false);
            new pickupService();
        } else if (e.getSource() == checkOutBtn){
            setVisible(false);
            new checkOut();
        } else if (e.getSource() == logoutBtn){
            setVisible(false);
            System.exit(0);
        }



    }

    public static void main(String[] args) {
        new reception();
    }


}
