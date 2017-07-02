import ea.*;
/**
 * Beschreiben Sie hier die Klasse Menu_Maus.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class M_Maus extends Maus
{
    private Menu menu;
    public M_Maus(Menu m){
        super(3);
        menu = m;
        mausBewegungReagierbarAnmelden(m);
        klickReagierbarAnmelden(m);
    }
}

