package edu.southtexascollege

class LoginController {
	//Will handle the heavy lifting - LDAP should be configured
	def authService

	def form(String username) {
		//This is to return it back to the form should there have been an error
		[username:username]
	}

	def signIn(String username, String password) {
		if (authService.validLogin(username, password)) {
			def user = User.findByUsername(username)
			session.user = user;
			redirect(uri:'/')
		} else {
			flash.message = "Unknown username or password"
			redirect(action:'form')
		}
	}

	def logOut() {
		if (session.user) {
			session['user'] = null
			flash.message = "You have been logged out!"
			redirect(uri:'/')
		} else {
			flash.message = "You are not logged in!"
			redirect(uri:'/')
		}
	}
}
