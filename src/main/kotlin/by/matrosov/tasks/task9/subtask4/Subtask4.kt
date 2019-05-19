package by.matrosov.tasks.task9.subtask4

import by.matrosov.tasks.task9.Passenger
import by.matrosov.tasks.task9.TaxiPark

fun TaxiPark.findSmartPassengers1(): Set<Passenger> {
    val pair = trips.partition { it.discount is Double }
    return allPassengers
        .filter { passenger ->
            pair.first.count { it.passengers.contains(passenger) } >
                    pair.second.count { it.passengers.contains(passenger) }
        }
        .toSet()
}

fun TaxiPark.findSmartPassengers2(): Set<Passenger> {
    val (tripWithDiscount, tripWithoutDiscount) =
        trips.partition { it.discount != null }
    return allPassengers
        .filter { passenger ->
            tripWithDiscount.count { passenger in it.passengers } >
                    tripWithoutDiscount.count { passenger in it.passengers }
        }
        .toSet()
}

fun TaxiPark.findSmartPassengers3(): Set<Passenger> =
    allPassengers
        .associate { p ->
            p to trips.filter { t -> p in t.passengers }
        }
        .filterValues { group ->
            val (withDiscount, withoutDiscount) = group
                .partition { it.discount != null }
            withDiscount.size > withoutDiscount.size
        }
        .keys

fun TaxiPark.findSmartPassengers4(): Set<Passenger> =
    allPassengers
        .filter { p ->
            val withDiscount = trips.count { t -> p in t.passengers && t.discount != null }
            val withoutDiscount = trips.count { t -> p in t.passengers && t.discount == null }
            withDiscount > withoutDiscount
        }.toSet()
