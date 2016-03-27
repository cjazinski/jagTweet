package edu.southtexascollege

class User {
	String username
	String password
	Date dateCreated
	Date lastUpdated
	//Valdations or constraints
	//Notice the different syntax is valid
	static constraints = {
		username(size:3..20, unique:true, nullable:false)
		password size:6..8, nullable:false, validator: {
			passwd, user -> passwd != user.username
		}
		profile nullable:true //Do not need profile
		//we can use regex also
		//aNumber matches: '[A]{1}[0-9]{8}' //A01234567
	}

	String toString() {
		return username
	}

	//ORM
	static hasOne = [profile: Profile]
	static hasMany = [posts: Post, tags: Tag, following: User]

	static mapping = {
    	posts sort:'dateCreated'
	}
}