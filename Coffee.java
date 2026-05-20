import greenfoot.*;

/** Power-up que recupera energía. */
public class Coffee extends Actor
{
    public Coffee()
    {
        GreenfootImage img = new GreenfootImage(48, 48);
        img.setColor(new Color(130, 80, 45));
        img.fillRoundRect(10, 15, 26, 25, 6, 6);
        img.setColor(new Color(245, 245, 235));
        img.fillRect(14, 9, 18, 7);
        img.setColor(new Color(70, 45, 30));
        img.drawOval(30, 20, 12, 14);
        setImage(img);
    }
}
