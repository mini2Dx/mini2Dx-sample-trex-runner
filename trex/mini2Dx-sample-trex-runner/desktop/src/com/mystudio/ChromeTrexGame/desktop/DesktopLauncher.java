package com.mystudio.ChromeTrexGame.desktop;


import com.badlogic.gdx.backends.lwjgl.DesktopMini2DxGame;

import com.mystudio.ChromeTrexGame.ChromeTrexGame;
import org.mini2Dx.libgdx.desktop.DesktopMini2DxConfig;

public class DesktopLauncher {
	public static void main (String[] arg) {
		DesktopMini2DxConfig config = new DesktopMini2DxConfig(ChromeTrexGame.GAME_IDENTIFIER);
		config.vSyncEnabled = true;
		new DesktopMini2DxGame(new ChromeTrexGame(), config);
	}
}
