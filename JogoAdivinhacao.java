import java.util.Random;

/**
 * Jogo de Adivinhação onde o usuário insere um valor de 0 a 9, a máquina pode responder
 * se o número está correto, é maior, ou menor que o numero gerado.
 * 
 * @author Samuel Borges
 * @author Isabelle Karine
 * @version MR12
 */

public class JogoAdivinhacao {
    // Gera um número aleatório
    Random random = new Random();
    private int numeroSorteado;
    private int numeroTentativas;
    private boolean jogoEncerrado;
    
    /* Define o número de tentativas para 3 */
    public JogoAdivinhacao() {
        numeroTentativas = 3;
        jogoEncerrado = false;
        sortearNumero();
    }
    
    /* Defina o número de tentativas */
    public JogoAdivinhacao(int numPalpites) {
        numeroTentativas = numPalpites;
        jogoEncerrado = false;
        sortearNumero();
    }
    
    /* Um número aleatório de 0 a 99 é sorteado */
    private void sortearNumero() {
        numeroSorteado = random.nextInt(100);
    }
    
    /* Sorteia um número aleatório de 0 a 99 */
    private int getSorteado() {
        return numeroSorteado;
    }
    
    /* Dê o seu palpite, caso esteja errado ou correto o programa irá responder */
    public String palpitar(int palpite) {
        if (jogoEncerrado) {
            return "O jogo acabou. Reinicie para jogar novamente.";
        }

        if (palpite == numeroSorteado) {
            jogoEncerrado = true; // Define o jogo como encerrado
            return "Acertou!";
        } else {
            numeroTentativas--;

            if (numeroTentativas <= 0) {
                jogoEncerrado = true; // Define o jogo como encerrado
                return "Ultrapassou o limite de tentativas, o numero sorteado foi " + numeroSorteado;
            } else if (palpite < numeroSorteado) {
                return "Informe um numero maior. Tentativas restantes: " + numeroTentativas;
            } else {
                return "Informe um numero menor. Tentativas restantes: " + numeroTentativas;
            }
        }
    }
    
    /* Verifica se o jogo acabou */
    private boolean jogoEncerrado() {
        return jogoEncerrado;
    }
}
