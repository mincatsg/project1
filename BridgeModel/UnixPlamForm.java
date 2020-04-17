package BridgeModel;

class UnixPlamForm extends AbstractPlamForm {      //定义UNIX操作系统接口
    public void play() {
        System.out.println("当前操作系统:Unix.开始调用播放器启动播放");
        mediaPlayInter.mediaPlay();
    }
}
