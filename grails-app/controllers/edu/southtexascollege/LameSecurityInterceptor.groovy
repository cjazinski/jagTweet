package edu.southtexascollege

class LameSecurityInterceptor {

	public LameSecurityInterceptor() {
		match controller: 'post', action:'addPost|deletePost'
	}

    boolean before() { 
    	//Will allow for impersenation
    	if (params.impersonatUsername) {
    		session.user = User.findByUsername(params.impersonatUsername)
    	}
    	//Check to see if user in session facade
    	if(!session.user) {
    		redirect(controller:'login', action:'form')
    		return false
    	}
    	return true;
    }

    boolean after() {
    	log.debug("Finshed running ${controllerName} ${actionName}")
    	return true;
    }

    void afterView() {
        // no-op
    }
}
