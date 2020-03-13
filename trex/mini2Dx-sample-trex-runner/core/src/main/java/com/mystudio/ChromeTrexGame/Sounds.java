package com.mystudio.ChromeTrexGame;

import org.mini2Dx.core.Mdx;
import org.mini2Dx.core.audio.Sound;

import java.io.IOException;

public class Sounds {

    private static final String DEATH_SOUND_LOCATION = "Sounds/death.wav";
    static long DEATH_SOUND_ID;
    static Sound deathSound;

    static {
        try {
            deathSound = Mdx.audio.newSound(Mdx.files.internal(DEATH_SOUND_LOCATION));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void playDeathSound() {
        DEATH_SOUND_ID = deathSound.play(1f);

    }


}
