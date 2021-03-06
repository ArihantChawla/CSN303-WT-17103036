import java.io.IOException;
import java.io.FileWriter;
import java.util.*;
import java.io.FileOutputStream;
import java.io.File;
import java.lang.*;
import java.net.*;
import java.io.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
//import com.opencsv.CSVWriter;
class Main{

    public static void facultyUrls(String url, String primaryUrl) throws IOException{
        FileWriter myWriter = new FileWriter("faculty-urls.csv");
        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("li.list-group-item> a[href]");
        myWriter.write("Department,Faculty Url\n");
        for(Element link: links){
            String src = link.attr("href");
            StringBuilder str = new StringBuilder(primaryUrl);
            Document temp;
            Elements temp_links;
            if(src.length()!=0)// && src.contains("https://pec.ac.in/faculty/")){
                str.append("/faculty");
                str.append(src);
                temp = Jsoup.connect(str.toString()).get();
                temp_links = temp.select("strong>a[href]");
                System.out.println("EXTRACTING FACULTY URLS from " + src);
                for(Element tl : temp_links){
                        myWriter.write(src + "," + tl.absUrl("href")+"\n");
                //        System.out.println(tl.absUrl("href"));
                }
                  System.out.println(str+"\n");
//                System.out.println(primaryUrl+"/faculty" + src);
        //        myWriter.write(level + "," + src +"\n");

        }
        myWriter.close();
//
    }

    public static void createCSVfromUrl(String url) throws IOException{
        Document doc = Jsoup.connect(url).get();
        System.out.println(doc.title());
        FileWriter myWriter = new FileWriter("all-tags.csv");
        myWriter.write("HTML Tag,Tag Text\n");

        //<p>
        Elements ps = doc.select("p");
        for (Element p : ps) {
            if(p.text()!=null && p.text().length() != 0)
                myWriter.write("p,"+p.text()+"\n");
            }

        //<h1>
        Elements h1s = doc.select("h1");
        for (Element h1 : h1s) {
            if(h1.text()!=null && h1.text().length() != 0)
                myWriter.write("h1,"+h1.text()+"\n");
        }

        //<h2>
        Elements h2s = doc.select("h2");
        for (Element h2 : h2s) {
            if(h2.text()!=null && h2.text().length() != 0)
                myWriter.write("h2,"+h2.text()+"\n");
        }

        //<h3>
        Elements h3s = doc.select("h3");
        for (Element h3 : h1s) {
            if(h3.text()!=null && h3.text().length() != 0)
                myWriter.write("h3,"+h3.text()+"\n");
        }

        //<h4>
        Elements h4s = doc.select("h4");
        for (Element h4 : h4s) {
            if(h4.text()!=null && h4.text().length() != 0)
                myWriter.write("h4,"+h4.text()+"\n");
        }

        //imgs
        Elements imgs = doc.select("img");
        for (Element img : imgs) {
            String src = img.attr("src");
            if(src!=null && src.length() != 0)
                myWriter.write("img,"+src+"\n");
        }
        myWriter.close();

        //a[href]

        FileWriter linkWriter = new FileWriter("link-tags.csv");
        linkWriter.write("Link Text,URL\n");
        Elements links = doc.select("a[href]");
        for (Element link : links) {
            //myWriter.write("a,"+ link.text() + "," + link.absUrl("href")+"\n");
            if(link.text().length()!=0 && link.absUrl("href").length()!=0)
                linkWriter.write(link.text() + "," + link.absUrl("href")+"\n");
//            System.out.println(link.text());
        }
        linkWriter.close();
    }

    public static void downloadFile(String link) throws IOException{
        System.out.println("opening connection");
        URL url = new URL(link);
        InputStream in = url.openStream();
        String[] fn = link.split("/");
        String fileName = fn[fn.length-1];
        FileOutputStream fos = new FileOutputStream(new File(fileName));

        System.out.println("reading from resource and writing to file...");
        int length = -1;
        byte[] buffer = new byte[1024];// buffer for portion of edata from connection
        while ((length = in.read(buffer)) > -1) {
            fos.write(buffer, 0, length);
        }
        fos.close();
        in.close();
        System.out.println("File downloaded");
    }

    public static void main(String[] args) throws IOException{


        //Part A
        String primaryUrl = "https://pec.ac.in";
        createCSVfromUrl(primaryUrl);

        //Part C (Using StringBuilder (For Part B))
        String deptUrl = "https://pec.ac.in/departments";
        facultyUrls(deptUrl,primaryUrl);

        //Part D
        String dwdUrl = "http://www.cs.sjtu.edu.cn/~jiangli/teaching/CS222/files/materials/Algorithm%20Design.pdf";
        downloadFile(dwdUrl);
    }


}
