package com.example.demo;

import com.example.demo.game.GameRunner;
import com.example.demo.game.MarioGame;
import com.example.demo.game.PacMan;
import com.example.demo.game.SuperContraGame;

public class App01GamingBasicJava {

	public static void main(String[] args) {
		// MarioGame 객체 생성
		//var game = new MarioGame();
		
		// var game = new SuperContraGame();
		
		var game  = new PacMan();
		
		// GameRunner 객체 생성 + 인수로 marioGame
		var gameRunner = new GameRunner(game);
		
		// gameRunner에 있는 run 메서드 실행
		gameRunner.run();
	}

}
