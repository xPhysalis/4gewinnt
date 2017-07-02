import ea.*;
public class SteinSp2 extends Stein
{
    public SteinSp2(Game g)
    {
        super(Spiel.getsDesign2());
        System.out.println(Spiel.getsDesign2());
        mittelpunktSetzen((Spiel.getSpalte()*100)-50,(Spielfeld.getInstance().getZeile()*100)-50+110);
        g.wurzel.add(this);
    }
}
