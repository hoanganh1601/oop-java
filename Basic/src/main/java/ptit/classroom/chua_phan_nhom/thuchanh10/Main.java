package ptit.classroom.chua_phan_nhom.thuchanh10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean checkLogin(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<User> userList = new ArrayList<>();
        int[] loginCnt = new int[n];

        for (int i = 0; i < n; ++i) {
            String username = sc.next();
            String password = sc.next();
            userList.add(new User(username, password));
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; ++i) {
            String tmpUsername = sc.next();
            String tmpPassword = sc.next();

            for (int j = 0; j < n; ++j) {
                if(userList.get(j).checkLogin(tmpUsername, tmpPassword)) {
                    loginCnt[j]++;
                    break;
                }
            }
        }

        for(int i = 0; i < n; ++i) {
            System.out.print(loginCnt[i] + " ");
        }
        System.out.println();

        sc.close();
    }
}
