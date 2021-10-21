import java.time.LocalDate;

/**
 * This class inherits directly from PlayerSkill and indirectly from GenericProfile. 
 * It is used to create JuniorPlayer objects. It holds the data of junior player profiles. 
 *@author Renat Oosthuizen
 *@since 09/05/2021
 *
 *
 */
public class JuniorPlayer extends PlayerSkill {
	
	/**String variable holding the relationship status of the first kin of the JuniorPlayer.*/
	private String kinRelationship = "";
	/**String variable holding the home address of the first kin of the JuniorPlayer.*/
	private String kinAddress = "";
	/**String variable holding the name of the second kin of the JuniorPlayer.*/
	private String kin2Name = "";
	/**String variable holding the relationship status of the second kin of the JuniorPlayer.*/
	private String kin2Relationship = "";
	/**String variable holding the home address of the second kin of the JuniorPlayer.*/
	private String kin2Address = "";
	/**String variable holding the telephone number of the second kin of the JuniorPlayer.*/
	private String kin2TelNumber = "";
	/**String variable holding the home address of the doctor of the JuniorPlayer.*/
	private String doctorAddress = "";

	/**
	 * This is the default constructor that is used when creating brand new junior player profiles.
	 * It had to be specified due to the existence of a parameterised constructor.
	 */
	public JuniorPlayer() 
	{
		
	}
	
	/**
	 * This is a parameterised constructor that is used when importing Junior Players from the database.
	 * @param kinRelationship holding the relationship status of the first kin of the junior player.
	 * @param kinAddress holding the home address of the first kin of the junior player.
	 * @param kin2Name holding the name of the second kin of the junior player.
	 * @param kin2Relationship holding the relationship status of the second kin of the junior player.
	 * @param kin2Address holding the home address of the second kin of the junior player.
	 * @param kin2TelNumber holding the telephone number of the second kin of the junior player.
	 * @param doctorAddress holding the home address of the doctor of the junior player.
	 * @param ID holding the unique ID of the junior player.
	 * @param fullName holding the full name of the junior player.
	 * @param address holding the home address of the junior player.
	 * @param postCode holding the post code of the junior player.
	 * @param SRUNumber holding the Scottish Rugby Union number of the junior player.
	 * @param DOB holding the date of birth of the junior player.
	 * @param telNumber holding the telephone number of the junior player.
	 * @param mobNumber holding the mobile number of the junior player.
	 * @param email holding the email address of the junior player.
	 * @param kinName holding the name of the first kin of the junior player.
	 * @param kinTelNumber holding the telephone number of the first kin of the junior player.
	 * @param doctorName holding the full name of the junior player's doctor.
	 * @param doctorTelNumber holding the telephone number of the junior player's doctor.
	 * @param preferredPosition holding the junior player's preferred position in a squad.
	 * @param healthComment holding a Coach's comment on the junior player's health.
	 * @param passingComment holding a Coach's comment on the junior player's passing skill.
	 * @param tacklingComment holding a Coach's comment on the junior player's tackling skill.
	 * @param kickingComment holding a Coach's comment on the junior player's kicking skill.
	 * @param standardSkill holding the junior player's skill on a scale from 1 to 5.
	 * @param spinSkill holding the junior player's skill on a scale from 1 to 5.
	 * @param popSkill holding the junior player's skill on a scale from 1 to 5.
	 * @param frontSkill holding the junior player's skill on a scale from 1 to 5.
	 * @param rearSkill holding the junior player's skill on a scale from 1 to 5.
	 * @param sideSkill holding the junior player's skill on a scale from 1 to 5.
	 * @param scrabbleSkill holding the junior player's skill on a scale from 1 to 5.
	 * @param dropSkill holding the junior player's skill on a scale from 1 to 5.
	 * @param puntSkill holding the junior player's skill on a scale from 1 to 5.
	 * @param grubberSkill holding the junior player's skill on a scale from 1 to 5.
	 * @param goalSkill holding the junior player's skill on a scale from 1 to 5.
	 */
	public JuniorPlayer(String kinRelationship, String kinAddress, String kin2Name, String kin2Relationship, String kin2Address, String kin2TelNumber, String doctorAddress, 
			int ID, String fullName, String address, String postCode, String SRUNumber, LocalDate DOB, String telNumber, String mobNumber, String email, String kinName, String kinTelNumber, String doctorName, String doctorTelNumber,
			String preferredPosition, String healthComment, String passingComment, String tacklingComment, String kickingComment, int standardSkill, int spinSkill, int popSkill, int frontSkill, int rearSkill, int sideSkill, int scrabbleSkill, int dropSkill, int puntSkill, int grubberSkill, int goalSkill) {
		
		setKinRelationship(kinRelationship);
		setKinAddress(kinAddress);
		setKin2Name(kin2Name);
		setKin2Relationship(kin2Relationship);
		setKin2Address(kin2Address);
		setKin2TelNumber(kin2TelNumber);
		setDoctorAddress(doctorAddress);
		
		setID(ID);
		setFullName(fullName);
		setAddress(address);
		setPostCode(postCode);
		setSRUNumber(SRUNumber);
		setDOB(DOB);
		setTelNumber(telNumber);
		setMobNumber(mobNumber);
		setEmail(email);
		setKinName(kinName);
		setKinTelNumber(kinTelNumber);
		setDoctorName(doctorName);
		setDoctorTelNumber(doctorTelNumber);
		
		setPreferredPosition(preferredPosition);
		setHealthComment(healthComment);
		setPassingComment(passingComment);
		setTacklingComment(tacklingComment);
		setKickingComment(kickingComment);
		setStandardSkill(standardSkill);
		setSpinSkill(spinSkill);
		setPopSkill(popSkill);
		setFrontSkill(frontSkill);
		setRearSkill(rearSkill);
		setSideSkill(sideSkill);
		setScrabbleSkill(scrabbleSkill);
		setDropSkill(dropSkill);
		setPuntSkill(puntSkill);
		setGrubberSkill(grubberSkill);
		setGoalSkill(goalSkill);
	}
	
	
	/*---GETTERS---*/
	
	/**
	 * Getter for the JuniorPlayer class.
	 * @return kinRelationship holding the relationship status of the first kin of the JuniorPlayer
	 */
	public String getKinRelationship() {
		return kinRelationship;
	}
	
	/**
	 * Getter for the JuniorPlayer class.
	 * @return kinAddress holding the home address of the first kin of the JuniorPlayer.
	 */
	public String getKinAddress() {
		return kinAddress;
	}
	
	/**
	 * Getter for the JuniorPlayer class.
	 * @return kin2Name holding the name of the second kin of the JuniorPlayer.
	 */
	public String getKin2Name() {
		return kin2Name;
	}
	
	/**
	 * Getter for the JuniorPlayer class.
	 * @return kin2Relationship holding the relationship status of the second kin of the JuniorPlayer.
	 */
	public String getKin2Relationship() {
		return kin2Relationship;
	}
	
	/**
	 * Getter for the JuniorPlayer class.
	 * @return kin2Address holding the home address of the second kin of the JuniorPlayer.
	 */
	public String getKin2Address() {
		return kin2Address;
	}
	
	/**
	 * Getter for the JuniorPlayer class.
	 * @return kin2TelNumber holding the telephone number of the second kin of the JuniorPlayer.
	 */
	public String getKin2TelNumber() {
		return kin2TelNumber;
	}
	
	/**
	 * Getter for the JuniorPlayer class.
	 * @return doctorAddress holding the home address of the doctor of the JuniorPlayer.
	 */
	public String getDoctorAddress() {
		return doctorAddress;
	}
	
	/*---SETTERS---*/
	
	/**
	 * Setter for the JuniorPlayer class.
	 * @param kinRelationship holding the relationship status of the first kin of the JuniorPlayer
	 */
	public void setKinRelationship(String kinRelationship) {
		this.kinRelationship = kinRelationship;
	}
	
	/**
	 * Setter for the JuniorPlayer class.
	 * @param kinAddress holding the home address of the first kin of the JuniorPlayer.
	 */
	public void setKinAddress(String kinAddress) {
		this.kinAddress = kinAddress;
	}
	
	/**
	 * Setter for the JuniorPlayer class.
	 * @param kin2Name holding the name of the second kin of the JuniorPlayer.
	 */
	public void setKin2Name(String kin2Name) {
		this.kin2Name = kin2Name;
	}
	
	/**
	 * Setter for the JuniorPlayer class.
	 * @param kin2Relationship holding the relationship status of the second kin of the JuniorPlayer.
	 */
	public void setKin2Relationship(String kin2Relationship) {
		this.kin2Relationship = kin2Relationship;
	}
	
	/**
	 * Setter for the JuniorPlayer class.
	 * @param kin2Address holding the home address of the second kin of the JuniorPlayer.
	 */
	public void setKin2Address(String kin2Address) {
		this.kin2Address = kin2Address;
	}
	
	/**
	 * Setter for the JuniorPlayer class.
	 * @param kin2TelNumber holding the telephone number of the second kin of the JuniorPlayer.
	 */
	public void setKin2TelNumber(String kin2TelNumber) {
		this.kin2TelNumber = kin2TelNumber;
	}
	
	/**
	 * Setter for the JuniorPlayer class.
	 * @param doctorAddress holding the home address of the doctor of the JuniorPlayer.
	 */
	public void setDoctorAddress(String doctorAddress) {
		this.doctorAddress = doctorAddress;
	}
	

}
