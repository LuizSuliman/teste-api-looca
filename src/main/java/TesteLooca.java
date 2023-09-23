import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.janelas.Janela;
import com.github.britooo.looca.api.group.janelas.JanelaGrupo;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;
import com.github.britooo.looca.api.group.rede.Rede;
import com.github.britooo.looca.api.group.servicos.Servico;
import com.github.britooo.looca.api.group.servicos.ServicoGrupo;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.temperatura.Temperatura;

import java.util.List;

public class TesteLooca {
    public static void main(String[] args) {
        // Instânciando o objeto Looca:
        Looca looca = new Looca();

        // Coletando informações do sistema:
        Sistema sistema = looca.getSistema();

        System.out.println(sistema);

        // Exibindo informações separadamente:
        System.out.println("*----- Sistema -----*");
        System.out.println(sistema.getPermissao());
        System.out.println(sistema.getFabricante());
        System.out.println(sistema.getArquitetura());
        System.out.println(sistema.getInicializado());
        System.out.println(sistema.getSistemaOperacional());

        // Criando o Gerenciador de Discos
        DiscoGrupo grupoDeDiscos = looca.getGrupoDeDiscos();

        //Obtendo lista de discos a partir do getter (pode ser mais de um):
        List<Disco> discos = grupoDeDiscos.getDiscos();

        // Usando Enhanced For para exibir cada disco:
        System.out.println("*----- Disco -----*");
        for (Disco disco : discos) {
            System.out.println(disco);
        }

        // Testando outros recursos do Looca:
        // Memória:
        Memoria memoria = looca.getMemoria();
        System.out.println("*----- Memória -----*");
        System.out.println(memoria);

        // Processador:
        Processador processador = looca.getProcessador();
        System.out.println("*----- Processador -----*");
        System.out.println(processador);

        // Temperatura:
        Temperatura temperatura = looca.getTemperatura();
        System.out.println("*----- Temperatura -----*");
        System.out.println(temperatura);

        // Serviços:
        ServicoGrupo grupoDeServicos = looca.getGrupoDeServicos();
        List<Servico> servicos = grupoDeServicos.getServicos();

        System.out.println("*----- Serviços -----*");
        for (Servico servico : servicos) {
            System.out.println(servico);
        }

        // Processos:
        ProcessoGrupo grupoDeProcessos = looca.getGrupoDeProcessos();
        List<Processo> processos = grupoDeProcessos.getProcessos();

        System.out.println("*----- Processos -----*");
        for (Processo processo : processos) {
            System.out.println(processo);
        }

        // Rede:
        Rede rede = looca.getRede();
        System.out.println("*----- Rede -----*");
        System.out.println(rede);

        // Janelas:
        JanelaGrupo grupoDeJanelas = looca.getGrupoDeJanelas();
        List<Janela> janelas = grupoDeJanelas.getJanelas();

        System.out.println("*----- Janelas -----*");
        for (Janela janela : janelas) {
            System.out.println(janela);
        }

        System.exit(0);
    }
}
