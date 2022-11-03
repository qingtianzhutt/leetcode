package com.example.demo.es.utils;

import com.example.demo.es.bean.Good;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HtmlParseUtil {
    public static void main(String[] args) throws IOException {
        new HtmlParseUtil().parseJD("方便面").forEach(System.out::println);
    }
    public List<Good> parseJD(String keywords) throws IOException {
        String url = "https://search.jd.com/Search?keyword="+keywords;
        // jsoup解析网页，返回浏览器document对象
        Document document = Jsoup.parse(new URL(url), 30000);  //url 最长解析时间
        Element element = document.getElementById("J_goodsList");
        Elements elements = element.getElementsByTag("li");

        ArrayList<Good> goodsList = new ArrayList<>();

        for (Element el : elements) {
            //              找到<img>标签； 找到<li>标签下的第1个<img>标签； 获取其src属性
            String img = el.getElementsByTag("img").eq(0).attr("data-lazy-img");
            //             找到"p-price"类；找到<li>标签下的第1个"p-price"； 将其内容转为文字
            String price = el.getElementsByClass("p-price").eq(0).text();
            //             同上
            String name = el.getElementsByClass("p-name").eq(0).text();

            Good good = new Good();
            good.setImg(img);
            good.setName(name);
            good.setPrice(price);

            goodsList.add(good);
//            System.out.println(img);
//            System.out.println(price);
//            System.out.println(name);
        }
        return goodsList;
    }
}