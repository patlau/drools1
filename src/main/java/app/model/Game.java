package app.model;

import java.util.Random;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Game {
	
	private static Random r = new Random();
	
	final int num = r.nextInt(9);
	int maxCount = 5;
	int count = 0;
	
}
