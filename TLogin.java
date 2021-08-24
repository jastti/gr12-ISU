package Tsystem;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.awt.event.ActionEvent;

public class TLogin extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField account;
	private JPasswordField passwordField;
	tt frame;
	TAdmin m1;
	static AdminSystem admin = new AdminSystem();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TLogin(tt frame, TAdmin m1) {
		this.frame = frame;
		this.m1 = m1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 196);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(contentPane);
		contentPane.setLayout(null);
		// set panel and frame
		
		JLabel lblNewLabel_1 = new JLabel("Account");
		lblNewLabel_1.setBounds(29, 55, 58, 15);
		contentPane.add(lblNewLabel_1);
		
		account = new JTextField();
		account.setColumns(10);
		account.setBounds(104, 55, 115, 21);
		contentPane.add(account);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(104, 94, 117, 21);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aID = "";
				String aPd = "";
					try {
						aID = account.getText();
				    	aPd = String.valueOf(passwordField.getPassword());
				    	// get account and password from input
				    	System.out.println("acc:"+aID+", apd："+aPd);
				    	System.out.println(admin.find(aID));
				    	System.out.println(admin.find(aID).getAdminPswd());
						if(admin.find(aID) != null && Objects.equals(admin.find(aID).getAdminPswd(), aPd)) 
						{
							// if both account and password are correct
							System.out.println("yes");
							setVisible(false);
							dispose();
							// set invisible to current window
							frame.setVisible(false);
							m1.setVisible(true);
							// open admin system window
							System.out.println("show the login window");
					     } 
						else {
							JOptionPane.showMessageDialog(frame,
									(Object) "Please enter account and password!", "Play",
									JOptionPane.INFORMATION_MESSAGE);
							// display notice
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(frame,
								(Object) "Please enter correct account and password", "Play",
								JOptionPane.INFORMATION_MESSAGE);
						// display notice
					}
			}
		});
		btnLogin.setBounds(284, 51, 97, 23);
		contentPane.add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				m1.setVisible(false);
				setVisible(false);
				System.out.println("go back to user window");
				// change back to user system
			}
		});
		btnCancel.setBounds(284, 93, 97, 23);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setBounds(29, 94, 58, 15);
		contentPane.add(lblNewLabel_1_1);
	}
	
	public JPanel view() {
		return contentPane;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
