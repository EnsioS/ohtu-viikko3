package statistics.matcher;

import statistics.Player;

public class QueryBuilder {

    Matcher matcher;
    boolean ready;

    public QueryBuilder() {
        ready = false;
        initialize();
    }

    private void initialize() {
        if (!ready) {
            ready = true;
            matcher = new Matcher() {
                @Override
                public boolean matches(Player p) {
                    return true;
                }
            };
        }
    }

    public Matcher build() {
        ready = false;
        return matcher;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        initialize();
        this.matcher = new And(matcher, new HasAtLeast(value, category));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        initialize();
        this.matcher = new And(matcher, new HasFewerThan(value, category));
        return this;
    }

    public QueryBuilder playsIn(String team) {
        initialize();
        this.matcher = new And(matcher, new PlaysIn(team));
        return this;
    }

    public QueryBuilder not(Matcher matcher) {
        initialize();
        this.matcher = new And(this.matcher, new Not(matcher));
        return this;
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        initialize();
        this.matcher = new Or(matchers);
        return this;
    }
}
