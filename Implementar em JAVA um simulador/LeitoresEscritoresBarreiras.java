import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class LeitoresEscritoresBarreiras {
    private final CyclicBarrier barreira;
    private int numLeitores = 0;

    public LeitoresEscritoresBarreiras(int totalThreads) {
        barreira = new CyclicBarrier(totalThreads);
    }

    public void iniciaLeitura() throws InterruptedException, BrokenBarrierException {
        numLeitores++;
        System.out.println("Leitor iniciou leitura.");
        barreira.await();
    }

    public void terminaLeitura() throws InterruptedException, BrokenBarrierException {
        numLeitores--;
        System.out.println("Leitor terminou leitura.");
        barreira.await();
    }

    public void iniciaEscrita() throws InterruptedException, BrokenBarrierException {
        System.out.println("Escritor iniciou escrita.");
        barreira.await();
    }

    public void terminaEscrita() throws InterruptedException, BrokenBarrierException {
        System.out.println("Escritor terminou escrita.");
        barreira.await();
    }
}
