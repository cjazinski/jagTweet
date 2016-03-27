package edu.southtexascollege

class PhotoUploadCommand {
    byte[] avatar
    String username
}

class ImageController {

    def upload(PhotoUploadCommand puc) {
        def user = User.findByUsername(puc.username)
        user.profile.avatar = puc.avatar
        redirect(controller: "user", action: "profile", id: puc.username)
    }

    def form() {
        // pass through to upload form
        [ userList : User.list() ]
    }

    def renderImage(String id) {
        def user = User.findByUsername(id)
        if (user?.profile?.avatar) {
            response.setContentLength(user.profile.avatar.size())
            response.outputStream.write(user.profile.avatar)
        } else {
            response.sendError(404)
        }
    }
    
}