import java.util.Optional;

public class spielfeld {

    private String[][] spielfeld = new String[4][6];
    private String[] kickedStones = new String[2];

    public spielfeld() {
        spielfeld[0][0] = "S2";
        spielfeld[0][5] = "W5";
        spielfeld[1][1] = "W3";
        spielfeld[1][5] = "S5";
        spielfeld[2][0] = "W5";
        spielfeld[2][4] = "S3";
        spielfeld[3][0] = "S5";
        spielfeld[3][5] = "W2";
        kickedStones[0] = "S0";
        kickedStones[1] = "W0";
    }

    public boolean isFree(int quarter, int stein, char color) {
        Optional<String> feld = Optional.ofNullable(spielfeld[quarter][stein]);
        return !feld.isPresent() || feld.get().charAt(0) == color || feld.get().charAt(1) < '2';
    }

    @Override
    public String toString(){
        String output = "";
        int zeilenumbruch = 0;
        output += "13 14 15 16 17 18 19 20 21 22 23 24 \n";
        for (String[] quarter:spielfeld) {
            for (String s:quarter) {
                if (s == null){
                    output += "F0 ";
                }else{
                    output += s + " ";
                }
            }
            zeilenumbruch++;
            if (zeilenumbruch == 2){
                output += "\n\n";
                output += kickedStones[0] + "                               " + kickedStones[1] + "\n";
                output += "\n";
            }

        }
        output += "\n12 11 10 09 08 07 06 05 04 03 02 01";
        return output;
    }

}
