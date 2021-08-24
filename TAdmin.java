package Tsystem;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Color;

public class TAdmin extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	static AdminSystem admin = new AdminSystem();
	tt frame;
	// create components

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TAdmin(tt frame) {
		this.frame = frame;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 884, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User");
		lblNewLabel.setBounds(10, 36, 58, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setBounds(10, 69, 58, 15);
		contentPane.add(lblUserId);
		
		JLabel lblUserName = new JLabel("Name");
		lblUserName.setBounds(10, 102, 58, 15);
		contentPane.add(lblUserName);
		
		JLabel lblDish = new JLabel("Dish");
		lblDish.setBounds(10, 213, 58, 15);
		contentPane.add(lblDish);
		
		JLabel lblDishId = new JLabel("Dish ID");
		lblDishId.setBounds(10, 251, 58, 15);
		contentPane.add(lblDishId);
		
		JLabel lblNewLabel_4_1 = new JLabel("Dish Name");
		lblNewLabel_4_1.setBounds(10, 294, 58, 15);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Dish Type");
		lblNewLabel_4_2.setBounds(10, 330, 58, 15);
		contentPane.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("Price");
		lblNewLabel_4_3.setBounds(10, 367, 58, 15);
		contentPane.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_4_4 = new JLabel("Order");
		lblNewLabel_4_4.setBounds(365, 40, 58, 15);
		contentPane.add(lblNewLabel_4_4);
		
		JLabel lblNewLabel_4_5 = new JLabel("Order Id");
		lblNewLabel_4_5.setBounds(365, 76, 58, 15);
		contentPane.add(lblNewLabel_4_5);
		
		textField = new JTextField();//UserID
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setBounds(78, 66, 66, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(78, 96, 66, 21);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(78, 251, 66, 21);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(78, 294, 97, 21);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(78, 330, 97, 21);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(78, 367, 66, 21);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(433, 73, 97, 21);
		contentPane.add(textField_6);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(306, 109, 540, 307);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(306, 109, 540, 307);
		textArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);// 自左到右的展示
		textArea.setRows(100);
		scrollPane.setViewportView(textArea);
		// can add the scrollPane to the textArea.
		
		JButton btnNewButton = new JButton("User List");
		btnNewButton.setBounds(78, 29, 97, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// initialize 
					try {
						textArea.setText(null);
						User[] usList = admin.viewUserToWin();
						if(usList == (null) || usList.length == 0) {
							JOptionPane.showMessageDialog(contentPane,
									(Object) "There is no user to display so far!\n", "Play",
									JOptionPane.INFORMATION_MESSAGE);
							System.out.println("no user displayed");
							// display notice
						} else {
							textArea.append("There are " + usList.length + " users right now! \n");
							textArea.append("User List: \n");
						for(User user:usList) {
							textArea.append("\n" + user+"\n");
							}
						// Iterate usList and display user info line by line
						System.out.println("user displayed");
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String uidString = "";
					uidString = textField.getText();
					System.out.println(uidString);
					if (admin.deleteUserToWin(uidString)==true) {
						textArea.setText(null);
						textArea.append("\n user " + uidString +" was deleted\n");
						// display deleted info
					}
					else {
						JOptionPane.showMessageDialog(contentPane,
								(Object) "User cannot found!", "Play",
								JOptionPane.INFORMATION_MESSAGE);
							System.out.println("Wrong");
							// display notice
						}
						
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(152, 65, 72, 23);
		contentPane.add(btnNewButton_1);
		
		JButton searchUser = new JButton("Search");//search for a user
		searchUser.setBounds(234, 65, 78, 23);
		searchUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String uidString = "";
					uidString = textField.getText();
					System.out.println(uidString);
					User user = admin.findUserToWin(uidString);
					// use user id to find user
					if(user != null) {
						System.out.println("user found");
						textArea.setText(null);
						textArea.append("\nFound: " + user.toString());
						// display found user info
					}
					else {
						textArea.setText(null);
						JOptionPane.showMessageDialog(frame,
								(Object) "Please enter correct user ID", "Play",
								JOptionPane.INFORMATION_MESSAGE);
							System.out.println("Wrong");
							// display notice
					}
						
				} catch (Exception e2) {
					e2.printStackTrace();
			}
			}
		});
		contentPane.add(searchUser);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 133, 58, 15);
		contentPane.add(lblAddress);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(78, 127, 198, 21);
		contentPane.add(textField_7);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(150, 102, 36, 15);
		contentPane.add(lblPhone);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(204, 100, 69, 21);
		contentPane.add(textField_8);
		
		JButton menuList = new JButton("Menu List");
		menuList.setBounds(78, 209, 97, 23);
		menuList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.setText(null);
					Dish[] dsList = admin.viewAllDishToWin();
					if (dsList == (null) || dsList.length == 0) {
						JOptionPane.showMessageDialog(contentPane, (Object) "There is no dishes to display so far!",
								"Play", JOptionPane.INFORMATION_MESSAGE);
						System.out.println("no dish displayed");
						// display notice
					} else {
						textArea.append("There are " + dsList.length + " dishes right now! \n");
						textArea.append("Dish List: \n");
						for (Dish dish : dsList) {
							textArea.append("\n" + dish + "\n");
						}
						// Iterate dsList and display line by line
						System.out.println("dishes displayed");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		contentPane.add(menuList);
		
		JButton dishDelete = new JButton("Delete");
		dishDelete.setBounds(150, 249, 70, 23);
		dishDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(null);
				try {
					String uidString = "";
					uidString = textField_2.getText();
					System.out.println(uidString);
					if (admin.deleteDishToWin(uidString)==true) {
						textArea.append("\n dish " + uidString +" was deleted\n");
					}// display deleted dish info
					else {
						JOptionPane.showMessageDialog(contentPane,
								(Object) "Dish cannot found!", "Play",
								JOptionPane.INFORMATION_MESSAGE);
							System.out.println("Wrong");
							// display notice
						}
						
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		contentPane.add(dishDelete);
		
		JButton btnSearchType = new JButton("Search");
		btnSearchType.setBounds(187, 328, 75, 23);
		btnSearchType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.setText(null);
					String dTypeString = "";
					dTypeString = textField_4.getText();
					System.out.println(dTypeString);
					Dish[] dishes = admin.DishByTypeToWin(dTypeString);
					// find dish by dish type
					if(dishes != null) {
						System.out.println("dish found");
						for (int i = 0; i < dishes.length; i++) {
							textArea.append("\nFound: " + dishes[i].toString());
						}// display found dish info
					}
					else {
						JOptionPane.showMessageDialog(frame,
								(Object) "Please enter correct user ID", "Play",
								JOptionPane.INFORMATION_MESSAGE);
							System.out.println("Can't find the dishes of this type!");
					}// display notice
						
				} catch (Exception e2) {
					e2.printStackTrace();
			}
			}
		});
		contentPane.add(btnSearchType);
		
		JButton btnChangePrice = new JButton("Change");
		btnChangePrice.setBounds(179, 365, 97, 23);
		btnChangePrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				textArea.setText(null);
				String dTypeString = "";
				dTypeString = textField_2.getText();
				Double dPrice = Double.parseDouble(textField_5.getText());
				System.out.println(dTypeString);
				Dish dish = admin.priceChange(dTypeString, dPrice);
				// change price by finding dish with matched dish id
				if(dish != null) {
					System.out.println("Dish's price was changed successfully!");
						textArea.append("\nChanged: " + dish.toString());
				}// display dish info with new price
				else {
					JOptionPane.showMessageDialog(frame,
							(Object) "Please enter correct user ID", "Play",
							JOptionPane.INFORMATION_MESSAGE);
						System.out.println("Can't find the dishes of this type!");
				}// notice display
					
			} catch (Exception e2) {
				e2.printStackTrace();
		}
			}
		});
		contentPane.add(btnChangePrice);
		
		JButton btnOrderList = new JButton("Order List");
		btnOrderList.setBounds(433, 36, 97, 23);
		btnOrderList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.setText(null);
					double ttlPrice = 0;
					List<Order> odList = admin.showOrderListToWin();
					if (odList == (null) || odList.size() == 0) {
						JOptionPane.showMessageDialog(contentPane, (Object) "There is no dishes to display so far!",
								"Play", JOptionPane.INFORMATION_MESSAGE);
						System.out.println("no orders displayed");
						// notice display
					} else {
						textArea.append("There are " + odList.size() + " orders right now! \n");
						textArea.append("Order List: \n");
						for (Order order : odList) {
							ttlPrice = ttlPrice + order.getOrderPrice();
							textArea.append("\n" + order + "\n");
							textArea.append("The total price is " + ttlPrice + " for the order right now! \n");
						}// Iterate odList and display line by line
						System.out.println("Orders displayed");
					}

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		contentPane.add(btnOrderList);
		
		JButton btnOrderDelete = new JButton("Delete");
		btnOrderDelete.setBounds(547, 69, 97, 23);
		btnOrderDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(null);
				try {
					String uidString = "";
					uidString = textField_6.getText();
					System.out.println(uidString);
					if(admin.deleteOrderToWin(uidString)) {
						textArea.append("\t The order: " + uidString + " was deleted! " + "\n");
						}// delete order by id and display
					else {
						JOptionPane.showMessageDialog(contentPane,
								(Object) "Dish cannot found!", "Play",
								JOptionPane.INFORMATION_MESSAGE);
							System.out.println("Wrong");
						} // notice display
						
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		contentPane.add(btnOrderDelete);
		
		JButton btnToUserSys = new JButton("Change to User System");
		btnToUserSys.setForeground(Color.BLUE);
		btnToUserSys.setBounds(680, 32, 170, 23);
		btnToUserSys.addActionListener(this);
		contentPane.add(btnToUserSys);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(712, 65, 121, 23);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin.exitSystem();
				System.exit(0);
				// exit the whole program
			}
		});
		contentPane.add(btnExit);
		
		JButton btnAddUser = new JButton("Add User");
		btnAddUser.setHorizontalAlignment(SwingConstants.RIGHT);
		btnAddUser.setBounds(78, 158, 97, 23);
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.setText(null);
					String uidString = textField.getText();
					String nameString = textField_1.getText();
					String addressString = textField_7.getText();
					String phoneString = textField_8.getText();
					// get user name/ address/ phone
					if (uidString.trim().equals("") || nameString.trim().equals("") 
							|| addressString.trim().equals("") || phoneString.trim().equals("")) {
						JOptionPane.showMessageDialog(contentPane,
								(Object) "Please input the right info!", "Play",
								JOptionPane.INFORMATION_MESSAGE);
						// display notice
					}else {
						User user = admin.addUserToWin(uidString,nameString,
								addressString,phoneString);
						textArea.append("\t The user: " + uidString + " was added! " + "\n");
						textArea.setText(user.toString());
						// add new user and display
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		contentPane.add(btnAddUser); 
		
		JButton btnAddDish = new JButton("Add Dish");
		btnAddDish.setBounds(78, 398, 97, 23);
		btnAddDish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.setText(null);
					String dId = textField_2.getText();
					String dName = textField_3.getText();
					String dTpye = textField_4.getText();
					Double dPrice = Double.parseDouble(textField_5.getText());
					// get dish name/ type/ price
					if (dId.trim().equals("") || dName.trim().equals("") 
							|| dTpye.trim().equals("") || dPrice == 0) {
						JOptionPane.showMessageDialog(contentPane,
								(Object) "Please input the right info!", "Play",
								JOptionPane.INFORMATION_MESSAGE);
						// display notice
					}else {
						Dish dish = admin.addDishToWin(dId,dName, dTpye,dPrice);
						textArea.append("\t The dish: " + dId + " was added! " + "\n");
						textArea.setText(dish.toString());
						// add new dish and display
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		contentPane.add(btnAddDish);
	}
	
	public void actionPerformed (ActionEvent event) {
		String eventName = event.getActionCommand();
		if (eventName.equals ("Change to User System")) {
			frame.setVisible(true);
			setVisible(false);
			admin.viewUserToWin();
			admin.viewAllDishToWin();
			frame.contentPane.repaint();
			// Change to User System, close current window
			System.out.println("show the user window");
		}
	}
}
