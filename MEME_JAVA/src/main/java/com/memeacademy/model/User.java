package com.memeacademy.model;

import java.util.ArrayList;

public class User {
    private final String userName;
    private final String memeCategory;
    private int score;
    private int rank;
    private final ArrayList<QuizItem> solvedQuizList = new ArrayList<>();


    public User(String userName, String memeCategory) {
        this.userName = userName;
        this.memeCategory = memeCategory;
        this.score = 0;
    }

    public String getUserName() {
        return userName;
    }

    public String getMemeCategory() {
        return memeCategory;
    }

    public void setOneTryScore() {
        this.score += 10;
    }

    public void setTwoTryScore() {
        this.score += 5;
    }

    public int getScore() {
        return score;
    }

    public void addSolvedQuiz(QuizItem quizItem) {
        solvedQuizList.add(quizItem);
    }

    public ArrayList<QuizItem> getSolvedQuizList() {
        return solvedQuizList;
    }

}
