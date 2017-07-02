import ea.*;
public class SteinSp1 extends Stein
{
    public SteinSp1(Game g)
    {
        super(Spiel.getsDesign1());
        mittelpunktSetzen((Spiel.getSpalte()*100)-50,(Spielfeld.getInstance().getZeile()*100)-50+110);
        g.wurzel.add(this);
    }
}
