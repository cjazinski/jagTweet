package edu.southtexascollege

class UserController {

    static scaffold = User

    //Needed for view to be rendered
    def search() {}

    def results(String username) {
    	def users = User.where {
    		username =~ "%${username}%"
    	}.list()
    	return [ 
    		users:users,
    		term:  params.username,
    		totalUsers: User.count()
    	]
    }
    
    def advSearch() {}

    def advResults() {
        def profileProps = Profile.metaClass.properties*.name
        def profiles = Profile.withCriteria {
            "${params.queryType}" {

                params.each { field, value ->

                    if (profileProps.grep(field) && value) {
                        ilike(field, value)
                    }
                }

            }

        }
        [ profiles : profiles ]

    }

    def register() {
        if (request.method == "POST") {
            def user = new User(params)
            if (user.validate()) {
                user.save()
                flash.message = "Successfully created user!"
                redirect(uri:'/')
            } else {
                flash.message = "Error Registering User"
                return [user: user]
            }
        }
    }


    def register2(UserRegistrationCommand urc) {
        if (urc.hasErrors()) {
            render view: "register", model: [ user : urc ]
        } else {
            def user = new User(urc.properties)
            user.profile = new Profile(urc.properties)
            if (user.validate() && user.save()) {
                flash.message = "Welcome aboard, ${urc.fullName ?: urc.username}"
                redirect(uri: '/')
            } else {
                // maybe not unique username
                return [ user : urc ]
            }
        }
    }

    def profile(String id) {
        def user = User.findByUsername(id)
        log.debug user
        if (user) {
            return [profile: user.profile]
        } else {
            response.sendError(404)
        }
    }


}

class UserRegistrationCommand {
    String username
    String password
    String passwordRepeat
    byte[] avatar
    String fullName
    String bio
    String homePage
    String email
    String jabberAddress

    static constraints = {
        importFrom Profile
        importFrom User
        password(size: 6..8, blank: false,
                 validator: { passwd, urc ->
                    return passwd != urc.username
                })
        passwordRepeat(nullable: false,
                validator: { passwd2, urc ->
                    return passwd2 == urc.password
                })
    }
}
