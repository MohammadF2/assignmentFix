package xyz.mohammadf.assignmentfix.model;

import androidx.annotation.Nullable;

import java.util.Date;

public class Task {

    private String title;
    private String description;
    private Date dueDate;
    private String answer;

    private boolean solved;



    public Task(String title, String description, Date dueDate, String answer) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.answer = answer;
    }


    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        Task t = (Task) obj;
        assert t != null;
        return title.equals(t.getTitle());
    }
}
