package com.botchan;

public class Context {

    private Query query;

    private String theme;

    private String[] arguments;

    private String[] targets;

    private boolean followUp;

    public Context(Query type)
    {
        this.query = type;
    }
    
    public Query getQuery() {
        return query;
    }
    public void setQuery(Query query) {
        this.query = query;
    }
    public String getTheme() {
        return theme;
    }
    public void setTheme(String theme) {
        this.theme = theme;
    }
    public String[] getArguments() {
        return arguments;
    }
    public void setArguments(String[] arguments) {
        this.arguments = arguments;
    }
    public String[] getTargets() {
        return targets;
    }
    public void setTargets(String[] targets) {
        this.targets = targets;
    }
    public boolean isFollowUp() {
        return followUp;
    }
    public void setFollowUp(boolean followUp) {
        this.followUp = followUp;
    }
    public enum Query {
        Order,
        Question,
        Command,
        Chat,
    }
}
