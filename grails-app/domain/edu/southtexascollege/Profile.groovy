package edu.southtexascollege

class Profile {
	User user
	byte[] avatar
	String fullName
	String skin
	String bio
	String homePage
	String email
	String jabberAddress
	Date dateCreated
	Date lastUpdated

	String toString() {
		return "Profile of $fullName (id: $id)"
	}

	String getDisplayString() {
		return fullName
	}

	static constraints = {
		fullName blank:false
		bio nullable:true, maxSize: 1000
		homePage url:true, nullable:true
		email email:true, blank:false
		avatar nullable:true, maxSize: 2 * 1024 * 1024 //2MB
		jabberAddress email: true, nullable: true
		skin(nullable: true, blank: true, inList: ['blues', 'nighttime'])
	}

	static belongsTo = [user:User]
}