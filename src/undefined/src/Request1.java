package undefined.src;

/**
 * Created by xushuailong on 2016/12/15.
 */
public class Request1 extends AbstractReqest {

    public Request1(Object obj) {
        super(obj);
    }

    @Override
    public int getRequestLevel() {
        return 1;
    }
}
