package edu.southtexascollege

import grails.transaction.Transactional

class PostException extends RuntimeException {
	String message
	Post post
}

@Transactional
class PostService {

	Post createPost(String username, String content) {
		def user = User.findByUsername(username)
		if (user) {
			def post = new Post(content:content)
			user.addToPosts(post)
			if (post.validate() && user.save()) {
				return post
			} else {
			throw new PostException(
				message: "Invalid or empty post!",
				post:post)
			}
		} else {
			throw new PostException(message: "Invalid Username")
		}
	}

}