package com.mystudio.ChromeTrexGame;

import org.mini2Dx.core.Mdx;

import org.mini2Dx.core.exception.PlayerDataException;
import org.mini2Dx.core.serialization.annotation.Field;


public class TrexData {
    @Field
    private int highScore;

    private static final String DATA_LOCATION = "playerdata.json";

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public void saveTrexData(int highScore) {

        try {
            TrexData data = new TrexData();
            data.setHighScore(highScore);
            Mdx.playerData.writeJson(data, DATA_LOCATION);


        } catch (PlayerDataException e) {
            System.out.println("Unable to save data.");
            e.printStackTrace();

        }
    }

    public void loadTrexData() {
        try {
            TrexData data = Mdx.playerData.readJson(TrexData.class, DATA_LOCATION);
            setHighScore(data.getHighScore());
        } catch (PlayerDataException e) {
            setHighScore(0);
        } catch (Exception e) {
            setHighScore(0);
        }
    }
}