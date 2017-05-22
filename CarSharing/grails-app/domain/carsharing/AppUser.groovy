package carsharing

class AppUser {

    public AppUser(String l, String p)
    {
        login=l; password=p
    }

    public AppUser()
    {

    }

    static hasMany = [reservations : Reservation]

    String login
    String password

    static constraints = {
        login(unique: true, nullable: false)
        password(size: 6..20, nullable: false)
    }
}
