package undefined.src;

/**
 * Created by xushuailong on 2016/12/15.
 */
public class Handler3 extends AbstractHandler {
    @Override
    protected int getHandleLevel() {
        return 3;
    }

    @Override
    protected void handle(AbstractReqest reqest) {
        System.out.println("Handler3 handle request:" + reqest.getRequestLevel());
    }
}
