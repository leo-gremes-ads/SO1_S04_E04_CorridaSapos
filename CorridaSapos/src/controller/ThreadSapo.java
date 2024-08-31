package controller;

public class ThreadSapo extends Thread
{
    private int id;
    private double distPercorrida;
    private int qtdSaltos;
    private Corrida corrida;
    private double maxSalto;
    
    public ThreadSapo(int id, Corrida corrida, double maxSalto)
    {
        this.id = id;
        this.distPercorrida = 0;
        this.qtdSaltos = 0;
        this.corrida = corrida;
        this.maxSalto = maxSalto;
    }

    @Override
    public void run()
    {
        double salto;
        while (true) {
            if (this.distPercorrida >= corrida.getDistancia()) {
                corrida.addChegadas(this.id);
                //System.out.println("Sapo " + this.id + " chegou!");
                break;
            }
            salto = Math.round((1 - Math.random()) * (this.maxSalto) * 100) / 100.0;
            this.distPercorrida += salto;
            this.qtdSaltos++;
            System.out.println("Sapo " + this.id + " saltou " + String.format("%5.2f", salto) +
                               " m. (Distância percorrida: " + String.format("%8.2f", this.distPercorrida) + 
                               " m - " + String.format("%2d", this.qtdSaltos) + " saltos)");
        }
    }
}