package ptit.code.mang_doi_tuong.j05011;

public class Gamer {
    private String id;
    private String name;
    private int playTime;

    public int getPlayTime() {
        return playTime;
    }

    public Gamer(String id, String name, String timeIn, String timeOut) {
        this.id = id;
        this.name = name;
        this.playTime = calculateTime(timeIn, timeOut);
    }

    private int calculateTime(String timeIn, String timeOut) {
        String[] inParts = timeIn.split(":");
        String[] outParts = timeOut.split((":"));

        int inMinutes = Integer.parseInt(inParts[0]) * 60 + Integer.parseInt(inParts[1]);
        int outMinutes = Integer.parseInt(outParts[0]) * 60 + Integer.parseInt(outParts[1]);

        return outMinutes - inMinutes;
    }

    @Override
    public String toString() {
        int hours = playTime / 60;
        int minutes = playTime % 60;

        return id + " " + name + " " + hours + " gio " + minutes + " phut";
    }
}
