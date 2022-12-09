NOTE: DATABASE LOGIN CREDENTIALS HAVE BEEN REMOVED FROM THE CODE. PLEASE USE THE EXECUTABLE IF YOU WISH TO SEE THE APPLICATION IN ACTION.

ABOUT
-----------------
Welcome to the Simply Rugby management application by Renat Oosthuizen. 
This is a prototype application that is meant to be used by Coaches and Secretaries of a rugby club to manage it's members.
It was coded with a combination of Java and MySQL and features a Graphical User Interface.
It allows for different profiles to be created, edited and deleted. It also allows for the creation, editing and deletion of squads.

This application stores data in an online database and will REQUIRE AN INTERNET CONNECTION to use!

The application tracks 2 administrative profiles (Secretaries and Coaches) and 3 non-administrative profiles (Senior Players, Junior Players and Non Players).
By default the database contains 1 Secretary, 1 Coach, 1 Senior Player, 1 Non Player, 3 Junior Players and 1 Squad.

-----------------
  LOGIN DETAILS
-----------------
COACH
Email: georgeh@hotmail.com
Password: GeorgePass

SECRETARY
Email: susanp@gmail.com
Password: password

-------------------
COACH FUNCTIONALITY
-------------------
Once a Coach provides a valid email and password the system will check their account type and will display an appropriate set of menus. 
At all times a Coach will be able to navigate to the My Details page, View Players page and View Squads pages. They are also able to see their name and ID at 
the top of each page as well as the Logout button which will forget the logged user and take them back to the Login page.

On My Details page a Coach is able to edit their details and click the Save button to save them. If the New Password and Repeat Password text fields are not empty and 
contain matching data then the password for the account will be changed to the new password. The application uses password hashing and salting when storing passwords.

The View Players page will display all Player IDs, Names and Player Types for all players.
The Coach can click on a line in the table to select it and the press the Select Player button to view the details of the player.
This will take them to the Player Profile page that shows the details for that player. If they are looking at a Junior Player then they will have the option to click
the More Details button which will take them to the Junior Profile page that shows additional details. This page has a Go Back button that will return the Coach to the 
Player Profile page. Both of these pages also have a Player Skills button that will take the Coach to the Edit Skills page. Here, the Coach can grade the player in various 
categories on a scale from 1 to 5. The Coach can also write comments regarding player skills in those categories as well as make notes regarding any relevant health issues.

The View Squads page will display the Squad IDs and Squad Names for every squad that the Coach is a member of.
The Coach can enter a new squad name and create a new squad which will then appear in the table. The Coach can also click on a line in the table to select it and the press the 
Select Squad button to view the details of the squad in the Edit Squad page. On this page, the Coach can see the name of the squad as well as the names of all the members of the 
squad (including coaches). The Coach can enter Player IDs and Coach IDs for different positions to add/replace players/coaches. They can also delete the squad altogether. 
 

-----------------------
SECRETARY FUNCTIONALITY
-----------------------
Once a Secretary provides a valid email and password the system will check their account type and will display an appropriate set of menus. 
At all times a Secretary will be able to navigate to the My Details page, View Accounts page and Create New Account pages. They are also able to see their name and ID at 
the top of each page as well as the Logout button which will forget the logged user and take them back to the Login page.

On My Details page a Secretary is able to edit their details and click the Save button to save them. If the New Password and Repeat Password text fields are not empty and 
contain matching data then the password for the account will be changed to the new password. The application uses password hashing and salting when storing passwords.

The View Accounts page will display all Profile IDs, Names and Profile Types for all profiles.
The Secretary can click on a line in the table to select it and the press the Select Profile button to view the details of the profile.
This will take them to the Profile page that shows the details for that profile. The Secretary can edit the profile data or delete the profile. If the Secretary is looking 
at another Secretary or Coach profile then they can also reset their password back to "root". If they are looking at a Junior Player then they will not have the option to Save 
on this page but will have the option to click the More Details button which will take them to the Junior Profile page that shows additional details. This page has a Go Back button 
that will return the Secretary to the Profile page as well as the Save button that will save changes from both pages. Edits are remembered when the Secretary navigates between the 
Profile page and the Junior Profile page but they are only saved when the Save button is pressed.

Clicking on Create New Account will prompt the Secretary to select which account they wish to make. They will then be taken to a blank Profile page to fill in. If the Secretary selected 
a Junior Player then they will also be able to navigate to the Junior Profile page to add additional details. New Coach and Secretary accounts are created with the default "root" password.

Login Screen:
![Login](https://user-images.githubusercontent.com/79414856/206750910-c85711d0-cad5-415b-969a-a4938eeca4b7.JPG)

Secretary View Accounts Screen + Create New Accounts button pressed:
![View_Accounts_Secretary](https://user-images.githubusercontent.com/79414856/206750979-c519e827-7519-4fcb-a3fc-a10e20477de8.JPG)

Secretary viewing an account for a Coach:
![View_Accounts_Secretary2](https://user-images.githubusercontent.com/79414856/206750989-7dd2af15-f88c-4edd-972a-7e5ed8009cac.JPG)

Secretary viewing details of her own account:
![My_Details_Secretary](https://user-images.githubusercontent.com/79414856/206751003-779e080a-5a6c-4afc-abe0-e3bb169115aa.JPG)

Coach viewing player details:
![Player_Details_Coach](https://user-images.githubusercontent.com/79414856/206751026-eacbb824-3bcf-44f3-88e1-43ff0adfb1af.JPG)

Coach viewing aditional player details:
![Player_Details_Coach2](https://user-images.githubusercontent.com/79414856/206751058-e42bd249-ccdf-4c1b-bfe0-fba58ab35e5e.JPG)

Coach viewing/editing skills sheet of a particular player:
![Player_Skills_Coach](https://user-images.githubusercontent.com/79414856/206751099-0f7919ca-0a82-4fcf-bc9f-fcacf39fb6e6.JPG)

Coach viewing existing squads:
![View_Squads_Coach](https://user-images.githubusercontent.com/79414856/206751140-28bda755-fde4-4be8-b2b4-874920838a70.JPG)

Coach viewing details of a particular squad:
![View_Squads_Coach2](https://user-images.githubusercontent.com/79414856/206751154-e26cbdd5-48d8-433c-bd2e-f88883f3d0e4.JPG)





