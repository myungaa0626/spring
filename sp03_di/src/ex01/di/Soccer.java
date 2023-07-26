package ex01.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Soccer {

	
	@Autowired
	@Qualifier("player2")
	private PlayerImpl player;

	public void setPlayer(PlayerImpl player) { // DI
		this.player = player;
	}

}
