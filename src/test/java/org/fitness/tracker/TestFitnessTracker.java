package org.fitness.tracker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestFitnessTracker {
    private FitnessTracker fitnessTracker;

    @BeforeEach
    @DisplayName("Initializing fitness tracker to use in tests.")
    public void initialize() {
        fitnessTracker = new FitnessTracker();
    }

    @Test
    @DisplayName("Test to get total steps.")
    void testGetTotalSteps() {
        assertEquals(0, fitnessTracker.getTotalSteps());
    }

    @Test
    @DisplayName("Test to get total miles run.")
    void testGetMilesRun() {
        assertEquals(0.0, fitnessTracker.getMilesRun());
    }

    @Test
    @DisplayName("Test to get daily calories.")
    void testGetDailyCalories() {
        assertEquals(0.0, fitnessTracker.getDailyCalories());
    }

    @Test
    @DisplayName("Test to add miles run.")
    void testAddMilesRun() {
        assertEquals(9.1, fitnessTracker.addMilesRun(9.1));
    }

    @Test
    @DisplayName("Test to log weekly workout.")
    void testLogWorkout() {
        String[] expectedWorkouts = {
                "Monday workout logged for day 1",
                "Tuesday workout logged for day 2",
                "Wednesday workout logged for day 3",
                "Thursday workout logged for day 4",
                "Friday workout logged for day 5",
                "Saturday workout logged for day 6",
                "Sunday workout logged for day 7"
        };

        fitnessTracker.logWorkout(1, "Monday workout logged for day 1");
        fitnessTracker.logWorkout(2, "Tuesday workout logged for day 2");
        fitnessTracker.logWorkout(3, "Wednesday workout logged for day 3");
        fitnessTracker.logWorkout(4, "Thursday workout logged for day 4");
        fitnessTracker.logWorkout(5, "Friday workout logged for day 5");
        fitnessTracker.logWorkout(6, "Saturday workout logged for day 6");
        fitnessTracker.logWorkout(7, "Sunday workout logged for day 7");

        String[] actualWorkouts = fitnessTracker.getWeeklyWorkouts();
        assertArrayEquals(expectedWorkouts, actualWorkouts);
    }

    @Test
    @DisplayName("Test to get weekly workouts")
    void testGetWeeklyWorkouts() {
        fitnessTracker.logWorkout(5, "Friday Workout");
        assertEquals("Friday Workout", fitnessTracker.getWeeklyWorkouts()[4]);
    }

    @Test
    @DisplayName("Test to check if a person has mer calorie goal")
    void testHasMetCalorieGoal() {
        assertFalse(fitnessTracker.hasMetCalorieGoal());
        fitnessTracker.setCalorieGoal();
        assertTrue(fitnessTracker.hasMetCalorieGoal());
    }

    @Test
    @DisplayName("Test to consume calories")
    void testConsumeCalories() {
        assertEquals(540, fitnessTracker.consumeCalories(540));
    }

    @Test
    @DisplayName("Test to reset daily tracker")
    void testResetDailyTracker() {
        fitnessTracker.addMilesRun(5.9);
        fitnessTracker.consumeCalories(981);
        fitnessTracker.setCalorieGoal();
        fitnessTracker.resetDailyTracker();
        assertEquals(0, fitnessTracker.getTotalSteps());
        assertEquals(0.0, fitnessTracker.getMilesRun());
        assertEquals(0.0, fitnessTracker.getDailyCalories());
        assertFalse(fitnessTracker.hasMetCalorieGoal());
    }

    @Test
    @DisplayName("Test to increment total steps")
    void testIncrementTotalSteps() {
        assertEquals(6514, fitnessTracker.incrementTotalSteps(6514));
    }

    @Test
    @DisplayName("Test to check if a person has run more than yesterday")
    void testDidRunMoreThanYesterday() {
        fitnessTracker.addMilesRun(6.3);
        assertTrue(fitnessTracker.didRunMoreThanYesterday(3.9));
        assertFalse(fitnessTracker.didRunMoreThanYesterday(8.1));
    }
}
