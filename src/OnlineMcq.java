
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class OnlineMcq extends JFrame implements ActionListener {

	int nextCount = 0;
	int rightCount = 0;
	int wrongCount = 0;
	int unattemptedCount = 0;
	double total_score = 0;
	String[] rightAnswers = { "Operating System", "Network Interface Card", "Java Virtual Machine",
			"Cascading Style Sheet", "Java Runtime Environment", "String[]", "LEFT", "All of the above",
			"MouseListener", "Batch OS" };
	String[] userAnswers = new String[10];

	JPanel mainPanel, subPanel;
	JPanel welcomePanel, loginPanel, startPanel;
	JPanel panel0,panelad, panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9, panel10, panel11,
			optionPanel;
	JPanel endPanel, finishPanel;

	JLabel correct, wrong, score, message, logintext,unattempted,pass;
	JLabel question1, question2, question3, question4, question5, question6, question7, question8, question9,
			question10, welcome, usernametext,rules,neg;
	JTextField txtCorrect, txtWrong, txtScore, username,txtunattempted,adpass;

	JButton next, quit, start, finish, restart, loginbtn, scores,submit;

	JRadioButton q1a, q1b, q1c, q1d;
	ButtonGroup grp1;

	JRadioButton q2a, q2b, q2c, q2d;
	ButtonGroup grp2;

	JRadioButton q3a, q3b, q3c, q3d;
	ButtonGroup grp3;

	JRadioButton q4a, q4b, q4c, q4d;
	ButtonGroup grp4;

	JRadioButton q5a, q5b, q5c, q5d;
	ButtonGroup grp5;

	JRadioButton q6a, q6b, q6c, q6d;
	ButtonGroup grp6;

	JRadioButton q7a, q7b, q7c, q7d;
	ButtonGroup grp7;

	JRadioButton q8a, q8b, q8c, q8d;
	ButtonGroup grp8;

	JRadioButton q9a, q9b, q9c, q9d;
	ButtonGroup grp9;

	JRadioButton q10a, q10b, q10c, q10d;
	ButtonGroup grp10;

	Container container;

	CardLayout cardl;

	OnlineMcq() {
		setSize(430, 300);
		// this.setEditable(false);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		cardl = new CardLayout();

		container = getContentPane();
		// container.setLayout(new BorderLayout());

		next = new JButton("Next");
		quit = new JButton("Quit");
		start = new JButton("Start");
		loginbtn = new JButton("Submit");
		scores = new JButton("View Scores");
		submit = new JButton("Check Results");
		

		mainPanel = new JPanel();// The panel on the JFrame
		mainPanel.setLayout(new BorderLayout());

		subPanel = new JPanel();// The panel which contains all the cards
		subPanel.setLayout(cardl);

		optionPanel = new JPanel();// The panel which contains the next and quit buttons
		optionPanel.setLayout(new GridLayout(0, 2));
		JPanel p1 = new JPanel();
		p1.add(quit);
		JPanel p2 = new JPanel();
		p2.add(next);
		optionPanel.add(p1);
		optionPanel.add(p2);

		welcomePanel = new JPanel();// The panel which contains the welcome label
		welcome = new JLabel("Welcome!!!");
		welcomePanel.add(welcome);

		panelad = new JPanel();
		panelad.setLayout(new BorderLayout());
		pass = new JLabel("Please Enter Admin Password:");
		adpass = new JTextField(10);
		panelad.add(pass);
		panelad.add(adpass);
		
		
		panel0 = new JPanel();
		panel0.setLayout(new BorderLayout());
		JPanel panel00 =new JPanel();
		panel00.setLayout(new BorderLayout());
		logintext = new JLabel("LOGIN");
		rules =new JLabel("****Negative Marking Applicable***");
		neg = new JLabel("Negative Marking Applicable !");
		panel0.add(logintext);
		panel00.add(neg);
		panel0.add(rules);
		
		JPanel dummyPanel0 = new JPanel();
		dummyPanel0.setLayout(new GridLayout(2, 1));
		usernametext = new JLabel("Candidate Name:");
		username = new JTextField(10);
		JPanel user = new JPanel();
		user.add(usernametext);
		JPanel user1 = new JPanel();
		user1.add(username);
		JPanel pass = new JPanel();
		JPanel pass1 = new JPanel();
		dummyPanel0.add(user);
		dummyPanel0.add(user1);
		dummyPanel0.add(pass);
		dummyPanel0.add(pass1);
		loginbtn = new JButton("Login");
		JPanel log = new JPanel();
		log.add(loginbtn);
		log.setLayout(new GridLayout(4, 2));
		panel0.add(logintext, BorderLayout.NORTH);
		panel00.add(neg, BorderLayout.NORTH);			
		panel0.add(rules, BorderLayout.NORTH);
		
	panel0.add(loginbtn, BorderLayout.SOUTH);
		panel0.add(dummyPanel0, BorderLayout.CENTER);

		startPanel = new JPanel();// The panel which contains the start button
		startPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		startPanel.add(start);
		startPanel.add(scores);

		panel1 = new JPanel();// The panel which contains the first question
		panel1.setLayout(new BorderLayout());
		question1 = new JLabel("What is the full form of OS ?");
		q1a = new JRadioButton("Operating System");
		q1b = new JRadioButton("Operating Service");
		q1c = new JRadioButton("Overloading System");
		q1d = new JRadioButton("Overriding System");
		grp1 = new ButtonGroup();
		grp1.add(q1a);
		grp1.add(q1b);
		grp1.add(q1c);
		grp1.add(q1d);
		JPanel dummyPanel1 = new JPanel();
		dummyPanel1.setLayout(new GridBagLayout());
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.fill = GridBagConstraints.HORIZONTAL;
		gbc1.gridwidth = 2;
		gbc1.gridx = 0;
		gbc1.gridy = 0;
		dummyPanel1.add(question1, gbc1);
		gbc1.gridx = 0;
		gbc1.gridy = 1;
		dummyPanel1.add(q1a, gbc1);
		gbc1.gridx = 2;
		gbc1.gridy = 1;
		dummyPanel1.add(q1b, gbc1);
		gbc1.gridx = 0;
		gbc1.gridy = 2;
		dummyPanel1.add(q1c, gbc1);
		gbc1.gridx = 2;
		gbc1.gridy = 2;
		dummyPanel1.add(q1d, gbc1);
		panel1.add(dummyPanel1, BorderLayout.CENTER);

		panel2 = new JPanel();// The panel which contains the second question
		panel2.setLayout(new BorderLayout());
		question2 = new JLabel("What is the full form of NIC ?");
		q2a = new JRadioButton("Non-Integrated Circuit");
		q2b = new JRadioButton("Network Interface Card");
		q2c = new JRadioButton("Network Interface Chip");
		q2d = new JRadioButton("None of the above");
		grp2 = new ButtonGroup();
		grp2.add(q2a);
		grp2.add(q2b);
		grp2.add(q2c);
		grp2.add(q2d);
		JPanel dummyPanel2 = new JPanel();
		dummyPanel2.setLayout(new GridBagLayout());
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.fill = GridBagConstraints.HORIZONTAL;
		gbc2.gridwidth = 2;
		gbc2.gridx = 0;
		gbc2.gridy = 0;
		dummyPanel2.add(question2, gbc2);
		gbc2.gridx = 0;
		gbc2.gridy = 1;
		dummyPanel2.add(q2a, gbc2);
		gbc2.gridx = 2;
		gbc2.gridy = 1;
		dummyPanel2.add(q2b, gbc2);
		gbc2.gridx = 0;
		gbc2.gridy = 2;
		dummyPanel2.add(q2c, gbc2);
		gbc2.gridx = 2;
		gbc2.gridy = 2;
		dummyPanel2.add(q2d, gbc2);
		panel2.add(dummyPanel2, BorderLayout.CENTER);

		panel3 = new JPanel();//// The panel which contains the third question
		panel3.setLayout(new BorderLayout());
		question3 = new JLabel("What is the full form of JVM ?");
		q3a = new JRadioButton("Java Vector Machine");
		q3b = new JRadioButton("Java Virtual Model");
		q3c = new JRadioButton("Java Virtual Machine");
		q3d = new JRadioButton("None of the above");
		grp3 = new ButtonGroup();
		grp3.add(q3a);
		grp3.add(q3b);
		grp3.add(q3c);
		grp3.add(q3d);
		JPanel dummyPanel3 = new JPanel();
		dummyPanel3.setLayout(new GridBagLayout());
		GridBagConstraints gbc3 = new GridBagConstraints();
		gbc3.fill = GridBagConstraints.HORIZONTAL;
		gbc3.gridwidth = 2;
		gbc3.gridx = 0;
		gbc3.gridy = 0;
		dummyPanel3.add(question3, gbc3);
		gbc3.gridx = 0;
		gbc3.gridy = 1;
		dummyPanel3.add(q3a, gbc3);
		gbc3.gridx = 2;
		gbc3.gridy = 1;
		dummyPanel3.add(q3b, gbc3);
		gbc3.gridx = 0;
		gbc3.gridy = 2;
		dummyPanel3.add(q3c, gbc3);
		gbc3.gridx = 2;
		gbc3.gridy = 2;
		dummyPanel3.add(q3d, gbc3);
		panel3.add(dummyPanel3, BorderLayout.CENTER);

		panel4 = new JPanel();// The panel which contains the fourth question
		panel4.setLayout(new BorderLayout());
		question4 = new JLabel("What is the full form of CSS");
		q4a = new JRadioButton("Client Side Scripting");
		q4b = new JRadioButton("Cascading Style Sheet");
		q4c = new JRadioButton("Both of the above");
		q4d = new JRadioButton("None of the above");
		grp4 = new ButtonGroup();
		grp4.add(q4a);
		grp4.add(q4b);
		grp4.add(q4c);
		grp4.add(q4d);
		JPanel dummyPanel4 = new JPanel();
		dummyPanel4.setLayout(new GridBagLayout());
		GridBagConstraints gbc4 = new GridBagConstraints();
		gbc4.fill = GridBagConstraints.HORIZONTAL;
		gbc4.gridwidth = 2;
		gbc4.gridx = 0;
		gbc4.gridy = 0;
		dummyPanel4.add(question4, gbc4);
		gbc4.gridx = 0;
		gbc4.gridy = 1;
		dummyPanel4.add(q4a, gbc4);
		gbc4.gridx = 2;
		gbc4.gridy = 1;
		dummyPanel4.add(q4b, gbc4);
		gbc4.gridx = 0;
		gbc4.gridy = 2;
		dummyPanel4.add(q4c, gbc4);
		gbc4.gridx = 2;
		gbc4.gridy = 2;
		dummyPanel4.add(q4d, gbc4);
		panel4.add(dummyPanel4, BorderLayout.CENTER);

		panel5 = new JPanel();//// The panel which contains the fifth question
		panel5.setLayout(new BorderLayout());
		question5 = new JLabel("What is the full form of JRE ?");
		q5a = new JRadioButton("Java Runtime Environment");
		q5b = new JRadioButton("Java Runtime Exception");
		q5c = new JRadioButton("Java Ready Environment");
		q5d = new JRadioButton("Java Realtime Environment");
		grp5 = new ButtonGroup();
		grp5.add(q5a);
		grp5.add(q5b);
		grp5.add(q5c);
		grp5.add(q5d);
		JPanel dummyPanel5 = new JPanel();
		dummyPanel5.setLayout(new GridBagLayout());
		GridBagConstraints gbc5 = new GridBagConstraints();
		gbc5.fill = GridBagConstraints.HORIZONTAL;
		gbc5.gridwidth = 2;
		gbc5.gridx = 0;
		gbc5.gridy = 0;
		dummyPanel5.add(question5, gbc5);
		gbc5.gridx = 0;
		gbc5.gridy = 1;
		dummyPanel5.add(q5a, gbc5);
		gbc5.gridx = 2;
		gbc5.gridy = 1;
		dummyPanel5.add(q5b, gbc5);
		gbc5.gridx = 0;
		gbc5.gridy = 2;
		dummyPanel5.add(q5c, gbc5);
		gbc5.gridx = 2;
		gbc5.gridy = 2;
		dummyPanel5.add(q5d, gbc5);
		panel5.add(dummyPanel5, BorderLayout.CENTER);

		panel6 = new JPanel();//// The panel which contains the sixth question
		panel6.setLayout(new BorderLayout());
		question6 = new JLabel("What is the return type of getItems() ?");
		q6a = new JRadioButton("void");
		q6b = new JRadioButton("String");
		q6c = new JRadioButton("String[]");
		q6d = new JRadioButton("char");
		grp6 = new ButtonGroup();
		grp6.add(q5a);
		grp6.add(q5b);
		grp6.add(q5c);
		grp6.add(q5d);
		JPanel dummyPanel6 = new JPanel();
		dummyPanel6.setLayout(new GridBagLayout());
		GridBagConstraints gbc6 = new GridBagConstraints();
		gbc6.fill = GridBagConstraints.HORIZONTAL;
		gbc6.gridwidth = 2;
		gbc6.gridx = 0;
		gbc6.gridy = 0;
		dummyPanel6.add(question6, gbc6);
		gbc6.gridx = 0;
		gbc6.gridy = 1;
		dummyPanel6.add(q6a, gbc6);
		gbc6.gridx = 2;
		gbc6.gridy = 1;
		dummyPanel6.add(q6b, gbc6);
		gbc6.gridx = 0;
		gbc6.gridy = 2;
		dummyPanel6.add(q6c, gbc6);
		gbc6.gridx = 2;
		gbc6.gridy = 2;
		dummyPanel6.add(q6d, gbc6);
		panel6.add(dummyPanel6, BorderLayout.CENTER);

		panel7 = new JPanel();//// The panel which contains the seventh question
		panel7.setLayout(new BorderLayout());
		question7 = new JLabel("What is the default alignment in JLabel class ?");
		q7a = new JRadioButton("CENTER");
		q7b = new JRadioButton("RIGHT");
		q7c = new JRadioButton("LEFT");
		q7d = new JRadioButton("TOP");
		grp7 = new ButtonGroup();
		grp7.add(q7a);
		grp7.add(q7b);
		grp7.add(q7c);
		grp7.add(q7d);
		JPanel dummyPanel7 = new JPanel();
		dummyPanel7.setLayout(new GridBagLayout());
		GridBagConstraints gbc7 = new GridBagConstraints();
		gbc7.fill = GridBagConstraints.HORIZONTAL;
		gbc7.gridwidth = 2;
		gbc7.gridx = 0;
		gbc7.gridy = 0;
		dummyPanel7.add(question7, gbc7);
		gbc7.gridx = 0;
		gbc7.gridy = 1;
		dummyPanel7.add(q7a, gbc7);
		gbc7.gridx = 2;
		gbc7.gridy = 1;
		dummyPanel7.add(q7b, gbc7);
		gbc7.gridx = 0;
		gbc7.gridy = 2;
		dummyPanel7.add(q7c, gbc7);
		gbc7.gridx = 2;
		gbc7.gridy = 2;
		dummyPanel7.add(q7d, gbc7);
		panel7.add(dummyPanel7, BorderLayout.CENTER);

		panel8 = new JPanel();//// The panel which contains the 8th question
		panel8.setLayout(new BorderLayout());
		question8 = new JLabel("Which is the right constructor of TextField class from the given options:");
		q8a = new JRadioButton("TextField(String str)");
		q8b = new JRadioButton("TextField(int col)");
		q8c = new JRadioButton("TextField(String str, int col)");
		q8d = new JRadioButton("All of the above");
		grp8 = new ButtonGroup();
		grp8.add(q8a);
		grp8.add(q8b);
		grp8.add(q8c);
		grp8.add(q8d);
		JPanel dummyPanel8 = new JPanel();
		dummyPanel8.setLayout(new GridBagLayout());
		GridBagConstraints gbc8 = new GridBagConstraints();
		gbc8.fill = GridBagConstraints.HORIZONTAL;
		gbc8.gridwidth = 2;
		gbc8.gridx = 0;
		gbc8.gridy = 0;
		dummyPanel8.add(question8, gbc8);
		gbc8.gridx = 0;
		gbc8.gridy = 1;
		dummyPanel8.add(q8a, gbc8);
		gbc8.gridx = 2;
		gbc8.gridy = 1;
		dummyPanel8.add(q8b, gbc8);
		gbc8.gridx = 0;
		gbc8.gridy = 2;
		dummyPanel8.add(q8c, gbc8);
		gbc8.gridx = 2;
		gbc8.gridy = 2;
		dummyPanel8.add(q8d, gbc8);
		panel8.add(dummyPanel8, BorderLayout.CENTER);

		panel9 = new JPanel();//// The panel which contains the 9th question
		panel9.setLayout(new BorderLayout());
		question9 = new JLabel("Method mousePressed() is the method of which class/interface ?");
		q9a = new JRadioButton("MouseEvent");
		q9b = new JRadioButton("MouseListener");
		q9c = new JRadioButton("MouseMotionEvent");
		q9d = new JRadioButton("MouseMotionListener");
		grp9 = new ButtonGroup();
		grp9.add(q9a);
		grp9.add(q9b);
		grp9.add(q9c);
		grp9.add(q9d);
		JPanel dummyPanel9 = new JPanel();
		dummyPanel9.setLayout(new GridBagLayout());
		GridBagConstraints gbc9 = new GridBagConstraints();
		gbc9.fill = GridBagConstraints.HORIZONTAL;
		gbc9.gridwidth = 2;
		gbc9.gridx = 0;
		gbc9.gridy = 0;
		dummyPanel9.add(question9, gbc9);
		gbc9.gridx = 0;
		gbc9.gridy = 1;
		dummyPanel9.add(q9a, gbc9);
		gbc9.gridx = 2;
		gbc9.gridy = 1;
		dummyPanel9.add(q9b, gbc9);
		gbc9.gridx = 0;
		gbc9.gridy = 2;
		dummyPanel9.add(q9c, gbc9);
		gbc9.gridx = 2;
		gbc9.gridy = 2;
		dummyPanel9.add(q9d, gbc9);
		panel9.add(dummyPanel9, BorderLayout.CENTER);

		panel10 = new JPanel();//// The panel which contains the 10th question
		panel10.setLayout(new BorderLayout());
		question10 = new JLabel("Which was the first Operating System invented ?");
		q10a = new JRadioButton("Real Time OS");
		q10b = new JRadioButton("Batch OS");
		q10c = new JRadioButton("Multitasking OS");
		q10d = new JRadioButton("Multiprogramming OS");
		grp10 = new ButtonGroup();
		grp10.add(q10a);
		grp10.add(q10b);
		grp10.add(q10c);
		grp10.add(q10d);
		JPanel dummyPanel10 = new JPanel();
		dummyPanel10.setLayout(new GridBagLayout());
		GridBagConstraints gbc10 = new GridBagConstraints();
		gbc10.fill = GridBagConstraints.HORIZONTAL;
		gbc10.gridwidth = 2;
		gbc10.gridx = 0;
		gbc10.gridy = 0;
		dummyPanel10.add(question10, gbc10);
		gbc10.gridx = 0;
		gbc10.gridy = 1;
		dummyPanel10.add(q10a, gbc10);
		gbc10.gridx = 2;
		gbc10.gridy = 1;
		dummyPanel10.add(q10b, gbc10);
		gbc10.gridx = 0;
		gbc10.gridy = 2;
		dummyPanel10.add(q10c, gbc10);
		gbc10.gridx = 2;
		gbc10.gridy = 2;
		dummyPanel10.add(q10d, gbc10);
		panel10.add(dummyPanel10, BorderLayout.CENTER);

		endPanel = new JPanel();// The panel which is the score board
		endPanel.setLayout(new BorderLayout());
		JPanel dummyPanel11 = new JPanel();
		dummyPanel11.setLayout(new GridLayout(4, 2));
		correct = new JLabel("Correct:");
		wrong = new JLabel("Wrong:");
		score = new JLabel("Total Score:");
		unattempted= new JLabel("Unattempted:");
		try {
//        	Connection con =null;
//        	Class.forName("org.sqlite.JDBC");
//    		con = DriverManager.getConnection("jdbc:sqlite:Scores.db");
//    		Statement stmt = con.createStatement();
//    		PreparedStatement ps =null;
//    		String sql ="INSERT INTO details(name,correct) VALUES(?,?)" ;
//    		ps = con.prepareStatement(sql);
//    		System.out.println("Username11:"+username.getText()+"RightCount11:"+rightCount);
//    		ps.setString(1,username.getText());
//    		ps.setInt(2, rightCount);
//    		ps.execute();
////    		System.out.println("Inserted..!!!");
//    		con.close();
//    		JOptionPane.showMessageDialog(null,"Saved Successfully !");
		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null,e);
			System.out.println(e.toString());
		}
		txtWrong = new JTextField(10);
		txtCorrect = new JTextField(10);
		txtunattempted = new JTextField(10);
		txtScore = new JTextField(10);
		JPanel p3 = new JPanel();
		p3.add(correct);
		JPanel p4 = new JPanel();
		p4.add(txtCorrect);
		txtCorrect.setEnabled(false);
		JPanel p5 = new JPanel();
		p5.add(wrong);
		JPanel p6 = new JPanel();
		p6.add(txtWrong);
		txtWrong.setEnabled(false);
		JPanel utxt = new JPanel();
		utxt.add(unattempted);
		JPanel uscore = new JPanel();
		uscore.add(txtunattempted);
		txtunattempted.setEnabled(false);
		JPanel p7 = new JPanel();
		p7.add(score);
		JPanel p8 = new JPanel();
		p8.add(txtScore);
		txtScore.setEnabled(false);
		dummyPanel11.add(p3);
		dummyPanel11.add(p4);
		dummyPanel11.add(p5);
		dummyPanel11.add(p6);
		dummyPanel11.add(utxt);
		dummyPanel11.add(uscore);
		dummyPanel11.add(p7);
		dummyPanel11.add(p8);
		message = new JLabel();
		endPanel.add(message, BorderLayout.NORTH);
		endPanel.add(dummyPanel11, BorderLayout.CENTER);

		finishPanel = new JPanel();// The panel which contains the finish and restart button
		finishPanel.setLayout(new GridLayout(1, 2));
		finish = new JButton("Finish");
		restart = new JButton("Restart");
		JPanel p9 = new JPanel();
		p9.add(finish);
		JPanel p10 = new JPanel();
		p10.add(restart);
		finishPanel.add(p9);
		finishPanel.add(p10);

		subPanel.add(welcomePanel);
		subPanel.add(panel0);
		subPanel.add(panel1);
		subPanel.add(panel2);
		subPanel.add(panel3);
		subPanel.add(panel4);
		subPanel.add(panel5);
		subPanel.add(panel6);
		subPanel.add(panel7);
		subPanel.add(panel8);
		subPanel.add(panel9);
		subPanel.add(panel10);
		subPanel.add(endPanel);

		mainPanel.add(subPanel, BorderLayout.CENTER);
//		mainPanel.add(adpass,BorderLayout.CENTER);
		// mainPanel.add(loginPanel,BorderLayout.SOUTH);
		mainPanel.add(startPanel, BorderLayout.SOUTH);

		container.add(mainPanel);

		next.addActionListener(this);
		quit.addActionListener(this);
		start.addActionListener(this);
		finish.addActionListener(this);
		restart.addActionListener(this);
		loginbtn.addActionListener(this);
		scores.addActionListener(this);

		q1a.addActionListener(this);
		q1b.addActionListener(this);
		q1c.addActionListener(this);
		q1d.addActionListener(this);

		q2a.addActionListener(this);
		q2b.addActionListener(this);
		q2c.addActionListener(this);
		q2d.addActionListener(this);

		q3a.addActionListener(this);
		q3b.addActionListener(this);
		q3c.addActionListener(this);
		q3d.addActionListener(this);

		q4a.addActionListener(this);
		q4b.addActionListener(this);
		q4c.addActionListener(this);
		q4d.addActionListener(this);

		q5a.addActionListener(this);
		q5b.addActionListener(this);
		q5c.addActionListener(this);
		q5d.addActionListener(this);

		q6a.addActionListener(this);
		q6b.addActionListener(this);
		q6c.addActionListener(this);
		q6d.addActionListener(this);

		q7a.addActionListener(this);
		q7b.addActionListener(this);
		q7c.addActionListener(this);
		q7d.addActionListener(this);

		q8a.addActionListener(this);
		q8b.addActionListener(this);
		q8c.addActionListener(this);
		q8d.addActionListener(this);

		q9a.addActionListener(this);
		q9b.addActionListener(this);
		q9c.addActionListener(this);
		q9d.addActionListener(this);

		q10a.addActionListener(this);
		q10b.addActionListener(this);
		q10c.addActionListener(this);
		q10d.addActionListener(this);

		validate();

	}

	public void actionPerformed(ActionEvent ae) {
		cardOperations(ae);
		storeAnswer(ae);
	}

	private void cardOperations(ActionEvent ae) {
		if (ae.getSource() == start) {
			mainPanel.remove(startPanel);
			// mainPanel.add(optionPanel,BorderLayout.SOUTH);
			cardl.next(subPanel);
		}
		if (ae.getSource() == loginbtn) {
			mainPanel.add(optionPanel, BorderLayout.SOUTH);
			
				if (username.getText() != null) {
					JOptionPane.showMessageDialog(null, "Welcome"+ username.getText());
					cardl.next(subPanel);
				} else {
					JOptionPane.showMessageDialog(null, "Invalid Username !");
				}
				System.out.println("Inserted..!!!");
//        		con.close();
			
		}
		if (ae.getSource() == scores) {
			
			this.setVisible(false);
			this.dispose();
			LoginPage obj = new LoginPage();
			obj.setSize(400,500);
			obj.setVisible(true);
			

		}

		if (ae.getSource() == quit) {
			cardl.last(subPanel);
			mainPanel.remove(optionPanel);
			mainPanel.add(finishPanel, BorderLayout.SOUTH);
		} else if (ae.getSource() == next) {
//			if (userAnswers[nextCount] != null) {
			nextCount++;	
			cardl.next(subPanel);
				
//			} else {
//				JOptionPane.showMessageDialog(null, "Please Select One Option !");
//			}
			if (nextCount == 10) {
				mainPanel.remove(optionPanel);
				mainPanel.add(finishPanel, BorderLayout.SOUTH);
				scoreBoard();
				try {
					Connection con = null;
					Class.forName("org.sqlite.JDBC");
					con = DriverManager.getConnection("jdbc:sqlite:Scores.db");
//            		Statement stmt = con.createStatement();
					PreparedStatement ps = null;
					String sql = "INSERT INTO details(name,correct,wrong,unattempted,totalscore) VALUES(?,?,?,?,?)";
					ps = con.prepareStatement(sql);
					ps.setString(1, username.getText());
					ps.setInt(2, rightCount);
					ps.setInt(3, wrongCount);
					ps.setInt(4, unattemptedCount);
					ps.setDouble(5, total_score);
					ps.execute();
					System.out.println("Inserted..!!!");
					con.close();
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
		}

		if (ae.getSource() == finish) {
			// System.exit(0);
			new FinishDialog(this, "Finish");
		} else if (ae.getSource() == restart) {
			OnlineMcq newObj = new OnlineMcq();
			newObj.setVisible(true);
			this.setVisible(false);
			System.gc();
		}
	}

	private void scoreBoard() {

		for (int i = 0; i < 10; i++) {
			if (rightAnswers[i].equals(userAnswers[i])) {
				rightCount++;
			}

			else if (userAnswers[i] == null) {
				unattemptedCount++;
			} else {
				wrongCount++;
			}

			System.out.println("Array content at index " + i + " is :" + userAnswers[i]);
		}
		double neg_mark = wrongCount * 0.25;
//        System.out.println(rightCount - neg_mark)  ;
		total_score = rightCount - neg_mark;
		System.out.println(total_score);
		if (rightCount == 0) {
			message.setText("LEARNIG FROM FAILURE CAN TAKE YOU TO SUCCESS!!!");
		} else if (rightCount == 1) {
			message.setText("YOU CAN DO BETTER!!!");
		} else if (rightCount == 2) {
			message.setText("YOU CAN DO THIS!!!");
		} else if (rightCount == 3) {
			message.setText("YOU HAVE GOT THIS!!!");
		} else if (rightCount == 4) {
			message.setText("YOU HAVE GOT THIS!!!");
		} else if (rightCount == 5) {
			message.setText("YOU HAVE GOT THIS!!!");
		} else if (rightCount == 6) {
			message.setText("YOU HAVE GOT THIS!!!");
		} else if (rightCount == 7) {
			message.setText("YOU HAVE GOT THIS!!!");
		} else if (rightCount == 8) {
			message.setText("YOU HAVE GOT THIS!!!");
		} else if (rightCount == 9) {
			message.setText("ONE STEP AWAY FROM YOUR GOAL :)");
		} else if (rightCount == 10) {
			message.setText("CONGRATULATIONS! YOU HAVE MADE IT TO YOUR GOAL :)");
		}

		txtCorrect.setText("" + rightCount);
		txtWrong.setText("" + wrongCount);
		txtunattempted.setText(""+ unattemptedCount);
		txtScore.setText("" + total_score + "/10");
	}

	private void storeAnswer(ActionEvent ae) {

		if (ae.getSource() == q1a) {
			userAnswers[0] = q1a.getText();

		} else if (ae.getSource() == q1b)
			userAnswers[0] = q1b.getText();
		else if (ae.getSource() == q1c)
			userAnswers[0] = q1c.getText();
		else if (ae.getSource() == q1d)
			userAnswers[0] = q1d.getText();
//        else if (grp1.getSelection()==null) {
//        	JOptionPane.showMessageDialog(null, "Select One!");
//        }

		if (ae.getSource() == q2a)
			userAnswers[1] = q2a.getText();
		else if (ae.getSource() == q2b)
			userAnswers[1] = q2b.getText();
		else if (ae.getSource() == q2c)
			userAnswers[1] = q2c.getText();
		else if (ae.getSource() == q2d)
			userAnswers[1] = q2d.getText();

		if (ae.getSource() == q3a)
			userAnswers[2] = q3a.getText();
		else if (ae.getSource() == q3b)
			userAnswers[2] = q3b.getText();
		else if (ae.getSource() == q3c)
			userAnswers[2] = q3c.getText();
		else if (ae.getSource() == q3d)
			userAnswers[2] = q3d.getText();

		if (ae.getSource() == q4a)
			userAnswers[3] = q4a.getText();
		else if (ae.getSource() == q4b)
			userAnswers[3] = q4b.getText();
		else if (ae.getSource() == q4c)
			userAnswers[3] = q4c.getText();
		else if (ae.getSource() == q4d)
			userAnswers[3] = q4d.getText();

		if (ae.getSource() == q5a)
			userAnswers[4] = q5a.getText();
		else if (ae.getSource() == q5b)
			userAnswers[4] = q5b.getText();
		else if (ae.getSource() == q5c)
			userAnswers[4] = q5c.getText();
		else if (ae.getSource() == q5d)
			userAnswers[4] = q5d.getText();

		if (ae.getSource() == q6a)
			userAnswers[5] = q6a.getText();
		else if (ae.getSource() == q6b)
			userAnswers[5] = q6b.getText();
		else if (ae.getSource() == q6c)
			userAnswers[5] = q6c.getText();
		else if (ae.getSource() == q6d)
			userAnswers[5] = q6d.getText();

		if (ae.getSource() == q7a)
			userAnswers[6] = q7a.getText();
		else if (ae.getSource() == q7b)
			userAnswers[6] = q7b.getText();
		else if (ae.getSource() == q7c)
			userAnswers[6] = q7c.getText();
		else if (ae.getSource() == q7d)
			userAnswers[6] = q7d.getText();

		if (ae.getSource() == q8a)
			userAnswers[7] = q8a.getText();
		else if (ae.getSource() == q8b)
			userAnswers[7] = q8b.getText();
		else if (ae.getSource() == q8c)
			userAnswers[7] = q8c.getText();
		else if (ae.getSource() == q8d)
			userAnswers[7] = q8d.getText();

		if (ae.getSource() == q9a)
			userAnswers[8] = q5a.getText();
		else if (ae.getSource() == q9b)
			userAnswers[8] = q9b.getText();
		else if (ae.getSource() == q9c)
			userAnswers[8] = q9c.getText();
		else if (ae.getSource() == q9d)
			userAnswers[8] = q9d.getText();

		if (ae.getSource() == q10a)
			userAnswers[9] = q10a.getText();
		else if (ae.getSource() == q10b)
			userAnswers[9] = q10b.getText();
		else if (ae.getSource() == q10c)
			userAnswers[9] = q10c.getText();
		else if (ae.getSource() == q10d)
			userAnswers[9] = q10d.getText();

	}

	public static void main(String[] args) {
		OnlineMcq obj = new OnlineMcq();
		obj.setVisible(true);
	}
}
/*
 * 
 * CENTER left right centre
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */