package com.mystudio.ChromeTrexGame;


import org.mini2Dx.core.Graphics;
import org.mini2Dx.core.Mdx;
import org.mini2Dx.core.collision.CollisionBox;
import org.mini2Dx.core.collision.CollisionPoint;
import org.mini2Dx.core.graphics.Animation;
import org.mini2Dx.core.graphics.SpriteSheet;
import org.mini2Dx.core.graphics.Texture;
import org.mini2Dx.gdx.math.Vector2;

import static com.mystudio.ChromeTrexGame.ChromeTrexGame.*;


public class Trex {

    public static float trex_x = 200;

    public static float trexY = 0;

    private float trexTextureHeight, trexTextureWidht;


    private float trexAccel = 0.0f;


    public static final CollisionPoint trexPoint = new CollisionPoint();
    public static final String TREX_LOCATION = "Trex/trex1.png";
    private Physics physics;

    Texture obstacleTexture = Mdx.graphics.newTexture(Mdx.files.internal(TREX_LOCATION));

//    public float frameDuration = 0.025f;

//    Texture spriteTexture = Mdx.graphics.newTexture(Mdx.files.internal(TREX_SPRITE_SHEET_LOCATION));
//    SpriteSheet trexSpriteSheet = new SpriteSheet(spriteTexture, 512, 512);

    public static CollisionPoint getTrexPoint() {
        return trexPoint;
    }
//    Animation trexAnimation = new Animation();

    public Trex() {
        physics = new Physics(trexPoint, 1);
        // trexCollisionBox = generateCollisionAt(trex_x, trexY);
        trex_x = trexTextureWidht;

    }


    void update(boolean isJumping, float delta) {
        //trexAnimation.setLooping(true);
        // trexAnimation.update(delta);
        //trexCollisionBox.set(trexCollisionBox.getX() + 4f, trexCollisionBox.getY() + 4f);
        if (inGame) {
            trexPoint.set(trexPoint.getX() + 2f, trexPoint.getY());
            //physics.addForce(new Vector2(20,0));
            //System.out.println("hn");
            if (jumping) {
                // trexPoint.set(trexPoint.getX() , trexPoint.getY()- 4f);
                physics.addForce(new Vector2(0, -5));
                System.out.println("jump");
                trexPoint.y = 299;
                jumping = false;
            }
        }
        if (trexPoint.y < 300) {
            physics.update(delta);
        } else {
            physics.setVelocity(0, 0);
        }
    }

    CollisionBox generateCollisionAt(float xPos, float yPos) {
        int tempX = (int) xPos;
        int tempY = (int) yPos;
        return new CollisionBox(tempX, tempY, trexTextureHeight, trexTextureWidht);
    }


    private void settingTrexJumping() {
        trexAccel = -9.0f;
    }

    public void render(Graphics g) {

        //trexAnimation.draw(g, trex_x, trexY);
        //  g.drawTexture(obstacleTexture, trex_x, trexY);
        g.drawTexture(obstacleTexture, trexPoint.getRenderX(), trexPoint.getRenderY());

    }

    public void interpolate(float alpha) {

        trexPoint.interpolate(alpha);
    }


    float getTrexX() {
        return trex_x;
    }

    float getTrexY() {
        return trexY;
    }


    float getTrexTextureWidht() {
        return trexTextureWidht;
    }

    void calcTrexXPos() {
        trex_x += trexAccel;
        //trexCollisionBox.setX(trex_x);
    }
}

