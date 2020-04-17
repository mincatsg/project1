package BridgeModel;

abstract class AbstractPlamForm {        //操作系统抽象类。
    MediaPlayInter mediaPlayInter ;
    public void setMediaPlayInter(MediaPlayInter mediaPlayInter){
        this.mediaPlayInter = mediaPlayInter ;
    }
    public abstract void play();

}
