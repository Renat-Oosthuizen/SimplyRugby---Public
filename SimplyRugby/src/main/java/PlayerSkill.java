/**
 * This is an abstract class that inherits from the GenericProfile class.
 * It is inherited from by JuniorPlayer and SeniorPlayer classes.
 * It holds data on rugby skills of players.
 *@author Renat Oosthuizen
 *@since 09/05/2021
 *
 *
 */
abstract class PlayerSkill extends GenericProfile {
	
	/**String variable holds a Coach's comment on the player's health.*/
	private String healthComment = "";
	/**String variable holds the players preferred position in a squad.*/
	private String preferredPosition = "";
	/**String variable holds a Coach's comment on the player's passing skills.*/
	private String passingComment = "";
	/**String variable holds a Coach's comment on the player's tackling skills.*/
	private String tacklingComment = "";
	/**String variable holds a Coach's comment on the player's kicking skills.*/
	private String kickingComment = "";
	/**int variable holds the player's standard skill on a scale from 1 to 5.*/
	private int standardSkill;
	/**int variable holds the player's spin skill on a scale from 1 to 5.*/
	private int spinSkill;
	/**int variable holds the player's pop skill on a scale from 1 to 5.*/
	private int popSkill;
	/**int variable holds the player's front skill on a scale from 1 to 5.*/
	private int frontSkill;
	/**int variable holds the player's rear skill on a scale from 1 to 5.*/
	private int rearSkill;
	/**int variable holds the player's side skill on a scale from 1 to 5.*/
	private int sideSkill;
	/**int variable holds the player's scrabble skill on a scale from 1 to 5.*/
	private int scrabbleSkill;
	/**int variable holds the player's drop skill on a scale from 1 to 5.*/
	private int dropSkill;
	/**int variable holds the player's punt skill on a scale from 1 to 5.*/
	private int puntSkill;
	/**int variable holds the player's grubber skill on a scale from 1 to 5.*/
	private int grubberSkill;
	/**int variable holds the player's goal skill on a scale from 1 to 5.*/
	private int goalSkill;
	

	/*---GETTERS---*/
	
	/**
	 * Getter for the PlayerSkill class.
	 * @return healthComment which holds a Coach's comment on the player's health.
	 */
	public String getHealthComment() {
		return healthComment;
	}
	
	/**
	 * Getter for the PlayerSkill class.
	 * @return preferredPosition which holds the players preferred position in a squad.
	 */
	public String getPreferredPosition() {
		return preferredPosition;
	}
	
	/**
	 * Getter for the PlayerSkill class.
	 * @return passingComment which holds a Coach's comment on the player's passing skills.
	 */
	public String getPassingComment() {
		return passingComment;
	}
	
	/**
	 * Getter for the PlayerSkill class.
	 * @return tacklingComment which holds a Coach's comment on the player's tackling skills.
	 */
	public String getTacklingComment() {
		return tacklingComment;
	}
	
	/**
	 * Getter for the PlayerSkill class.
	 * @return kickingComment which holds a Coach's comment on the player's kicking skills.
	 */
	public String getKickingComment() {
		return kickingComment;
	}
	
	/**
	 * Getter for the PlayerSkill class.
	 * @return standardSkill which holds the player's skill on a scale from 1 to 5.
	 */
	public int getStandardSkill() {
		return standardSkill;
	}
	
	/**
	 * Getter for the PlayerSkill class.
	 * @return spinSkill which holds the player's skill on a scale from 1 to 5.
	 */
	public int getSpinSkill() {
		return spinSkill;
	}
	
	/**
	 * Getter for the PlayerSkill class.
	 * @return popSkill which holds the player's skill on a scale from 1 to 5.
	 */
	public int getPopSkill() {
		return popSkill;
	}
	
	/**
	 * Getter for the PlayerSkill class.
	 * @return frontSkill which holds the player's skill on a scale from 1 to 5.
	 */
	public int getFrontSkill() {
		return frontSkill;
	}
	
	/**
	 * Getter for the PlayerSkill class.
	 * @return rearSkill which holds the player's skill on a scale from 1 to 5.
	 */
	public int getRearSkill() {
		return rearSkill;
	}
	
	/**
	 * Getter for the PlayerSkill class.
	 * @return sideSkill which holds the player's skill on a scale from 1 to 5.
	 */
	public int getSideSkill() {
		return sideSkill;
	}
	
	/**
	 * Getter for the PlayerSkill class.
	 * @return scrabbleSkill which holds the player's skill on a scale from 1 to 5.
	 */
	public int getScrabbleSkill() {
		return scrabbleSkill;
	}
	
	/**
	 * Getter for the PlayerSkill class.
	 * @return dropSkill which holds the player's skill on a scale from 1 to 5.
	 */
	public int getDropSkill() {
		return dropSkill;
	}
	
