/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividadenclase.busqueda;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author miguelcatalan
 */
public final class Laberinto {

    public final short OBSTACULO = -1;
    private short INICIO = -2;
    private static short OBJETIVO = -3;
    private int alto = 3;
    private int largo = 3;
    private short[][] laberinto;

    public Laberinto() {
        System.out.println("Nuevo laberinto de tamaño " + alto + " por " + largo);

        laberinto = new short[largo + 2][alto + 2];

        for (int i = 0; i < largo + 2; i++) {
            for (int j = 0; j < alto + 2; j++) {
                laberinto[i][j] = 0;
                //System.out.println("["+i+"]["+j+"]");
            }
        }

        for (int i = 0; i < alto + 2; i++) {
            laberinto[0][i] = laberinto[largo + 1][i] = OBSTACULO;

        }

        for (int i = 0; i < largo + 2; i++) {
            laberinto[i][0] = laberinto[i][alto + 1] = OBSTACULO;
        }

        //Colocar obstaculos
        setValor(3, 2, OBSTACULO);
        setValor(2, 3, OBSTACULO);
        setValor(1, 2, OBSTACULO);

        //Especificar el estado inicial
        setValor(1, 1, INICIO);

        //Especifiar el estado objetivo
        setValor(largo - 1, alto - 1, OBJETIVO);

        //Declaramos la cola
        Queue<String> cola = new LinkedList();
        Queue<String> fifo = new LinkedList();

        //Mapea la matriz
        int e = 0;
        while (e < 5) {
            for (int j = 0; j < 5; j++) {
                System.out.print("|" + laberinto[e][j] + "|    ");
                cola.offer(String.valueOf(laberinto[e][j]));
            }
            System.out.println("");
            e++;
        }
        System.out.println("##############Cola###########");
        System.out.print(cola);
        System.out.println("");

        cola.forEach(nodo -> {
            if (nodo.equals("-2")) { fifo.offer(nodo); } });

        cola.forEach(nodo -> {
            if (nodo.equals("0")) {fifo.offer(nodo);}});

        cola.forEach(nodo -> {
            if (nodo.equals("-3")) { fifo.offer(nodo); }});

        System.out.println("##############fifo###########");
        System.out.print(fifo);

    }

    public short getValor(int x, int y) {
        return laberinto[x + 1][y + 1];
    }

    public void setValor(int x, int y, short value) {
        laberinto[x + 1][y + 1] = value;
        //System.out.println("setValor" + laberinto[x + 1][y + 1]);
    }

    public int getLargo() {
        return largo;
    }

    public int getAlto() {
        return alto;
    }
}
