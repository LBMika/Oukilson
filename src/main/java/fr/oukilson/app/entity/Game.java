package fr.oukilson.app.entity;

public class Game {

	// attributs
	private int id;
	private String name;
	private int minPlayer;
	private int maxPlayer;
	// Duration in minutes
	private int minTime;
	private int maxTime;
	private int age;
	private String creatorName;
	
	/**
	 * Creation of an instance of game by giving its identifying and name.
	 * An exception is thrown if the length of name is upper than 45 characters.
	 * @param id identifying of game
	 * @param name name of game
	 * @throws IllegalArgumentException exception thrown
	 */
	public Game (int id, String name) throws IllegalArgumentException {
		super();
		this.id = id;
		this.setName(name);
		this.minPlayer = 0;
		this.maxPlayer = 0;
	}
	
	/**
	 * getter of name
	 * @return name of game
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * setter of name. IllegalArgumentException is thrown if the length of name is upper than 45 characters.
	 * @param name name of game
	 * @throws IllegalArgumentException Exception thrown
	 */
	public void setName(String name) throws IllegalArgumentException {
		if (name.length() > 45) {
			throw new IllegalArgumentException("The name is too long");
		} else {
			this.name = name;
		}
	}
	
	
	/**
	 * getter of the minimal player number
	 * If the returned value is 0, the minimal player number is unknown
	 * @return minimal player number
	 */
	public int getMinPlayer() {
		return this.minPlayer;
	}
	
	/**
	 * setter of the minimal player number.
	 * IllegalArgumentException is thrown if this number is negative or 0. 
	 * setMinPlayer must be executed before setMaxPlayer
	 * @param minPlayer minimal player number
	 * @throws IllegalArgumentException
	 */
	public void setMinPlayer(int minPlayer) throws IllegalArgumentException {
		if (minPlayer < 1) {
			throw new IllegalArgumentException("The minimal player number is too low");
		} else {
			this.minPlayer = minPlayer;
		}
	}
	
	/**
	 * getter of the maximal player number 
	 * If the returned value is 0, the maximal player number is unknown
	 * @return maximal player number
	 */
	public int getMaxPlayer() {
		return this.maxPlayer;
	}
	
	/**
	 * setter of the maximal player number.
	 * IllegalArgumentException is thrown if this number is lower than 2 or 
	 * if it is lower than the minimal player number
	 * setMinPlayer must be executed before setMaxPlayer
	 * @param maxPlayer maximal player number
	 * @throws IllegalArgumentException
	 */
	public void setMaxPlayer(int maxPlayer) throws IllegalArgumentException {
		if (maxPlayer < 2 || maxPlayer < this.getMinPlayer()) {
			throw new IllegalArgumentException("The maximal player number is too low");
		} else {
			this.maxPlayer = maxPlayer;
		}
	}
	
	/**
	 * getter of the minimal age of the game players
	 * If the returned value is 0, the minimal age is unknown
	 * @return minimal age of the players
	 */
	public int getAge() {
		return this.age;
	}
	
	/**
	 * setter of the minimal age of the game players
	 * IllegalArgumentException is thrown if this number is lower than 3 
	 * @param age
	 * @throws IllegalArgumentException
	 */
	public void setAge (int age) throws IllegalArgumentException{
		if (age < 3) {
			throw new IllegalArgumentException("The game age is too low");
		} else {
			this.age = age;
		}
	}
	/**
	 * getter of the creator name of the game
	 * @return creator name of the game
	 */
	public String getCreatorName () {
		return this.creatorName;
	}
	
	/**
	 * setter of creator name. IllegalArgumentException is thrown if the length of name is upper than 45 characters.
	 * @param creatorName creator name of game
	 * @throws IllegalArgumentException Exception thrown
	 */
	public void setCreatorName(String creatorName) throws IllegalArgumentException {
		if (creatorName.length() > 45) {
			throw new IllegalArgumentException("The creator name is too long");
		} else {
			this.creatorName = creatorName;
		}
	}
	
	/**
	 * getter of the minimum time of game
	 * @return minTime minimum time of game
	 */
	public int getMinTime() {
		return minTime;
	}
	
	/**
	 * setter of minimum time of game. IllegalArgumentException is thrown if this number is negative ou nulle
	 * @param minTime
	 * @throws IllegalArgumentException
	 */
	public void setMinTime(int minTime) throws IllegalArgumentException {
		if (minTime <= 0) {
			throw new IllegalArgumentException("The minimum time of game is not positive");
		} else {
			this.minTime = minTime;
		}
	}
	
	/**
	 * getter of the maximum time of game
	 * @return minTime maximum time of game
	 */
	public int getMaxTime() {
		return maxTime;
	}
	
	/**
	 * setter of maximum time of game. IllegalArgumentException is thrown
	 * if this time is lower than the minimum time of game 
	 * @param maxTime
	 * @throws IllegalArgumentException
	 */
	public void setMaxTime(int maxTime) throws IllegalArgumentException {
		if (maxTime < this.getMinTime()) {
			throw new IllegalArgumentException("The maximum time of game is lower than the minimum time of game");
		} else {
			this.maxTime = maxTime;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
