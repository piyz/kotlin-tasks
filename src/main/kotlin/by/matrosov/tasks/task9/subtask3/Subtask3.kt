package by.matrosov.tasks.task9.subtask3

import by.matrosov.tasks.task9.Driver
import by.matrosov.tasks.task9.Passenger
import by.matrosov.tasks.task9.TaxiPark
import by.matrosov.tasks.task9.Trip

fun TaxiPark.findFrequentPassengers1(driver: Driver): Set<Passenger> =
        trips
            .filter { trip -> trip.driver == driver }
            .flatMap(Trip::passengers)
            .groupBy { passenger -> passenger }
            .filterValues { group -> group.size > 1 }
            .keys

fun TaxiPark.findFrequentPassengers2(driver: Driver): Set<Passenger> =
    allPassengers
        .filter { p ->
            trips.count { trip -> trip.driver == driver && p in trip.passengers } > 1
        }
        .toSet()
