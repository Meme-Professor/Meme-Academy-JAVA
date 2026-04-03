package com.memeacademy.model;

import com.memeacademy.constant.MemeCategory;
import com.memeacademy.contents.Meme2024;
import com.memeacademy.contents.Meme2025;
import com.memeacademy.contents.MemeClassic;

import java.util.ArrayList;

public class QuizBank {
    private final Meme2024 meme2024;
    private final Meme2025 meme2025;
    private final MemeClassic classicMeme;

    public QuizBank() {
        this.meme2024 = new Meme2024();
        this.meme2025 = new Meme2025();
        this.classicMeme = new MemeClassic();
    }

    public ArrayList<QuizItem> getQuizListByCategory(String category) {
        return switch (category) {
            case MemeCategory.MEME_2024 -> meme2024.getMemes2024();
            case MemeCategory.MEME_2025 -> meme2025.getMemes2025();
            case MemeCategory.MEME_CLASSIC -> classicMeme.getMemesClassic();
            default -> new ArrayList<>();
        };
    }
}