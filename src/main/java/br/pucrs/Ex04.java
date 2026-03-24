// Exercicio 4
/*
A Multiplicação Inteira de n-bits recebe dois números inteiros x e y de n-bits e retorna o resutado de x * y.

Assim, novamente:
    implemente o algortimo abaixo;
    teste-o para os 3 casos de valores inteiros: com 4 bits, com 16 bits e com 64 bits. Nestes testes, contabilize o número de iterações que o algoritmo executa, e o tempo gasto.

O algoritmo está dado abaixo:

MULTIPLY(x, y, n) 
IF (n = 1)
    RETURN x * y.
ELSE
    m ← ⎡ n / 2 ⎤.
    a ← ⎣ x / 2^m ⎦;
    b ← x mod 2^m.
    c ← ⎣ y / 2^m ⎦;
    d ← y mod 2^m.
    e ← MULTIPLY(a, c, m).
    f ← MULTIPLY(b, d, m).
    g ← MULTIPLY(b, c, m).
    h ← MULTIPLY(a, d, m).
    RETURN 2^(2m)*e + 2^m*(g + h) + f.

Ajuste a assinatura da sua implementação para receber tipo inteiros long (em java).
*/

package br.pucrs;

public class Ex04 {
    
    static long iteracoes = 0;
    
    public static long MULTIPLY(long x, long y, int n){
        
        iteracoes++;
        
        if( n == 1){
            return x*y;
        }
        
        int m = n/2;
        long mathpow2m = (long) Math.pow(2, m);
        
        long a = x / mathpow2m;
        long c = y / mathpow2m;
        long b = x % mathpow2m;
        long d = y % mathpow2m;
        
        long e = MULTIPLY(a, c, m);
        long f = MULTIPLY(b, d, m);
        long g = MULTIPLY(b, c, m);
        long h = MULTIPLY(a, d, m);
        
        return (long) Math.pow(2, 2*m) * e + mathpow2m * (g + h) + f;
    }
    
    public static void main(String[] args) {
        
        long x = 4;
        long y = 6;
        int n = 64;
        
        long tempoInicial = System.nanoTime();
        
        System.out.println(MULTIPLY(x, y, n));
        long tempoFinal = System.nanoTime();
        System.out.println("tempo gasto: " + (tempoFinal-tempoInicial));
        System.out.println("n interacoes: " + iteracoes);
        
    }
}
