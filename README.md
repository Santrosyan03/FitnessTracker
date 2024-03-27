# FitnessTracker Class

The `FitnessTracker` class is a simple Java class designed to track fitness-related metrics 
such as total steps, miles run, daily calories consumed, weekly workouts, and whether a calorie
goal has been met. It provides methods to log workouts, consume calories, reset daily tracking metrics,
increment total steps and more.

## Usage

To use the `FitnessTracker` class, you can follow these steps:

1. **Instantiate FitnessTracker**: Create an instance of the `FitnessTracker` class.

    ```java
    FitnessTracker fitnessTracker = new FitnessTracker();
    ```

2. **Track Fitness Metrics**: Use the various methods provided by the `FitnessTracker` class 
to track fitness metrics such as steps taken, miles run, calories consumed, and workouts logged.

    ```java
    fitnessTracker.incrementTotalSteps(1000);
    fitnessTracker.addMilesRun(5.0);
    fitnessTracker.consumeCalories(500);
    fitnessTracker.logWorkout(1, "Monday Workout");
    ```

3. **Retrieve Fitness Metrics**: Retrieve fitness metrics using getter methods provided by the 
4. `FitnessTracker` class.

    ```java
    int totalSteps = fitnessTracker.getTotalSteps();
    double milesRun = fitnessTracker.getMilesRun();
    double dailyCalories = fitnessTracker.getDailyCalories();
    String[] weeklyWorkouts = fitnessTracker.getWeeklyWorkouts();
    boolean hasMetCalorieGoal = fitnessTracker.hasMetCalorieGoal();
    ```

4. **Reset Daily Tracker**: Reset daily tracking metrics using the `resetDailyTracker()` method.

    ```java
    fitnessTracker.resetDailyTracker();
    ```

5. **Check Running Activity**: Check if more miles were run today compared to yesterday using the 
6. `didRunMoreThanYesterday()` method.

    ```java
    boolean ranMoreToday = fitnessTracker.didRunMoreThanYesterday(4.0);
    ```

## Unit Tests

Unit tests have been provided to ensure the correctness of the `FitnessTracker` class. You can find 
them in the `src/test/java/org/fitness/tracker/TestFitnessTracker.java` class. These tests cover various 
scenarios and ensure that the class behaves as expected and covers 100% test coverage.

## Dependencies

This project has no external dependencies and can be integrated into your Java project seamlessly.

