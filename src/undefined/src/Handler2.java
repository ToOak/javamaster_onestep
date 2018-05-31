package undefined.src;

/**
 * Created by xushuailong on 2016/12/15.
 */
public class Handler2 extends AbstractHandler {
    @Override
    protected int getHandleLevel() {
        return 2;
    }

    @Override
    protected void handle(AbstractReqest reqest) {
        System.out.println("Handler2 handle request:" + reqest.getRequestLevel());
    }
}
