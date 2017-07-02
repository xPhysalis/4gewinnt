import ea.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Write a description of class Spiel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spiel extends Game implements KlickReagierbar
{
    private static int spielfeldG = Spielfeld.getInstance().getSpaltenZahl() *100 ;
    private static int Spalte;
    private String name1, name2;
    private int anzGew;
    private static int spielD;
    public Spiel(String n1, String n2, int n, int gD ){        
        super(spielfeldG,spielfeldG+100);
        name1 = n1;
        name2 = n2;
        anzGew = n;
        spielD = gD;
        new SpielfeldDesign(7, this,spielfeldG+100,spielfeldG);
        Bild cursor = new Bild(0, 0, "logo.gif");
        Punkt hotspot = new Punkt(0,0);
        Maus maus = new Maus(cursor, hotspot);
        mausAnmelden(maus);
        maus.klickReagierbarAnmelden(this);
    }

    public void klickReagieren(Punkt punkt){
        System.out.println(punkt);

        for(int j = 0; j < Spielfeld.getInstance().getSpaltenZahl()+1; j++) {
            if(punkt.x() >= spielfeldG-100*j && punkt.x() <= (spielfeldG-100*j)+100 ) {
                if(XoderO() == "X")  {
                    Spalte = ((spielfeldG/100)-j)+1;
                    System.out.println("Spalte:" + Spalte);
                    Spielfeld.getInstance().setzeX((spielfeldG/100)-j);
                    new SteinSp1(this); 
                    new Gewinnabfrage(name1,name2,anzGew);
                }else if(XoderO() == "O"){
                    Spalte = ((spielfeldG/100)-j)+1;
                    System.out.println("Spalte:" + Spalte);
                    Spielfeld.getInstance().setzeO((spielfeldG/100)-j);
                    new SteinSp2(this);
                    new Gewinnabfrage(name1,name2,anzGew);
                }
            }
        }
    }

    @Override
    public void tasteReagieren(int c){}

    public static int getSpalte(){
        return Spalte;
    }
    
    public void gameOver(String gewinner){
        new EndScreen(gewinner);
        beenden();
        //Menu.openMenu();
    }
    
    public static int getspielfeldB(){
        return spielfeldG/100;
    }
    
    public static String getsDesign1(){
        if(spielD == 1){
            return "Stein1.png";
        }else if(spielD == 2){
            return "Stein1_1.png";
        }else if(spielD == 3){
            return "Stein1_2.png";
        }else{
        return "fehler";
        }
    }
    public static String getsDesign2(){
        if(spielD == 1){
            return "Stein2.png";
        }else if(spielD == 2){
            return "Stein2_1.png";
        }else if(spielD == 3){
            return "Stein2_2_1.png";
        }
        return "";
    }
    
    public static String XoderO(){
        if(Spielfeld.getInstance().getRundenAnzahl()% 2 == 0){
            return "X";
        }else{
            return "O";
        }
    }
  
    private static Spiel instance;
    
     public static Spiel getInstance(){
        
    if (Spiel.instance == null) {
      Spiel.instance = new Spiel ("Something went", "very wrong",3,4);
    }
    return Spiel.instance;
     }
}
