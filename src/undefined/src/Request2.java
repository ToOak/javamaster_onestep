package undefined.src;

/**
 * Created by xushuailong on 2016/12/15.
 */
public class Request2 extends AbstractReqest {
    public Request2(Object obj) {
        super(obj);
    }

    @Override
    public int getRequestLevel() {
        return 2;
    }
}
