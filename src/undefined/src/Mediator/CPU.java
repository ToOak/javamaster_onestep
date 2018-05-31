package undefined.src.Mediator;

/**
 * Created by xushuailong on 2016/12/16.
 */
public class CPU extends Colleague {
    private String dataVideo, dataSound;

    public CPU(Mediator mediator) {
        super(mediator);
    }

    public String getDataVideo() {
        return dataVideo;
    }

    public String getDataSound() {
        return dataSound;
    }

    public void decodeData(String data){
        String[] tmp = data.split(",");
        dataVideo = tmp[0];
        dataSound = tmp[1];
        mediator.changed(this);
    }
}
