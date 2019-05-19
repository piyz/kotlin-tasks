package by.matrosov.tasks.task9.subtask2

import by.matrosov.tasks.task9.Passenger
import by.matrosov.tasks.task9.TaxiPark
import by.matrosov.tasks.task9.Trip

//not readable because of many it
fun TaxiPark.findFaithfulPassengers1(minTrips: Int): Set<Passenger> =
    trips
        .flatMap { it.passengers }
        .groupBy { it }
        .filter { it.value.size >= minTrips }
        .map { it.key }
        .toSet()

fun TaxiPark.findFaithfulPassengers2(minTrips: Int): Set<Passenger> =
    trips
        .flatMap(Trip::passengers)
        .groupBy { passenger -> passenger }
        .filterValues { group -> group.size >= minTrips }
        .keys

fun TaxiPark.findFaithfulPassengers3(minTrips: Int): Set<Passenger> =
        allPassengers
            .filter { p ->
                trips.count { trip -> p in trip.passengers } >= minTrips
            }
            .toSet()