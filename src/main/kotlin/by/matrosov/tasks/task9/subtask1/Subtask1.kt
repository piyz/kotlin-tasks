package by.matrosov.tasks.task9.subtask1

import by.matrosov.tasks.task9.Driver
import by.matrosov.tasks.task9.TaxiPark

fun TaxiPark.findFakeDrivers1(): Set<Driver> =
        allDrivers.filter { d -> trips.none {it.driver == d} }.toSet()

fun TaxiPark.findFakeDrivers2(): Set<Driver> =
        allDrivers - trips.map { it.driver }