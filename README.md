**task1**

Implement the function that checks whether a string is a valid identifier. A valid identifier is a non-empty string that
starts with a letter or underscore and consists of only letters, digits and underscores.

**task2**

Change the 'sum' function so that it was declared as an extension to List<Int>

**task3**

Mastermind is a board game for two players. The first player invents a code and the second player tries to guess this code. A code is made up 4 coloured pins and their position. There are 6 colours to choose from and the same colour can be repeated multiple times.

**task4**

Add and implement an extension function 'isEmptyOrNull()' on the type String?.
It should return true, if the string is null or empty.

**task5**

Declare the s variable to make the first line print null
and the second one throw an exception

**task6**

Functions 'all', 'none' and 'any' are interchangeable, you can use one or the other to implement the same functionality.
Implement the functions 'allNonZero' and 'containsZero' using all three predicates in turn. 'allNonZero' checks that all the elements in the list are non-zero; 'containsZero' checks that the list contains zero element.
Add the negation before the whole call (right before 'any', 'all' or 'none') when necessary, not only inside the predicate.

**task7**

Mastermind in a functional style

**task8**

A string is nice if at least two of the following conditions are satisfied:
1. It doesn't contain substrings bu, ba or be;
2. It contains at least three vowels (vowels are a, e, i, o and u);
3. It contains a double letter (at least two similar letters following one another), like b in "abba".
Check whether a given string is nice.

**task9**

Taxi Park

The TaxiPark class stores information about registered drivers, passengers, and their trips. Your task is to implement six functions which collect different statistics about the data.

SubTask 1

fun TaxiPark.findFakeDrivers(): Collection<Driver>
Find all the drivers who didn't perform any trips.

SubTask 2

fun TaxiPark.findFaithfulPassengers(minTrips: Int): List<Passenger>
Find all the clients who completed at least the given number of trips.

SubTask 3

fun TaxiPark.findFrequentPassengers(driver: Driver): List<Passenger>
Find all the passengers who were driven by a certain driver more than once.

SubTask 4

fun TaxiPark.findSmartPassengers(): Collection<Passenger>
If we consider "smart", a passenger who had a discount for the majority of the trips they made or took part in (including the trips with more than one passenger), find all the "smart" passengers. A "smart" passenger should have strictly more trips with discount than trips without discount, the equal amounts of trips with and without discount isn't enough.

Note that the discount can't be 0.0, it's always non-zero if it's recorded.

SubTask 5

fun TaxiPark.findTheMostFrequentTripDurationPeriod(): IntRange?
Find the most frequent trip duration period among minute periods 0..9, 10..19, 20..29, and so on. Return any suitable period if many are the most frequent, return null if there're no trips.

SubTask 6

fun TaxiPark.checkParetoPrinciple(): Boolean
Check whether no more than 20% of the drivers contribute 80% of the income. The function should return true if the top 20% drivers (meaning the top 20% best performers) represent 80% or more of all trips total income, or false if not. The drivers that have no trips should be considered as contributing zero income. If the taxi park contains no trips, the result should be false.

For example, if there're 39 drivers in the taxi park, we need to check that no more than 20% of the most successful ones, which is seven drivers (39 * 0.2 = 7.8), contribute at least 80% of the total income. Note that eight drivers out of 39 is 20.51% which is more than 20%, so we check the income of seven the most successful drivers.

To find the total income sum up all the trip costs. Note that the discount is already applied while calculating the cost.

**task10**

Implement the property 'foo' so that it produced a different value on each access.
Note that you can modify the code outside the 'foo' getter (e.g. add additional imports or properties).