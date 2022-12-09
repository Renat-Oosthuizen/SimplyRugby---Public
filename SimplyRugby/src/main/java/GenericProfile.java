import java.time.LocalDate;

/**
 * This is an abstract class that holds data common to all profiles.
 * It is directly inherited from by User and PlayerSkill and NonPlayer classes.
 * It is indirectly inherited from by SeniorPlayer and JuniorPlayer classes.
 *@author Renat Oosthuizen
 *@since 09/05/2021
 *
 *
 */
abstract class GenericProfile {

	/**int variable holds the unique ID of the profile.*/
	private int ID;
	/**String variable holds the full name of the profile.*/
	private String fullName = "";
	/**String variable holds the home address of the profile.*/
	private String address = "";
	/**String variable holds the post code of the profile.*/
	private String postCode = "";
	/**String variable holds the Scottish Rugby Union number of the profile*/
	private String SRUNumber;
	/**LocalDate variable holds the date of birth of the profile.*/
	private LocalDate DOB;
	/**String variable holds the telephone number of the profile.*/
	private String telNumber = "";
	/**String variable holds the mobile number of the profile.*/
	private String mobNumber = "";
	/**String variable holds the email address of the profile.*/
	private String email = "";
	/**String variable holds the name of the next of kin of the profile.*/
	private String kinName = "";
	/**String variable holds the telephone number for the next of kin of the profile.*/
	private String kinTelNumber = "";
	/**String variable holds the name of the profile's doctor.*/
	private String doctorName = "";
	/**String variable holds the telephone number of the profile's doctor.*/
	private String doctorTelNumber = "";
	

	/*---GETTERS---*/
	
	/**
	 * Getter for the GenericProfile class.
	 * @return ID holds the unique ID of the profile.
	 */
	public int getID() {
		return ID;
	}
	
	/**
	 * Getter for the GenericProfile class.
	 * @return fullName holds the full name of the profile.
	 */
	public String getFullName() {
		return fullName;
	}
	
	/**
	 * Getter for the GenericProfile class.
	 * @return address holds the home address of the profile.
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Getter for the GenericProfile class.
	 * @return postCode holds the post code of the profile.
	 */
	public String getPostCode() {
		return postCode;
	}
	
	/**
	 * Getter for the GenericProfile class.
	 * @return SRUNumber holds the Scottish Rugby Union number of the profile.
	 */
	public String getSRUNumber() {
		return SRUNumber;
	}
	
	/**
	 * Getter for the GenericProfile class.
	 * @return DOB holds the date of birth of the profile.
	 */
	public LocalDate getDOB() {
		return DOB;
	}
	
	/**
	 * Getter for the GenericProfile class.
	 * @return telNumber holds the telephone number of the profile.
	 */
	public String getTelNumber() {
		return telNumber;
	}
	
	/**
	 * Getter for the GenericProfile class.
	 * @return mobNumber holds the mobile number of the profile.
	 */
	public String getMobNumber() {
		return mobNumber;
	}
	
	/**
	 * Getter for the GenericProfile class.
	 * @return email holds the email address of the profile.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Getter for the GenericProfile class.
	 * @return kinName holds the name of the next of kin of the profile.
	 */
	public String getKinName() {
		return kinName;
	}

	/**
	 * Getter for the GenericProfile class.
	 * @return kinTelNumber holds the telephone number for the next of kin of the profile.
	 */
	public String getKinTelNumber() {
		return kinTelNumber;
	}

	/**
	 * Getter for the GenericProfile class.
	 * @return doctorName holds the name of the profile's doctor.
	 */
	public String getDoctorName() {
		return doctorName;
	}

	/**
	 * Getter for the GenericProfile class.
	 * @return doctorTelNumber holds the telephone number of the profile's doctor.
	 */
	public String getDoctorTelNumber() {
		return doctorTelNumber;
	}


	/*---SETTERS---*/
	
	/**
	 * Setter for the GenericProfile class.
	 * @param newID holds the unique ID of the profile.
	 */
	public void setID(int newID) {
		this.ID = newID;
	}
	
	/**
	 * Setter for the GenericProfile class.
	 * @param newName holds the full name of the profile.
	 */
	public void setFullName(String newName) {
		this.fullName = newName;
	}
	
	/**
	 * Setter for the GenericProfile class.
	 * @param newAddress holds the home address of the profile.
	 */
	public void setAddress(String newAddress) {
		this.address = newAddress;
	}
	
	/**
	 * Setter for the GenericProfile class.
	 * @param newPostCode holds the post code of the profile.
	 */
	public void setPostCode(String newPostCode) {
		this.postCode = newPostCode;
	}
	
	/**
	 * Setter for the GenericProfile class.
	 * @param newSRUNumber holds the Scottish Rugby Union number of the profile.
	 */
	public void setSRUNumber(String newSRUNumber) {
		this.SRUNumber = newSRUNumber;
	}
	
	/**
	 * Setter for the GenericProfile class.
	 * @param newDOB holds the date of birth of the profile.
	 */
	public void setDOB(LocalDate newDOB) {
		this.DOB = newDOB;
	}
	
	/**
	 * Setter for the GenericProfile class.
	 * @param newTelNumber holds the telephone number of the profile.
	 */
	public void setTelNumber(String newTelNumber) {
		this.telNumber = newTelNumber;
	}
	
	/**
	 * Setter for the GenericProfile class.
	 * @param newMobNumber holds the mobile number of the profile.
	 */
	public void setMobNumber(String newMobNumber) {
		this.mobNumber = newMobNumber;
	}
	
	/**
	 * Setter for the GenericProfile class.
	 * @param newEmail holds the email address of the profile.
	 */
	public void setEmail(String newEmail) {
		this.email = newEmail;
	}
	
	/**
	 * Setter for the GenericProfile class.
	 * @param kinName holds the name of the next of kin of the profile.
	 */
	public void setKinName(String kinName) {
		this.kinName = kinName;
	}

	/**
	 * Setter for the GenericProfile class.
	 * @param kinTelNumber holds the telephone number for the next of kin of the profile.
	 */
	public void setKinTelNumber(String kinTelNumber) {
		this.kinTelNumber = kinTelNumber;
	}

	/**
	 * Setter for the GenericProfile class.
	 * @param doctorName holds the name of the profile's doctor.
	 */
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	/**
	 * Setter for the GenericProfile class.
	 * @param doctorTelNumber holds the telephone number of the profile's doctor.
	 */
	public void setDoctorTelNumber(String doctorTelNumber) {
		this.doctorTelNumber = doctorTelNumber;
	}
}
