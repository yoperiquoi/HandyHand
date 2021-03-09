package Testing.GestureTest;

import Core.Daemon.CallLoop;
import Core.Daemon.Daemon;
import Core.Gesture.GestureMatcher;
import Core.Interaction.Interaction;
import Core.Listener.GestureListener;
import Core.Listener.MainListener;
import Core.Script.Script;
import Testing.Tester;
import Visual.ProcessingVisual.Skeleton.SkeletonView;
import Visual.Renderer.ProcessingRenderer;
import com.leapmotion.leap.Controller;

public class GestureSkeletonTest implements Tester {
    @Override
    public void start() {
        Controller controller = new Controller();
        skeletonTest(controller);

        //GestureMatcher.init();

        gestureTesting();
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void gestureTesting(){
        Interaction interaction = new Interaction();
        /*
        MainListener listener = GestureListener.GestureListenerFactory("rock");
        interaction.addListener(new MainListener[]{listener}, new Script("test.bat", new String[]{} ,""));
        Daemon daemon = new Daemon("GestureListener", new CallLoop(interaction));
        daemon.start();
        */
    }

    private void skeletonTest(Controller controller){
        ProcessingRenderer cam = new ProcessingRenderer(controller,new SkeletonView());
        cam.show();
    }
}
