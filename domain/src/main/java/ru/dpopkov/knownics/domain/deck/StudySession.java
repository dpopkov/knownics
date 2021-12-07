package ru.dpopkov.knownics.domain.deck;

import java.util.Date;

/*
 * Implement as Embedded component.
 */
public class StudySession {

    private Date started;
    private Date finished;
    private int currentCardIndex;
    private int successCount;
    private int resetCount;
    // private Deck deck; // m.b not needed - use unidirectional assoc from Deck


    public Date getStarted() {
        return started;
    }

    public void setStarted(Date started) {
        this.started = started;
    }

    public Date getFinished() {
        return finished;
    }

    public void setFinished(Date finished) {
        this.finished = finished;
    }

    public int getCurrentCardIndex() {
        return currentCardIndex;
    }

    public void setCurrentCardIndex(int currentCardIndex) {
        this.currentCardIndex = currentCardIndex;
    }

    public int getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(int successCount) {
        this.successCount = successCount;
    }

    public int getResetCount() {
        return resetCount;
    }

    public void setResetCount(int resetCount) {
        this.resetCount = resetCount;
    }
}
