package org.fitness.tracker;

import java.util.Arrays;

public class FitnessTracker {

    private int totalSteps;
    private double milesRun;
    private final String[] weeklyWorkouts;
    private boolean metCalorieGoal;
    private int dailyCalories;

    public FitnessTracker() {
        this.totalSteps = 0;
        this.milesRun = 0.0;
        this.weeklyWorkouts = new String[7];
        this.metCalorieGoal = false;
        this.dailyCalories = 0;
    }

    public int getTotalSteps() {
        return this.totalSteps;
    }

    public double getMilesRun() {
        return this.milesRun;
    }

    public double getDailyCalories() {
        return this.dailyCalories;
    }

    public double addMilesRun(double miles) {
        milesRun += miles;
        return milesRun;
    }

    public String logWorkout(int dayOfWeek, String workout) {
        int index = dayOfWeek-1;
        weeklyWorkouts[index] = workout;
        return workout + " logged for day " + dayOfWeek;
    }

    public String[] getWeeklyWorkouts() {
        return Arrays.copyOf(weeklyWorkouts, weeklyWorkouts.length);
    }

    public boolean hasMetCalorieGoal() {
        return metCalorieGoal;
    }

    public void setCalorieGoal() {
        this.metCalorieGoal = !metCalorieGoal;
    }

    public int consumeCalories(int calories) {
        dailyCalories += calories;
        return dailyCalories;
    }

    public void resetDailyTracker() {
        this.totalSteps = 0;
        this.milesRun = 0.0;
        this.dailyCalories = 0;
        this.metCalorieGoal = false;
    }

    public int incrementTotalSteps(int steps) {
        this.totalSteps += steps;
        return this.totalSteps;
    }

    public boolean didRunMoreThanYesterday(double yesterdayRunMiles) {
        return this.milesRun > yesterdayRunMiles;
    }
}
