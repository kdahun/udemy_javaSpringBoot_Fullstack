package com.example.demo.game;

public class GameRunner {
	private GamingConsole game;
	
	// GameRunner의 생성자
	public GameRunner(GamingConsole game) {
		// MarioGame의 객체를 받아서 변수에 저장
		this.game = game;
	}
	public void run() {
		
		System.out.println("runner : " + game);
		game.up();
		game.down();
		game.left();
		game.right();
	}
	
}
