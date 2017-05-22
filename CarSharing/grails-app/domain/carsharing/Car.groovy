package carsharing

class Car {

    Car(String manufacturer, String model, Integer possesionNumber) {
        this.manufacturer = manufacturer
        this.model = model
        this.possesionNumber = possesionNumber
        this.isVacant = true
    }

    static belongsTo = [reservation:Reservation]

    String manufacturer
    String model
    Integer possesionNumber
    Boolean isVacant

    static constraints = {
        isVacant(nullable: true)
        reservation(nullable: true)
    }

}
