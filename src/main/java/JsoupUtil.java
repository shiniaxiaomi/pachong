import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2018/12/29.
 */
public class JsoupUtil {

    //解析字符串并生成html文档
    public static void parseHtml(){
        String html = "<html><head><title>First parse</title></head>"
                + "<body><p>Parsed HTML into a doc.</p></body></html>";
        Document doc = Jsoup.parse(html);
        System.out.println(doc);
    }

    //解析html片段生成body标签包含的html
    public static void parseBodyFragment(){
        String html = "<div><p>Lorem ipsum.</p>";
        Document doc = Jsoup.parseBodyFragment(html);
        Element body = doc.body();
        System.out.println(body);
    }

    //根据url加载页面
    public static void connect() throws IOException {
        Document doc = Jsoup.connect("http://www.baidu.com").get();//带查询条件,具体看http://www.open-open.com/jsoup/load-document-from-url.htm
        String title = doc.title();
        System.out.println(doc);
    }

    //根据文件加载页面
    public static Document connectPath() throws IOException {
        File input = new File("D:\\code\\pachong\\src\\main\\resources\\1.html");
        Document doc = Jsoup.parse(input, "UTF-8");
//        System.out.println(doc);
        return doc;
    }

    //根据dom来解析文档
    public static void parseDom() throws IOException {
        Document doc=connectPath();//获取页面

        Element content = doc.getElementById("content");//根据id获取节点
        Elements links = content.getElementsByTag("h1");//根据标签获取节点
        //更多操作节点的方法 参考文档http://www.open-open.com/jsoup/dom-navigation.htm
        for (Element link : links) {
            String attr = link.attr("attr");//获取标签中的attr属性值
            String text = link.text();//获取标签中的text内容
            System.out.println(attr);
            System.out.println(text);
        }

    }

    //根据选择器语法来查找元素,并从元素中获取属性(使用css或jQuery的语法)
    public static void select() throws IOException {
        Document doc=connectPath();//获取页面

        //更多语法 参考文档
        // http://www.open-open.com/jsoup/selector-syntax.htm
        // http://www.open-open.com/jsoup/attributes-text-html.htm

        Element links = doc.select("a[href]").first(); //带有href属性的a元素
        Element masthead = doc.select("div.masthead").first();//class等于masthead的div标签

        System.out.println(links.attr("href"));//获取元素的href属性值
        System.out.println(masthead.id());//获取元素的id
    }



    public static void main(String[] args) throws IOException {
        //输入(获取页面)
//        parseHtml();//解析字符串并生成html文档
//        parseBodyFragment();//解析html片段生成body标签包含的html
//        connect();//根据url加载页面
//        connectPath();//根据文件加载页面

        //解析页面
//        parseDom();//根据dom来解析文档
//        select();//根据选择器语法来查找元素
    }

}
