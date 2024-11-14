
package com.ds_intelligence_arm.scraper;

import java.util.List;

public interface Scraper<T> {
    List<T> scrapeData();
}
