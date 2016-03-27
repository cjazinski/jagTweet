package edu.southtexascollege

import grails.transaction.Transactional

@Transactional
class AuthService {
	
	def validLogin(String username, String password) { 
		def user = User.findByUsername(username)
		if (user && user.password == password) {
			return true
		} else {
			return false
		}
	}

}
