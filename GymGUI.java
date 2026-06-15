import javax.swing.*;
import java.awt.*;
import javax.swing.JComboBox;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

//import java.io.FileNotFoundException;

public class GymGUI{
    private ArrayList<GymMember> member = new ArrayList<GymMember>();
    private JFrame guiFrame;
    private JPanel homePanel, regularPanel, premiumPanel;
    private JLabel HLabel, paidDueAmountPremiumLabel,idRegularLabel, nameRegularLabel, locationRegularLabel, phoneRegularLabel, emailRegularLabel, genderRegularLabel, dobRegularLabel, yearRegularLabel, monthRegularLabel, dateRegularLabel, membershipStartdateRegularLabel, membershipYearRegularLabel, membershipMonthRegularLabel, membershipDateRegularLabel, referralsourceRegularLabel, paidamountRegularLabel, removalreasonsRegularLabel, planLabel, planpriceLabel, idPremiumLabel, namePremiumLabel, locationPremiumLabel, phonePremiumLabel, emailPremiumLabel, genderPremiumLabel, dobPremiumLabel, yearPremiumLabel, monthPremiumLabel, datePremiumLabel,  membershipStartdatePremiumLabel, membershipYearPremiumLabel, membershipMonthPremiumLabel, membershipDatePremiumLabel, referralsourcePremiumLabel, removalreasonsPremiumLabel, paidamountPremiumLabel, trainersNameLabel,  planchargeLabel;
    private JTextField paidDueAmountPremiumTextField,removalReasonRegularTextField,nameRegularTextField, idRegularTextField, locationRegularTextField, phoneRegularTextField, emailRegularTextField, referralSourceRegularTextField, paidAmountRegularTextField, planpriceTextField, trainersNameTextField, namePremiumTextField, idPremiumTextField, locationPremiumTextField, phonePremiumTextField, emailPremiumTextField, referralSourcePremiumTextField, paidAmountPremiumTextField, planchargeTextField;
    private JTextArea removalreasonRegularTA, removalReasonPremiumTA; 
    private JButton payDuePremium,readToFilePremium,saveToFilePremium,readToFileRegular,saveToFileRegular,upgradePlans,discountBtn,addRegularMember, addPremiumMember, activateMembershipRegular, deactivateMembershipRegular, markAttendanceRegular, displayRegular, clearRegular,backBtnRegular,backBtnpremium, Hregular, Hpremium, revertRegular,revertPremium,activateMembershipPremium, deactivateMembershipPremium, markAttendancePremium, displayPremium, clearPremium;
    private JComboBox plan, dobDateRegular, dobMonthRegular,dobYearComboRegular,dobMonthComboRegular,dobDateComboRegular ,dobYearRegular, dobDateP, dobMonthP, dobYearP, membershipStartYearRegular, membershipStartMonthRegular, membershipStartDateRegular, membershipStartYearPremium, membershipSrtartMonthPremium, membershipStartDatePremium;
    private JRadioButton maleRadioButtonRegular, femaleRadioButtonRegular, otherRadioButtonRegular, maleRadioButtonPremium, femaleRadioButtonPremium, otherRadioButtonPremium;

