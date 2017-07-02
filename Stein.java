import ea.*;
public abstract class Stein extends Bild
{
    public Stein(String dateiname){
        super("src\\"+dateiname);
        mittelpunktSetzen(50,500);
    }
 
} 
