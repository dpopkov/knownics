package ru.dpopkov.knownics.domain.deck;

import java.time.LocalDateTime;

/*
 * Implement as Embedded component.
 */
public class StudySession {

    private LocalDateTime started;
    private LocalDateTime finished;
    private int currentCardIndex;
    private int successCount;
    private int resetCount;
    // private Deck deck; // m.b not needed - use unidirectional assoc from Deck


    public LocalDateTime getStarted() {
        return started;
    }

    public void setStarted(LocalDateTime started) {
        this.started = started;
    }

    public LocalDateTime getFinished() {
        return finished;
    }

    public void setFinished(LocalDateTime finished) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudySession)) return false;

        StudySession that = (StudySession) o;

        if (!getStarted().equals(that.getStarted())) return false;
        return getFinished() != null ? getFinished().equals(that.getFinished()) : that.getFinished() == null;
    }

    @Override
    public int hashCode() {
        int result = getStarted().hashCode();
        result = 31 * result + (getFinished() != null ? getFinished().hashCode() : 0);
        return result;
    }
}
