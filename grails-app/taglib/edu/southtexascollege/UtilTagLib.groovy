package edu.southtexascollege

class UtilTagLib {
    static namespace = "jagTweet"

    def certainBrowser = {  attrs, body ->
        if (request.getHeader('User-Agent') =~ attrs.userAgent ) {
            out << body()
        }
    }
    
    def eachFollower = { attrs, body ->
        def followers = attrs.followers
        followers?.each { follower ->
            body(followUser: follower)
        }
    }
    
    def tinyThumbnail = { attrs ->
        def username = attrs.username
        out << "<img src='"
        out << g.createLink(action: "tiny", controller: "image", id: username)
        out << "' alt='${loginId}'"
    }
    
}