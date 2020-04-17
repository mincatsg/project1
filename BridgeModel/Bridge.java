package BridgeModel;

public class Bridge {               //客户端测试代码

    public static void main(String[] args) {
        AbstractPlamForm linux = new LinuxPlamForm();    //假设当前操作系统是Linux
        linux.setMediaPlayInter(new AVIPlay());           //假设播放的文件是AVI格式
        linux.play();                                       //输出提示结果
        System.out.println("");


        AbstractPlamForm window= new WindowsPlamForm();           // 以下原理同上。多次测试避免错误
        window.setMediaPlayInter(new RmvbPlay());
        window.play();
        System.out.println("");


    }
}

