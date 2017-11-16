
package ohtu;

/**
 *
 * @author ensio
 */
public class Kurssi {
    
    private String name;
    private String term;
    private int[] exercises;

    public Kurssi(String name, String term, int[] exercises) {
        this.name = name;
        this.term = term;
        this.exercises = exercises;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public int[] getExercises() {
        return exercises;
    }

    public void setExercises(int[] exercises) {
        this.exercises = exercises;
    }
      
}
