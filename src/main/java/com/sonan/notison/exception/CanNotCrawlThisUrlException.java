package com.sonan.notison.exception;

/**
 * 해당 url로는 document를 얻어올 수 없을때 발생.
 *
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2020-04-10
 * @since: 1.8
 */
public class CanNotCrawlThisUrlException extends RuntimeException {
  private static final String MESSAGE = "can not crawling this url page.";

  public CanNotCrawlThisUrlException() {
    super(MESSAGE);
  }

  public CanNotCrawlThisUrlException(Throwable t) {
    super(MESSAGE, t);
  }
}
