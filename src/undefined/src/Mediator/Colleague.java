package undefined.src.Mediator;

/**
 * Created by xushuailong on 2016/12/16.
 */
public abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator){
        this.mediator = mediator;
    }
}
