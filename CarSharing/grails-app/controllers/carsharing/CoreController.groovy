package carsharing

class CoreController {

    CoreService coreService

    def index() { }

    def validateUser()
    {
        String login = params.login
        String password = params.password
        render (coreService.validateUser(login, password))
    }

    def registerUser()
    {
        String login = params.login
        String password = params.password
        render (coreService.registerUser(login, password))
    }

    def registerCar()
    {
        String manufacturer = params.manufacturer
        String model = params.model
        Integer posessionNumber = params.possesion_number.toInteger()
        render (coreService.registerCar(new Car(manufacturer: manufacturer, model: model, possesionNumber: posessionNumber)))
    }

    def getVacantCars()
    {
        return coreService.getVacantCars()
    }

    def createReservation()
    {
        String userLogin = params.login
    }
}
