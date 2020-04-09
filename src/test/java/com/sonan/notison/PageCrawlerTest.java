package com.sonan.notison;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2020-04-10
 * @since: 1.8
 */
public class PageCrawlerTest {

  /**
   * crawling getDocument test
   *
   * @param url
   */
  @ParameterizedTest
  @ValueSource(strings = {"https://bbs.ruliweb.com/market/board/1020", "https://endic.naver.com/?sLn=kr"})
  public void Constructor(String url) {
    System.out.println(new PageCrawler(url).getDocument());
  }
}