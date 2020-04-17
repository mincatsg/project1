package BridgeModel;

class LinuxPlamForm extends AbstractPlamForm {    //定义LINUX操作系统接口
    public void play() {
        System.out.print("当前操作系统:Linux.开始调用播放器启动播放");
        mediaPlayInter.mediaPlay();
    }
}
