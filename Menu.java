package Tsystem;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import javax.sound.midi.Soundbank;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Menu {
	static AdminSystem admin = new AdminSystem();
    Scanner sc = new Scanner(System.in);
    static Menu menu = new Menu();
    static User u = new User();
    static Order o = new Order();
    static Dish d = new Dish();
    static UserSystem us = new UserSystem();
    static OrderSystem os = new OrderSystem();
    static DishSystem ds = new DishSystem();
    // menu
    
    static JFrame frame = new JFrame("Login");
	static JFrame uFrame = new JFrame("User System");
	static JFrame aFrame = new JFrame("Admin System");
	// frames

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
			admin.addMessage();
			menu.showMenu();
		// user System
				uFrame.setBounds(250, 100, 800, 600);
				JPanel uPanel = new JPanel();
				uPanel.setBounds(200, 100, 800, 600);
				uPanel.setLayout(null);
				
				JLabel lbluName = new JLabel("User name");
				lbluName.setBounds(90, 20, 150, 30);
				lbluName.setFont(new Font("SimSun", Font.BOLD, 14));
				uPanel.add(lbluName);
				
				JComboBox userCombo = new JComboBox();
				userCombo.setBounds(190, 20, 160, 25);
				uPanel.add(userCombo);
				
				JLabel lbldType = new JLabel("Dish Type");
				lbldType.setBounds(90, 50, 150, 30);
				lbldType.setFont(new Font("SimSun", Font.BOLD, 14));
				uPanel.add(lbldType);
				
				JComboBox dishTCombo = new JComboBox();
				dishTCombo.setBounds(90, 80, 120, 25);
				uPanel.add(dishTCombo);
				
				JLabel lbldName = new JLabel("Dish name");
				lbldName.setBounds(230, 50, 150, 30);
				lbldName.setFont(new Font("SimSun", Font.BOLD, 14));
				uPanel.add(lbldName);
				
				JComboBox dishNCombo = new JComboBox();
				dishNCombo.setBounds(230, 80, 120, 25);
				uPanel.add(dishNCombo);
				
				JLabel lblAmount = new JLabel("Amount");
				lblAmount.setBounds(410, 50, 150, 30);
				lblAmount.setFont(new Font("SimSun", Font.BOLD, 14));
				uPanel.add(lblAmount);
				
				JTextField amText = new JTextField();
				amText.setBounds(410, 80, 50, 25);
				uPanel.add(amText);
				
//				JLabel lbloID = new JLabel("Order ID");
//				lbloID.setBounds(410, 50, 150, 30);
//				lbloID.setFont(new Font("SimSun", Font.BOLD, 14));
//				uPanel.add(lbloID);
//				
//				JTextField oiText = new JTextField();
//				oiText.setBounds(410, 80, 50, 25);
//				uPanel.add(oiText);
				
				JButton cAdmin = new JButton("Admin Login");
				cAdmin.setBounds(520, 40, 150, 25);
				cAdmin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String eventName = e.getActionCommand();
						// initialize 
						if(eventName.equals("Admin Login")) {
							loginPage();
							uFrame.setVisible(false);
						}
					}
				});
				uPanel.add(cAdmin);
				
				JButton uExit = new JButton("Exit");
				uExit.setBounds(520, 80, 150, 25);
				uExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String eventName = e.getActionCommand();
						// initialize 
						if(eventName.equals("Exit")) {
							System.exit(0);
						}
					}
				});
				uPanel.add(uExit);
				
				JButton uAdd = new JButton("Add Order");
				uAdd.setBounds(90, 130, 180, 25);
				uAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String eventName = e.getActionCommand();
						// initialize 
						if(eventName.equals("Add Order")) {
							String input = "";
							int amNum = 0;
							
								try {
									input = amText.getText();
									System.out.println(input);
									if (input != null) {
										amNum = Integer.valueOf(input);
										/*
    									 * else if(admin.find(info[0]) != null && Objects.equals(admin.find(info[0]).getAdminPswd(), info[1])) {
              								adminMenu();
          										} 
    									 */
										// if input isn't null, convert the input string into num in integer
									}
									if(amNum <= 0) {
										JOptionPane.showMessageDialog(frame,
												(Object) "Please enter a positive integer!", "Play",
												JOptionPane.INFORMATION_MESSAGE);
									} else {
										System.out.println(amNum);
//									admin.buyDish(u, );
//						            menu.userMenu(u);
//										System.out.println(o.getOrderNum());
//						            break;
									}
								} catch (Exception e2) {
									JOptionPane.showMessageDialog(frame,
											(Object) "Please enter a positive integer!", "Play",
											JOptionPane.INFORMATION_MESSAGE);
//									 if the number input is informal, show the notice of re-input
//									break;
								}
							
						}
					}
				});
				uPanel.add(uAdd);
				
				JButton uDel = new JButton("Cancel Order");
				uDel.setBounds(290, 130, 180, 25);
				uDel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String eventName = e.getActionCommand();
						// initialize 
						if(eventName.equals("Cancel Order")) {
//							System.exit(0);
							String cancel = "";
							try {
								JOptionPane.showMessageDialog(frame,
								(Object) "Please enter order ID of the order you want to delete", "Play",
								JOptionPane.INFORMATION_MESSAGE);
								JTextField oiText = new JTextField();
								
							} catch (Exception e2) {
								// TODO: handle exception
							}
							admin.deleteOrder();
							
						}
					}
				});
				uPanel.add(uDel);
				
				JButton uOrd = new JButton("My History Order");
				uOrd.setBounds(490, 130, 180, 25);
				uOrd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String eventName = e.getActionCommand();
						// initialize 
						if(eventName.equals("My History Order")) {
//							System.exit(0);
						}
					}
				});
				uPanel.add(uOrd);
				
				JTextArea uDisplay = new JTextArea();
				uDisplay.setBounds(80, 190, 600, 340);
				uPanel.add(uDisplay);
				
				uFrame.add(uPanel);
				uFrame.setVisible(true);
				

