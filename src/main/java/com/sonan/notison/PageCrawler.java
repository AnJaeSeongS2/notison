package com.sonan.notison;

import com.sonan.notison.exception.CanNotCrawlThisUrlException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Jsoup을 이용해 특정 url의 페이지를 크롤링 해온다.
 * connection을 얻어오는 것은 고 코스트 작업이므로, url을 변경하게끔 api를 제공하고 있지 않는다.
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2020-04-10
 * @since: 1.8
 */
public class PageCrawler {
  private String url;
  private Connection connection;
  private Document document;

  public PageCrawler(String url) {
    this.url = url;
    this.connection = Jsoup.connect(url);
    try {
      this.document = this.connection.get();
    } catch (Exception e) {
      throw new CanNotCrawlThisUrlException(e);
    }
  }

  public Document getDocument() {
    return this.document;
  }



}
