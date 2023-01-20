package matchapxstore;

import java.sql.Timestamp;

public class Camera extends Item
{
    public Camera()
    {
        super(5, "Camera", 190, null, "camera.png", "electronics");
        setDescription("Brand:  Canon\n Weight: 9.5 pounds\nShooting modes: Manual\nColor: Black\nLens Type: Zoom, Wide Angle\nHardware Interface: USB");
    }

    public Camera(String name, int transaction_cost, Timestamp time)
    {
        super(5, name, transaction_cost, time, "camera.png", "electronics");
        setDescription("Brand:  Canon\n Weight: 9.5 pounds\nShooting modes: Manual\nColor: Black\nLens Type: Zoom, Wide Angle\nHardware Interface: USB");
    }
}