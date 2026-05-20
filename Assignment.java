import greenfoot.*;

/** Objeto coleccionable que representa una tarea o proyecto entregable. */
public class Assignment extends Actor
{
    public Assignment()
    {
        GreenfootImage img = new GreenfootImage(42, 50);
        img.setColor(new Color(255, 255, 245));
        img.fillRect(5, 3, 32, 42);
        img.setColor(Color.DARK_GRAY);
        img.drawRect(5, 3, 32, 42);
        img.drawString("A+", 14, 30);
        setImage(img);
    }
}
