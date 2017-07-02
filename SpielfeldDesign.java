import ea.*;
public class SpielfeldDesign
{
    private RECHTECK GitterSpalte[];
    private RECHTECK GitterZeile[];
    public SpielfeldDesign(int anzahl, Game g,int SpielfeldL,int  SpielfeldB)
    {   
        GitterSpalte = new RECHTECK [SpielfeldB/100+1];
        GitterZeile = new RECHTECK [SpielfeldL/100+1];
        for (int i =0 ; i< GitterSpalte.length; i++){
            GitterSpalte[i] = new RECHTECK(5,SpielfeldL); 
            GitterSpalte[i].setzeMittelpunkt(i*100,SpielfeldL/2+100);
            g.wurzel.add(GitterSpalte[i]);
        }
        for (int i =0 ; i< GitterSpalte.length; i++){
            GitterZeile[i] = new RECHTECK(SpielfeldB,5); 
            GitterZeile[i].setzeMittelpunkt(SpielfeldB/2,i*100+100);
            g.wurzel.add(GitterZeile[i]);
        }
    }
}
