
package com.ds_intelligence_arm.scraper;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduler {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void scheduleScraping(Scraper<?> scraper, long interval, TimeUnit unit) {
        scheduler.scheduleAtFixedRate(scraper::scrapeData, 0, interval, unit);
    }
}
