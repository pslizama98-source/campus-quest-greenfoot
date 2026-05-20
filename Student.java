import greenfoot.*;

/** Actor principal controlado por el jugador. */
public class Student extends Actor
{
    private int speed = 4;
    private int hitCooldown = 0;

    public Student()
    {
        drawStudent();
    }

    public void act()
    {
        moveWithKeyboard();
        checkCollisions();
        if (hitCooldown > 0) hitCooldown--;
    }

    private void moveWithKeyboard()
    {
        int dx = 0;
        int dy = 0;
        if (Greenfoot.isKeyDown("left")) dx -= speed;
        if (Greenfoot.isKeyDown("right")) dx += speed;
        if (Greenfoot.isKeyDown("up")) dy -= speed;
        if (Greenfoot.isKeyDown("down")) dy += speed;
        setLocation(getX() + dx, getY() + dy);
    }

    private void checkCollisions()
    {
        Assignment assignment = (Assignment)getOneIntersectingObject(Assignment.class);
        if (assignment != null) {
            getWorld().removeObject(assignment);
            ((CampusQuestWorld)getWorld()).addScore(10);
        }

        Coffee coffee = (Coffee)getOneIntersectingObject(Coffee.class);
        if (coffee != null) {
            getWorld().removeObject(coffee);
            ((CampusQuestWorld)getWorld()).changeEnergy(15);
        }

        StressCloud stress = (StressCloud)getOneIntersectingObject(StressCloud.class);
        if (stress != null && hitCooldown == 0) {
            ((CampusQuestWorld)getWorld()).changeEnergy(-12);
            try { Greenfoot.playSound("stress.wav"); } catch (Exception e) { }
            hitCooldown = 45;
        }

        GoalPortal goal = (GoalPortal)getOneIntersectingObject(GoalPortal.class);
        if (goal != null && ((CampusQuestWorld)getWorld()).getScore() >= 30) {
            ((CampusQuestWorld)getWorld()).completeLevel();
        }
    }

    private void drawStudent()
    {
        GreenfootImage img = new GreenfootImage(52, 82);
        img.setColor(new Color(245, 188, 130));
        img.fillOval(15, 0, 24, 24);
        img.setColor(new Color(47, 102, 170));
        img.fillRect(12, 24, 28, 35);
        img.setColor(new Color(68, 89, 110));
        img.fillRect(3, 28, 12, 25);
        img.setColor(Color.DARK_GRAY);
        img.drawLine(17, 59, 10, 80);
        img.drawLine(34, 59, 42, 80);
        setImage(img);
    }
}
