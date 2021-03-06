package graphics.character;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import mechanics.character.Player;
import graphics.GamePlayCommon;
import graphics.MainPanel;
import graphics.util.Coordinate;

public class PlayerDisplay implements GamePlayCommon {

	private Image playerImage;
	private final String playerImagePath = "images/Actor1.png";
	
	private MainPanel panel;
	private Coordinate playerImageCoord = new Coordinate(0,0);
	
	public PlayerDisplay(MainPanel panel){
		this.panel = panel;
		loadImage();
	}
	
	@Override
	public void draw(Graphics g, int offsetX, int offsetY) {
		Player player = Player.getPlayer();
		
		int c = player.getpc();
		int r = player.getpr();

		g.drawImage(playerImage, 
					c * CS + offsetX, 
					r * CS + offsetY,
					c * CS + CS + offsetX, 
					r * CS + CS + offsetY, 
					playerImageCoord.getX()*CS, 
					playerImageCoord.getY()*CS, 
					playerImageCoord.getX()*CS + CS, 
					playerImageCoord.getY()*CS + CS, 
					panel);
	}
	
	private void loadImage(){
		
		ImageIcon icon = new ImageIcon(getClass().getResource(playerImagePath));
		playerImage = icon.getImage();
		
	}
}
