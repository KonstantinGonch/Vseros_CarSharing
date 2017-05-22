package carsharing

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/validate"(controller: "core", action: "validateUser")
        "/register_user"(controller: "core", action: "registerUser")
        "/register_car"(controller: "core", action: "registerCar")
        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
