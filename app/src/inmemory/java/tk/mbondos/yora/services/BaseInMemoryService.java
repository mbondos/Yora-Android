package tk.mbondos.yora.services;

import com.squareup.otto.Bus;

import java.util.Random;
import android.os.Handler;

import tk.mbondos.yora.infrastructure.YoraApplication;

/**
 * Created by maksy on 17.02.2017.
 */

public abstract class BaseInMemoryService {
    protected final Bus bus;
    protected final YoraApplication application;
    protected final Handler handler;
    protected final Random random;

    protected BaseInMemoryService(YoraApplication application) {
        this.application = application;
        bus = application.getBus();
        handler = new Handler();
        random = new Random();
        bus.register(this);
    }
    protected void invokeDelayed(Runnable runnable, long millisecondMin, long millisecondMax) {
        if (millisecondMin > millisecondMax)
            throw new IllegalArgumentException("Min mus be smaller than max");

        long delay = (long) (random.nextDouble() * (millisecondMax - millisecondMin)) + millisecondMin;
        handler.postDelayed(runnable,delay);
    }

    protected void postDelayed(final Object event, long millisecondMin, long millisecondMax) {
        invokeDelayed(new Runnable() {
            @Override
            public void run() {
                bus.post(event);
            }
        }, millisecondMin, millisecondMax);
    }

    protected void postDelayed(Object event, long milliseconds) {
        postDelayed(event, milliseconds, milliseconds);
    }

    protected void postDelayed(Object event) {
        postDelayed(event, 600, 1200);
    }
}
