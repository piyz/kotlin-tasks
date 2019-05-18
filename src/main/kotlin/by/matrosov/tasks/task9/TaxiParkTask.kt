package by.matrosov.tasks.task9

/*
 * Task #1. Find all the drivers who performed no trips.
 */
fun TaxiPark.findFakeDrivers(): Set<Driver> {

    fun driversWithAtLeastOneTrip() : Set<Driver> {
        return this.trips.map { it.driver }.toSet()
    }

    return this.allDrivers.filter { driver -> !driversWithAtLeastOneTrip().contains(driver) }.toSet()
}
/*
 * Task #2. Find all the clients who completed at least the given number of trips.
 */
fun TaxiPark.findFaithfulPassengers(minTrips: Int): Set<Passenger> {

    if (minTrips == 0) return this.allPassengers

    return this.trips
            .flatMap { it.passengers }                  //get all passengers
            .groupingBy { it }
            .eachCount()                                //count trips for each passengers
            .filter { (_,i) -> i >= minTrips }.keys     //return only keys
}

/*
 * Task #3. Find all the passengers, who were taken by a given driver more than once.
 */
fun TaxiPark.findFrequentPassengers(driver: Driver): Set<Passenger> {

    return this.trips
            .filter { trip -> trip.driver.name == driver.name }  //filter trips by driver name
            .flatMap { it.passengers }
            .groupingBy { it }
            .eachCount()                                         //count number of trips for each passenger
            .filter { (_,count) -> count >1}.keys
}

/*
 * Task #4. Find the passengers who had a discount for majority of their trips.
 */
fun TaxiPark.findSmartPassengers(): Set<Passenger> {

    fun discount(p: Passenger): Int {
        return trips
                .filter { trip -> trip.passengers.contains(p) }
                .map { it.discount }
                .filter { d -> d != null }
                .count()
    }

    fun nonDiscount(p: Passenger): Int {
        return trips
                .filter { trip -> trip.passengers.contains(p) }
                .map { it.discount }
                .filter { d -> d == null }
                .count()
    }

    return allPassengers.filter { p -> discount(p) > nonDiscount(p) }.toSet()
}

/*
 * Task #5. Find the most frequent trip duration among minute periods 0..9, 10..19, 20..29, and so on.
 * Return any period if many are the most frequent, return `null` if there're no trips.
 */
fun TaxiPark.findTheMostFrequentTripDurationPeriod(): IntRange? {

    fun getMaxDuration(): Int? {
        return trips
                .map { it.duration / 10 * 10}
                .groupingBy { it }
                .eachCount()
                .maxBy { it.value }?.value
    }

    return trips
            .map { it.duration / 10 * 10}
            .groupingBy { it }
            .eachCount()
            .filter { it.value == getMaxDuration() }
            .map { it.key .. it.key + 9 }
            .getOrNull(0)
}

/*
 * Task #6.
 * Check whether 20% of the drivers contribute 80% of the income.
 */
fun TaxiPark.checkParetoPrinciple(): Boolean {

    fun findTripByDriver(d: Driver): List<Trip> {
        return trips.filter { trip -> trip.driver == d }
    }

    fun find20PercentDrivers(): Int {
        return (allDrivers.count() * 0.2).toInt()
    }

    fun calculateAllIncome(): Double {
        return allDrivers
                .map { d -> findTripByDriver(d)
                        .map { it.cost }
                        .sum()
                }.sum()
    }

    fun calculate20ProcentIncome(): Double {
        return allDrivers
                .map { d -> findTripByDriver(d)
                        .map { it.cost }
                        .sum() }
                .sortedDescending()
                .subList(0, find20PercentDrivers())
                .sum()
    }

    fun calculateRelativeIncome(): Double {
        return calculate20ProcentIncome() / calculateAllIncome()
    }

    return (calculateRelativeIncome() >= 0.8)
}