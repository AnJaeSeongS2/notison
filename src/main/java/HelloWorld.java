import java.io.IOException;
import java.util.Iterator;
import org.apache.logging.log4j.LogManager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 루리웹 동물의 숲 예판 홈피 url
 * https://bbs.ruliweb.com/market/board/1020
 *
 * $(".board_main tr.table_body").not(".best").not(".inside") .find("td.subject a.deco")[0].outerText;
 * "[네이버] 문어/오징어/새우 간장조림 160g (4,900원/무료)"
 *
 * $(".board_main tr.table_body").not(".best").not(".inside").find("td.id")[0].outerText
 * "38873"
 */

/**
 *
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2020-04-08
 * @since: 1.8
 */
public class HelloWorld {
  public static void main(String[] args) {
    System.out.println("HelloWorld.");
    LogManager.getLogger(HelloWorld.class.getName()).info("log info HelloWorld.");
    LogManager.getLogger(HelloWorld.class.getName()).warn("log warn HelloWorld.");
    LogManager.getLogger().info("root log info HelloWorld.");
    LogManager.getLogger().warn("root log warn HelloWorld.");


    // Jsoup를 이용해서 https://endic.naver.com/?sLn=kr 크롤링

    String url = "https://endic.naver.com/?sLn=kr";    //크롤링할 url지정
    Document doc = null;        //Document에는 페이지의 전체 소스가 저장된다

    try {
      doc = Jsoup.connect(url).get();
    } catch (IOException e) {
      e.printStackTrace();
    }

    //select를 이용하여 원하는 태그를 선택한다. select는 원하는 값을 가져오기 위한 중요한 기능이다.
    //                               ==>원하는 값들이 들어있는 덩어리를 가져온다
    Elements element = doc.select("ul.component_today_word");
    System.out.println("============================================================");

    //Iterator을 사용하여 하나씩 값 가져오기
    //덩어리안에서 필요한부분만 선택하여 가져올 수 있다.
    Iterator<Element> ie1 = element.select("a.word_link").iterator();
    Iterator<Element> ie2 = element.select("div.txt_trans").iterator();

    while (ie1.hasNext()) {
      System.out.println(ie1.next().text()+"\t"+ie2.next().text());
    }
    System.out.println("============================================================");

  }
}
