import java.time.LocalDate;

/**
 * This class inherits from GenericProfile. 
 * It is used to create NonPlayer objects. It holds the data of non-player profiles. 
 *@author Renat Oosthuizen
 *@since 09/05/2021
 *
 *
 */
public class NonPlayer extends GenericProfile {
	
	/**
	 * This is the default constructor that is used when creating brand new non-player profiles.
	 * It had to be specified due to the existence of a parameterised constructor.
	 */
	public NonPlayer() 
	{
		
	}

	/**
	 * This is a parameterised constructor that is used when importing Non-Players from the database.
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
	 */
	public NonPlayer(int ID, String fullName, String address, String postCode, String SRUNumber, LocalDate DOB, String telNumber, String mobNumber, String email, String kinName, String kinTelNumber, String doctorName, String doctorTelNumber) {
		
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
	}

}
