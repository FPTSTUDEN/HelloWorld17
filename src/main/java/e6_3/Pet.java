package e6_3;

public class Pet {
    double x, y;       // current position
    double speed = 2;  // pixels per frame

    public Pet(double startX, double startY) {
        this.x = startX;
        this.y = startY;
    }

    public void moveToward(double targetX, double targetY) {
        double dx = targetX - x;
        double dy = targetY - y;
        double distance = Math.sqrt(dx * dx + dy * dy);

        if (distance > speed) {
            double dirX = dx / distance;
            double dirY = dy / distance;
            x += dirX * speed;
            y += dirY * speed;
        } else {
            // Snap to target when close enough
            x = targetX;
            y = targetY;
        }
    }
}

