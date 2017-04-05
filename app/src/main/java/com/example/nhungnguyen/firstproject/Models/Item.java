package com.example.nhungnguyen.firstproject.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Copy right asiantech
 * Created by asiantech on 4/5/17.
 */

public class Item {
    @SerializedName("owner")
    @Expose
    private Owner owner;
    @SerializedName("is_accepted")
    @Expose
    private Boolean is_accepted;
    @SerializedName("score")
    @Expose
    private Integer score;
    @SerializedName("last_activity_date")
    @Expose
    private Integer lastActivityDate;
    @SerializedName("creation_date")
    @Expose
    private Integer creationDate;
    @SerializedName("answer_id")
    @Expose
    private Integer answerId;
    @SerializedName("question_id")
    @Expose
    private Integer questionId;
    @SerializedName("last_edit_date")
    @Expose
    private Integer last_edit_date;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Boolean getIs_accepted() {
        return is_accepted;
    }

    public void setIs_accepted(Boolean is_accepted) {
        this.is_accepted = is_accepted;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(Integer lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public Integer getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Integer creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getLast_edit_date() {
        return last_edit_date;
    }

    public void setLast_edit_date(Integer last_edit_date) {
        this.last_edit_date = last_edit_date;
    }
}
