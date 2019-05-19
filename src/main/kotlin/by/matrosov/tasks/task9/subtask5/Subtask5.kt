package by.matrosov.tasks.task9.subtask5

import by.matrosov.tasks.task9.TaxiPark

fun TaxiPark.findTheMostFrequentTripDurationPeriod(): IntRange? {
    return trips
        .groupBy {
            val start = it.duration / 10 * 10
            val end = start + 9
            start..end
        }
        .maxBy { (_, group) -> group.size }
        ?.key
}
