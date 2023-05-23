
import java.awt.Graphics;
import java.util.LinkedList;

public class stores {

    LinkedList<object> object = new LinkedList<object>();
    LinkedList<Block> blocks = new LinkedList<Block>();
    public static int playerindex = 0;

    public void tick() {
        for (int i = 0; i < object.size(); i++) {
            object o = object.get(i);
            int tick = Game.limit(object.get(playerindex).getY() / Game.HEIGHT * Game.HEIGHT,
                    -(object.get(playerindex).getY() / Game.HEIGHT * Game.HEIGHT), o.getY());
            if (tick == object.get(playerindex).getY() / Game.HEIGHT * Game.HEIGHT
                    || tick == -(object.get(playerindex).getY() / Game.HEIGHT * Game.HEIGHT)) {
                o.tick();
            }
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            object o = object.get(i);
            int render = Game.limit(object.get(playerindex).getY() / Game.HEIGHT * Game.HEIGHT,
                    -(object.get(playerindex).getY() / Game.HEIGHT * Game.HEIGHT), o.getY());
            if (render == object.get(playerindex).getY() / Game.HEIGHT * Game.HEIGHT
                    || render == -(object.get(playerindex).getY() / Game.HEIGHT * Game.HEIGHT)) {
                o.render(g);
            }
        }
    }

    public void remove(object o) {
        this.object.remove(o);
    }

    public void add(object o) {
        this.object.add(o);
    }

    public void addBlock(object o) {
        this.object.add(o);
        this.blocks.add((Block) o);
    }

}
