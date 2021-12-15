package fr.oukilson.app.entity;

public class Location {

	
	/**
	 * attributes
	 */
	private int location_id;
	private String town;
	private int zip_code;
	private String adress;
	
	/**
	 * empty constructor
	 */
	public Location() {
	}

	/**
	 * constructor with town name
	 * @param town event town name
	 * @throws IllegalArgumentException if the town name is either too short or too long or contains illegal characters
	 */
	public Location(String town) throws IllegalArgumentException{
		this.setTown(town);
	}
	
	/**
	 * constructor with town name
	 * @param zip_code event zip code 
	 * @throws IllegalArgumentException if the zip code is either too short or too long or contains illegal characters
	 */
	public Location(int zip_code) throws IllegalArgumentException{
		this.setZip_code(zip_code);
	}
	
	/**
	 * constructor with town name and zip code
	 * @param town event town name
	 * @param zip_code event town zip code
	 * @throws IllegalArgumentException
	 */
	public Location(String town, int zip_code) throws IllegalArgumentException{
		this.setTown(town);
		this.setZip_code(zip_code);
	}
	
	/**
	 * getters & setters
	 */
	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	public String getTown() {
		return town;
	}

	/**
	 * function to verify if town name has valid length 
	 * @param town
	 * @throws IllegalArgumentException returns exception if input is too long or too short
	 */
	public void setTown(String town) throws IllegalArgumentException{
		if (Tools.checkLength(town, 45)) {
			this.town = town;
        }
	}

	public int getZip_code() {
		return zip_code;
	}

	/**
	 * function to verify if zip_code is valid
	 * @param zip_code
	 * @throws IllegalArgumentException returns exception if input isn't in valid zip_code
	 */
	public void setZip_code(int zip_code) throws IllegalArgumentException{
		if (zip_code >= 01001 && zip_code <= 98901)
			this.zip_code = zip_code;
    }
		

	public String getAdress() {
		return adress;
	}

	/**
	 * function to verify if adress is valid
	 * @param adress event number and street
	 * @throws IllegalArgumentException returns exception if input is too long or empty
	 */
	public void setAdress(String adress) throws IllegalArgumentException{
		if (Tools.checkLength(adress, 45)) {
			this.adress = adress;
        }
		
	}
}