	/**
	 * Getter for the PlayerSkill class.
	 * @return puntSkill which holds the player's skill on a scale from 1 to 5.
	 */
	public int getPuntSkill() {
		return puntSkill;
	}
	
	/**
	 * Getter for the PlayerSkill class.
	 * @return grubberSkill which holds the player's skill on a scale from 1 to 5.
	 */
	public int getGrubberSkill() {
		return grubberSkill;
	}
	
	/**
	 * Getter for the PlayerSkill class.
	 * @return goalSkill which holds the player's skill on a scale from 1 to 5.
	 */
	public int getGoalSkill() {
		return goalSkill;
	}
	
	/*---SETTERS---*/
	
	/**
	 * Setter for the PlayerSkill class.
	 * @param healthComment which holds a Coach's comment on the player's health.
	 */
	public void setHealthComment(String healthComment) {
		this.healthComment = healthComment;
	}
	
	/**
	 * Setter for the PlayerSkill class.
	 * @param preferredPosition which holds the players preferred position in a squad.
	 */
	public void setPreferredPosition(String preferredPosition) {
		this.preferredPosition = preferredPosition;
	}
	
	/**
	 * Setter for the PlayerSkill class.
	 * @param passingComment which holds a Coach's comment on the player's passing skills.
	 */
	public void setPassingComment(String passingComment) {
		this.passingComment = passingComment;
	}
	
	/**
	 * Setter for the PlayerSkill class.
	 * @param tacklingComment which holds a Coach's comment on the player's tackling skills.
	 */
	public void setTacklingComment(String tacklingComment) {
		this.tacklingComment = tacklingComment;
	}
	
	/**
	 * Setter for the PlayerSkill class.
	 * @param kickingComment which holds a Coach's comment on the player's kicking skills.
	 */
	public void setKickingComment(String kickingComment) {
		this.kickingComment = kickingComment;
	}
	
	/**
	 * Setter for the PlayerSkill class.
	 * @param standardSkill which holds the player's skill on a scale from 1 to 5.
	 */
	public void setStandardSkill(int standardSkill) {
		this.standardSkill = standardSkill;
	}
	
	/**
	 * Setter for the PlayerSkill class.
	 * @param spinSkill which holds the player's skill on a scale from 1 to 5.
	 */
	public void setSpinSkill(int spinSkill) {
		this.spinSkill = spinSkill;
	}
	
	/**
	 * Setter for the PlayerSkill class.
	 * @param popSkill which holds the player's skill on a scale from 1 to 5.
	 */
	public void setPopSkill(int popSkill) {
		this.popSkill = popSkill;
	}
	
	/**
	 * Setter for the PlayerSkill class.
	 * @param frontSkill which holds the player's skill on a scale from 1 to 5.
	 */
	public void setFrontSkill(int frontSkill) {
		this.frontSkill = frontSkill;
	}
	
	/**
	 * Setter for the PlayerSkill class.
	 * @param rearSkill which holds the player's skill on a scale from 1 to 5.
	 */
	public void setRearSkill(int rearSkill) {
		this.rearSkill = rearSkill;
	}
	
	/**
	 * Setter for the PlayerSkill class.
	 * @param sideSkill which holds the player's skill on a scale from 1 to 5.
	 */
	public void setSideSkill(int sideSkill) {
		this.sideSkill = sideSkill;
	}
	
	/**
	 * Setter for the PlayerSkill class.
	 * @param scrabbleSkill which holds the player's skill on a scale from 1 to 5.
	 */
	public void setScrabbleSkill(int scrabbleSkill) {
		this.scrabbleSkill = scrabbleSkill;
	}
	
	/**
	 * Setter for the PlayerSkill class.
	 * @param dropSkill which holds the player's skill on a scale from 1 to 5.
	 */
	public void setDropSkill(int dropSkill) {
		this.dropSkill = dropSkill;
	}
	
	/**
	 * Setter for the PlayerSkill class.
	 * @param puntSkill which holds the player's skill on a scale from 1 to 5.
	 */
	public void setPuntSkill(int puntSkill) {
		this.puntSkill = puntSkill;
	}
	
	/**
	 * Setter for the PlayerSkill class.
	 * @param grubberSkill which holds the player's skill on a scale from 1 to 5.
	 */
	public void setGrubberSkill(int grubberSkill) {
		this.grubberSkill = grubberSkill;
	}
	
	/**
	 * Setter for the PlayerSkill class.
	 * @param goalSkill which holds the player's skill on a scale from 1 to 5.
	 */
	public void setGoalSkill(int goalSkill) {
		this.goalSkill = goalSkill;
	}
	
}
