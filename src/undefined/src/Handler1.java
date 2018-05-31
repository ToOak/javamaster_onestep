package undefined.src;

/**
 * Created by xushuailong on 2016/12/15.
 */
public class Handler1 extends AbstractHandler {
    @Override
    protected int getHandleLevel() {
        return 1;
    }

    @Override
    protected void handle(AbstractReqest reqest) {
        System.out.println("Handler1 handle request:" + reqest.getRequestLevel());
    }
}
