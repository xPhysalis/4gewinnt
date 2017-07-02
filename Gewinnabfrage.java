
/**
 * Write a description of class Gewinnabfrage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gewinnabfrage
{
    private int y;
    private String nameX;
    private String nameO;
    private String[][] spielfeld;
    public Gewinnabfrage(String Name1, String Name2, int Gewinnzahl )
    {
        spielfeld = Spielfeld.getInstance().getSpielfeld();
        nameX=Name1;
        nameO=Name2;
        y=Gewinnzahl;
        System.out.println("Name1: " +nameX +"Name3: " +nameO);
        if (spielfeld == null) {
            System.out.println("NULL");
        }else{    
            abfrage();
        }
    }
    // i = y-Koordinate; j = x-Koordinate
    public void abfrage(){
        for(int i = 0; i < spielfeld.length; i++){
            for(int j = 0; j < spielfeld.length; j++){                
                if(spielfeld[i][j] != "-"){
                    String gew = spielfeld[i][j];
                    System.out.println("Gew:" + gew);
                    if (spielfeld.length-1-i < y-1){                       
                    }else if(spielfeld[i+1][j] == gew){
                        int gewi = 2;
                        for (int z = 2; z < y; z++){
                            if(spielfeld[i+z][j] == gew){
                                gewi++;
                                System.out.println("Gewi" + gewi);
                                if (gewi == y){
                                    if(gew == "X"){
                                        Spiel.getInstance().gameOver(nameX);
                                    }else if(gew == "O"){
                                        Spiel.getInstance().gameOver(nameO);
                                    }
                                }
                            }
                        } 
                    }
                    if(spielfeld.length-1-j < y-1){
                        
                    }else{
                        if(spielfeld[i][j+1] == gew){
                            int gewi = 2;
                            System.out.println("Gewi" + gewi);
                            for (int z = 2; z < y; z++){
                                if(spielfeld[i][j+z] == gew){
                                    gewi++;
                                    if (gewi == y){
                                        if(gew == "X"){
                                            Spiel.getInstance().gameOver(nameX);
                                        }else if(gew == "O"){
                                            Spiel.getInstance().gameOver(nameO);
                                        }
                                    }
                                }
                            } 
                        }
                    }
                    if(spielfeld.length-1-i > y-1 || spielfeld.length-1-j < y-1){
                        
                    }else{
                        if(spielfeld[i-1][j+1] == gew){
                            int gewi = 2;
                            for (int z = 2; z < y; z++){
                                if(spielfeld[i-z][j+z] == gew){
                                    gewi++;
                                    if (gewi == y){
                                        if(gew == "X"){
                                            Spiel.getInstance().gameOver(nameX);
                                        }else if(gew == "O"){
                                            Spiel.getInstance().gameOver(nameO);
                                        }
                                    }
                                }
                            } 
                        }
                    }
                    if(spielfeld.length-1-i < y-1 || spielfeld.length-1-j < y-1){

                    }else{
                        if(spielfeld[i+1][j+1] == gew){
                            int gewi = 2;
                            for (int z = 2; z < y; z++){
                                if(spielfeld[i+z][j+z] == gew){
                                    gewi++;
                                    if (gewi == y){
                                        if(gew == "X"){
                                            Spiel.getInstance().gameOver(nameX);
                                        }else if(gew == "O"){
                                            Spiel.getInstance().gameOver(nameO);
                                        }
                                    }
                                }
                            } 
                        }
                    }
                }
            }
        }
    }
}
