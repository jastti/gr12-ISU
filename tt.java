package Tsystem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class tt extends JFrame implements WindowListener {

	// Create JPanel contentPane;
	JPanel contentPane;
	private JTextField orderNum;
	JPanel panel;
	static TAdmin m1;
	static TLogin m2;
	static tt frame;
	static AdminSystem admin = new AdminSystem();
	JComboBox<Dish[]> dishName;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// main method for graphic display
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new tt();
					m1 = new TAdmin(frame);
					m2 = new TLogin(frame, m1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws FileNotFoundException
	 */
	public tt() throws FileNotFoundException {
		admin.addMessage();
		// add default message
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 389);
		contentPane = new JPanel();// New panel
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 171, 569, 169);
		contentPane.add(scrollPane); 
		// Add scrollPane to contentPane to display content in TextArea

		JTextArea textArea = new JTextArea();
		textArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);// 自左到右的展示
		textArea.setRows(100);
		textArea.setBounds(10, 171, 569, 169);
		// new a textArea

		scrollPane.setViewportView(textArea);
		// can add the scrollPane to the textArea.

		JLabel lblNewLabel = new JLabel("User Info");
		lblNewLabel.setBounds(20, 28, 71, 15);
		contentPane.add(lblNewLabel);
		JComboBox<User[]> userCombo = new JComboBox(admin.viewUserToWin());
		userCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(null);
				// clear textArea, current user can only see user's own orders
			}
		});
		userCombo.setBounds(91, 24, 359, 23);
		contentPane.add(userCombo);

		JComboBox<Dish[]> dishName = new JComboBox(admin.viewAllDishToWin());
		dishName.setBounds(20, 105, 359, 23);
		contentPane.add(dishName);

		orderNum = new JTextField();
		orderNum.setBounds(389, 106, 61, 21);
		// Check valid input integer
		orderNum.setDocument(new NumberDocument());
		// set a new NumberDocument and call
		contentPane.add(orderNum);
		orderNum.setColumns(10);

		JLabel dishPrice = new JLabel("Dish Info");
		dishPrice.setBounds(23, 87, 58, 15);
		contentPane.add(dishPrice);

		JButton adminLog = new JButton("Admin Login");
		// By clicking "Admin Login" button
		adminLog.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				System.out.println("show admin login");
				m2.setVisible(true);
				// set current frame invisible, and show login frame
			}
		});
		adminLog.setForeground(Color.BLUE);
		adminLog.setBounds(468, 24, 111, 23);
		contentPane.add(adminLog);

		JLabel lblNewLabel_2 = new JLabel("Amount");
		lblNewLabel_2.setBounds(392, 87, 58, 15);
		contentPane.add(lblNewLabel_2);

		JButton btnQuit = new JButton("Exit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin.exitSystem();
				System.exit(0);
				// exit the whole program
			}
		});
		btnQuit.setBounds(468, 79, 111, 23);
		contentPane.add(btnQuit);

		JButton addOrder = new JButton("Add");
		addOrder.setBounds(55, 138, 97, 23);
		addOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dishName.setModel(new DefaultComboBoxModel(admin.viewAllDishToWin()));
				// Update new info to combobox
				userCombo.setModel(new DefaultComboBoxModel(admin.viewUserToWin()));
				// Update new info to combobox
				User selectedUser = (User) userCombo.getSelectedItem();
				// set user info from combobox
				Dish selectedDish = (Dish) dishName.getSelectedItem();
				// set dish info from combobox

				String input = "";
				// initialize input to protect
				input = orderNum.getText();
				if (!input.equals("")) {
					Integer value = Integer.parseInt(input);
					// get text from textField and change String to Integer
					System.out.println(value);
					Order addedOrder = admin.buyDishToWin(selectedUser, selectedDish.getDishID(), value);
					textArea.setText(null);
					// clear textArea
					textArea.append("\nThe User ID: " + addedOrder.getUserID() + "\t the order ID:"
							+ addedOrder.getOrderID() + "\t Order Time: " + addedOrder.getOrderTime() + "\n");
					textArea.append("Dish ID \tDish Name \t  Dish Price \t" + "Amonut \tSubtotal   \n");
					textArea.append(addedOrder.getDish().getDishID() + "\t" + addedOrder.getDish().getDishName() + "\t  "
							+ addedOrder.getDish().getPrice() + "\t" + addedOrder.getOrderNum() + "\t"
							+ addedOrder.getOrderPrice() + "\n");
					textArea.append("\n*****************\n");
					System.out.println(addedOrder.toString());

				} else {
					JOptionPane.showMessageDialog(contentPane, "Please input the valid amount! ", "warning",
							JOptionPane.PLAIN_MESSAGE);
					// notice window display
				}
			}
		});
		contentPane.add(addOrder);

		JButton cancelOrder = new JButton("Delete");
		cancelOrder.setBounds(182, 138, 97, 23);
		cancelOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String orderID;
				orderID = JOptionPane.showInputDialog(contentPane, "Please enter the order you want to deleted");
				admin.deleteOrderToWin(orderID);
				textArea.setText(null);
				// By clicking "Delete", clear textArea
				if(admin.deleteOrderToWin(orderID)) {
					textArea.append("\t The order: " + orderID + " was deleted! " + "\n");
					}
					else {
						textArea.append("\t No order: " + " was deleted! " + "\n");
					}
			}
		});
		contentPane.add(cancelOrder);

		JButton orderList = new JButton("My History Orders");
		orderList.setBounds(310, 138, 140, 23);
		orderList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Order> orders;
				User selectedUser = (User) userCombo.getSelectedItem();
				// Choose user info from user combobox 
				orders = admin.showOrderListToWin(selectedUser);
				// find order(s) of the selected user
				textArea.setText(null);
				// clear the textArea

				if (orders.isEmpty()) {
					textArea.append("\nThe User ID: " + selectedUser.getUserID() + " has not order right now!\n");
				// If order list is empty, display notice
				}

				for (Iterator<Order> iterator = orders.iterator(); iterator.hasNext();) {
					Order orderItem1 = (Order) iterator.next();
					textArea.append("\nThe User ID: " + orderItem1.getUserID() + "\t the order ID:"
							+ orderItem1.getOrderID() + "\t Order Time: " + orderItem1.getOrderTime() + "\n");
					textArea.append("Dish ID \tDish Name \t  Dish Price \t" + "Quality \tSubtotal   \n");
					textArea.append(orderItem1.getDish().getDishID() + "\t" + orderItem1.getDish().getDishName() + "\t  "
							+ orderItem1.getDish().getPrice() + "\t" + orderItem1.getOrderNum() + "\t"
							+ orderItem1.getOrderPrice() + "\n");
					textArea.append("\n*****************\n");
					// display in formal way
				}
			}
		});
		contentPane.add(orderList);

		JLabel lblPleaseSelectUser = new JLabel("Please Select the User Name");
		lblPleaseSelectUser.setBounds(122, 10, 173, 15);
		contentPane.add(lblPleaseSelectUser);
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		dishName.setModel(new DefaultComboBoxModel(admin.viewAllDishToWin()));
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
	}

}
