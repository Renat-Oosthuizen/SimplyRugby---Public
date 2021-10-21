/**
 * This class is used to create Squad objects. It holds the Name and ID of the squad as well as the IDs of all of it's members. 
 *@author Renat Oosthuizen
 *@since 09/05/2021
 *
 *
 */
public class Squad {
	
	/**int variable that holds the unique ID of the Squad.*/
	private int squadID;
	/**String variable that holds the unique name of the Squad.*/
	private String squadName = "";
	/**int variable that holds the unique ID of the first coach member of the Squad.*/
	private int coach1;
	/**int variable that holds the unique ID of the second coach member of the Squad.*/
	private int coach2;
	/**int variable that holds the unique ID of the third coach member of the Squad.*/
	private int coach3;
	/**int variable that holds the unique ID of a member of the Squad in the Hooker position.*/
	private int hookerID;
	/**int variable that holds the unique ID of a member of the Squad in the Left Prop position.*/
	private int leftPropID;
	/**int variable that holds the unique ID of a member of the Squad in the Right Prop position.*/
	private int rightPropID;
	/**int variable that holds the unique ID of a member of the Squad in the Left Lock position.*/
	private int leftLockID;
	/**int variable that holds the unique ID of a member of the Squad in the Right Lock position.*/
	private int rightLockID;
	/**int variable that holds the unique ID of a member of the Squad in the Left Flanker position.*/
	private int leftFlankerID;
	/**int variable that holds the unique ID of a member of the Squad in the Right Flanker position.*/
	private int rightFlankerID;
	/**int variable that holds the unique ID of a member of the Squad in the Number Eight position.*/
	private int numberEightID;
	/**int variable that holds the unique ID of a member of the Squad in the Scrum Half position.*/
	private int scrumHalfID;
	/**int variable that holds the unique ID of a member of the Squad in the Fly Half position.*/
	private int flyHalfID;
	/**int variable that holds the unique ID of a member of the Squad in the Inner Centre position.*/
	private int innerCentreID;
	/**int variable that holds the unique ID of a member of the Squad in the Outer Centre position.*/
	private int outerCentreID;
	/**int variable that holds the unique ID of a member of the Squad in the Left Wing position.*/
	private int leftWingID;
	/**int variable that holds the unique ID of a member of the Squad in the Right Wing position.*/
	private int rightWingID;
	/**int variable that holds the unique ID of a member of the Squad in the Full Back position.*/
	private int fullBackID;
	
	
	/**
	 * A parameterised constructor for a Squad. Used when importing a Squad from the database.
	 * @param squadID holds the unique ID of the Squad.
	 * @param squadName holds the unique name of the Squad.
	 * @param coach1 holds the unique ID of the first coach member of the Squad.
	 * @param coach2 holds the unique ID of the second coach member of the Squad.
	 * @param coach3 holds the unique ID of the third coach member of the Squad.
	 * @param hookerID holds the unique ID of a member of the Squad in the Hooker position.
	 * @param leftPropID holds the unique ID of a member of the Squad in the Left Prop position.
	 * @param rightPropID holds the unique ID of a member of the Squad in the Right Prop position.
	 * @param leftLockID holds the unique ID of a member of the Squad in the Left Lock position.
	 * @param rightLockID holds the unique ID of a member of the Squad in the Right Lock position.
	 * @param leftFlankerID holds the unique ID of a member of the Squad in the Left Flanker position.
	 * @param rightFlankerID holds the unique ID of a member of the Squad in the Right Flanker position.
	 * @param numberEightID holds the unique ID of a member of the Squad in the Number Eight position.
	 * @param scrumHalfID holds the unique ID of a member of the Squad in the Scrum Half position.
	 * @param flyHalfID holds the unique ID of a member of the Squad in the Fly Half position.
	 * @param innerCentreID holds the unique ID of a member of the Squad in the Inner Centre position.
	 * @param outerCentreID holds the unique ID of a member of the Squad in the Outer Centre position.
	 * @param leftWingID holds the unique ID of a member of the Squad in the Left Wing position.
	 * @param rightWingID holds the unique ID of a member of the Squad in the Right Wing position.
	 * @param fullBackID holds the unique ID of a member of the Squad in the Full Back position.
	 */
	public Squad(int squadID, String squadName, int coach1, int coach2, int coach3, int hookerID, int leftPropID, int rightPropID, int leftLockID, int rightLockID, int leftFlankerID, int rightFlankerID, int numberEightID, int scrumHalfID, int flyHalfID, int innerCentreID, int outerCentreID, int leftWingID, int rightWingID, int fullBackID) {
		
		this.squadID = squadID;
		this.squadName = squadName;
		this.coach1 = coach1;
		this.coach2 = coach2;
		this.coach3 = coach3;
		this.hookerID = hookerID;
		this.leftPropID = leftPropID;
		this.rightPropID = rightPropID;
		this.leftLockID = leftLockID;
		this.rightLockID = rightLockID;
		this.leftFlankerID = leftFlankerID;
		this.rightFlankerID = rightFlankerID;
		this.numberEightID = numberEightID;
		this.scrumHalfID = scrumHalfID;
		this.flyHalfID = flyHalfID;
		this.innerCentreID = innerCentreID;
		this.outerCentreID = outerCentreID;
		this.leftWingID = leftWingID;
		this.rightWingID = rightWingID;
		this.fullBackID = fullBackID;
	}

