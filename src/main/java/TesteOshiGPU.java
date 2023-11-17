import com.github.britooo.looca.api.core.Looca;
import oshi.SystemInfo;
import oshi.hardware.GraphicsCard;
import oshi.hardware.HardwareAbstractionLayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class TesteOshiGPU {
    public static void main(String[] args) throws IOException {
        Looca looca = new Looca();
        SystemInfo si = new SystemInfo();

        HardwareAbstractionLayer hal = si.getHardware();

        System.out.println("Dados da GPU:");

        String tipoKernel = (looca.getSistema().getSistemaOperacional().toLowerCase().contains("windows")) ? "windows" : "linux";

        // Obtêm as GPUs presentes
        List<GraphicsCard> graphicsCards = hal.getGraphicsCards();

        // Váriavel que armazena um comando para Runtime
        Process processo = null;
        for (GraphicsCard gpu : graphicsCards) {
            // Obtêm o vendedor de cada GPU
            String fabricante = gpu.getVendor();
            if (tipoKernel.equals("linux")) {
                if (fabricante.toLowerCase().contains("amd")) {
                    processo = Runtime.getRuntime().exec("bash amd");
                } else if (fabricante.toLowerCase().contains("nvidia")) {
                    processo = Runtime.getRuntime().exec("nvidia-smi --query-gpu=utilization.gpu --format=csv,noheader,nounits");
                } else if (fabricante.toLowerCase().contains("intel")) {
                    processo = Runtime.getRuntime().exec("bash intel");
                }
            } else if (tipoKernel.equals("windows")) {
                if (fabricante.toLowerCase().contains("amd")) {
                    processo = Runtime.getRuntime().exec("bash amd");
                } else if (fabricante.toLowerCase().contains("nvidia")) {
                    processo = Runtime.getRuntime().exec("nvidia-smi --query-gpu=utilization.gpu --format=csv,noheader,nounits");
                } else if (fabricante.toLowerCase().contains("intel")) {
                    processo = Runtime.getRuntime().exec("bash intel");
                }
            } else {
                System.out.println("Sistema operacional não compatível.");
                return;
            }

            // Output final
            BufferedReader output = new BufferedReader(new InputStreamReader(processo.getInputStream()));
            System.out.println(output.readLine());
        }
    }
}
