package javaapplication1;

import java.util.Scanner;

// emerson da silva oliveira

public class Hora {
    private int hora;
    private int min;
    private int seg;

    // Construtor sem parâmetros [cite: 9]
    public Hora() {
        setHor();
        setMin();
        setSeg();
    }

    // Construtor com parâmetros [cite: 11]
    public Hora(int h, int m, int s) {
        this.hora = h;
        this.min = m;
        this.seg = s;
    }

    // Métodos set com parâmetros [cite: 12]
    public void setHor(int h) { this.hora = h; }
    public void setMin(int m) { this.min = m; }
    public void setSeg(int s) { this.seg = s; }

    // Métodos set sem parâmetros com validação [cite: 13, 14]
    public void setHor() {
        this.hora = validarEntrada("Digite a hora (0-23): ", 0, 23);
    }

    public void setMin() {
        this.min = validarEntrada("Digite o minuto (0-59): ", 0, 59);
    }

    public void setSeg() {
        this.seg = validarEntrada("Digite o segundo (0-59): ", 0, 59);
    }

    // Métodos get [cite: 15]
    public int getHor() { return hora; }
    public int getMin() { return min; }
    public int getSeg() { return seg; }

    // Formato hh:mm:ss [cite: 16]
    public String getHora1() {
        return String.format("%02d:%02d:%02d", hora, min, seg);
    }

    // Formato hh:mm:ss (AM/PM) 
    public String getHora2() {
        int h = (hora == 0 || hora == 12) ? 12 : hora % 12;
        String periodo = (hora < 12) ? "AM" : "PM";
        return String.format("%02d:%02d:%02d (%s)", h, min, seg, periodo);
    }

    // Total de segundos [cite: 18]
    public int getSegundos() {
        return (hora * 3600) + (min * 60) + seg;
    }

    // Validação e tratamento de exceção [cite: 10, 19]
    private int validarEntrada(String mensagem, int min, int max) {
        Scanner sc = new Scanner(System.in);
        int valor;
        while (true) {
            try {
                System.out.print(mensagem);
                valor = Integer.parseInt(sc.nextLine());
                if (valor >= min && valor <= max) return valor;
                System.out.println("Valor inválido! Deve estar entre " + min + " e " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Erro: Entrada inválida. Digite um número inteiro.");
            }
        }
    }
}
