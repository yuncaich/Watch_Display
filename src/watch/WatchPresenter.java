package watch;

public class WatchPresenter implements Observer {
    
    private final Watch watch;
    private final WatchDisplay watchDisplay;

    public WatchPresenter(Watch watch, WatchDisplay watchDisplay) {
        this.watch = watch;
        this.watchDisplay = watchDisplay;
        this.watch.addObserver(this);
    }


    @Override
    public void update() {
        watchDisplay.show(watch.getHours(), watch.getMinutes(), watch.getSeconds());
    }
    
}
