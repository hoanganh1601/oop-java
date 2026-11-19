package ptit.code.mang_doi_tuong.j05015;

public class Cyclist {
    private String id;
    private String name;
    private String team;
    private int speed;
    private int totalMinutes;

    public int getTotalMinutes() {
        return totalMinutes;
    }

    public Cyclist(String name, String team, String timeOut) {
        this.name = name;
        this.team = team;
        this.id = generateId(name, team);
        this.speed = cal(timeOut);
    }

    public String generateId(String name, String team) {
        StringBuilder sb = new StringBuilder();
        String[] teamList = team.split("\\s+");
        String[] nameList = name.split("\\s+");

        for(String tmp : teamList) sb.append(tmp.charAt(0));
        for(String tmp : nameList) sb.append(tmp.charAt(0));

        return sb.toString();
    }

    public int cal(String timeOut) {
        String[] parts = timeOut.split(":");

        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);

        this.totalMinutes = (hours - 6) * 60 + minutes;
        int res = (int)Math.round(120.0 * 60 / (totalMinutes));

        return res;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + team + " " + speed + " Km/h";
    }
}