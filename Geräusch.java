import ea.*;

public class Geräusch
{

    public Geräusch(String name)
    {
        Sound s = new Sound("src\\sounds\\"+name);
        s.play();
    }
}