//		User u = new User();
//		menu.showMenu();
//		menu.adminMenu();
//		menu.userMenu(u);
	}
	
	public static void closeThis() {
		frame.dispose();
	}

	public static void loginPage() {
		// TODO Auto-generated method stub
    	//Log in Page
    			frame.setBounds(450, 200, 450, 300);
    			JPanel panel = new JPanel();
    			panel.setBounds(100, 100, 450, 300);
    			panel.setLayout(null);
    			
    			JLabel lblPage = new JLabel("Login Page");
    			lblPage.setBounds(160, 10, 150, 30);
    			lblPage.setFont(new Font("SimSun", Font.BOLD, 18));
    			panel.add(lblPage);
    			
    			JLabel idLabel = new JLabel("Account: ");
    			idLabel.setBounds(50, 50, 80, 20);
    			panel.add(idLabel);
    			
    			JTextField idText = new JTextField();
    			idText.setBounds(140, 50, 80, 20);
    			panel.add(idText);
    			
    			JLabel lblNewLabel = new JLabel("(User doesn't need to login)");
    			lblNewLabel.setFont(new Font("SimSun", Font.PLAIN, 10));
    			lblNewLabel.setBounds(230, 50, 170, 20);
    			panel.add(lblNewLabel);
    			
    			JLabel psLabel = new JLabel("Password:");
    			psLabel.setBounds(50, 80, 80, 20);
    			panel.add(psLabel);
    			
    			JTextField psText = new JTextField();
    			psText.setBounds(140, 80, 80, 20);
    			panel.add(psText);
    			
    	//按钮
    			JButton button = new JButton("User System");
    			button.setBounds(60, 130, 150, 35);
    			panel.add(button);
    	//添加点击事件监听器（你可以使用任何其他监听，看你想在什么情况下创建新的窗口了）
    			button.addActionListener(new ActionListener() {
    	//单击按钮执行的方法
    				public void actionPerformed(ActionEvent e) {
    					closeThis();
    					uFrame.setVisible(true);
    				}
    			});
    			
    			//按钮
    					JButton button1 = new JButton("Admin LogIn");
    					button1.setBounds(230, 130, 150, 35);
    					panel.add(button1);
    			//在窗体上添加按钮
    					frame.add(panel);
    			//显示窗体
    					frame.setVisible(true);
    			//添加点击事件监听器（你可以使用任何其他监听，看你想在什么情况下创建新的窗口了）
    					button1.addActionListener(new ActionListener() {
    			//单击按钮执行的方法
    						public void actionPerformed(ActionEvent e) {
    							String aID = "";
    							String aPd = "";
//    							while(true) {
    								try {
    									aID = idText.getText();
	    						    	aPd = psText.getText();
	    						    	System.out.println("acc:"+aID+", apd："+aPd);
	    						    	System.out.println(admin.find(aID));
	    						    	System.out.println(admin.find(aID).getAdminPswd());
	    						    	/*
	    						    	 * else if(admin.find(info[0]) != null && Objects.equals(admin.find(info[0]).getAdminPswd(), info[1])) {
              								adminMenu();
          } 
	    						    	 */
    									if(admin.find(aID) != null && Objects.equals(admin.find(aID).getAdminPswd(), aPd)) {
    										System.out.println("yes");
    										closeThis();
    										AdminPage();
    	        							aFrame.setVisible(true);
    	    						          } 
    									/*
    									 * else if(admin.find(info[0]) != null && Objects.equals(admin.find(info[0]).getAdminPswd(), info[1])) {
              								adminMenu();
          										} 
    									 */
    									else {
    										JOptionPane.showMessageDialog(frame,
	    											(Object) "Please enter account and password!", "Play",
	    											JOptionPane.INFORMATION_MESSAGE);
	    									// if the num input is informal, show the notice
//	    						          break;
    									}
    									// adminMenu();
//    	    							closeThis();
//    	    							AdminPage();
//    	    							aFrame.setVisible(true);
									} catch (Exception e2) {
										// TODO: handle exception
										JOptionPane.showMessageDialog(frame,
												(Object) "Please enter correct account and password", "Play",
												JOptionPane.INFORMATION_MESSAGE);
										// if the num input is informal, show the notice
//										break;
									}
    							
//    						}
    						}
    					});
    					
    	    			JButton exit = new JButton("Exit");
    	    			exit.setBounds(170, 180, 110, 35);
    	    			exit.addActionListener(new ActionListener() {
    	    	//单击按钮执行的方法
    	    				public void actionPerformed(ActionEvent e) {
    	    					String eventName = e.getActionCommand();
    	    					Frame frame = null;
    	    					AbstractButton message;
    	    					// initialize 
    	    					if(eventName.equals("Exit")) {
    	    						System.exit(0);
    	    					}
    	    				}
    	    			});
    	    			panel.add(exit);
	}

	public static void AdminPage() {
		// Admin page
				aFrame.setBounds(150, 25, 1100, 700);
				JPanel aPanel = new JPanel();
				aPanel.setBounds(250, 100, 800, 600);
				aPanel.setLayout(null);
				
				JTextArea uDisplay = new JTextArea();
				uDisplay.setBounds(550, 105, 450, 400);
				aPanel.add(uDisplay);
				
				// user
				JLabel lbluser = new JLabel("User: ");
				lbluser.setBounds(70, 20, 150, 30);
				lbluser.setFont(new Font("SimSun", Font.BOLD, 14));
				aPanel.add(lbluser);
				
				JButton uList = new JButton("User list");
				uList.setBounds(130, 20, 150, 25);
				uList.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String eventName = e.getActionCommand();
						// initialize 
						if(eventName.equals("User list")) {
							try {
								List<User> usList = us.findAll();
								if(usList.equals(null) || usList.isEmpty()) {
									JOptionPane.showMessageDialog(frame,
											(Object) "There is no user to display so far!", "Play",
											JOptionPane.INFORMATION_MESSAGE);
									System.out.println("no user displayed");
								} else {
								admin.viewUser();
								uDisplay.setText(null);
								uDisplay.append("User List: \n");
								for(User user:usList) {
									uDisplay.append("\n" + user+"\n");
									}
								System.out.println("user displayed");
//								System.out.println(usList);
								}
							} catch (Exception e2) {
								// TODO: handle exception
//								JOptionPane.showMessageDialog(frame,
//										(Object) "There is no user to display so far!", "Play",
//										JOptionPane.INFORMATION_MESSAGE);
								// if the num input is informal, show the notice
							}
						}
					}
				});
				aPanel.add(uList);
				
				JLabel lbluID = new JLabel("User ID");
				lbluID.setBounds(70, 65, 150, 30);
				lbluID.setFont(new Font("SimSun", Font.BOLD, 14));
				aPanel.add(lbluID);
				
				JTextField uIDText = new JTextField();
				uIDText.setBounds(130, 65, 120, 25);
				aPanel.add(uIDText);
				
				JButton delU = new JButton("Delete");
				delU.setBounds(280, 65, 80, 25);
				delU.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String eventName = e.getActionCommand();
						// initialize 
						if(eventName.equals("Delete")) {
							try {
								String uidString = "";
								uidString = uIDText.getText();
								System.out.println(uidString);
								System.out.println(us.find(uidString).getUserID());
								if(us.find(uidString) != null && Objects.equals(us.find(uidString).getUserID(), uidString)) {
									uDisplay.setText(null);
									uDisplay.append("\n" + admin.findUser(uidString).toString()+" deleted\n");
									us.delete(uidString);
									System.out.println("deleted");
								}
								else {
									JOptionPane.showMessageDialog(frame,
											(Object) "User cannot found!", "Play",
											JOptionPane.INFORMATION_MESSAGE);
										System.out.println("Wrong");
									}
									
							} catch (Exception e2) {
								// TODO: handle exception
								JOptionPane.showMessageDialog(frame,
										(Object) "User cannot found!", "Play",
										JOptionPane.INFORMATION_MESSAGE);
									System.out.println("Wrong");
							}
						}
					}
				});
				aPanel.add(delU);
				
				JButton searU = new JButton("Search");
				searU.setBounds(370, 65, 80, 25);
				searU.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String eventName = e.getActionCommand();
						// initialize 
						if(eventName.equals("Search")) {
							try {
								String uidString = "";
								uidString = uIDText.getText();
								System.out.println(uidString);
								System.out.println(us.find(uidString).getUserID());
								if(us.find(uidString) != null && Objects.equals(us.find(uidString).getUserID(), uidString)) {
									admin.findUser(uidString);
//									us.find(uidString);
									System.out.println("user found");
									uDisplay.setText(null);
									uDisplay.append("\nFound: " + admin.findUser(uidString).toString());
								}
								else {
									JOptionPane.showMessageDialog(frame,
											(Object) "Please enter correct user ID", "Play",
											JOptionPane.INFORMATION_MESSAGE);
										System.out.println("Wrong");
									}
									
							} catch (Exception e2) {
								// TODO: handle exception
								JOptionPane.showMessageDialog(frame,
										(Object) "User cannot found!", "Play",
										JOptionPane.INFORMATION_MESSAGE);
									System.out.println("Wrong");
							}
						}
					}
				});
				aPanel.add(searU);
				
				JLabel lbluName = new JLabel("User name");
				lbluName.setBounds(55, 110, 150, 30);
				lbluName.setFont(new Font("SimSun", Font.BOLD, 14));
				aPanel.add(lbluName);
				
				JTextField uNText = new JTextField();
				uNText.setBounds(130, 110, 120, 25);
				aPanel.add(uNText);
				
				JButton addU = new JButton("Add user");
				addU.setBounds(130, 155, 150, 25);
				addU.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String eventName = e.getActionCommand();
						// initialize 
						if(eventName.equals("Add user")) {
							try {
								String uidString = "";
								String uNameString = "";
								uidString = uIDText.getText();
								uNameString = uNText.getText();
								System.out.println(uidString);
								
								if(uidString!=null && uNameString!=null) {
//									admin.findUser(uidString);
//									admin.addUser();
									admin.addUser();
									us.add(u);
									System.out.println(u.toString());
//									System.out.println("user added");
								}
								else {
									JOptionPane.showMessageDialog(frame,
											(Object) "Please enter user ID/ user name", "Play",
											JOptionPane.INFORMATION_MESSAGE);
										System.out.println("Wrong");
									}
									
							} catch (Exception e2) {
								// TODO: handle exception
								JOptionPane.showMessageDialog(frame,
										(Object) "Unable to add! Re-enter", "Play",
										JOptionPane.INFORMATION_MESSAGE);
									System.out.println("Wrong");
							}
						}
					}
				});
				aPanel.add(addU);
				
				
				// dish
						JLabel lbldish = new JLabel("Dish: ");
						lbldish.setBounds(70, 240, 150, 30);
						lbldish.setFont(new Font("SimSun", Font.BOLD, 14));
						aPanel.add(lbldish);
						
						JButton menu = new JButton("Menu");
						menu.setBounds(130, 240, 150, 25);
						menu.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String eventName = e.getActionCommand();
								// initialize 
								if(eventName.equals("Menu")) {
									try {
										List<Dish> menu = ds.findAll();
										// Todo: append
										if(menu.equals(null) || menu.isEmpty()) {
											JOptionPane.showMessageDialog(frame,
													(Object) "There is no user to display so far!", "Play",
													JOptionPane.INFORMATION_MESSAGE);
											System.out.println("no user displayed");
										} else {
										admin.viewAllDish();
										uDisplay.setText(null);
										uDisplay.append("Menu: \n");
										for(Dish dish:menu) {
										uDisplay.append("\n" + dish+"\n");
										}
										System.out.println("dish menu displayed");
//										System.out.println(usList);
										}
									} catch (Exception e2) {
										// TODO: handle exception
									}
								}
							}
						});
						aPanel.add(menu);
						
						JLabel lbldID = new JLabel("Dish ID");
						lbldID.setBounds(70, 285, 150, 30);
						lbldID.setFont(new Font("SimSun", Font.BOLD, 14));
						aPanel.add(lbldID);
						
						JTextField dIDText = new JTextField();
						dIDText.setBounds(130, 285, 120, 25);
						aPanel.add(dIDText);
						
						JButton delD = new JButton("Delete");
						delD.setBounds(280, 285, 80, 25);
						delD.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String eventName = e.getActionCommand();
								// initialize 
								if(eventName.equals("Delete")) {
									try {
										String didString = "";
										didString = dIDText.getText();
										System.out.println(didString);
										System.out.println(ds.find(didString).getDishID());
										if(ds.find(didString) != null && Objects.equals(ds.find(didString).getDishID(), didString)) {
											uDisplay.setText(null);
											uDisplay.append("\n" + ds.find(didString).toString()+" deleted\n");
											ds.delete(didString);
											System.out.println("deleted");
										}
										else {
											JOptionPane.showMessageDialog(frame,
													(Object) "Dish cannot found!", "Play",
													JOptionPane.INFORMATION_MESSAGE);
												System.out.println("Wrong");
											}
											
									} catch (Exception e2) {
										// TODO: handle exception
										JOptionPane.showMessageDialog(frame,
												(Object) "Dish cannot found!", "Play",
												JOptionPane.INFORMATION_MESSAGE);
											System.out.println("Wrong");
									}
								}
							}
						});
						aPanel.add(delD);
						
						JLabel lbldName = new JLabel("Dish name");
						lbldName.setBounds(55, 330, 150, 30);
						lbldName.setFont(new Font("SimSun", Font.BOLD, 14));
						aPanel.add(lbldName);
						
						JTextField dNText = new JTextField();
						dNText.setBounds(130, 330, 120, 25);
						aPanel.add(dNText);
						
						JLabel lbldType = new JLabel("Dish type");
						lbldType.setBounds(55, 375, 150, 30);
						lbldType.setFont(new Font("SimSun", Font.BOLD, 14));
						aPanel.add(lbldType);
						
						JTextField dTText = new JTextField();
						dTText.setBounds(130, 375, 120, 25);
						aPanel.add(dTText);
						
						JButton searD = new JButton("Search");
						searD.setBounds(280, 375, 80, 25);
						searD.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String eventName = e.getActionCommand();
								// initialize 
								if(eventName.equals("Search")) {
//									try {
//										// ToDO： 判断条件
//										String ttString = "";
//										ttString = dTText.getText();
//										List<Dish> list = new ArrayList<>();
//								        for (String key : ds.ds) {
//								        	list.add(d);
//								            if (Objects.equals(ttString, ds.findByType(ttString))) {
//								                list.add(ds.);
//								            }
//								        }
//										
//										System.out.println(ttString);
//										System.out.println(ds.findByType(ttString));
//										if(ds.findByType(ttString) != null && Objects.equals(ds.findByType(ttString), ttString)) {
////											admin.findUser(ttString);
////											us.find(uidString);
//											ds.findByType(ttString);
//											System.out.println("dish found");
//											uDisplay.setText(null);
////											uDisplay.append("\nFound: " + ds.findByType(ttString).toString());
//										}
//										else {
//											JOptionPane.showMessageDialog(frame,
//													(Object) "Please enter correct dish type", "Play",
//													JOptionPane.INFORMATION_MESSAGE);
//												System.out.println("Wrong");
//											}
//											
//									} catch (Exception e2) {
//										// TODO: handle exception
//										JOptionPane.showMessageDialog(frame,
//												(Object) "Dish cannot found!", "Play",
//												JOptionPane.INFORMATION_MESSAGE);
//											System.out.println("Wrong");
//									}
								}
							}
						});
						aPanel.add(searD);
						
						JLabel lbldPrice = new JLabel("Dish price");
						lbldPrice.setBounds(55, 420, 150, 30);
						lbldPrice.setFont(new Font("SimSun", Font.BOLD, 14));
						aPanel.add(lbldPrice);
						
						JTextField dPText = new JTextField();
						dPText.setBounds(130, 420, 120, 25);
						aPanel.add(dPText);
						
						JButton addD = new JButton("Add dish");
						addD.setBounds(120, 475, 150, 25);
						addD.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String eventName = e.getActionCommand();
								// initialize 
								if(eventName.equals("Add dish")) {
									
								}
							}
						});
						aPanel.add(addD);
				
						// order
						JLabel lblorder = new JLabel("Order: ");
						lblorder.setBounds(550, 20, 150, 30);
						lblorder.setFont(new Font("SimSun", Font.BOLD, 14));
						aPanel.add(lblorder);
						
						JButton oList = new JButton("Order list");
						oList.setBounds(610, 20, 180, 25);
						oList.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String eventName = e.getActionCommand();
								// initialize 
								if(eventName.equals("Order list")) {
									try {
										List<Order> oList = os.findAll();
										if(oList.equals(null) || oList.isEmpty()) {
											JOptionPane.showMessageDialog(frame,
													(Object) "There is no order to display so far!", "Play",
													JOptionPane.INFORMATION_MESSAGE);
											System.out.println("no order displayed");
										} else {
										admin.showOrderList();
										uDisplay.setText(null);
										uDisplay.append("Order List: \n");
										for(Order order:oList) {
											uDisplay.append("\n" + order+"\n");
											}
										System.out.println("order displayed");
//										System.out.println(usList);
										}
									} catch (Exception e2) {
										// TODO: handle exception
									}
								}
							}
						});
						aPanel.add(oList);
						
						JLabel lbloID = new JLabel("Order ID");
						lbloID.setBounds(550, 65, 150, 30);
						lbloID.setFont(new Font("SimSun", Font.BOLD, 14));
						aPanel.add(lbloID);
						
						JTextField oIDText = new JTextField();
						oIDText.setBounds(610, 65, 120, 25);
						aPanel.add(oIDText);
						
						JButton oDel = new JButton("Delete");
						oDel.setBounds(740, 65, 150, 25);
						oDel.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String eventName = e.getActionCommand();
								// initialize 
								if(eventName.equals("Delete")) {
									
									try {
									String oidString = "";
									oidString = oIDText.getText();
									System.out.println(oidString);
									System.out.println(os.find(oidString).getOrderID());
									if(os.find(oidString) != null && Objects.equals(os.find(oidString).getOrderID(), oidString)) {
										uDisplay.setText(null);
										uDisplay.append("\n" + os.find(oidString).toString()+" deleted\n");
										os.delete(oidString);
										System.out.println("deleted");
									}
									else {
										JOptionPane.showMessageDialog(frame,
												(Object) "Order cannot found!", "Play",
												JOptionPane.INFORMATION_MESSAGE);
											System.out.println("Wrong");
										}
										
								} catch (Exception e2) {
									// TODO: handle exception
									JOptionPane.showMessageDialog(frame,
											(Object) "Order cannot found!", "Play",
											JOptionPane.INFORMATION_MESSAGE);
										System.out.println("Wrong");
								}
								}
							}
						});
						aPanel.add(oDel);
						
						
						
				JButton cUser = new JButton("Change to User System");
				cUser.setBounds(520, 555, 200, 25);
				cUser.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String eventName = e.getActionCommand();
						// initialize 
						if(eventName.equals("Change to User System")) {
							uFrame.setVisible(true);
							aFrame.setVisible(false);
						}
					}
				});
				aPanel.add(cUser);
				
				JButton aExit = new JButton("Exit");
				aExit.setBounds(850, 555, 150, 25);
				aExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String eventName = e.getActionCommand();
						// initialize 
						if(eventName.equals("Exit")) {
							System.exit(0);
						}
					}
				});
				aPanel.add(aExit);
				
				aFrame.add(aPanel);
				aFrame.setVisible(true);
	}

	public void showMenu() throws FileNotFoundException {
        admin.addMessage();
//        while()
        System.out.println("1: Admin; 2: User\nEnter your choice:");
      Scanner s = new Scanner(System.in);
    String str = s.nextLine();
    if(str.equals("1")) {
        System.out.println("Enter account and password(account/password): ");
      String adm = sc.next();
      String[] info = adm.split("/");
      if (info.length < 2) {
          System.out.println("Wrong input! Re-enter: ");
          showMenu();
      } else if(admin.find(info[0]) != null && Objects.equals(admin.find(info[0]).getAdminPswd(), info[1])) {
              adminMenu();
          } 
        adminMenu();
    } else if(str.equals("2")) {
    	System.out.println("User ID:");
    	String UserLogin = sc.next();
    	User user = admin.findUser(UserLogin);
        userMenu(user);
    }

    }
    
	private void userMenu(User user) {
		// TODO Auto-generated method stub
		System.out.println("====【1】Buy Dish=================");
        System.out.println("====【2】Display dish by category===");
        System.out.println("====【3】Display all dishes============");
        System.out.println("====【4】Change to Admin Menu===============");
        System.out.println("====【5】Order list============");
        System.out.println("====【6】Delete order====");
        System.out.println("====【7】Exit==================");
//        System.out.println("====【8】Exit==================");
        System.out.println("请输入您要进行的操作：");
        String n = sc.next();
        switch (n) {
        case "1":
            admin.buyDish(user);
            userMenu(user);
            break;
        case "2":
            admin.DishByType();
            userMenu(user);
            break;
        case "3":
            admin.viewAllDish();
            userMenu(user);
            break;
        case "4":
        	System.out.println("Admin Menu: ");
        	menu.adminMenu();
            break;
        case "5":
            admin.showOrderList(user);
            userMenu(user);
            break;
        case "6":
            admin.deleteOrder();
            userMenu(user);
            break;
        case "7":
            System.out.println("Bye!");
            System.exit(0);
        default:
            System.out.println("Wrong input! Re-enter: ");
            userMenu(user);
        }
	}

	private void adminMenu() {
		// TODO Auto-generated method stub
        System.out.println("====【1】Add dish===============");
        System.out.println("====【2】Display all dishes=======");
        System.out.println("====【3】Display dish by category=====");
        System.out.println("====【4】Change dish price=====");
        System.out.println("====【5】Delete dish=========");
        System.out.println("====【6】Add user================");
        System.out.println("====【7】Display user list=============");
        System.out.println("====【8】Delete user==========");
        System.out.println("====【9】Display order list=============");
        System.out.println("====【10】Delete order====");
        System.out.println("====【11】Change to User Menu=================");
        System.out.println("====【12】Exit=================");
        String m = sc.next();
        switch (m) {
        case "1":
            try {
				admin.addDish();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            adminMenu();
            break;
        case "2":
//            System.out.println("请输入您需要每行显示多少数据：");
//            int pageSize = sc.nextInt();
            admin.viewAllDish();
            adminMenu();
            break;
        case "3":
            admin.DishByType();
            adminMenu();
            break;
        case "4":
            admin.priceChange();
            adminMenu();
            break;
        case "5":
            admin.deleteDish();
            adminMenu();
            break;
        case "6":
            admin.addUser();
            adminMenu();
            break;
        case "7":
            admin.viewUser();
            adminMenu();
            break;
        case "8":
            admin.deleteUser();
            adminMenu();
            break;
        case "9":
            admin.showOrderList();
            adminMenu();
            break;
        case "10":
        	admin.deleteOrder();
        	adminMenu();
            break;
        case "11":
        	System.out.println("User ID:");
        	String UserLogin = sc.next();
        	User user = admin.findUser(UserLogin);
        	System.out.println("User Menu: ");
        	menu.userMenu(user);
            break;
        case "12":
        	System.out.println("Bye!");
            System.exit(0);
            break;
        default:
            System.out.println("Wrong input! Re-enter: ");
            adminMenu();
        }
	}

}
