import greenfoot.*;

/**
 * Mundo principal del prototipo Campus Quest.
 * El objetivo es recoger tareas, mantener energía y llegar a la entrega final.
 */
public class CampusQuestWorld extends World
{
    private int score = 0;
    private int energy = 100;
    private int timeLeft = 60;
    private int level = 1;
    private int frameCounter = 0;
    private boolean gameOver = false;
    private boolean levelComplete = false;

    public CampusQuestWorld()
    {
        super(800, 600, 1);
        setPaintOrder(Student.class, StressCloud.class, Assignment.class, Coffee.class, GoalPortal.class);
        prepare();
        updateHUD();
    }

    private void prepare()
    {
        GreenfootImage background = new GreenfootImage(getWidth(), getHeight());
        background.setColor(new Color(220, 239, 247));
        background.fillRect(0, 0, getWidth(), 145);
        background.setColor(new Color(193, 224, 184));
        background.fillRect(0, 145, getWidth(), getHeight() - 145);
        background.setColor(new Color(204, 190, 160));
        int[] xs = {330, 470, 670, 130};
        int[] ys = {145, 145, 600, 600};
        background.fillPolygon(xs, ys, 4);
        background.setColor(new Color(235, 233, 224));
        background.fillRect(40, 65, 175, 85);
        background.fillRect(585, 65, 175, 85);
        background.setColor(Color.DARK_GRAY);
        background.drawString("Biblioteca", 80, 95);
        background.drawString("Laboratorio", 630, 95);
        setBackground(background);

        addObject(new Student(), 90, 520);
        addObject(new GoalPortal(), 720, 470);

        addObject(new Assignment(), 160, 260);
        addObject(new Assignment(), 340, 350);
        addObject(new Assignment(), 520, 250);
        addObject(new Assignment(), 610, 420);

        addObject(new Coffee(), 420, 485);
        addObject(new Coffee(), 250, 430);

        addObject(new StressCloud(2), 260, 210);
        addObject(new StressCloud(3), 560, 310);
        addObject(new StressCloud(2), 690, 220);
    }

    public void act()
    {
        if (gameOver || levelComplete) {
            if (Greenfoot.isKeyDown("space")) {
                Greenfoot.setWorld(new CampusQuestWorld());
            }
            return;
        }

        frameCounter++;
        if (frameCounter % 60 == 0) {
            timeLeft--;
            if (timeLeft <= 0) {
                endGame("Se acabó el tiempo. Presiona ESPACIO para reiniciar.");
            }
        }
        updateHUD();
    }

    public void addScore(int points)
    {
        score += points;
        try { Greenfoot.playSound("collect.wav"); } catch (Exception e) { }
        updateHUD();
    }

    public void changeEnergy(int amount)
    {
        energy += amount;
        if (energy > 100) energy = 100;
        if (energy <= 0) {
            energy = 0;
            endGame("Tu energía llegó a cero. Presiona ESPACIO para reiniciar.");
        }
        updateHUD();
    }

    public int getScore()
    {
        return score;
    }

    public void completeLevel()
    {
        levelComplete = true;
        try { Greenfoot.playSound("success.wav"); } catch (Exception e) { }
        showText("Nivel superado", 400, 260);
        showText("Puntaje final: " + score + " | Presiona ESPACIO para reiniciar", 400, 300);
    }

    private void endGame(String message)
    {
        gameOver = true;
        showText(message, 400, 300);
    }

    private void updateHUD()
    {
        showText("Puntos: " + score, 85, 24);
        showText("Energía: " + energy + "%", 210, 24);
        showText("Tiempo: " + timeLeft, 340, 24);
        showText("Nivel " + level + ": Campus", 670, 24);
        showText("Flechas para moverse | Recoge tareas | Evita estrés", 400, 55);
    }
}
