import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginPage extends JFrame implements ActionListener {
	JPanel jp;
	 Container container;
		CardLayout cardl;
	JLabel lbl,lbl2;
	JTextField login;
	JPasswordField pass;
	JButton submit;
	LoginPage(){
		jp = new JPanel();
		jp.setLayout(new BorderLayout());
		JPanel dummy = new JPanel();
		dummy.setLayout(new GridLayout(2,4));
		JPanel log = new JPanel();
//		log.setLayout(new GridLayout(2,2));
		lbl = new JLabel("Login:           ");
		login = new JTextField(10);
		lbl2 = new JLabel("Password:  ");
		pass = new JPasswordField(10);
		submit = new JButton("Submit");
//		submit.setSize(2,2);
		submit.addActionListener(this);
		dummy.add(lbl);
		dummy.add(login);
		dummy.add(lbl2);
		dummy.add(pass);
		log.add(submit);
		
//		dummy.add(submit);
		jp.add(dummy,BorderLayout.NORTH);
		jp.add(log,BorderLayout.CENTER);
//		JPanel main = new JPanel();
//		main.setLayout(new BorderLayout());
//		main.add(dummy,BorderLayout.NORTH);
//		main.add(log,BorderLayout.CENTER);
		JPanel dummyPanel1 = new JPanel();
		dummyPanel1.setLayout(new GridBagLayout());
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.fill = GridBagConstraints.HORIZONTAL;
		gbc1.gridwidth =2;
		gbc1.gridx = 0;
		gbc1.gridy = 0;
		dummyPanel1.add(lbl, gbc1);
		gbc1.gridx = 2;
		gbc1.gridy = 0;
		dummyPanel1.add(login,gbc1);
		gbc1.gridx = 1;
		gbc1.gridy = 3;
		dummyPanel1.add(lbl2,gbc1);
		gbc1.gridx = 3;
		gbc1.gridy = 3;
		dummyPanel1.add(pass,gbc1);
		gbc1.gridx = 2;
		gbc1.gridy = 4;
		dummyPanel1.add(log,gbc1);
		

		
		jp.add(dummyPanel1,BorderLayout.CENTER);
		
		
//		    jp.setLayout(new GridLayout(2,7));
		    container = getContentPane();
//		    container.add(jp);
	    	container.add(jp);
//	    	container.add(jbtn);
	    	validate();
	}
	public static void main(String[] args) {
		LoginPage obj = new LoginPage();
		obj.setSize(400,500);
		obj.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==submit) {
			if(login.getText().equals("admin")&&pass.getText().equals("admin")) {
				this.setVisible(false);
				this.dispose();
				SampleTable obj = new SampleTable();
				obj.setVisible(true);
				obj.setSize(430, 300);
				obj.readAll();
			}
			else {
				JOptionPane.showMessageDialog(null, "Please Enter Valid Username OR Password!");
				login.setText("");
				pass.setText("");
			}
		}
	}
}
 