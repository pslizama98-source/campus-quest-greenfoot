import greenfoot.*;

/** Meta del primer nivel: representa entregar el proyecto a tiempo. */
public class GoalPortal extends Actor
{
    public GoalPortal()
    {
        GreenfootImage img = new GreenfootImage(90, 110);
        img.setColor(new Color(255, 218, 90));
        img.fillOval(10, 5, 70, 95);
        img.setColor(new Color(255, 245, 185));
        img.fillOval(22, 18, 46, 68);
        img.setColor(Color.DARK_GRAY);
        img.drawString("META", 24, 58);
        setImage(img);
    }
}
