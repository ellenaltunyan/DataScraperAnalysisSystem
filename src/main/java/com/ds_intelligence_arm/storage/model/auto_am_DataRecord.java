
package com.ds_intelligence_arm.storage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;


@Entity
public class auto_am_DataRecord {
    String url;
    String html;

    auto_am_DataRecord(String url, String html){
        this.url = url;
        this.html = html;
    }

    public String getUrl() {
        return this.url;
    }

    public String getTitle() {
        return getFirstElementText("title");
    }

    public String getDescription() {
        return getMetaContent("description");
    }

    public String getPriceInUSD() {
        return getFirstElementText(".offer-top-price .fnum");  // Assuming .fnum within price section
    }

    public String getPriceInAMD() {
        return getFirstElementText("#pricedown li:nth-child(2) span");  // Second item in dropdown for AMD
    }

    //ToDo: Getter for url, price_in_usd, price_in_amd, title, description using any of the getElements method 

        // Method to retrieve the first matching element's text
        private String getFirstElementText(String selector) {
            Document document = Jsoup.parse(this.html);
            Element element = document.selectFirst(selector);
            return element != null ? element.text() : "";
        }
    
        // Method to retrieve content from a meta tag
        private String getMetaContent(String metaName) {
            Document document = Jsoup.parse(this.html);
            Element metaElement = document.selectFirst("meta[name=" + metaName + "]");
            return metaElement != null ? metaElement.attr("content") : "";
        }
    
        // Generic method for fetching elements by selector
    public List<Element> getElementsBySelector(String selector) {
            Document document = Jsoup.parse(this.html);
            Elements elements = document.select(selector);
            return new ArrayList<>(elements);
        }

}
