import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.stream.IntStream;
import ea.*;
public class Spielfeld{

    private static Spielfeld instance;
    private int RundenAnz = 0;
    private String spielfeld[][];
    private int x = 10;
    private static int Zeile;

    public static Spielfeld getInstance(){

        if (Spielfeld.instance == null) {
            Spielfeld.instance = new Spielfeld ();
        }
        return Spielfeld.instance;
    }

    private Spielfeld() {
        spielfeld = new String[x][x];
        for (int i=0; i<spielfeld.length; i++){
            for (int j =0; j<spielfeld.length; j++){
                spielfeld[i][j] = "-";

            } 
        }

    }    

    public  void setzeX(int z) {
        for(int j =0; j < spielfeld.length; j++){
            if (spielfeld[spielfeld.length-1-j][z] == "X"||spielfeld[spielfeld.length-1-j][z] == "O") {
                
            }else{
                spielfeld[spielfeld.length-1-j][z] = "X";
                zeigeSpielfeld();
                RundenAnz++;
                Zeile = spielfeld.length-j;
                break;
            }
        }
    }

    public void setzeO(int z) {
        for(int j =0; j < spielfeld.length; j++)

            if (spielfeld[spielfeld.length-1-j][z] == "O"||spielfeld[spielfeld.length-1-j][z] == "X") {
            }else{
                spielfeld[spielfeld.length-1-j][z] = "O";
                zeigeSpielfeld();
                RundenAnz++;
                Zeile = spielfeld.length-j;
                break;
            }

    }

    public void zeigeSpielfeld(){
        System.out.println("");
        for (int i=0; i<spielfeld.length; i++){     
            for (int j =0; j<spielfeld.length; j++){
                System.out.print(spielfeld[i][j]);
            }
            System.out.println("");
        }
        System.out.println("______________________");
    }

    public int getRundenAnzahl() {
        return RundenAnz;  
    }

    public int getSpaltenZahl() {
        return x;  
    }

    public static int getZeile(){
        return Zeile;
    }

    public String[][] getSpielfeld(){
        return spielfeld;
    }
}