	/*---GETTERS---*/
	
	/**
	 * Getter for the Squad class.
	 * @return squadID holds the unique ID of the Squad.
	 */
	public int getSquadID() {
		return squadID;
	}
	
	/**
	 * Getter for the Squad class.
	 * @return squadName holds the unique name of the Squad.
	 */
	public String getSquadName() {
		return squadName;
	}
	
	/**
	 * Getter for the Squad class.
	 * @return coach1 holds the unique ID of the first coach member of the Squad.
	 */
	public int getCoach1() {
		return coach1;
	}
	
	/**
	 * Getter for the Squad class.
	 * @return coach2 holds the unique ID of the second coach member of the Squad.
	 */
	public int getCoach2() {
		return coach2;
	}
	
	/**
	 * Getter for the Squad class.
	 * @return coach3 holds the unique ID of the third coach member of the Squad.
	 */
	public int getCoach3() {
		return coach3;
	}
	
	/**
	 * Getter for the Squad class.
	 * @return hookerID holds the unique ID of a member of the Squad in the Hooker position.
	 */
	public int getHookerID() {
		return hookerID;
	}
	
	/**
	 * Getter for the Squad class.
	 * @return leftPropID holds the unique ID of a member of the Squad in the Left Prop position.
	 */
	public int getLeftPropID() {
		return leftPropID;
	}
	
	/**
	 * Getter for the Squad class.
	 * @return rightPropID holds the unique ID of a member of the Squad in the Right Prop position.
	 */
	public int getRightPropID() {
		return rightPropID;
	}
	
	/**
	 * Getter for the Squad class.
	 * @return leftLockID holds the unique ID of a member of the Squad in the Left Lock position.
	 */
	public int getLeftLockID() {
		return leftLockID;
	}
	
	/**
	 * Getter for the Squad class.
	 * @return rightLockID holds the unique ID of a member of the Squad in the Right Lock position.
	 */
	public int getRightLockID() {
		return rightLockID;
	}
	
	/**
	 * Getter for the Squad class.
	 * @return leftFlankerID holds the unique ID of a member of the Squad in the Left Flanker position.
	 */
	public int getLeftFlankerID() {
		return leftFlankerID;
	}
	
	/**
	 * Getter for the Squad class.
	 * @return rightFlankerID holds the unique ID of a member of the Squad in the Right Flanker position.
	 */
	public int getRightFlankerID() {
		return rightFlankerID; 
	}
	
	/**
	 * Getter for the Squad class.
	 * @return numberEightID holds the unique ID of a member of the Squad in the Number Eight position.
	 */
	public int getNumberEightID() {
		return numberEightID;
	}
	
	/**
	 * Getter for the Squad class.
	 * @return scrumHalfID holds the unique ID of a member of the Squad in the Scrum Half position.
	 */
	public int getScrumHalfID() {
		return scrumHalfID;
	}
	
	/**
	 * Getter for the Squad class.
	 * @return flyHalfID holds the unique ID of a member of the Squad in the Fly Half position.
	 */
	public int getFlyHalfID() {
		return flyHalfID;
	}
	
	/**
	 * Getter for the Squad class.
	 * @return innerCentreID holds the unique ID of a member of the Squad in the Inner Centre position.
	 */
	public int getInnerCentreID() {
		return innerCentreID;
	}
	
	/**
	 * Getter for the Squad class.
	 * @return outerCentreID holds the unique ID of a member of the Squad in the Outer Centre position.
	 */
	public int getOuterCentreID() {
		return outerCentreID;
	}
	
	/**
	 * Getter for the Squad class.
	 * @return leftWingID holds the unique ID of a member of the Squad in the Left Wing position.
	 */
	public int getLeftWingID() {
		return leftWingID;
	}
	
	/**
	 * Getter for the Squad class.
	 * @return rightWingID holds the unique ID of a member of the Squad in the Right Wing position.
	 */
	public int getRightWingID() {
		return rightWingID;
	}
	
	/**
	 * Getter for the Squad class.
	 * @return fullBackID holds the unique ID of a member of the Squad in the Full Back position.
	 */
	public int getFullBackID() {
		return fullBackID;
	}
	
	/*---SETTERS---*/
	
