import java.time.LocalDate;

/**
 * This class inherits from GenericProfile. It is used to create User objects. It holds the data of Coaches and Secretaries. 
 *@author Renat Oosthuizen
 *@since 09/05/2021
 */
public class User extends GenericProfile {
	
	/**String variable holds either "Coach" or "Secretary" value.*/
	private String userType = ""; 
	
	/**
	 * This is the default constructor that is used when creating brand new Coaches and Secretaries.
	 * It had to be specified due to the existence of a parameterised constructor.
	 */
	public User()
	{
		
	}
	
	/**
	 * This is a parameterised constructor that is used when Coach/Secretary data is imported from the database.
	 * @param ID holds the unique UserID of the Coach/Secretary. Inherited from GenericProfile.
	 * @param userType hold the type of user, Coach/Secretary. Inherited from GenericProfile.
	 * @param fullName holds the full name of the user. Inherited from GenericProfile.
	 * @param address holds the home address of the user. Inherited from GenericProfile.
	 * @param postCode holds the post code of the user. Inherited from GenericProfile.
	 * @param SRUNumber holds the Scottish Rugby Union number of the user. Inherited from GenericProfile.
	 * @param DOB hold the date of birth of the user. Inherited from GenericProfile.
	 * @param telNumber holds the telephone number of the user. Inherited from GenericProfile.
	 * @param mobNumber holds the mobile number of the user. Inherited from GenericProfile.
	 * @param email holds the email address of the user. Inherited from GenericProfile.
	 * @param kinName hold the name of the next of kin of the user. Inherited from GenericProfile.
	 * @param kinTelNumber holds the telephone number of the next of kin of the user. Inherited from GenericProfile.
	 * @param doctorName hold the name of the user's doctor. Inherited from GenericProfile.
	 * @param doctorTelNumber holds the telephone number of the user's doctor. Inherited from GenericProfile.
	 */
	public User(int ID, String userType, String fullName, String address, String postCode, String SRUNumber, LocalDate DOB, String telNumber, String mobNumber, String email, String kinName, String kinTelNumber, String doctorName, String doctorTelNumber) {
		
		setID(ID);
		setUserType(userType);
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
	}
	
	/*---GETTERS---*/
	
	/**
	 * Getter for the User class.
	 * @return userType holds either "Coach" or "Secretary" value.
	 */
	public String getUserType() {
		return userType;
	}

	/*---SETTERS---*/
	
	/**
	 * Setter for the User class.
	 * @param userType holds either "Coach" or "Secretary" value.
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	

}
