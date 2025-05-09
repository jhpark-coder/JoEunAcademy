package Excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelCrawling {
    public static void main(String[] args) throws IOException {
        String url = "https://novel.naver.com/webnovel/weekday";
        Document document = Jsoup.connect(url).get();
        Elements elements = document.select("div.info_area");
        //System.out.println(elements.text());
        int count = 1; // 번호

        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("웹소설");
        Row headRow = sheet.createRow(0);
        headRow.createCell(0).setCellValue("번호");
        headRow.createCell(1).setCellValue("제목");
        headRow.createCell(2).setCellValue("작성자");
        headRow.createCell(3).setCellValue("관심수");

        for(Element e: elements){
            Row r = sheet.createRow(count); // 1, 2, 3, .....
            // 비어있지 않으면 실행
            if(!e.select("span.title").text().isEmpty() &&
                    !e.select("span.author").text().isEmpty() &&
                    !e.select("span.count").text().isEmpty())
            {
                r.createCell(0).setCellValue(count++);
                r.createCell(1).setCellValue(e.select("span.title").text());
                r.createCell(2).setCellValue(e.select("span.author").text());
                r.createCell(3).setCellValue(e.select("span.count span").text());
                //System.out.println(count + "\t" + e.select("span.title").text() + "\t" + e.select("span.author").text() + "\t" + e.select("span.count > span"));
            }
        }
        FileOutputStream outputStream = new FileOutputStream(new File("web.xlsx"));
        workbook.write(outputStream);
        workbook.close();

    }
}
