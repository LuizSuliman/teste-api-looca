import oshi.SystemInfo;
import oshi.hardware.GraphicsCard;
import oshi.hardware.HardwareAbstractionLayer;

import java.util.List;

public class TesteOshiGPU {
    public static void main(String[] args) {
        SystemInfo si = new SystemInfo();

        HardwareAbstractionLayer hal = si.getHardware();

        System.out.println("Dados da GPU:");

        List<GraphicsCard> graphicsCards = hal.getGraphicsCards();
        for (GraphicsCard graphicsCard : graphicsCards) {
            System.out.println(graphicsCard);
        }
    }
}
