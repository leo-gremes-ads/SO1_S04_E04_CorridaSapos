package controller;

import java.util.ArrayList;

public class Corrida
{
    private double distancia;
    private ArrayList<Integer> chegadas;
    
    public Corrida(double distancia)
    {
        this.distancia = distancia;
        this.chegadas = new ArrayList<Integer>();
    }

    public double getDistancia()
    {
        return this.distancia;
    }

    public void addChegadas(int valor)
    {
        chegadas.add(valor);
    }

    public void mostrarResultado()
    {
        int tam = chegadas.size();
        int i = 0;
        if (tam >= 3) {
            System.out.println("\n----------  RESULTADO  ----------\n");
            System.out.println("             Sapo " + chegadas.get(0) + "             ");
            System.out.println("  Sapo " + chegadas.get(1) + "   ----------           ");
            System.out.println("----------|          |  Sapo " + chegadas.get(2) + "  ");
            System.out.println("          |          |----------");
            i = 3;
        }
        while (i < tam) {
            System.out.println((i + 1) + "º -> Sapo " + chegadas.get(i));
            i++;
        }
        System.out.println("___________________________________\n");
    }
}