	/**
	 * Setter for the Squad class.
	 * @param squadID holds the unique ID of the Squad.
	 */
	public void setSquadID(int squadID) {
		this.squadID = squadID;
	}
	
	/**
	 * Setter for the Squad class.
	 * @param squadName holds the unique name of the Squad.
	 */
	public void setSquadName(String squadName) {
		this.squadName = squadName;
	}
	
	/**
	 * Setter for the Squad class.
	 * @param coach1 holds the unique ID of the first coach member of the Squad.
	 */
	public void setCoach1(int coach1) {
		this.coach1 = coach1;
	}
	
	/**
	 * Setter for the Squad class.
	 * @param coach2 holds the unique ID of the second coach member of the Squad.
	 */
	public void setCoach2(int coach2) {
		this.coach2 = coach2;
	}
	
	/**
	 * Setter for the Squad class.
	 * @param coach3 holds the unique ID of the third coach member of the Squad.
	 */
	public void setCoach3(int coach3) {
		this.coach3 = coach3;
	}
	
	/**
	 * Setter for the Squad class.
	 * @param hookerID holds the unique ID of a member of the Squad in the Hooker position.
	 */
	public void setHookerID(int hookerID) {
		this.hookerID = hookerID;
	}
	
	/**
	 * Setter for the Squad class.
	 * @param leftPropID holds the unique ID of a member of the Squad in the Left Prop position.
	 */
	public void setLeftPropID(int leftPropID) {
		this.leftPropID = leftPropID;
	}
	
	/**
	 * Setter for the Squad class.
	 * @param rightPropID holds the unique ID of a member of the Squad in the Right Prop position.
	 */
	public void setRightPropID(int rightPropID) {
		this.rightPropID = rightPropID;
	}
	
	/**
	 * Setter for the Squad class.
	 * @param leftLockID holds the unique ID of a member of the Squad in the Left Lock position.
	 */
	public void setLeftLockID(int leftLockID) {
		this.leftLockID = leftLockID;
	}
	
	/**
	 * Setter for the Squad class.
	 * @param rightLockID holds the unique ID of a member of the Squad in the Right Lock position.
	 */
	public void setRightLockID(int rightLockID) {
		this.rightLockID = rightLockID;
	}
	
	/**
	 * Setter for the Squad class.
	 * @param leftFlankerID holds the unique ID of a member of the Squad in the Left Flanker position.
	 */
	public void setLeftFlankerID(int leftFlankerID) {
		this.leftFlankerID = leftFlankerID;
	}
	
	/**
	 * Setter for the Squad class.
	 * @param rightFlankerID holds the unique ID of a member of the Squad in the Right Flanker position.
	 */
	public void setRightFlankerID(int rightFlankerID) {
		this.rightFlankerID = rightFlankerID;
	}
	
	/**
	 * Setter for the Squad class.
	 * @param numberEightID holds the unique ID of a member of the Squad in the Number Eight position.
	 */
	public void setNumberEightID(int numberEightID) {
		this.numberEightID = numberEightID;
	}
	
	/**
	 * Setter for the Squad class.
	 * @param scrumHalfID holds the unique ID of a member of the Squad in the Scrum Half position.
	 */
	public void setScrumHalfID(int scrumHalfID) {
		this.scrumHalfID = scrumHalfID;
	}
	
	/**
	 * Setter for the Squad class.
	 * @param flyHalfID holds the unique ID of a member of the Squad in the Fly Half position.
	 */
	public void setFlyHalfID(int flyHalfID) {
		this.flyHalfID = flyHalfID;
	}
	
	/**
	 * Setter for the Squad class.
	 * @param innerCentreID holds the unique ID of a member of the Squad in the Inner Centre position.
	 */
	public void setInnerCentreID(int innerCentreID) {
		this.innerCentreID = innerCentreID;
	}
	
	/**
	 * Setter for the Squad class.
	 * @param outerCentreID holds the unique ID of a member of the Squad in the Outer Centre position.
	 */
	public void setOuterCentreID(int outerCentreID) {
		this.outerCentreID = outerCentreID;
	}
	
	/**
	 * Setter for the Squad class.
	 * @param leftWingID holds the unique ID of a member of the Squad in the Left Wing position.
	 */
	public void setLeftWingID(int leftWingID) {
		this.leftWingID = leftWingID;
	}
	
	/**
	 * Setter for the Squad class.
	 * @param rightWingID holds the unique ID of a member of the Squad in the Right Wing position.
	 */
	public void setRightWingID(int rightWingID) {
		this.rightWingID = rightWingID;
	}
	
	/**
	 * Setter for the Squad class.
	 * @param fullBackID holds the unique ID of a member of the Squad in the Full Back position.
	 */
	public void setFullBackID(int fullBackID) {
		this.fullBackID = fullBackID;
	}
	
}
