import ea.*;
import java.util.concurrent.TimeUnit;
/* Beschreiben Sie hier die Klasse Menu.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Menu extends Game implements MausBewegungReagierbar, KlickReagierbar
{
    private static Menu self;
    private static final int höhe = 900;
    private static final int breite = 1500;
    private Bild btn_0;
    private Bild btn_1;
    private boolean aktiv = false;
    private int MouseX = breite/2, MouseY = höhe/2;
    private static Hintergrundmusik hm;
    private String[] namen = new String[2];
    private int beGewStein;
    private int uDesgins;
    public Menu(){
        super(breite,höhe,"Menü", false, true, 20,50);
        // iconSetzen(new Bild("src\\BO_icon.png"));
        self = this;
        hintergrundSetzen(new Bild("src\\StartHintergrund.png"));
        btn_0 = new Bild("src\\button_0.png");
        btn_0.mittelpunktSetzen(breite/2, höhe/2);
        btn_1 = new Bild("src\\button_1.png");
        btn_1.mittelpunktSetzen(breite/2, höhe/2);
        btn_1.sichtbarSetzen(false);
        wurzel.add(btn_0);
        wurzel.add(btn_1);
        playMusic();
        mausAnmelden(new M_Maus(this));
        namen[0] = eingabeFordern("Name Spieler 1");
        namen[1] = eingabeFordern("Name Spieler zwei");
        beGewStein = Integer.parseInt(eingabeFordern("Steine benötigt um zu Gewinnen (größer als 2)"));
        uDesgins = Integer.parseInt(eingabeFordern("Wähle zwischen 3 Designs: Erstes Design = 1, zweites Design = 2; drittes Design = 3"));
    }

    private void starteSpiel(){
        new Spiel(namen[0], namen[1],beGewStein,uDesgins);
        beenden(); 
    }

    private void updateBtn(boolean hover){
        if (!aktiv && hover){
            aktiv = true;
            btn_0.sichtbarSetzen(false);
            btn_1.sichtbarSetzen(true);
        }else if (aktiv && !hover){
            aktiv = false;
            btn_0.sichtbarSetzen(true);
            btn_1.sichtbarSetzen(false);
        }
    }

    private void playMusic(){
        if (hm == null){
            hm = new Hintergrundmusik("Titelmusik.wav");
        }else {
            hm.play();
        }
    }

    @Override
    public void tasteReagieren(int c){
        if (c == Taste.S){
            //starteSpiel();
        }

    }

    @Override
    public void mausBewegt(Vektor v){
        MouseX += v.dX();
        MouseY += v.dY();
        Punkt p = new Punkt(MouseX, MouseY);
        updateBtn(btn_0.beinhaltet(p));
    }

    @Override
    public void klickReagieren(Punkt p){
        if (btn_0.beinhaltet(p)){
            starteSpiel();

        }
    }
    public static Hintergrundmusik getHm(){
        return hm;
    }

    static void openMenu(){
        if (self == null)
            return;
        self.fensterMaximieren();
        self.playMusic();

    }
}
