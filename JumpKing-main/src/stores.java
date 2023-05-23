import java.awt.Graphics;
import java.util.Collections;
import java.util.LinkedList;
//This class stores all object in the game.
public class stores {
	//a linked list for all object in the game.
	LinkedList<object> object = new LinkedList<object>();
	//a linked list for all blocks in the game.
	LinkedList<Block> blocks = new LinkedList<Block>();
	//finds the player index.
	public static int playerindex = 0;
	public void rememberPlayerindex() {
		for(int i = 0; i < object.size(); i++) {
			if(object.get(i).getid() == ID.Player) {
				playerindex = i;
			}
		}
	}
	//ticks all the object that the camera renders.
	public void tick() {
		for(int i = 0; i < object.size(); i++) {
			object o = object.get(i);
			int tick = Game.limit(object.get(playerindex).getY()/Game.HEIGHT * Game.HEIGHT,
					-(object.get(playerindex).getY()/Game.HEIGHT * Game.HEIGHT), o.getY());
			if( tick == object.get(playerindex).getY()/Game.HEIGHT * Game.HEIGHT ||
					tick == -(object.get(playerindex).getY()/Game.HEIGHT * Game.HEIGHT)) {
				o.tick();
			}
		}
	}
	//render all the object that the camera include.
	public void render(Graphics g) {
		for(int i = 0; i < object.size(); i++) {
			object o = object.get(i);
			int render = Game.limit(object.get(playerindex).getY()/Game.HEIGHT * Game.HEIGHT,
					-(object.get(playerindex).getY()/Game.HEIGHT * Game.HEIGHT), o.getY());
			if( render == object.get(playerindex).getY()/Game.HEIGHT * Game.HEIGHT ||
					render == -(object.get(playerindex).getY()/Game.HEIGHT * Game.HEIGHT)) {
				o.render(g);
			}
			}
	}
	//merges blocks horizontally to make decrease the amount of unnecessary tick between object that is
	//far away.
	public void merge() {
		Collections.sort(blocks,new SortX());
		Collections.sort(blocks);
		int index = 0;
		while(index < blocks.size()-1) {
			Block temp1 = blocks.get(index);
			Block temp2 = blocks.get(index+1);
			if(temp1.getY() == temp2.getY() && temp1.getX() + temp1.getWidth() == temp2.getX()) {
				blocks.get(index).setWidth(blocks.get(index).getWidth() + 32);
				blocks.remove(index+1);
			}else index++;
			
		}
	}
	//remove an object from the linked list.
	public void remove(object o) {
		this.object.remove(o);
	}
	//add an object to the linked list
	public void add(object o) {
		this.object.add(o);
	}
	//add a block
	public void addBlock(object o) {
		this.object.add(o);
		this.blocks.add((Block)o);
	}
	
}
