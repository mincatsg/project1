package BridgeModel;

class WindowsPlamForm extends AbstractPlamForm {   //定义Windows操作系统接口
    public void play() {
        System.out.print("当前操作系统:Windows.开始调用播放器启动播放");
        mediaPlayInter.mediaPlay();
    }
}
