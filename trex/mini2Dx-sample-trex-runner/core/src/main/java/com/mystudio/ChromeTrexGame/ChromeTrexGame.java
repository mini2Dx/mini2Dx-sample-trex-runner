package com.mystudio.ChromeTrexGame;

import org.mini2Dx.core.Graphics;
import org.mini2Dx.core.Mdx;
import org.mini2Dx.core.collision.CollisionBox;
import org.mini2Dx.core.font.GameFont;
import org.mini2Dx.core.game.BasicGame;
import org.mini2Dx.core.graphics.Texture;
import org.mini2Dx.core.graphics.viewport.FitViewport;
import org.mini2Dx.core.graphics.viewport.Viewport;
import sun.rmi.runtime.Log;


import static com.mystudio.ChromeTrexGame.Sounds.playDeathSound;


public class ChromeTrexGame extends BasicGame {
    public static final String GAME_IDENTIFIER = "com.mystudio.ChromeTrexGame";
    private static final String BACKGROUND_TEXTURE_LOCATION = "backrgound.png";
    //private static final String BOTTOM_TEXTURE_LOCATION = "ground.png";
    public static float GRAVITY = 1.0f;

    public static boolean inGame, jumping;
    public static final float GAME_WIDTH = 500;
    public static final float GAME_HEIGHT = 500;
    private static float GAME_GRAVITY = 0.6f;


    private boolean deadTrex;
    public static int trexScore, highestScore;


    InputHandler inputHandler;
    Viewport fitViewport;
    Trex trexTexture;
    TrexData trexData;
    Trex trex;
    Obstacle obstacle;
    Obstacle[] obstacles;
    Obstacle obstacleTexture;
    Sounds gameSounds;
    //colisiones de el techo y el suelo del juego
    CollisionBox[] colliderBottom, obstacleCollider;
    Texture background;
    //Texture ground;
    UI ui;

    @Override
    public void initialise() {
        GRAVITY = 0.0f;
        inGame = false;
        jumping = false;
        deadTrex = false;
        trexScore = 0;
        obstacles = new Obstacle[5];
        inputHandler = new InputHandler();
        ui = new UI(0);
        obstacle = new Obstacle();

        //textures y el cuadro
        obstacleTexture = new Obstacle();
        trex = new Trex();

        fitViewport = new FitViewport(GAME_WIDTH, GAME_HEIGHT);

        //trex data
        trexData = new TrexData();
        trexData.loadTrexData();
        highestScore = trexData.getHighScore();
        gameSounds = new Sounds();
    }

    @Override
    public void update(float delta) {
        trexScore += 1.0;

        if (deadTrex == false) {
            if (inputHandler.spacePressed()) {
                inGame = true;
            }
            if (inGame == true && inputHandler.spacePressed()) {
                jumping = true;
                GRAVITY = GAME_GRAVITY;

            }
        } else {
            if (trexScore > highestScore) {
                trexData.saveTrexData(trexScore);
            }
            initialise();
        }
        trex.update(inputHandler.spacePressed(), delta);
        obstacle.update(delta);
        System.out.println(trexScore);
        checkCollisions();
    }


    @Override
    public void render(Graphics g) {
        //ground = Mdx.graphics.newTexture(Mdx.files.internal(BOTTOM_TEXTURE_LOCATION));
        // background = Mdx.graphics.newTexture(Mdx.files.internal(BACKGROUND_TEXTURE_LOCATION));
        fitViewport.apply(g);
        //obstacleTexture.render(g);
        trex.render(g);
        obstacle.render(g);
        //g.drawTexture(background, GAME_WIDTH, GAME_HEIGHT);
        // g.drawTexture(ground, 0f, GAME_HEIGHT - ground.getHeight());
        //SCORE

        ui.set(trexScore);

    }

    void checkCollisions() {
        for (int i = 0; i < 5; i++) {

//            if (!obstacles[5].getObsPoint().intersects(trex.getTrexPoint())) {
//                continue;
//            }
//            setDead();
//            break;
            //System.out.println("collides");
        }
    }

    void setDead() {
        deadTrex = true;
        GRAVITY = 0f;
        playDeathSound();
    }

    public static void setScore(int score) {
        trexScore = score;

    }

    public static int getScore() {
        return trexScore;
    }


}

