package edu.southtexascollege

import grails.test.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
@Rollback
class UserIntegrationSpec extends Specification {

	def "Saving first user to the database"() {
		given:"A brand new user"
			def chris = new User(username:'chris', password:'jazinski', homePage:'http://www.google.com')

		when: "the user is saved"
			chris.save()

		then: "it saved successfully and can be found in the DB"
			chris.errors.errorCount == 0
			chris.id != null
			User.get(chris.id).username == chris.username
	}

	def "Updating a saved user changes its properties"() {
		given: "An existing User"
			def existingUser = new User(username:'chris', password:'jazinski', homePage:'http://www.google.com')
			existingUser.save(failOnError:true)

		when: "A property is changed"
			def foundUser = User.get(existingUser.id)
			foundUser.password = 'password'
			foundUser.save(failOnError:true)

		then: "The change is reflected in the database"
			User.get(existingUser.id).password == 'password';

	}

	def "Deleting a user removes it from the database"() {
		given: "An existing user"
			def user = new User(username:'username', password:'password', homePage:'http://www.google.com')
			user.save(failOnError:true)

		when: "The user is deleted"
			def foundUser = User.get(user.id)
			foundUser.delete(flush:true) //Flush is so transaction occurs now not end of session

		then: "user is no longer in db - not found"
			!User.exists(foundUser.id)
	}

	def "Saving a user with invalid properties causes an error to occur"() {
		given: "A user which fails several field validations/constraints"
			def user = new User(username:'joe', password:'tiny', homePage:'not-a-url')

		when: "User is validated"
			user.validate()

		then:
			user.hasErrors()
			"size.toosmall" == user.errors.getFieldError("password").code
			"tiny" == user.errors.getFieldError("password").rejectedValue
			//"url.invalid" == user.errors.getFieldError("homePage").code
			//"not-a-url" == user.errors.getFieldError("homePage").rejectedValue
			!user.errors.getFieldError("username")
	}

	def "Recoving from a failed save attempt by fixing the properties"() {
		given: "A user with invalid properties"
			def chuck = new User(username:'chuck', password:'tiny')
			assert chuck.save() == null
			assert chuck.hasErrors()

		when: "We fix the invalid properties"
			chuck.password = "fistfist"
			//chuck.profile.homePage = "http://www.chucknorrisfacts.com"
			chuck.validate()

		then: "The user saves and validates correctly"
			!chuck.hasErrors()
			chuck.save()
	}

	def "Ensure a user can follow other users"() {
	    given: "A set of baseline users"
	    	def joe = new User(username: 'joe', password:'password').save()
	    	def jane = new User(username: 'jane', password:'password').save()
	    	def jill = new User(username: 'jill', password:'password').save()
	    
	    when: "Joe follows Jane & Jill, and Jill follows Jane"
	    	joe.addToFollowing(jane)
	    	joe.addToFollowing(jill)
	    	jill.addToFollowing(joe)
			    
	    then: "Follower counts should match following people"
	    	2 == joe.following.size()
	    	1 == jill.following.size()
	}

}