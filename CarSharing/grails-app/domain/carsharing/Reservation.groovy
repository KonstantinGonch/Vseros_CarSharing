package carsharing

class Reservation {

    public Reservation()
    {
        fromDate = new Date()
    }

    static belongsTo = [user: AppUser]

    static hasOne = [car: Car]

    Date fromDate
    Date toDate

    static constraints = {
        fromDate(nullable: false)
        toDate validator: {it==null || it > fromDate}
    }
}
