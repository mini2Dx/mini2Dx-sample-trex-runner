package com.mystudio.ChromeTrexGame;


import org.mini2Dx.core.Graphics;
import org.mini2Dx.core.Mdx;
import org.mini2Dx.core.collision.CollisionBox;
import org.mini2Dx.core.collision.CollisionPoint;
import org.mini2Dx.core.graphics.Animation;
import org.mini2Dx.core.graphics.SpriteSheet;
import org.mini2Dx.core.graphics.Texture;

import static com.mystudio.ChromeTrexGame.ChromeTrexGame.inGame;

public class Obstacle {

    private float collisionRectHeight;
    private float collisionRectWidth;

    public CollisionPoint obsPoint = new CollisionPoint();
    private Physics physics;


    public static final String OBSTACLE_LOCATION = "rock.png";

    Texture obstacleTexture = Mdx.graphics.newTexture(Mdx.files.internal(OBSTACLE_LOCATION));



    public Obstacle() {

        physics = new Physics(obsPoint, 4);
        obsPoint.x = 200;
        obsPoint.y = 50;
        obsPoint.add(new CollisionPoint(1, 1));

    }

    public void render(Graphics g) {

        g.drawTexture(obstacleTexture, obsPoint.getRenderX(), obsPoint.getRenderY());

    }

    void update(float delta) {
        obsPoint.set(obsPoint.getX(), obsPoint.getY());
        //generateObstacleAtPos(400,40);

        if (obsPoint.y < 300) {
            physics.update(delta);
        } else {
            physics.setVelocity(0, 0);
        }
    }
    public CollisionPoint getObsPoint() {
        return obsPoint;
    }
    CollisionBox generateObstacleCollisionRectAt(float xPos, float yPos) {

        return new CollisionBox(xPos, yPos, collisionRectWidth, collisionRectHeight);
    }


}