    public GymGUI(){
        guiFrame = new JFrame("24046367 Bijay Kumar Yadav");
        guiFrame.setSize(1100,1800);
        guiFrame.setResizable(false);
        guiFrame.setLayout(null);
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        homePanel = new JPanel();
        homePanel.setSize(1800,1800);
        homePanel.setLayout(null);

        homePanel.setBackground(new Color(205,215,190));//set color

        HLabel = new JLabel("Welcome! Select your MemberShip");
        HLabel.setBounds(210,290,500,40);
        HLabel.setFont(new Font("Arial Black", Font.BOLD, 22));

        Hregular = new JButton("RegularMember");
        Hregular.setBounds(325,360,250,40);
        Hregular.setFont(new Font("Arial CE Regular", Font.BOLD, 22));

        Hpremium = new JButton("PremiumMeber");
        Hpremium.setBounds(325,410,250,40);
        Hpremium.setFont(new Font("Arial CE Regular", Font.BOLD, 22));

        regularPanel = new JPanel();
        regularPanel.setSize(1500,1500);
        regularPanel.setLayout(null);
        regularPanel.setBackground(new Color(198,198,198));// set color

        idRegularLabel = new JLabel("ID:");
        idRegularLabel.setBounds(50,5,100,25);

        idRegularTextField = new JTextField();
        idRegularTextField.setBounds(150,5,80,30);

        nameRegularLabel = new JLabel("Name:");
        nameRegularLabel.setBounds(50,40,100,30);

        nameRegularTextField = new JTextField();
        nameRegularTextField.setBounds(150,40,200,30);

        locationRegularLabel = new JLabel("Location:");
        locationRegularLabel.setBounds(50,115,100,30);

        locationRegularTextField = new JTextField();
        locationRegularTextField.setBounds(150,115,200,30);

        phoneRegularLabel = new JLabel("Phone no:");
        phoneRegularLabel.setBounds(50,75,100,30);

        phoneRegularTextField = new JTextField();
        phoneRegularTextField.setBounds(150,75,200,30);

        emailRegularLabel = new JLabel("Email:");
        emailRegularLabel.setBounds(50,150,100,30);

        emailRegularTextField = new JTextField();
        emailRegularTextField.setBounds(150,150,200,30);

        planLabel = new JLabel("Plan:");
        planLabel.setBounds(300,430,100,30);

        String[] plan = {"Basic", "Standard", "Deluxe"};
        JComboBox<String> planCombo = new JComboBox<>(plan);
        planCombo.setBounds(350,430,100,30);

        genderRegularLabel = new JLabel("Gender:");
        genderRegularLabel.setBounds(50,200,100,30);

        maleRadioButtonRegular = new JRadioButton("Male");
        maleRadioButtonRegular.setBounds(200,200,70,30);

        femaleRadioButtonRegular = new JRadioButton("female");
        femaleRadioButtonRegular.setBounds(270,200,70,30);

        otherRadioButtonRegular = new JRadioButton("Other");
        otherRadioButtonRegular.setBounds(370,200,70,30);

        //select only one radiobutton at one time
        ButtonGroup genderRegular = new ButtonGroup();
        genderRegular.add(maleRadioButtonRegular);
        genderRegular.add(femaleRadioButtonRegular);
        genderRegular.add(otherRadioButtonRegular);

        //jcombobox for dob
        dobRegularLabel = new JLabel("DOB:");
        dobRegularLabel.setBounds(50,250,100,30);

        String[] dobYearR = new String[35];
        for (int i = 0; i < 35; i++){
            dobYearR[i] = String.valueOf(1985 + i);
        }

        String[]  dobMonthR= {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String[] dobDateR = new String[31];

        for(int i = 0; i< 31; i++){
            dobDateR[i] = String.valueOf(i + 1);
        }

        JComboBox<String> dobYearComboRegular = new JComboBox<>(dobYearR);
        dobYearComboRegular.setBounds(200,250,100,30);

        JComboBox<String> dobMonthComboRegular = new JComboBox<>(dobMonthR);
        dobMonthComboRegular.setBounds(325,250,100,30);

        JComboBox<String> dobDateComboRegular = new JComboBox<>(dobDateR);
        dobDateComboRegular.setBounds(450,250,100,30);

        membershipStartdateRegularLabel = new JLabel("Membership Start Date:");
        membershipStartdateRegularLabel.setBounds(50,330,100,30);

        String[] membershipStartYearRegular = new String[23];
        for (int i = 0; i < 23; i++){
            membershipStartYearRegular[i] = String.valueOf(2003 + i);
        }

        String[] membershipStartMonthRegular = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String[] membershipStartDateRegular = new String[31];

        for(int i = 0; i < 31; i++){
            membershipStartDateRegular[i] = String.valueOf(i + 1);
        }

        JComboBox<String> yearBoxRegular = new JComboBox<>(membershipStartYearRegular);
        yearBoxRegular.setBounds(200,330,100,30);

        JComboBox<String> monthBoxRegular = new JComboBox<>(membershipStartMonthRegular);
        monthBoxRegular.setBounds(325,330,100,30);

        JComboBox<String> dateBoxRegular = new JComboBox<>(membershipStartDateRegular);
        dateBoxRegular.setBounds(450,330,100,30);

        referralsourceRegularLabel = new JLabel("Referral Source:");
        referralsourceRegularLabel.setBounds(50,380,100,30);

        referralSourceRegularTextField = new JTextField();
        referralSourceRegularTextField.setBounds(150,380,130,30);

        paidamountRegularLabel = new JLabel("Paid Amount");
        paidamountRegularLabel.setBounds(300,380,100,30);

        paidAmountRegularTextField = new JTextField();
        paidAmountRegularTextField.setBounds(380,380,130,30);

        planpriceLabel = new JLabel("Plan Price");
        planpriceLabel.setBounds(50,430,100,30);

        planpriceTextField = new JTextField();
        planpriceTextField.setBounds(150,430,100,30);
        planpriceTextField.setEditable(false);

        removalreasonsRegularLabel = new JLabel("Removal Reason");
        removalreasonsRegularLabel.setBounds(50,465,100,30);

        removalreasonRegularTA = new JTextArea();
        removalreasonRegularTA.setBounds(150,465,350,60);

        addRegularMember = new JButton("Add Regular Member"); 
        addRegularMember.setBounds(250,550,180,30);

        activateMembershipRegular = new JButton("Activate Membership");
        activateMembershipRegular.setBounds(470,550,200,30);

        deactivateMembershipRegular = new JButton("Deactivate Membership");
        deactivateMembershipRegular.setBounds(150,600,150,30);

        markAttendanceRegular = new JButton("Mark Attendance");
        markAttendanceRegular.setBounds(310,600,150,30);

        displayRegular = new JButton("Display");
        displayRegular.setBounds(470,600,150,30);

        clearRegular = new JButton("Clear");
        clearRegular.setBounds(630,600,180,30);

        revertRegular=new JButton("Revert");
        revertRegular.setBounds(320,650,150,30);

        upgradePlans= new JButton("Upgrade Plan");
        upgradePlans.setBounds(140,650,150,30);

        saveToFileRegular=new JButton("Save To File");
        saveToFileRegular.setBounds(470,650,150,30);

        readToFileRegular=new JButton("Read from File");
        readToFileRegular.setBounds(620,650,150,30);

        //Back to home panel
        backBtnRegular=new JButton("Back To HomePanel");
        backBtnRegular.setBounds(250,710,180,30);

        //adding componentes regularPanel
        regularPanel.add(idRegularLabel);
        regularPanel.add(idRegularTextField);
        regularPanel.add(nameRegularLabel);
        regularPanel.add(nameRegularTextField);
        regularPanel.add(locationRegularLabel);
        regularPanel.add(locationRegularTextField);
        regularPanel.add(phoneRegularLabel);
        regularPanel.add(phoneRegularTextField);
        regularPanel.add(emailRegularLabel);
        regularPanel.add(emailRegularTextField);
        regularPanel.add(referralsourceRegularLabel);
        regularPanel.add(referralSourceRegularTextField);
        regularPanel.add(genderRegularLabel);
        regularPanel.add(maleRadioButtonRegular);
        regularPanel.add(femaleRadioButtonRegular);
        regularPanel.add(otherRadioButtonRegular);
        regularPanel.add(dobRegularLabel);
        regularPanel.add(dobYearComboRegular);
        regularPanel.add(dobMonthComboRegular);
        regularPanel.add(dobDateComboRegular);
        regularPanel.add(membershipStartdateRegularLabel);
        regularPanel.add(yearBoxRegular);
        regularPanel.add(monthBoxRegular);
        regularPanel.add(dateBoxRegular);
        regularPanel.add(planLabel);
        regularPanel.add(planCombo);
        regularPanel.add(planpriceLabel);
        regularPanel.add(planpriceTextField);
        regularPanel.add(paidamountRegularLabel);
        regularPanel.add(paidAmountRegularTextField);
        regularPanel.add(removalreasonsRegularLabel);
        regularPanel.add(removalreasonRegularTA);
        regularPanel.add(addRegularMember);
        regularPanel.add(activateMembershipRegular);
        regularPanel.add(deactivateMembershipRegular);
        regularPanel.add(markAttendanceRegular);
        regularPanel.add(displayRegular);
        regularPanel.add(clearRegular);
        regularPanel.add(revertRegular);
        regularPanel.add(backBtnRegular);
        regularPanel.add(upgradePlans);
        regularPanel.add(saveToFileRegular);
        regularPanel.add(readToFileRegular);

        premiumPanel = new JPanel();
        premiumPanel.setSize(1500,1500);
        premiumPanel.setLayout(null);
        premiumPanel.setBackground(new Color(255,235,171));//set color

        idPremiumLabel = new JLabel("ID:");
        idPremiumLabel.setBounds(50,5,100,25);

        idPremiumTextField = new JTextField();
        idPremiumTextField.setBounds(150,5,80,30);

        namePremiumLabel = new JLabel("Name:");
        namePremiumLabel.setBounds(50,40,100,30);

        namePremiumTextField = new JTextField();
        namePremiumTextField.setBounds(150,40,200,30);

        locationPremiumLabel = new JLabel("Location:");
        locationPremiumLabel.setBounds(50,115,100,30);

        locationPremiumTextField = new JTextField();
        locationPremiumTextField.setBounds(150,115,200,30);

        phonePremiumLabel = new JLabel("Phone no:");
        phonePremiumLabel.setBounds(50,75,100,30);

        phonePremiumTextField = new JTextField();
        phonePremiumTextField.setBounds(150,75,200,30);

        emailPremiumLabel = new JLabel("Email:");
        emailPremiumLabel.setBounds(50,150,100,30);

        emailPremiumTextField = new JTextField();
        emailPremiumTextField.setBounds(150,150,200,30);

        genderPremiumLabel = new JLabel("Gender:");
        genderPremiumLabel.setBounds(50,200,100,30);

        maleRadioButtonPremium = new JRadioButton("Male");
        maleRadioButtonPremium.setBounds(200,200,70,30);

        femaleRadioButtonPremium = new JRadioButton("Female");
        femaleRadioButtonPremium.setBounds(270,200,70,30);

        otherRadioButtonPremium = new JRadioButton("Other");
        otherRadioButtonPremium.setBounds(370,200,70,30);
        //radiobutton click
        ButtonGroup genderPremium = new ButtonGroup();
        genderPremium.add(maleRadioButtonPremium);
        genderPremium.add(femaleRadioButtonPremium);
        genderPremium.add(otherRadioButtonPremium);

        //JcomboBox

        dobPremiumLabel = new JLabel("DOB:");
        dobPremiumLabel.setBounds(50,250,100,30);

        String[] dobYearPremium = new String[35];
        for (int i = 0; i < 35; i++){
            dobYearPremium[i] = String.valueOf(1985 + i);
        }

        String[] dobMonthPremium = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String[] dobDatePremium = new String[31];

        for(int i = 0; i< 31; i++){
            dobDatePremium[i] = String.valueOf(i + 1);
        }

        JComboBox<String> dobYearComboPremium = new JComboBox<>(dobYearPremium);
        dobYearComboPremium.setBounds(200,250,100,30);

        JComboBox<String> dobMonthComboPremium = new JComboBox<>(dobMonthPremium);
        dobMonthComboPremium.setBounds(325,250,100,30);

        JComboBox<String> dobDateComboPremium= new JComboBox<>(dobDatePremium);
        dobDateComboPremium.setBounds(450,250,100,30);

        membershipStartdatePremiumLabel = new JLabel("Membership Start Date:");
        membershipStartdatePremiumLabel.setBounds(50,330,100,30);

        String[] membershipStartYearPremium = new String[23];
        for (int i = 0; i < 23; i++){
            membershipStartYearPremium[i] = String.valueOf(2003 + i);
        }

        String[] membershipStartMonthPremium= {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String[] membershipStartDatePremium = new String[31];

        for(int i = 0; i< 31; i++){
            membershipStartDatePremium[i] = String.valueOf(i + 1);
        }

        JComboBox<String> yearBoxPremium = new JComboBox<>(membershipStartYearPremium);
        yearBoxPremium.setBounds(200,330,100,30);

        JComboBox<String> monthBoxPremium = new JComboBox<>(membershipStartMonthPremium);
        monthBoxPremium.setBounds(325,330,100,30);

        JComboBox<String> dateBoxPremium = new JComboBox<>(membershipStartDatePremium);
        dateBoxPremium.setBounds(450,330,100,30);

        referralsourcePremiumLabel = new JLabel("Referral Source:");
        referralsourcePremiumLabel.setBounds(50,380,100,30);

        referralSourcePremiumTextField = new JTextField();
        referralSourcePremiumTextField.setBounds(150,380,130,30);

        paidamountPremiumLabel = new JLabel("Paid Amount");
        paidamountPremiumLabel.setBounds(350,380,100,30);

        paidAmountPremiumTextField = new JTextField();
        paidAmountPremiumTextField.setBounds(450,380,130,30);

        paidDueAmountPremiumLabel = new JLabel("Paid Due Amount");
        paidDueAmountPremiumLabel.setBounds(615,380,100,30);

        paidDueAmountPremiumTextField = new JTextField();
        paidDueAmountPremiumTextField.setBounds(730,380,130,30);

        trainersNameLabel = new JLabel("Trainer's Name");
        trainersNameLabel.setBounds(50,430,100,30);

        trainersNameTextField = new JTextField();
        trainersNameTextField.setBounds(150,430,100,30);

        planchargeLabel = new JLabel("Plan Charge");
        planchargeLabel.setBounds(350,430,100,30);

        planchargeTextField = new JTextField();
        planchargeTextField.setBounds(450,430,150,30);
        planchargeTextField.setEditable(false);

        removalreasonsPremiumLabel = new JLabel("Removal Reason");
        removalreasonsPremiumLabel.setBounds(50,485,100,30);

        removalReasonPremiumTA = new JTextArea();
        removalReasonPremiumTA.setBounds(150,485,350,60);

        addPremiumMember = new JButton("Add Premium Member"); 
        addPremiumMember.setBounds(250,550,180,30);

        activateMembershipPremium = new JButton("Activate Membership ");
        activateMembershipPremium.setBounds(450,550,200,30);

        deactivateMembershipPremium = new JButton("Deactivate Membership");
        deactivateMembershipPremium.setBounds(100,600,180,30);

        markAttendancePremium = new JButton("Mark Attendance");
        markAttendancePremium.setBounds(310,600,150,30);

        displayPremium = new JButton("Display");
        displayPremium.setBounds(470,600,150,30);

        clearPremium = new JButton("Clear");
        clearPremium.setBounds(630,600,180,30);

        revertPremium=new JButton("Revert");
        revertPremium.setBounds(120,650,150,30);

        payDuePremium=new JButton("Pay Due");
        payDuePremium.setBounds(310,650,150,30);
        //calculate button
        discountBtn=new JButton("Discount");
        discountBtn.setBounds(470,650,150,30);

        //read and save
        saveToFilePremium=new JButton("Save to File");
        saveToFilePremium.setBounds(670,650,150,30);

        readToFilePremium=new JButton("Read from File");
        readToFilePremium.setBounds(870,650,150,30);

        //back to home panel
        backBtnpremium= new JButton("Back TO HomePanel");
        backBtnpremium.setBounds(160,710,180,30);

        //adding componentes home panel
        homePanel.add(HLabel);
        homePanel.add(Hregular);
        homePanel.add(Hpremium);

        //adding to premium panel
        premiumPanel.add(idPremiumLabel);
        premiumPanel.add(idPremiumTextField);
        premiumPanel.add(namePremiumLabel);
        premiumPanel.add(namePremiumTextField);
        premiumPanel.add(locationPremiumLabel);
        premiumPanel.add(locationPremiumTextField);
        premiumPanel.add(phonePremiumLabel);
        premiumPanel.add(phonePremiumTextField);
        premiumPanel.add(emailPremiumLabel);
        premiumPanel.add(emailPremiumTextField);
        premiumPanel.add(referralsourcePremiumLabel);
        premiumPanel.add(referralSourcePremiumTextField);
        premiumPanel.add(genderPremiumLabel);
        premiumPanel.add(maleRadioButtonPremium);
        premiumPanel.add(femaleRadioButtonPremium);
        premiumPanel.add(otherRadioButtonPremium);
        premiumPanel.add(dobPremiumLabel);
        //premiumPanel.add(yearPremiumLabel);
        premiumPanel.add(dobYearComboPremium);
        //premiumPanel.add(monthPremiumLabel);
        premiumPanel.add(dobMonthComboPremium);
        //premiumPanel.add(datePremiumLabel);
        premiumPanel.add(dobDateComboPremium);
        premiumPanel.add(membershipStartdatePremiumLabel);
        //premiumPanel.add(membershipYearPremiumLabel);
        premiumPanel.add(yearBoxPremium);
        //premiumPanel.add(membershipMonthPremiumLabel);
        premiumPanel.add(monthBoxPremium);
        //premiumPanel.add(membershipDatePremiumLabel);
        premiumPanel.add(dateBoxPremium);
        premiumPanel.add(trainersNameLabel);
        premiumPanel.add(trainersNameTextField);
        premiumPanel.add(planchargeLabel);
        premiumPanel.add(planchargeTextField);
        premiumPanel.add(paidamountPremiumLabel);
        premiumPanel.add(paidAmountPremiumTextField);
        premiumPanel.add(removalreasonsPremiumLabel);
        premiumPanel.add(removalReasonPremiumTA);
        premiumPanel.add(addPremiumMember);
        premiumPanel.add(activateMembershipPremium);
        premiumPanel.add(deactivateMembershipPremium);
        premiumPanel.add(markAttendancePremium);
        premiumPanel.add(displayPremium);
        premiumPanel.add(clearPremium);
        premiumPanel.add(revertPremium);
        premiumPanel.add(backBtnpremium);
        premiumPanel.add(discountBtn);
        premiumPanel.add(saveToFilePremium);
        premiumPanel.add(readToFilePremium);
        premiumPanel.add(payDuePremium);
        premiumPanel.add(paidDueAmountPremiumLabel);
        premiumPanel.add(paidDueAmountPremiumTextField);

        //adding panels to frame
        guiFrame.add(homePanel);
        guiFrame.add(regularPanel);
        guiFrame.add(premiumPanel);

        addRegularMember.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {

                        int id = Integer.parseInt(idRegularTextField.getText());

                        String name = nameRegularTextField.getText();
                        String location = locationRegularTextField.getText();
                        String phone = phoneRegularTextField.getText();
                        String email = emailRegularTextField.getText();
                        String referralSource = referralSourceRegularTextField.getText();
                        String gender = maleRadioButtonRegular.isSelected() ? "Male" :
                            femaleRadioButtonRegular.isSelected() ? "Female" :
                            otherRadioButtonRegular.isSelected() ? "Other" : "Not Selected";

                        String DOB = dobYearComboRegular.getSelectedItem() + "-" +
                            dobMonthComboRegular.getSelectedItem() + "-" +
                            dobDateComboRegular.getSelectedItem();
                        String membershipStartDate = yearBoxRegular.getSelectedItem() + "-" +
                            monthBoxRegular.getSelectedItem() + "-" +
                            dateBoxRegular.getSelectedItem();

                        if (name.isEmpty() || location.isEmpty() || phone.isEmpty() || email.isEmpty() || referralSource.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please fill out all fields.", "Missing Information", JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                        // Check member ID
                        for (GymMember m : member) {
                            if (m.id == id) {
                                JOptionPane.showMessageDialog(null, "Member ID already exists.", "Duplicate ID", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                        }

                        // Create new RegularMember and add to the list
                        RegularMember newMember = new RegularMember(id, name, location, phone, email, gender, DOB, membershipStartDate, referralSource);
                        member.add(newMember);
                        JOptionPane.showMessageDialog(null, "Member added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid integer value for ID.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

        // Regular Panel Buttons
        activateMembershipRegular.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String idText = idRegularTextField.getText();
                        if (idText.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please enter member ID", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        int id = Integer.parseInt(idText);
                        boolean found = false;

                        for (GymMember m : member) {
                            if (m.id == id) {
                                found = true;
                                m.activateMembership();
                                JOptionPane.showMessageDialog(null, "Membership activated for ID: " + id, 
                                    "Success", JOptionPane.INFORMATION_MESSAGE);
                                break;
                            }
                        }

                        if (!found) {
                            JOptionPane.showMessageDialog(null, "Member with ID " + id + " not found", 
                                "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid ID format. Please enter a number.", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error activating membership: " + ex.getMessage(), 
                            "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

        /*deactivateMembershipRegular.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        try {
        String idText = idRegularTextField.getText();
        if (idText.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please enter member ID", "Error", JOptionPane.ERROR_MESSAGE);
        return;
        }

        int id = Integer.parseInt(idText);
        String removalReason = removalReasonRegularTA.getText();

        if (removalReason.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please enter removal reason", 
        "Error", JOptionPane.ERROR_MESSAGE);
        return;
        }

        boolean found = false;

        for (GymMember m : member) {
        if (m.id == id) {
        found = true;
        m.deactivateMembership(removalReason);
        JOptionPane.showMessageDialog(null, "Membership deactivated for ID: " + id, 
        "Success", JOptionPane.INFORMATION_MESSAGE);
        break;
        }
        }

        if (!found) {
        JOptionPane.showMessageDialog(null, "Member with ID " + id + " not found", 
        "Error", JOptionPane.ERROR_MESSAGE);
        }
        } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Invalid ID format. Please enter a number.", 
        "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Error deactivating membership: " + ex.getMessage(), 
        "Error", JOptionPane.ERROR_MESSAGE);
        }
        }
        });*/

        deactivateMembershipRegular.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String idText = idRegularTextField.getText();
                        if (idText.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please enter member ID", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        int id = Integer.parseInt(idText);
                        //String removalReason = removalReasonRegularTA.getText();

                        /*if (removalReason.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter removal reason", 
                        "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                        }*/

                        boolean found = false;

                        for (GymMember m : member) {
                            if (m.id == id) {
                                found = true;
                                m.deactivateMembership();
                                JOptionPane.showMessageDialog(null, "Membership deactivated for ID: " + id, 
                                    "Success", JOptionPane.INFORMATION_MESSAGE);
                                break;
                            }
                        }

                        if (!found) {
                            JOptionPane.showMessageDialog(null, "Member with ID " + id + " not found","Error", JOptionPane.ERROR_MESSAGE); 

                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid ID format. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error deactivate membership: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 

                    }
                }
            });

        markAttendanceRegular.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String idText = idRegularTextField.getText();
                        if (idText.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please enter member ID", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        int id = Integer.parseInt(idText);
                        boolean found = false;

                        for (GymMember m : member) {
                            if (m.id == id) {
                                found = true;
                                m.markAttendance();
                                JOptionPane.showMessageDialog(null, "Attendance marked for ID: " + id, 
                                    "Success", JOptionPane.INFORMATION_MESSAGE);
                                break;
                            }
                        }

                        if (!found) {
                            JOptionPane.showMessageDialog(null, "Member with ID " + id + " not found", 
                                "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid ID format. Please enter a number.", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error marking attendance: " + ex.getMessage(), 
                            "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

        displayRegular.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String idText = idRegularTextField.getText().trim();

                    if (idText.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter member ID(s)", "Input Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    String[] idArray = idText.split(",");
                    StringBuilder result = new StringBuilder();
                    boolean anyFound = false;

                    for (String idStr : idArray) {
                        try {
                            int id = Integer.parseInt(idStr.trim());
                            boolean found = false;

                            for (GymMember m : member) {
                                if (m.id == id && m instanceof RegularMember) {
                                    result.append("?Member Type: Regular\n");
                                    result.append("? Member ID: ").append(id).append("\n");
                                    result.append(m.display()).append("\n");
                                    result.append("--------------------------------------------------\n\n");
                                    found = true;
                                    anyFound = true;
                                    break;
                                }
                            }

                            if (!found) {
                                result.append("Regular Member with ID ").append(id).append(" not found.\n\n");
                            }
                        } catch (NumberFormatException ex) {
                            result.append("Invalid ID format: ").append(idStr.trim()).append("\n\n");
                        } catch (Exception ex) {
                            result.append("Error displaying member ID ").append(idStr.trim()).append(": ")
                            .append(ex.getMessage()).append("\n\n");
                        }
                    }

                    if (result.length() > 0) {
                        JOptionPane.showMessageDialog(null, result.toString(), "Regular Members", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No valid member data found.", "Display Error", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
        backBtnRegular.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    homePanel.setVisible(true);
                    regularPanel.setVisible(false);
                    premiumPanel.setVisible(false);
                }
            });

        //PremiumMember action event ---------------------------------------------------------------------------------------
        addPremiumMember.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    try{
                        int id = Integer.parseInt(idPremiumTextField.getText());
                        String name = namePremiumTextField.getText();
                        String location = locationPremiumTextField.getText();
                        String phone = phonePremiumTextField.getText();
                        String email = emailPremiumTextField.getText();
                        String referralSource = referralSourcePremiumTextField.getText();
                        String gender = maleRadioButtonPremium.isSelected() ? "Male": femaleRadioButtonPremium.isSelected() ? "Female":  otherRadioButtonPremium.isSelected() ? "Other" : "Not Selected";
                        String DOB = dobYearComboPremium.getSelectedItem() + "-" + dobMonthComboPremium.getSelectedItem() + "-" + dobDateComboPremium.getSelectedItem();
                        String membershipStartDate = yearBoxPremium.getSelectedItem() + "-" + monthBoxPremium.getSelectedItem() + "-" + dateBoxPremium.getSelectedItem();
                        String trainersName = trainersNameTextField.getText();
                        String plancharge = planchargeTextField.getText();
                        String paidAmount = paidAmountPremiumTextField.getText();
                        String removalReason = removalReasonPremiumTA.getText();

                        if(idPremiumTextField.getText().isEmpty() || name.isEmpty() || location.isEmpty() || phone.isEmpty() || email.isEmpty() || trainersName.isEmpty() ){
                            JOptionPane.showMessageDialog(null, "Please fill out all fields.", "Missing information", JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                        for (GymMember m : member) {
                            if (m.id == id) {
                                JOptionPane.showMessageDialog(null, " ID already exists.", "Invilid ID", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                        }                    
                        // Create new member and add to the list regularMember
                        PremiumMember newMember = new PremiumMember(id, name, location, phone, email, gender, DOB, membershipStartDate, trainersName);
                        member.add(newMember);
                        JOptionPane.showMessageDialog(null, "Member added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                    catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(null, "Please enter integer value for id.", "Invalid type,Please retype", JOptionPane.WARNING_MESSAGE);
                    }

                }
            });

        // Premium Panel Buttons
        activateMembershipPremium.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String idText = idPremiumTextField.getText();
                        if (idText.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please enter member ID", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        int id = Integer.parseInt(idText);
                        boolean found = false;

                        for (GymMember m : member) {
                            if (m.id == id) {
                                found = true;
                                m.activateMembership();
                                JOptionPane.showMessageDialog(null, "Membership activated in ID: " + id,"Success", JOptionPane.INFORMATION_MESSAGE); 

                                break;
                            }
                        }

                        if (!found) {
                            JOptionPane.showMessageDialog(null, "Member with ID " + id + " not found", "Error", JOptionPane.ERROR_MESSAGE);

                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid ID format. Please enter a integer value.","Error", JOptionPane.ERROR_MESSAGE); 

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error activating membership: " + ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE); 

                    }
                }
            });

        deactivateMembershipPremium.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String idText = idPremiumTextField.getText();
                        if (idText.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please enter member ID", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        int id = Integer.parseInt(idText);
                        String removalReason = removalReasonPremiumTA.getText();

                        if (removalReason.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please enter removal reason", 
                                "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        boolean found = false;

                        for (GymMember m : member) {
                            if (m.id == id) {
                                found = true;
                                m.deactivateMembership();
                                JOptionPane.showMessageDialog(null, "Membership deactivated for ID: " + id, 
                                    "Success", JOptionPane.INFORMATION_MESSAGE);
                                break;
                            }
                        }

                        if (!found) {
                            JOptionPane.showMessageDialog(null, "Member with ID " + id + " not found","Error", JOptionPane.ERROR_MESSAGE); 

                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid ID format. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error deactivate membership: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 

                    }
                }
            });

        markAttendancePremium.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String idText = idPremiumTextField.getText();
                        if (idText.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please enter member ID", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        int id = Integer.parseInt(idText);
                        boolean found = false;

                        for (GymMember m : member) {
                            if (m.id == id) {
                                found = true;
                                m.markAttendance();
                                JOptionPane.showMessageDialog(null, "Attendance marked for ID: " + id,"Success", JOptionPane.INFORMATION_MESSAGE); 

                                break;
                            }
                        }

                        if (!found) {
                            JOptionPane.showMessageDialog(null, "Member with ID " + id + " not found","Error", JOptionPane.ERROR_MESSAGE); 

                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid ID format. Please enter a number.","Error", JOptionPane.ERROR_MESSAGE); 

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error marking attendance: " + ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE); 

                    }
                }
            });

        displayPremium.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String idText = idPremiumTextField.getText().trim();

                    if (idText.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter member ID(s)", "Input Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    String[] idArray = idText.split(",");
                    StringBuilder result = new StringBuilder();
                    boolean anyFound = false;

                    for (String idStr : idArray) {
                        try {
                            int id = Integer.parseInt(idStr.trim());
                            boolean found = false;

                            for (GymMember m : member) {
                                if (m.id == id) {
                                    result.append("Member ID: ").append(id).append("\n");
                                    result.append(m.display()).append("\n");
                                    result.append("------------------\n\n");
                                    found = true;
                                    anyFound = true;
                                    break;
                                }
                            }

                            if (!found) {
                                result.append("Member with ID ").append(id).append(" not found.\n\n");
                            }
                        } catch (NumberFormatException ex) {
                            result.append(" Invalid ID format: ").append(idStr.trim()).append("\n\n");
                        } catch (Exception ex) {
                            result.append(" Error displaying member ID ").append(idStr.trim()).append(": ")
                            .append(ex.getMessage()).append("\n\n");
                        }
                    }

                    if (result.length() > 0) {
                        JOptionPane.showMessageDialog(null, result.toString(), "Premium Member Display", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No valid member data found.", "Display Error", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });

        clearRegular.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    idRegularTextField.setText("");
                    nameRegularTextField.setText("");
                    locationRegularTextField.setText("");
                    phoneRegularTextField.setText("");
                    emailRegularTextField.setText("");
                    referralSourceRegularTextField.setText("");
                    paidAmountRegularTextField.setText("");
                    removalReasonRegularTextField.setText("");
                }
            });

        revertRegular.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //System.out.println("Hello");
                    String idTxt = idRegularTextField.getText();
                    String removalReason = revertRegular.getText();

                    if (idTxt.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter a Member ID.", "Missing ID", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    if (removalReason.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please provide a reason for reverting membership.", "Missing Reason", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    try {
                        int id = Integer.parseInt(idTxt);
                        boolean memberFound = false;

                        for (GymMember m : member) {
                            if (m.getid() == id) {
                                memberFound = true;
                                if (m instanceof RegularMember) {
                                    // Implement the logic to revert RegularMember to another membership type if needed
                                    JOptionPane.showMessageDialog(null, "Membership has been reverted.");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Member is not a Regular Member.");
                                }
                                break;
                            }
                        }

                        if (!memberFound) {
                            JOptionPane.showMessageDialog(null, "Member Not Found");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter an integer value for ID.", "Invalid input", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });

        revertPremium.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String idTxt = idPremiumTextField.getText();
                    String removalReason = removalReasonPremiumTA.getText();

                    if (idTxt.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter a Member ID.", "Missing ID", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    if (removalReason.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please provide a reason for reverting membership.", "Missing Reason", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    try {
                        int id = Integer.parseInt(idTxt);
                        boolean memberFound = false;

                        for (GymMember m : member) {
                            if (m.getid() == id) {
                                memberFound = true;
                                if (m instanceof PremiumMember) {

                                    JOptionPane.showMessageDialog(null, "Membership has been reverted.");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Member is not a Premium Member.");
                                }
                                break;
                            }
                        }

                        if (!memberFound) {
                            JOptionPane.showMessageDialog(null, "Member Not Found");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter an integer value for ID.", "Invalid input", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });

        clearPremium.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    idPremiumTextField.setText("");
                    namePremiumTextField.setText("");
                    locationPremiumTextField.setText("");
                    phonePremiumTextField.setText("");
                    emailPremiumTextField.setText("");
                    referralSourcePremiumTextField.setText("");
                    trainersNameTextField.setText("");
                    paidAmountPremiumTextField.setText("");
                    removalReasonPremiumTA.setText("");
                }
            });

        discountBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Get the current paid amount from the premium panel
                    String paidAmountText = paidAmountPremiumTextField.getText();

                    if (paidAmountText.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter a paid amount first.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    try {
                        // Parse the current amount
                        double originalAmount = Double.parseDouble(paidAmountText);

                        // Calculate 10% discount
                        double discountedAmount = originalAmount * 0.9;

                        // Show a confirmation dialog
                        int option = JOptionPane.showConfirmDialog(null, 
                                "Apply 10% discount?\nOriginal: $" + originalAmount + 
                                "\nDiscounted: $" + String.format("%.2f", discountedAmount),
                                "Confirm Discount", 
                                JOptionPane.YES_NO_OPTION);

                        // If user confirms, apply the discount
                        if (option == JOptionPane.YES_OPTION) {
                            paidAmountPremiumTextField.setText(String.format("%.2f", discountedAmount));
                            JOptionPane.showMessageDialog(null, "10% discount applied successfully!", 
                                "Success", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number for paid amount.", 
                            "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

        upgradePlans.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String idText = idRegularTextField.getText();
                        if (idText.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please enter member ID", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        int id = Integer.parseInt(idText);
                        String selectedPlan = (String) planCombo.getSelectedItem();

                        boolean found = false;

                        for (GymMember m : member) {
                            if (m.id == id && m instanceof RegularMember) {
                                found = true;
                                RegularMember regularMember = (RegularMember) m;

                                if (!regularMember.getisEligibleForUpgrade()) {
                                    JOptionPane.showMessageDialog(null,
                                        "Member is not eligible for upgrade.\n" +
                                        "Attendance must reach " + regularMember.getattendanceLimit() +
                                        " (Current: " + regularMember.getattendance() + ")",
                                        "Not Eligible", JOptionPane.WARNING_MESSAGE);
                                    return;
                                }

                                String result = regularMember.upgradePlan(selectedPlan);

                                if (result.toLowerCase().contains("successfully")) {
                                    planpriceTextField.setText(String.valueOf(regularMember.getPlanPrice()));
                                    JOptionPane.showMessageDialog(null,
                                        result + " for member ID: " + id,
                                        "Success", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(null,
                                        result,
                                        "Error", JOptionPane.ERROR_MESSAGE);
                                }

                                break;
                            }
                        }

                        if (!found) {
                            JOptionPane.showMessageDialog(null,
                                "Regular Member with ID " + id + " not found",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null,
                            "Invalid ID format. Please enter a numeric ID.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null,
                            "Error upgrading plan: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

        saveToFileRegular.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    FileWriter writer = null;
                    try {
                        if (member.isEmpty()) {
                            JOptionPane.showMessageDialog(null,
                                "No regular members to save.",
                                "No Data", JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                        writer = new FileWriter("RegularMembers.txt");
                        writer.write(String.format("%-5s %-15s %-15s %-15s %-25s %-20s %-10s %-10s %-10s %-15s %-10s\n",
                                "ID", "Name", "Location", "Phone", "Email", "Membership Start",
                                "Plan", "Price", "Attendance", "Loyalty", "Status"));

                        boolean regularExists = false;
                        for (GymMember m : member) {
                            if (m instanceof RegularMember) {
                                regularExists = true;
                                RegularMember rm = (RegularMember) m;

                                // Get all required values safely
                                String name = rm.getname() != null ? rm.getname() : "N/A";
                                String location = rm.getlocation() != null ? rm.getlocation() : "N/A";
                                String phone = rm.getphone() != null ? rm.getphone() : "N/A";
                                String email = rm.getemail() != null ? rm.getemail() : "N/A";
                                String startDate = rm.getmembershipstartdate() != null ? rm.getmembershipstartdate() : "N/A";
                                String plan = rm.getplan() != null ? rm.getplan() : "N/A";
                                double price = rm.getprice();
                                int attendance = rm.getattendance();
                                double loyaltyPoints = rm.getloyaltyPoints();
                                String status = rm.getactiveStatus() ? "Active" : "Inactive";

                                writer.write(String.format("%-5d %-15s %-15s %-15s %-25s %-20s %-10s %-10.2f %-10d %-15.2f %-10s\n",
                                        rm.getid(),
                                        name,
                                        location,
                                        phone,
                                        email,
                                        startDate,
                                        plan,
                                        price,
                                        attendance,
                                        loyaltyPoints,
                                        status));
                            }
                        }

                        if (!regularExists) {
                            JOptionPane.showMessageDialog(null,
                                "No regular members found to save.",
                                "Info", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }

                        JOptionPane.showMessageDialog(null,
                            "Regular members saved successfully to RegularMembers.txt",
                            "Success", JOptionPane.INFORMATION_MESSAGE);

                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null,
                            "File writing error: " + ex.getMessage(),
                            "IO Error", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        try {
                            if (writer != null)
                                writer.close();
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null,
                                "Error closing the file: " + ex.getMessage(),
                                "Cleanup Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            });

        //read to file
        readToFileRegular.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Scanner scanner = null;
                    try {
                        File file = new File("RegularMembers.txt");
                        if (!file.exists()) {
                            JOptionPane.showMessageDialog(null,
                                "RegularMembers.txt file not found. Please save data first.",
                                "File Not Found", JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                        scanner = new Scanner(file);
                        StringBuilder content = new StringBuilder();

                        while (scanner.hasNextLine()) {
                            content.append(scanner.nextLine()).append("\n");
                        }

                        if (content.toString().trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null,
                                "File is empty. No data to display.",
                                "Empty File", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }

                        JFrame displayFrame = new JFrame("Regular Members Data");
                        JTextArea textArea = new JTextArea(content.toString());
                        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
                        textArea.setEditable(false);

                        JScrollPane scrollPane = new JScrollPane(textArea);
                        displayFrame.add(scrollPane);
                        displayFrame.setSize(800, 400);
                        displayFrame.setLocationRelativeTo(guiFrame);
                        displayFrame.setVisible(true);

                    } catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(null,
                            "Unable to read file: " + ex.getMessage(),
                            "File Error", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null,
                            "Unexpected error while reading file: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        if (scanner != null) {
                            scanner.close();
                        }
                    }
                }
            });

        saveToFilePremium.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    FileWriter writer = null;
                    try {
                        if (member.isEmpty()) {
                            JOptionPane.showMessageDialog(null,
                                "No premium members to save.",
                                "No Data", JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                        writer = new FileWriter("PremiumMembers.txt");
                        writer.write(String.format("%-5s %-15s %-15s %-15s %-25s %-20s %-15s %-10s %-10s %-15s %-10s\n",
                                "ID", "Name", "Location", "Phone", "Email", "Membership Start",
                                "Trainer", "Attendance", "Price", "Discount", "Status"));

                        boolean premiumExists = false;
                        for (GymMember m : member) {
                            if (m instanceof PremiumMember) {
                                premiumExists = true;
                                PremiumMember pm = (PremiumMember) m;

                                // Safely get data
                                String name = pm.getname() != null ? pm.getname() : "N/A";
                                String location = pm.getlocation() != null ? pm.getlocation() : "N/A";
                                String phone = pm.getphone() != null ? pm.getphone() : "N/A";
                                String email = pm.getemail() != null ? pm.getemail() : "N/A";
                                String startDate = pm.getmembershipstartdate() != null ? pm.getmembershipstartdate() : "N/A";
                                String trainer = pm.getpersonalTrainer() != null ? pm.getpersonalTrainer() : "N/A";
                                int attendance = pm.getattendance();
                                double price = pm.getPrice(); 
                                double discount = pm.getdiscountAmount();
                                String status = pm.getactiveStatus() ? "Active" : "Inactive";

                                writer.write(String.format("%-5d %-15s %-15s %-15s %-25s %-20s %-15s %-10d %-10.2f %-15.2f %-10s\n",
                                        pm.getid(),
                                        name,
                                        location,
                                        phone,
                                        email,
                                        startDate,
                                        trainer,
                                        attendance,
                                        price,
                                        discount,
                                        status));
                            }
                        }

                        if (!premiumExists) {
                            JOptionPane.showMessageDialog(null,
                                "No premium members found to save.",
                                "Info", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }

                        JOptionPane.showMessageDialog(null,
                            "Premium members saved successfully to PremiumMembers.txt",
                            "Success", JOptionPane.INFORMATION_MESSAGE);

                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null,
                            "Error saving file: " + ex.getMessage(),
                            "IO Error", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        try {
                            if (writer != null)
                                writer.close();
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null,
                                "Error closing the file: " + ex.getMessage(),
                                "Cleanup Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            });

        //read to file
        readToFilePremium.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Scanner scanner = null;
                    try {
                        File file = new File("PremiumMembers.txt");
                        if (!file.exists()) {
                            JOptionPane.showMessageDialog(null,
                                "PremiumMembers.txt file not found. Please save data first.",
                                "File Not Found", JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                        scanner = new Scanner(file);
                        StringBuilder content = new StringBuilder();

                        while (scanner.hasNextLine()) {
                            content.append(scanner.nextLine()).append("\n");
                        }

                        if (content.toString().trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null,
                                "File is empty. No premium data to display.",
                                "Empty File", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }

                        JFrame displayFrame = new JFrame("Premium Members Data");
                        JTextArea textArea = new JTextArea(content.toString());
                        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
                        textArea.setEditable(false);

                        JScrollPane scrollPane = new JScrollPane(textArea);
                        displayFrame.add(scrollPane);
                        displayFrame.setSize(800, 400);
                        displayFrame.setLocationRelativeTo(guiFrame);
                        displayFrame.setVisible(true);

                    } catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(null,
                            "File not found: " + ex.getMessage(),
                            "File Error", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null,
                            "Unexpected error while reading: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        if (scanner != null)
                            scanner.close();
                    }
                }
            });


        payDuePremium.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        // Get member ID and amount to pay
                        String idText = idPremiumTextField.getText().trim();
                        String amountText = paidDueAmountPremiumTextField.getText().trim();

                        if (idText.isEmpty() || amountText.isEmpty()) {
                            JOptionPane.showMessageDialog(null, 
                                "Please enter both Member ID and Amount to Pay", 
                                "Missing Information", JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                        int id = Integer.parseInt(idText);
                        double amount = Double.parseDouble(amountText);

                        if (amount <= 0) {
                            JOptionPane.showMessageDialog(null, 
                                "Amount must be greater than 0", 
                                "Invalid Amount", JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                        // Find the premium member
                        boolean found = false;
                        for (GymMember m : member) {
                            if (m.getid() == id && m instanceof PremiumMember) {
                                found = true;
                                PremiumMember pm = (PremiumMember)m;

                                // Pay the due amount
                                String result = pm.payDueAmount(amount);
                                JOptionPane.showMessageDialog(null, 
                                    result, 
                                    "Payment Result", JOptionPane.INFORMATION_MESSAGE);

                                // Update the paid amount field
                                paidDueAmountPremiumTextField.setText(String.format("%.2f", pm.getpaidAmount()));
                                break;
                            }
                        }

                        if (!found) {
                            JOptionPane.showMessageDialog(null, 
                                "Premium Member with ID " + id + " not found", 
                                "Member Not Found", JOptionPane.ERROR_MESSAGE);
                        }

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, 
                            "Please enter valid numbers for ID and Amount", 
                            "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, 
                            "Error processing payment: " + ex.getMessage(), 
                            "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

        backBtnpremium.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    homePanel.setVisible(true);
                    regularPanel.setVisible(false);
                    premiumPanel.setVisible(false);
                }
            });

        backBtnpremium.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    homePanel.setVisible(true);
                    regularPanel.setVisible(false);
                    premiumPanel.setVisible(false);
                }
            });

        Hregular.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    homePanel.setVisible(false);
                    regularPanel.setVisible(true);
                    premiumPanel.setVisible(false);
                }
            });

        Hpremium.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    homePanel.setVisible(false);
                    regularPanel.setVisible(false);
                    premiumPanel.setVisible(true);
                }
            });

        Hregular.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    homePanel.setVisible(false);
                    regularPanel.setVisible(true);
                    premiumPanel.setVisible(false);
                }
            });

        Hpremium.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    homePanel.setVisible(false);
                    regularPanel.setVisible(false);
                    premiumPanel.setVisible(true);
                }
            });

        //,making the frame visible
        homePanel.setVisible(true);
        regularPanel.setVisible(true);
        premiumPanel.setVisible(true);
        guiFrame.setVisible(true);

        homePanel.setVisible(true);
        regularPanel.setVisible(false);
        premiumPanel.setVisible(false);

    }

    public static void main(String[] args){
        new GymGUI();

    }
}