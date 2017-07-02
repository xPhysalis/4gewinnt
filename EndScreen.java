import ea.*;

public class EndScreen extends Game{
    public EndScreen(String gewinner){
        super(1500,900);
        Text t = new Text("SIEGER: "+gewinner,0,0,"Calibri",144,2,"Grün");
        t.mittelpunktSetzen(1500/2, 900/2);
        wurzel.add(t);
    }
    
    @Override
    public void tasteReagieren(int c){}
    
}
