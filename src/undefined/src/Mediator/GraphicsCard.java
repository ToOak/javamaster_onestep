package undefined.src.Mediator;

/**
 * Created by xushuailong on 2016/12/16.
 */
public class GraphicsCard extends Colleague {
    public GraphicsCard(Mediator mediator) {
        super(mediator);
    }
    public void videoPlay(String data){
        System.out.println("视频：" + data);
    }
}
