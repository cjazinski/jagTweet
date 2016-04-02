package jagtweet

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
       
        //Custom Mapping of stuff
        "/users/$id" {
            controller = "post"
            action = "timeline"
        }
        "/users/$username/feed/$format?" {
            controller: "post"
            action: "feed"
            constraints {
                format(inList: ['rss', 'atom'])
            }
        }
        "/timeline" {
            controller = "post"
            action = "personal"
        }
        "/timeline/$id" {
            controller = "post"
            action = "timeline"
        }

        //Named URL Mappings
        name chuck : "/timeline/chuck_norris" {
            controller = "post"
            action="timeline"
            id="chuck_norris"
        }

        //General URL Maps
        "/"(controller: "post", action:"global")
        "500"(view:'/error')
        "404"(view:'/notFound')

    }
}
