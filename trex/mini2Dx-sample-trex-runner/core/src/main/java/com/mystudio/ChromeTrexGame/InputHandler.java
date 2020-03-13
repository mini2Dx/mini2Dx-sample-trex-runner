package com.mystudio.ChromeTrexGame;

import org.mini2Dx.core.Mdx;
import org.mini2Dx.gdx.Input;

public class InputHandler {

    boolean spacePressed() {

        return Mdx.input.isKeyJustPressed(Input.Keys.SPACE);

    }
}
