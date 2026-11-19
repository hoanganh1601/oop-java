package ptit.code.vao_ra_file.j07017;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class Pair<T, U> {
    private final T first;
    private final U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    private boolean checkPrime(int num) {
        if(num < 2) return false;
        else if(num == 2 || num == 3) return true;
        else if(num % 2 == 0 || num % 3 == 0) return false;
        else {
            for (int i = 5; i * i <= num; i += 6) {
                if (num % i == 0 || num % (i + 2) == 0) return false;
            }
        }

        return true;
    }

    public boolean isPrime() {
        if (first instanceof Number && second instanceof Number) {
            int num1 = ((Number) first).intValue();
            int num2 = ((Number) second).intValue();
            return checkPrime(num1) && checkPrime(num2);
        }
        return false;
    }

    @Override
    public String toString() {
        return first + " " + second;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            boolean check = false;
            for(int i = 2; i <= 2*Math.sqrt(n); i++){
                Pair<Integer, Integer> p = new Pair<>(i, n-i);
                if(p.isPrime()){
                    System.out.println(p);
                    check = true;
                    break;
                }
            }
            if(!check) System.out.println(-1);
        }
    }
}
