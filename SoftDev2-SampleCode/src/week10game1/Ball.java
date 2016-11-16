package week10game1;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball implements Actor {
	static Color colors[] = {Color.BLACK, Color.CYAN, Color.red, Color.GREEN, Color.yellow, Color.BLUE, Color.MAGENTA, Color.LIGHT_GRAY, Color.PINK};
	
	float x,y,vx,vy;
	int size;
	Color color;
	GameBoard gameBoard;
	
	public Ball(GameBoard gb, int cx, int cy){
		Random generator = new Random(); 
		
		gameBoard = gb;
		size = (generator.nextInt(3)+1) *20;
		x = cx-((float)size/2);
		y = cy -((float)size/2);
		//System.out.println("new Ball "+x +","+y+":"+cx+","+cy+"::"+size);
		vx = generator.nextFloat()*3 - 1.5f;
		vy = generator.nextFloat()*3 - 1.5f;
		color = colors[generator.nextInt(colors.length)];
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval((int)x, (int)y, size, size);
		
	}

	@Override
	public void tick(){
		x+=vx;
		y+=vy;
		
		// bounds checking
		if (x < 0){
			vx = Math.abs(vx);
		}
		
		if (y < 0){
			vy = Math.abs(vy);
		}
		if (x > gameBoard.getWidth()- size){
			vx = -Math.abs(vx);
		}
		
		if (y > gameBoard.getHeight()- size){
			vy = -Math.abs(vy);
		}
	}

}
