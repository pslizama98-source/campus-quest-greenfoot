import greenfoot.*;

/** Obstáculo móvil que representa estrés académico. */
public class StressCloud extends Actor
{
    private int speed;

    public StressCloud(int speed)
    {
        this.speed = speed;
        drawCloud();
    }

    public void act()
    {
        setLocation(getX() + speed, getY());
        if (getX() > getWorld().getWidth() - 20 || getX() < 20) {
            speed = -speed;
        }
    }

    private void drawCloud()
    {
        GreenfootImage img = new GreenfootImage(72, 44);
        img.setColor(new Color(112, 120, 135));
        img.fillOval(5, 15, 35, 22);
        img.fillOval(22, 5, 35, 32);
        img.fillOval(38, 16, 30, 20);
        img.setColor(new Color(255, 230, 80));
        img.drawString("!", 33, 27);
        setImage(img);
    }
}
