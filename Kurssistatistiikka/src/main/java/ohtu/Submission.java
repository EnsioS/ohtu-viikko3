package ohtu;

import java.util.*;

public class Submission {

    /**
     * @return the kurssi
     */
    public Kurssi getKurssi() {
        return kurssi;
    }

    /**
     * @param kurssi the kurssi to set
     */
    public void setKurssi(Kurssi kurssi) {
        this.kurssi = kurssi;
    }

    private int week;
    private int hours;
    private ArrayList<Integer> exercises;
    private Kurssi kurssi;

    public Submission(int week, int huors, ArrayList<Integer> exercises) {
        this.week = week;
        this.hours = huors;
        this.exercises = exercises;
        this.kurssi = null;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getWeek() {
        return week;
    }

    public int getHuors() {
        return hours;
    }

    public void setHuors(int huors) {
        this.hours = huors;
    }

    public ArrayList<Integer> getExercises() {
        return exercises;
    }

    public void setExercises(ArrayList<Integer> exercises) {
        this.exercises = exercises;
    }

    @Override
    public String toString() {
        String s = " viikko" + week + ": \n  tehtyjä tehtäviä: " + exercises.size() + " (maksimi " + this.kurssi.getExercises()[week - 1] + "), aikaa kului " + hours + " tuntia,  tehdyt tehtävät:";

        for (int i = 0; i < exercises.size(); i++) {
            s += " " + exercises.get(i);
        }

        return s;
    }

}
