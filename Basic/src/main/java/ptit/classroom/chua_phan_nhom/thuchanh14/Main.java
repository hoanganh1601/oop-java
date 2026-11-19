package ptit.classroom.chua_phan_nhom.thuchanh14;

import java.util.*;

class Team {
    private String id;
    private String name;
    private String school;

    public Team(String id, String name, String school) {
        this.id = id;
        this.name = name;
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    public String getName() {
        return name;
    }
}

class Candidate implements Comparable<Candidate> {
    private String id;
    private String name;
    private Team team;

    public Candidate(String id, String name, Team team) {
        this.id = id;
        this.name = name;
        this.team = team;
    }

    @Override
    public int compareTo(Candidate other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return id + " " + name + " " + team.getName() + " " + team.getSchool();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        HashMap<String, Team> mapTeam = new HashMap<>();

        for (int i = 1; i <= n; ++i) {
            String id = String.format("Team%02d", i);
            mapTeam.put(id, new Team(id, sc.nextLine().trim(), sc.nextLine().trim()));
        }

        int m = Integer.parseInt(sc.nextLine());
        List<Candidate> candidates = new ArrayList<>();
        for (int i = 1; i <= m; ++i) {
            String id = String.format("C%03d", i);
            String name = sc.nextLine().trim();
            String idTeam = sc.nextLine().trim();

            Team team = mapTeam.get(idTeam);
            candidates.add(new Candidate(id, name, team));
        }

        Collections.sort(candidates);

        for (Candidate ca : candidates) {
            System.out.println(ca);
        }
        sc.close();
    }
}
