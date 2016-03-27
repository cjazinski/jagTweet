package edu.southtexascollege

class Post {
	String content
	Date dateCreated
	Date lastUpdated

	static constraints = {
		content blank:false
	}
	//ORM
	static belongsTo = [user: User]
	static hasMany = [tags: Tag]

	static mapping = {
		sort dateCreated:"desc"
	}
}