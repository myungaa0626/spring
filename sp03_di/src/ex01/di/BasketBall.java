package ex01.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BasketBall {
	
	@Autowired // 자동 주입된다.
	@Qualifier("player2")
	private PlayerImpl player;

	public void setPlayer(PlayerImpl player) { // DI
		this.player = player;
	}
	
	
	
}
