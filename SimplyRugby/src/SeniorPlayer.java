import java.time.LocalDate;

/**
 * This class inherits directly from PlayerSkill and indirectly from GenericProfile. 
 * It is used to create SeniorPlayer objects. It holds the data of senior player profiles. 
 *@author Renat Oosthuizen
 *@since 09/05/2021
 *
 *
 */
public class SeniorPlayer extends PlayerSkill {
	
	/**
	 * This is the default constructor that is used when creating brand new senior player profiles.
	 * It had to be specified due to the existence of a parameterised constructor.
	 */
	public SeniorPlayer()
	{
		
	}
	
	/**
	 * This is a parameterised constructor that is used when importing Senior Players from the database.
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
	public SeniorPlayer(int ID, String fullName, String address, String postCode, String SRUNumber, LocalDate DOB, String telNumber, String mobNumber, String email, String kinName, String kinTelNumber, String doctorName, String doctorTelNumber,
			String preferredPosition, String healthComment, String passingComment, String tacklingComment, String kickingComment, int standardSkill, int spinSkill, int popSkill, int frontSkill, int rearSkill, int sideSkill, int scrabbleSkill, int dropSkill, int puntSkill, int grubberSkill, int goalSkill) {
		
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

}
