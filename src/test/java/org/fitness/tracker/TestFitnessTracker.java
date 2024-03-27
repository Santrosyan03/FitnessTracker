package org.fitness.tracker;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestFitnessTracker {

    FitnessTracker fitnessTracker = new FitnessTracker();

    @Test
    void testGetTotalSteps() {
        assertEquals(0, fitnessTracker.getTotalSteps());
    }

    @Test
    void testGetMilesRun() {
        assertEquals(0.0, fitnessTracker.getMilesRun());
    }

    @Test
    void testGetDailyCalories() {
        assertEquals(0.0, fitnessTracker.getDailyCalories());
    }

    @Test
    void testAddMilesRun() {
        assertEquals(9.1, fitnessTracker.addMilesRun(9.1));
    }

    @Test
    void testLogWorkout() {
        assertEquals("Running logged for day 3", fitnessTracker.logWorkout(3, "Running"));
    }

    @Test
    void testGetWeeklyWorkouts() {
        fitnessTracker.logWorkout(5, "Friday Workout");
        assertEquals("Friday Workout", fitnessTracker.getWeeklyWorkouts()[4]);
    }

    @Test
    void testHasMetCalorieGoal() {
        assertFalse(fitnessTracker.hasMetCalorieGoal());
        fitnessTracker.setCalorieGoal();
        assertTrue(fitnessTracker.hasMetCalorieGoal());
    }

    @Test
    void testConsumeCalories() {
        assertEquals(540, fitnessTracker.consumeCalories(540));
    }

    @Test
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
    void testIncrementTotalSteps() {
        assertEquals(6514, fitnessTracker.incrementTotalSteps(6514));
    }

    @Test
    void testDidRunMoreThanYesterday() {
        fitnessTracker.addMilesRun(6.3);
        assertTrue(fitnessTracker.didRunMoreThanYesterday(3.9));
        assertFalse(fitnessTracker.didRunMoreThanYesterday(8.1));
    }
}
