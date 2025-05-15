import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
기본적으로 시간을 전담하는 클래스
 */
public class GameTimer {

    private Timer timer;
    private int seconds;
    private StatusPanel statusPanel;
    private boolean isRunning;

    public GameTimer(StatusPanel statusPanel){
        this.statusPanel = statusPanel;
        this.seconds = 0;
        this.isRunning = false;

        this.timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++;
                if(statusPanel != null){
                    statusPanel.updateTimeDisplay(seconds);
                }
            }
        });
    }

    public void startTimer(){
        if (!isRunning){
            timer.start();
            isRunning = true;
        }
    }

    public void stopTimer(){
        if (isRunning){
            timer.stop();
            isRunning = false;
        }
    }

    public void resetAndStart(){
        stopTimer();
        seconds = 0;
        if(statusPanel != null){
            statusPanel.updateTimeDisplay(seconds);
        }
        startTimer();
    }

    public int getSeconds() {
        return seconds;
    }

    public boolean isRunning() {
        return isRunning;
    }
}
