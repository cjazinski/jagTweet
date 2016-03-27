package edu.southtexascollege

class PostController {

    static scaffold = Post
    def postService //Dynamically Injects the PostService

    //This will be the entry page of our app
    def global() {
        [posts:Post.list(params), postCount: Post.count()]
    }

    def index() {
    	if (!params.id) {
    		params.id = "chuck_norris"
    	}
    	redirect(action:'timeline', params:params)
    }

    def timeline(String id) {
    	def user = User.findByUsername(id)
    	if (!user) {
            log.info("Can't find user with id: ${id}")
    		response.sendError(404)
    	} else {
    		[user:user]
    	}
    }

    def addPost(String id, String content) {
        try {
            def newPost = postService.createPost(id, content)
            flash.message = "Added new post: ${newPost.content}"
        } catch (PostException pe) {
            flash.message = pe.message
        }
    	redirect(action:'timeline', id:params.id)
    }

    def personal() {
        if (session.user) {
            //Need to reAttach the user domain object to the session using 
            //refresh() method.
            render(view:'timeline', model: [user:session.user.refresh()])
        } else {
            redirect(controller:'login', action:'form')
            return
        }
    }

    def tinyUrl(String fullUrl) {
        def origUrl = fullUrl?.encodeAsURL()
        def tinyUrl = new URL("http://tinyurl.com/api-create.php?url=${origUrl}").text
        render(contentType:"application/json") {
            urls(small: tinyUrl, full:fullUrl)
        }
    }

    def addPostAjax(String content) {
        try {
            def newPost = postService.createPost(session.user.username, content)
            def recentPosts = Post.findAllByUser(
                    session.user,
                    [sort: 'dateCreated', order: 'desc', max: 20])
            render template: 'postEntry', collection: recentPosts, var: 'post'
        } catch (PostException pe) {
            render {
                div(class:"errors", pe.message)
            }
        }
    }
}
