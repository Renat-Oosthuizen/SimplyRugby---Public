CREATE DATABASE SimplyRugbyDB;
USE SimplyRugbyDB;

CREATE TABLE ProfileTable(
    ProfileID INT(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    FullName VARCHAR(100) NOT NULL,
    Address VARCHAR(100) NOT NULL,
    PostCode VARCHAR(8) NOT NULL,
    SRUNumber VARCHAR(10) NOT NULL,
    DOB DATE NOT NULL,
    TelNumber VARCHAR(20),
    MobNumber VARCHAR(20),
    Email VARCHAR(100) NOT NULL UNIQUE,
    KinName VARCHAR(100),
    KinTelNumber VARCHAR(20), 
    DoctorName VARCHAR(100),
    DoctorTelNumber VARCHAR(20)

);

CREATE TABLE UserTable(
    UserID INT(10) PRIMARY KEY NOT NULL, /*FK*/
    PassHash VARCHAR(255) NOT NULL,
    UserType ENUM('Coach','Secretary') NOT NULL,
    FOREIGN KEY (UserID) REFERENCES ProfileTable(ProfileID)
);

CREATE TABLE PlayerTable(
    PlayerID INT(10) PRIMARY KEY NOT NULL, /*FK*/
    PlayerType ENUM('SeniorPlayer','JuniorPlayer','NonPlayer') NOT NULL,
    FOREIGN KEY (PlayerID) REFERENCES ProfileTable(ProfileID)
);

CREATE TABLE JuniorPlayerTable(
    JPlayerID INT(10) PRIMARY KEY NOT NULL, /*FK*/
    KinRelationship VARCHAR(50),
    KinAddress VARCHAR(100),
    Kin2Name VARCHAR(100),
    Kin2Relationship VARCHAR(50),
    Kin2Address VARCHAR(100),
    Kin2TelNumber VARCHAR(20),
    DoctorAddress VARCHAR(100),
    FOREIGN KEY (JPlayerID) REFERENCES PlayerTable(PlayerID)
);

CREATE TABLE SkillTable(
    SkillSetID INT(10) PRIMARY KEY NOT NULL,
    PreferredPosition ENUM('Full Back', 'Wing', 'Centre', 'Fly Half', 'Scrum Half', 'Hooker', 'Prop', '2nd Row', 'Back Row'),
    HealthComment VARCHAR(255),
    PassingComment VARCHAR(255),
    TacklingComment VARCHAR(255),
    KickingComment VARCHAR(255),
    StandardSkill INT(1),
    SpinSkill INT(1),
    PopSkill INT(1),
    FrontSkill INT(1),
    RearSkill INT(1),
    SideSkill INT(1),
    ScrabbleSkill INT(1),
    DropSkill INT(1),
    PuntSkill INT(1),
    GrubberSkill INT(1),
    GoalSkill INT(1),
    FOREIGN KEY (SkillSetID) REFERENCES PlayerTable(PlayerID)
);

CREATE TABLE SquadTable(
    SquadID INT(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    SquadName VARCHAR(20) NOT NULL UNIQUE,
    Coach1 INT(10) NOT NULL, /*FK*/
    Coach2 INT(10),
    Coach3 INT(10),
    HookerID INT(10),
    LeftPropID INT(10),
    RightPropID INT(10),
    LeftLockID INT(10),
    RightLockID INT(10),
    LeftFlankerID INT(10),
    RightFlankerID INT(10),
    NumberEightID INT(10),
    ScrumHalfID INT(10),
    FlyHalfID INT(10),
    InnerCentreID INT(10),
    OuterCentreID INT(10),
    LeftWingID INT(10),
    RightWingID INT(10),
    FullBackID INT(10),
    FOREIGN KEY (Coach1) REFERENCES UserTable(UserID)
);

/*-----------------------------------------------------TEST DATA-----------------------------------------------------------------*/

/*TEST DATA - SECRETARY*/
INSERT INTO ProfileTable(FullName, Address, PostCode, SRUNumber, DOB, TelNumber, MobNumber, Email, KinName, KinTelNumber, DoctorName, DoctorTelNumber) 
VALUES ("Susan Parr", "21 Nowhere Lane, Dundee", "SU2 6DE", "0123456789", "1990-11-09", "", "097-006-55-22-9", "susanp@gmail.com", "Jeremy Parr", "096-0126-75-82-9", "Alice Hope", "012-555-555-555");

INSERT INTO UserTable(UserID, PassHash, UserType) /*Password: password*/
VALUES ((SELECT ProfileID FROM ProfileTable WHERE Email = "susanp@gmail.com"), "1000:aa639a9e61e1d77a1d61e6813d86d83a:bc62315395e6c86395e6c0fabf86cbe5ce12feed8f2973ae6665e66da63f7bdfbb704f1d5ae17d7acba7a939fd390569e9c11a4022a012cd560944acb0b3c59e", "Secretary");


/*TEST DATA - COACH*/
INSERT INTO ProfileTable(FullName, Address, PostCode, SRUNumber, DOB, TelNumber, MobNumber, Email, KinName, KinTelNumber, DoctorName, DoctorTelNumber) 
VALUES ("George Hunter", "17 Dark Alley, Edinburgh", "SV6 2DR", "9876543210", "1990-08-10", "097-826-55-32-9", "", "georgeh@hotmail.com", "Jane Hunter", "096-0126-75-82-9", "Henri Gervais", "013-555-555-555");

INSERT INTO UserTable(UserID, PassHash, UserType) /*Password: GeorgePass*/
VALUES ((SELECT ProfileID FROM ProfileTable WHERE Email = "georgeh@hotmail.com"), "1000:0c13ba67f3253f995c3a9ed822101593:4fa7989126622894ad5b27ed0fed1c685f6f548538281a3f8c988b7e640813f804911d87e74e0ea8edb3cb4dd79cee68c1fc3b1c1ccd64696070b2d4620a5b53", "Coach");


/*TEST DATA - 1 SENIOR PLAYER*/
INSERT INTO ProfileTable(FullName, Address, PostCode, SRUNumber, DOB, TelNumber, MobNumber, Email, KinName, KinTelNumber, DoctorName, DoctorTelNumber) 
VALUES ("Christopher Fairburn", "5 Victoria Road, Edinburgh", "RB2 2DR", "1928374650", "1980-12-15", "022 652 71 44 2", "09166627119", "chrisf@btinternet.com", "-", "-", "-", "012-555-555-555");

INSERT INTO PlayerTable(PlayerID, PlayerType)
VALUES ((SELECT ProfileID FROM ProfileTable WHERE Email = "chrisf@btinternet.com"), "SeniorPlayer");

INSERT INTO SkillTable (SkillSetID, PreferredPosition, HealthComment, PassingComment, TacklingComment, KickingComment, StandardSkill, SpinSkill, PopSkill, FrontSkill, RearSkill, SideSkill, ScrabbleSkill, DropSkill, PuntSkill, GrubberSkill, GoalSkill)
VALUES ((SELECT ProfileID FROM ProfileTable WHERE Email = "chrisf@btinternet.com"), "Centre", "Currently taking Fluoxitine.", "Doesn't like to pass.", "Scared of tackling.", "Really good kicker.", "3", "3", "5", "4", "4", "3", "2", "3", "3", "3", "5");


/*TEST DATA - 1 NON PLAYER*/
INSERT INTO ProfileTable(FullName, Address, PostCode, SRUNumber, DOB, TelNumber, MobNumber, Email, KinName, KinTelNumber, DoctorName, DoctorTelNumber) 
VALUES ("Alice Michel", "12 Carnival Row, Edinburgh", "SV5 2DR", "1122334455", "1980-12-28", "", "081-821-88-23-8", "alicem@gmail.com", "", "", "", "");

INSERT INTO PlayerTable(PlayerID, PlayerType)
VALUES ((SELECT ProfileID FROM ProfileTable WHERE Email = "alicem@gmail.com"), "NonPlayer");


/*TEST DATA - 3 JUNIOR PLAYERS*/
INSERT INTO ProfileTable(FullName, Address, PostCode, SRUNumber, DOB, TelNumber, MobNumber, Email, KinName, KinTelNumber, DoctorName, DoctorTelNumber) 
VALUES ("Eliott H Bryan", "83 Park Row, Edinburgh", "EH6 0HB", "1325476980", "2007-08-10", "", "078 5412 5955", "eliottb@gmail.com", "John Bryan", "0131 9496 0925", "-", "012-555-555-555");

INSERT INTO PlayerTable(PlayerID, PlayerType)
VALUES ((SELECT ProfileID FROM ProfileTable WHERE Email = "eliottb@gmail.com"), "JuniorPlayer");

INSERT INTO JuniorPlayerTable(JPlayerID, KinRelationship, KinAddress, Kin2Name, Kin2Relationship, Kin2Address, Kin2TelNumber, DoctorAddress)
VALUES ((SELECT ProfileID FROM ProfileTable WHERE Email = "eliottb@gmail.com"), "Father", "83 Park Row, Edinburgh, EH6 0HB", "Jane Bryan", "Mother", "83 Park Row, Edinburgh, EH6 0HB", "0131 9496 0961", "");

INSERT INTO SkillTable (SkillSetID, PreferredPosition, HealthComment, PassingComment, TacklingComment, KickingComment, StandardSkill, SpinSkill, PopSkill, FrontSkill, RearSkill, SideSkill, ScrabbleSkill, DropSkill, PuntSkill, GrubberSkill, GoalSkill)
VALUES ((SELECT ProfileID FROM ProfileTable WHERE Email = "eliottb@gmail.com"), "Full Back", "", "Great at Tackling.", "Great at Kicking.", "Really good overall.", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5");

/*--------------------------------------------*/
INSERT INTO ProfileTable(FullName, Address, PostCode, SRUNumber, DOB, TelNumber, MobNumber, Email, KinName, KinTelNumber, DoctorName, DoctorTelNumber) 
VALUES ("Robin Clifford", "67 Park Row, Edinburgh", "EH5 3RL", "1111111111", "2008-01-01", "078 6565 1474", "01632 960078", "robinc@gmail.com", "Jean Clifford", "01632 960078", "Leela Potts", "077 4224 2396");

INSERT INTO PlayerTable(PlayerID, PlayerType)
VALUES ((SELECT ProfileID FROM ProfileTable WHERE Email = "robinc@gmail.com"), "JuniorPlayer");

INSERT INTO JuniorPlayerTable(JPlayerID, KinRelationship, KinAddress, Kin2Name, Kin2Relationship, Kin2Address, Kin2TelNumber, DoctorAddress)
VALUES ((SELECT ProfileID FROM ProfileTable WHERE Email = "robinc@gmail.com"), "Mother", "67 Park Row, Edinburgh, EH5 3RL", "", "", "", "", "1664 Havanna Street, Edinburgh, EH2 0YR");

INSERT INTO SkillTable (SkillSetID, PreferredPosition, HealthComment, PassingComment, TacklingComment, KickingComment, StandardSkill, SpinSkill, PopSkill, FrontSkill, RearSkill, SideSkill, ScrabbleSkill, DropSkill, PuntSkill, GrubberSkill, GoalSkill)
VALUES ((SELECT ProfileID FROM ProfileTable WHERE Email = "robinc@gmail.com"), "Centre", "", "", "", "", "3", "3", "3", "3", "3", "3", "3", "3", "3", "3", "3");

/*--------------------------------------------*/

INSERT INTO ProfileTable(FullName, Address, PostCode, SRUNumber, DOB, TelNumber, MobNumber, Email, KinName, KinTelNumber, DoctorName, DoctorTelNumber) 
VALUES ("Liam Moore", "70 Seafield Place, Edinburgh", "EH3 1EW", "2222222222", "2005-02-20", "022 652 71 44 2", "09166627119", "liamm@gmail.com", "Alice Moore", "01632 960934", "-", "012-555-555-555");

INSERT INTO PlayerTable(PlayerID, PlayerType)
Values ((SELECT ProfileID FROM ProfileTable WHERE Email = "liamm@gmail.com"), "JuniorPlayer");

INSERT INTO JuniorPlayerTable(JPlayerID, KinRelationship, KinAddress, Kin2Name, Kin2Relationship, Kin2Address, Kin2TelNumber, DoctorAddress)
VALUES ((SELECT ProfileID FROM ProfileTable WHERE Email = "liamm@gmail.com"), "Mother", "70 Seafield Place, Edinburgh", "Jason Moore", "Father", "70 Seafield Place, Edinburgh", "01632 960397", "");

INSERT INTO SkillTable (SkillSetID, PreferredPosition, HealthComment, PassingComment, TacklingComment, KickingComment, StandardSkill, SpinSkill, PopSkill, FrontSkill, RearSkill, SideSkill, ScrabbleSkill, DropSkill, PuntSkill, GrubberSkill, GoalSkill)
VALUES ((SELECT ProfileID FROM ProfileTable WHERE Email = "liamm@gmail.com"), "Wing", "Recently recovered from a broken leg.", "New to rugby. Needs practice.", "New to rugby. Needs practice.", "New to rugby. Needs practice.", "1", "1", "2", "1", "1", "1", "1", "1", "1", "1", "1");


/*TEST DATA - SQUAD*/
INSERT INTO SquadTable(SquadName, Coach1, Coach2, Coach3, HookerID, LeftPropID, RightPropID, LeftLockID, RightLockID, LeftFlankerID, RightFlankerID, NumberEightID, ScrumHalfID, FlyHalfID, InnerCentreID, OuterCentreID, LeftWingID, RightWingID, FullBackID)
VALUES ("The Titans", (SELECT ProfileID FROM ProfileTable WHERE Email = "georgeh@hotmail.com"), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", (Select ProfileID FROM ProfileTable WHERE Email = "eliottb@gmail.com"));