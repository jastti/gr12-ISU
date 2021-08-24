Readme.txt – Takeout Management System - Jasmine Tian - ICS4U - Ms. Wong - ISU

- Hints on how to use Takeout Management System:

Run in: tt.java(Graphic)
        Menu.java(Console)

Windows can go like: User System page --> Login page --> User System page
                or   User System page --> Login page --> Admin System page --> User System page
                
    1: User System page:
       User System is for the user to add orders, cancel orders, and view (current user's) history orders
       Add Order:
        1) Choose a user as an identity from the combobox
        2) Choose a dish to order
        3) Enter amount of the dish the user chose(User can ONLY input an integer)
        4) Click "Add Order" button to add an order
        
       Cancel Order:
        1) Click "Cancel Order" button
        2）Enter the correct order ID that user want to cancel in the pop-up window
        
       Other:
        - Click "My History Order" button to view history order of current user
        - Click "Admin Login" button to Login page of Admin Login
        - Click "Exit" button to exit the whole Takeout System
        
    2: Click "Change to Admin Login" button to Login page of Admin Login
    
    
    3: Login page: login with correct admin account and password
        **This login page is for administrator ONLY. User doesn't required to login
        By default:
        Admin Account: admin
        Admin Password: 123456
        Click "Admin Login" button to reach Admin System page
        Click "User System" button to back to User System page
    
    4: Admin System page:
       Admin System is for the administrator to add/delete/search/view user, delete/ view order, add/delete dish and view dish menu
       
        User:
        1) Click "User list" button to display user list
        2) To delete a user, type into correct user ID first, then click "delete" button beside
        3) To search a user, type into correct user ID first, then click "search" button beside
        4) To add a user, type into user ID and user name first, then click "Add user" button under
        
        Dish:
        1) Click "Menu" button to display dish menu
        2) To delete a dish, type into correct dish ID first, then click "delete" button beside
        3) To search a type of dishes, type into correct dish type first, then click "search" button beside
        4) To add a dish, type into dish ID, dish name, dish type, and dish price first, then click "Add dish" button under
        
        Order:
        1) Click "Order list" button to display order list
        2) To delete an order, type into correct order ID first, then click "delete" button beside
        
        Other:
        - Click "Change to User System" button to change to User System page directly(without login)
        - Click "Exit" button to exit the whole Takeout System
        
        
    5: Click "Change to User System" button to change to User System page directly
    
    
    
– Functionalities missing from your original plan for the management system
    Admin System:
    1. View the information of the dishes by types in Graphic(can work in Console; but still can view all the dishes in Graphic)
    2. Modify the order status according to the order id(found out that this function doesn't fit the whole ideas of the system)
    
    
– Any additional functionalities added from your original plan

    Admin System:
    1. Search dish by its ID
    2. Remove an order by its ID
    3. Change to User System directly
    
    User System:
    1. Cancel current user's own order
    2. Change to Login page
    3. Choose user/ dish from comboBox
    
    Login:
    1. Admin login ONLY
    2. Can choose whether to back to User System page or Login to Admin System
    
    Other:
    1. While making any change to User/ Dish/ Order, write into the files to save the change
    2. Read the new update file of info to show User/ Dish/ Order
    3. Check if user/ dish/ order ID is unique and increase the ID in a formal way
    4. Add some of protection on input(Amount: cannot input characters)
    5. Add scrollPane
    6. Sort user list/ order list/ menu
    
    
– Known bugs / errors in your game
    1. Didn't finish some error check: check input in correct way
    2. After changing dish price in Admin System and back to User System, need to click "add" to do the update display
    
    
– Any other important info for me to play/mark your management system
    For login, I only did admin login with correct account and password, but no user login. This is because I want to design the system just like McDonald -- user doesn't need to login, just need to choose/ add user as identity to order.
    
    For Graphic design, I did some change to User System - I used comboBox for user to choose identity and dish, which makes the whole page looks more clear and easier to use.