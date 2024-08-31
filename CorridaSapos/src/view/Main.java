package view;

import controller.*;

public class Main
{
    public static void main(String[] args)
    {
        double distancia = 10;
        double saltoMax = 1;
		// utilizando args pra distância da corrida
		// e pra distância do salto máximo
		try {
			distancia = Double.parseDouble(args[0]);
		} catch (NumberFormatException n) {
		} catch (ArrayIndexOutOfBoundsException o) {
		}
		// try separado por conta de que se houver erro na conversão da distãncia
		// eu ainda quero que tente ser feita a do salto
		try {
			saltoMax = Double.parseDouble(args[1]);
		} catch (NumberFormatException n) {
		} catch (ArrayIndexOutOfBoundsException o) {
		}
        Corrida corrida = new Corrida(distancia);
        ThreadSapo[] sapos = new ThreadSapo[5];
        for (int i = 0; i < 5; i++) {
            sapos[i] = new ThreadSapo(i + 1, corrida, saltoMax);
            sapos[i].start();
        }
        for (int i = 0; i < 5; i++) {
            try {
                sapos[i].join();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        corrida.mostrarResultado();
    }
}


