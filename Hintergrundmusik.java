import ea.*;
public class Hintergrundmusik
{
    private Sound s;
    public Hintergrundmusik(String name)
    {
        s = new Sound("src\\"+name);
        s.play();
        s.loop();
    }

    public void stop(){
        System.out.println("Music Stop");
        s.stop();
    }
    public void play(){
        s.play();
    }
}
