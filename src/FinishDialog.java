

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FinishDialog extends Dialog implements ActionListener{
    
    JButton yes,no;
    JLabel dialogMessage;

    FinishDialog(JFrame parent, String title){
    	super(parent,title,false);
    	setVisible(true);
    	setLayout(new BorderLayout());
    	setSize(200,150);
    	dialogMessage = new JLabel("Are you sure you want to exit?");
    	yes = new JButton("Yes");
    	no = new JButton("No");
    	JPanel p1 = new JPanel();
    	p1.setLayout(new GridLayout(0,2));
    	JPanel p2 = new JPanel();
    	p2.add(yes);
    	JPanel p3 = new JPanel();
    	p3.add(no);
    	p1.add(p2);
    	p1.add(p3);
    	add(dialogMessage,BorderLayout.CENTER);
    	add(p1,BorderLayout.SOUTH);
    	yes.addActionListener(this);
    	no.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae){
    	if(ae.getSource() == yes){
    		System.exit(0);
    	}
    	else{
    		dispose();
    	}
    }
}

