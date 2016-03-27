package edu.southtexascollege


import grails.test.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
@Rollback
class QueryIntegrationSpec extends Specification {

	def "Simple property comparison"() {
		when: "Users are select by a simple password match"
		def users = User.where {
			password == "testing"
		}.list(sort: "username")

		then: "The users with the password are returned"
		users*.username == ["frankie"]
	}

	def "Multiple criteria"() {
		when: "A user is select by user/password"
		def users = User.where{
			password == "crikey" || username == "frankie"
		}.list(sort: "username")

		then: "The matching usernames are returned"
		users*.username == ["dillon", "frankie", "sara"]
	}

	def "Query on association"() {
		when: "The following collection is queried"
		def users = User.where{
			following.username == "sara"
		}.list(sort: "username")

		then: "A list of the followers of the given user is returned"
		users*.username == ["phil"]
	}

	def "Query against a range value"() {
		given: "The current date & time"
		def now = new Date()

		when: "The dateCreated property is queried"
		def users = User.where{
			dateCreated in (now - 1)..now
		}.list(sort:"username", order:"desc")

		then:"The users created within the given range are returned"
		users*.username == ["phil", "peter", "glen", "frankie", "chuck_norris", "admin", "cjazinski"]
	}

	def "Retrieve a single instance"() {
		when: "A specific user is queried with get()"
		def user = User.where{
			username == "phil"
		}.get()

		then: "A single instance is returned"
		user.password == "thomas"
	}
}