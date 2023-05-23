
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Player extends object {

    private int width = 45;
    private int height = 45;
    public stores stores;
    private boolean canJump;
    private boolean offGround = false;
    private boolean isCharging = false;
    private int jumpStrength = 0;
    private int jumpSpeed = 5;
    private boolean right = true;
    private int action = 0;
    private final int resting = 0;
    private final int running = 1;
    private final int stop = 3;
    private final int bouncing = 4;
    private final int jumping = 5;
    private final int falling = 6;
    private final int charging = 7;
    private int countRun = 3;
    private int count = 3;

    public Player(int x, int y, ID id, stores stores) {
        super(x, y, id);
        this.stores = stores;

    }

    @Override
    public Rectangle getSkeleton() {
        return new Rectangle(x, y, width, height);
    }

    @Override
    public void tick() {
        gravity();
        XYcollision();
        x += dx;
        y += dy;
        x = Game.limit(Game.WIDTH - width, 0, x);
        if (y == Game.HEIGHT - 68) {
            offGround = false;
        }
        canJump = !offGround;
    }

    @Override
    public void render(Graphics g) {
        if (Math.abs(dx) == 2) {
            action = running;
            count++;
            if (count % 20 == 0) {
                countRun = count % 3;
            }
        } else if (dy > 0 && offGround && action != bouncing) {
            action = falling;
        } else if (dy < 0 && action != bouncing && offGround) {
            action = jumping;
        } else if (dx == 0 && dy == 0 && !isCharging) {
            action = stop;
        }
        if (right) {
            switch (action) {
                case running:
                    switch (countRun) {
                        case 0:
                            g.drawImage(Textures.rightWalking1.load(), x, y, null);
                            break;
                        case 1:
                            g.drawImage(Textures.rightWalking2.load(), x, y, null);
                            break;
                        case 2:
                            g.drawImage(Textures.rightWalking3.load(), x, y, null);
                            break;
                    }
                    break;
                case resting:
                    g.drawImage(Textures.resting.load(), x, y, null);
                    break;
                case stop:
                    g.drawImage(Textures.rightStanding.load(), x, y, null);
                    break;
                case bouncing:
                    g.drawImage(Textures.rightbouncing.load(), x, y, null);
                    break;
                case jumping:
                    g.drawImage(Textures.rightJump.load(), x, y, null);
                    break;
                case falling:
                    g.drawImage(Textures.rightfalling.load(), x, y, null);
                    break;
                case charging:
                    g.drawImage(Textures.charging.load(), x, y, null);
                    break;

            }
        } else {
            switch (action) {
                case running:
                    switch (countRun) {
                        case 0:
                            g.drawImage(Textures.leftWalking1.load(), x, y, null);
                            break;
                        case 1:
                            g.drawImage(Textures.leftWalking2.load(), x, y, null);
                            break;
                        case 2:
                            g.drawImage(Textures.leftWalking3.load(), x, y, null);
                            break;
                    }
                    break;
                case resting:
                    g.drawImage(Textures.resting.load(), x, y, null);
                    break;
                case stop:
                    g.drawImage(Textures.leftStanding.load(), x, y, null);
                    break;
                case bouncing:
                    g.drawImage(Textures.leftbouncing.load(), x, y, null);
                    break;
                case jumping:
                    g.drawImage(Textures.leftJump.load(), x, y, null);
                    break;
                case falling:
                    g.drawImage(Textures.leftfalling.load(), x, y, null);
                    break;
                case charging:
                    g.drawImage(Textures.charging.load(), x, y, null);
                    break;
            }
        }

    }

    public Rectangle getSkeletonRL() {
        int xx = (int) (x + dx);
        int xv = (int) (width + dx);
        return new Rectangle(xx, y, xv, height);
    }

    public Rectangle getSkeletonUD() {
        int yy = (int) (y + dy);
        int yv = (int) (height + dy);
        return new Rectangle(x, yy, width, yv);
    }

    public void gravity() {
        if (offGround) {
            dy += Game.Gravity;
            if (dy > Game.T_V) {
                dy = Game.T_V;
            }
        }
    }

    public void XYcollision() {
        for (int i = 0; i < stores.blocks.size(); i++) {
            Block temp = (Block) stores.blocks.get(i);
            if (getSkeletonRL().intersects(temp.getSkeleton())) {
                if (dx > 0) {
                    if (offGround) {
                        dx = -(dx - 2);
                        action = bouncing;
                    } else {
                        dx = 0;
                    }
                    x = temp.getX() - width;
                } else if (dx < 0) {
                    if (offGround) {
                        dx = -(dx + 2);
                        action = bouncing;
                    } else {
                        dx = 0;
                    }
                    x = temp.getX() + temp.getWidth();
                }
            }
            //stop if the player hits the top and bottom of the block
            if (getSkeletonUD().intersects(temp.getSkeleton())) {
                if (dy > 0) {//I'm falling on to the block
                    dy = 0;
                    y = temp.getY() - height;
                    offGround = false;
                } else if (dy < 0) {
                    dy = 0;
                    y = temp.getY() + temp.getHeight();
                }
            }
            if (getSkeleton().intersects(temp.getTop()) && dy > 0) {
                offGround = false;
                if (dy == Game.T_V) {
                    action = resting;
                }
                return;
            } else {
                offGround = true;
            }
        }
    }

    public void charging() {
        jumpStrength = jumpStrength + 2;
        if (jumpStrength > 11) {
            jumpStrength = 11;
        }
    }

    public void setOG(boolean a) {
        offGround = a;
    }

    public void setCanJump(boolean a) {
        canJump = a;
    }

    public void setJS(int nums) {
        jumpStrength = nums;
    }

    public void setChargin(boolean a) {
        isCharging = a;
    }

    public void setAction(int a) {
        action = a;
    }

    public void setRight(boolean a) {
        right = a;
    }

    public boolean getCharging() {
        return isCharging;
    }

    public boolean getOffGround() {
        return offGround;
    }

    public boolean getCJ() {
        return canJump;
    }

    public int giveJS() {
        return jumpStrength;
    }

    public int giveJP() {
        return jumpSpeed;
    }
}

