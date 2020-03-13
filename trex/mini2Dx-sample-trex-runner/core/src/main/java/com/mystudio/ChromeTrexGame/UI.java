package com.mystudio.ChromeTrexGame;

import org.mini2Dx.core.Graphics;

import static com.mystudio.ChromeTrexGame.ChromeTrexGame.trexScore;

public class UI {
    private String score;

    public UI(int score) {
        set(score);
    }

    public void set(int score) {
        this.score = "Score: " + Integer.toString(trexScore);
    }

    public void render(Graphics g) {

        g.drawString(score, 250, 0);
    }
}
