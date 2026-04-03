package com.memeacademy.model;

public class QuizItem {
    private final String memeKey;
    private String question;
    private String[] enableAnswer;
    private String originUrl;
    private String hint;

    public QuizItem(String memeKey, String question, String[] enableAnswer, String originUrl, String hint) {
        this.memeKey = memeKey;
        this.question = question;
        this.enableAnswer = enableAnswer;
        this.originUrl = originUrl;
        this.hint = hint;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getEnableAnswer() {
        return enableAnswer;
    }

    public String getOriginUrl() {
        return originUrl;
    }

    public String getHint() {
        return hint;
    }
}