class control extends KeyAdapter {

    private stores stores;
    private boolean[] keyPressed = new boolean[]{false, false, false};

    public control(stores s) {
        this.stores = s;
    }

    public void keyPressed(KeyEvent e) {
        int input = e.getKeyCode();
        for (int i = 0; i < stores.object.size(); i++) {
            object temp = stores.object.get(i);
            if (temp.getid() == ID.Player) {
                Player tempp = (Player) temp;
                if (input == KeyEvent.VK_LEFT) {
                    if (!tempp.getOffGround()) {
                        tempp.setRight(false);
                    }
                    keyPressed[1] = true;
                }
                if (input == KeyEvent.VK_RIGHT) {
                    if (!tempp.getOffGround()) {
                        tempp.setRight(true);
                    }
                    keyPressed[2] = true;
                }
                if (input == KeyEvent.VK_SPACE || keyPressed[0]) {
                    if (tempp.getCJ()) {
                        tempp.charging();
                        tempp.setChargin(true);
                        tempp.setAction(7);
                    }
                    keyPressed[0] = true;
                }

            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int input = e.getKeyCode();
        for (int i = 0; i < stores.object.size(); i++) {
            object temp = stores.object.get(i);
            if (temp.getid() == ID.Player) {
                Player tempp = (Player) temp;
                if (input == KeyEvent.VK_SPACE) {
                    if (keyPressed[1] && tempp.getCJ()) {

                        stores.object.get(i).setDY(-tempp.giveJS());
                        stores.object.get(i).setDX(-tempp.giveJP());

                    } else if (keyPressed[2] && tempp.getCJ()) {

                        stores.object.get(i).setDY(-tempp.giveJS());
                        stores.object.get(i).setDX(tempp.giveJP());

                    } else if (tempp.getCJ()) {
                        stores.object.get(i).setDY(-tempp.giveJS());
                    }

                    tempp.setChargin(false);
                    keyPressed[0] = false;
                }
                if (input == KeyEvent.VK_LEFT) {
                    keyPressed[1] = false;
                }
                if (input == KeyEvent.VK_RIGHT) {
                    if (!tempp.getOffGround()) {
                        tempp.setAction(3);
                    }
                    keyPressed[2] = false;
                }
            }
        }
    }

    public void velocityCheck() {
        for (int i = 0; i < stores.object.size(); i++) {
            object temp = stores.object.get(i);
            if (temp.getid() == ID.Player) {
                Player tempp = (Player) temp;

                if (!keyPressed[0] && !tempp.getOffGround()) {
                    temp.setDY(0);
                    tempp.setJS(0);
                }

                if ((!keyPressed[1] && !keyPressed[2] && !tempp.getOffGround()) || tempp.getCharging()) {
                    temp.setDX(0);
                }

                if (!tempp.getOffGround() && Math.abs(tempp.getDX()) == tempp.giveJP()) {
                    if (keyPressed[1]) {
                        stores.object.get(i).setDX(-2);
                    } else {
                        temp.setDX(0);
                    }
                }
                if (keyPressed[1] && !tempp.getCharging()) {
                    if (!tempp.getOffGround()) {
                        stores.object.get(i).setDX(-2);
                    }
                }
                if (keyPressed[2] && !tempp.getCharging()) {
                    if (!tempp.getOffGround()) {
                        stores.object.get(i).setDX(2);
                    }
                }

            }
        }
    }
}
