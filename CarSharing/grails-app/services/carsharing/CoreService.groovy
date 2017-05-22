package carsharing

import grails.transaction.Transactional
import org.grails.web.json.JSONArray
import org.grails.web.json.JSONObject

@Transactional
class CoreService {

    def locale = Locale.getDefault()
    def messageSource

    def validateUser(String loginarg, String passwordarg) {
        def query = AppUser.where {login == loginarg && password==passwordarg}
        def users = query.list()
        if (users.size()==0)
            return new JSONObject().put("state",0).toString()
        else
            return new JSONObject().put("state",1).toString()
    }

    def registerUser(String loginarg, String passwordarg)
    {
        AppUser u = new AppUser(loginarg, passwordarg)
        JSONObject retv = new JSONObject()
        JSONArray errors = new JSONArray()
        u.save(flush:true)
        if (u.hasErrors())
        {
            retv.put("state",0)
            u.errors.allErrors.each {errors.put(messageSource.getMessage(it, locale))}
        }
        else
        {
            retv.put("state",1)
        }
        retv.put("errors", errors)
        return retv.toString()
    }

    def registerCar(Car car)
    {
        car.save(flush: true)
        JSONObject retv = new JSONObject()
        JSONArray errors = new JSONArray()
        if (car.hasErrors()){
            retv.put("state", 0)
            car.errors.allErrors.each {errors.put(messageSource.getMessage(it, locale))}}
        else
            retv.put("state",1)
        retv.put("errors", errors)
        return retv.toString()
    }

    def getVacantCars()
    {
        def cars = Car.where {isVacant}.list()
        JSONArray arr = new JSONArray()
        cars.each {arr.put(it.possesionNumber)}
        return new JSONObject().put("available", arr).toString()
    }
}
