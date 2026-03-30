// Exercicio 4
/*

1.  Re-implemente o algoritmo de multiplicação de grandes inteiros, agora sobre duas sequências de bits representados como Strings de 0 e 1. Use a assinatura abaixo:

    Multiplica duas strings de bits x e y e retorna o resultado como um inteiro "long".
    
    public static long multiply(String X, String Y);
 
2.  Conte as iteraçõees/instruções/tempo e complete a tabela da atividade anterior.

*/

package br.pucrs;

public class Ex04String {
    
    static long iteracoes = 0;
    
    public static long MULTIPLY(String x, String y){
        
        iteracoes++;

        int n = Math.max(x.length(), y.length());

        int igualarX = x.length();
        int igualarY = y.length();

        for (; igualarX < n; igualarX++){
            x = '0' + x;
        }
        
        for (; igualarY < n; igualarY++){
            y = '0' + y;
        }

        if( x.length() == 0 || y.length() == 0 ){
            return 0;
        }

        if ( x.length() == 1 && y.length() == 1 ){
            return Long.parseLong(x)*Long.parseLong(y);
        }
        
        int m = (int) Math.ceil(n/2);
        long mathpow2m = (long) Math.pow(2, m);
        
        String a = x.substring(0, n - m);
        String c = y.substring(0, n - m);
        String b = x.substring(n - m);
        String d = y.substring(n - m);
        
        long e = MULTIPLY(a, c);
        long f = MULTIPLY(b, d);
        long g = MULTIPLY(b, c);
        long h = MULTIPLY(a, d);
        
        return (long) Math.pow(2, 2*m) * e + mathpow2m * (g + h) + f;
    }
    
    public static void Ex05(String x, String y, int n){
        iteracoes = 0;
        
        long tempoInicial = System.nanoTime();
        
        long resultado = MULTIPLY(x, y);
        
        long tempoFinal = System.nanoTime();
        
        System.out.println(n + " bits");
        //System.out.println("x: " + x + " | y: " + y);
        //System.out.println("resultado: " + resultado);
        System.out.println("tempo: " + (tempoFinal-tempoInicial) + " ns");
        System.out.println("n. interacoes: " + iteracoes);
        System.out.println("---------------");
    }
    
    public static void main(String[] args) {
        
        Ex05("1111", "1111", 4);
        Ex05("1111111111111111", "1111111111111111", 16);
        Ex05("1111111111111111111111111111111111111111111111111111111111111111", "1111111111111111111111111111111111111111111111111111111111111111", 64);
        
    }
}
