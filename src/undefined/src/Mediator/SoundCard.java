package undefined.src.Mediator;

/**
 * Created by xushuailong on 2016/12/16.
 */
public class SoundCard extends Colleague {
    public SoundCard(Mediator mediator) {
        super(mediator);
    }

    public void soundPlay(String data){
        System.out.println("音频：" + data);
    }
}
