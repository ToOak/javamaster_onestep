package undefined.src.Mediator;

/**
 * Created by xushuailong on 2016/12/16.
 */
public class Client {
    public static void main(String[] args){
        MainBoard mainBoard = new MainBoard();

        CDDevice cd = new CDDevice(mainBoard);
        CPU cpu = new CPU(mainBoard);
        GraphicsCard vc  = new GraphicsCard(mainBoard);
        SoundCard sc = new SoundCard(mainBoard);

        mainBoard.setCdDevice(cd);
        mainBoard.setCpu(cpu);
        mainBoard.setGraphicsCard(vc);
        mainBoard.setSoundCard(sc);

        cd.load();
    }
}
