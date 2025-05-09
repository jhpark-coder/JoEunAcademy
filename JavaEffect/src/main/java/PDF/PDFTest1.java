package PDF;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Year;
import java.util.HashMap;

public class PDFTest1 {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> bookInfo = new HashMap<>();

        bookInfo.put("title", "한글 자바");
        bookInfo.put("author", "홍길동");
        bookInfo.put("publisher", "한글 출판사");
        //String.valueOf(Year.now().getValue()) 현재 년에 대한 데이터를 문자열로 변경
        bookInfo.put("year", String.valueOf(Year.now().getValue()));
        bookInfo.put("price", "25000");
        bookInfo.put("pages", "400");

        // book.pdf FileOutputStream 객체를 생성 -> PdfWriter 객체를 생성
        PdfWriter writer = new PdfWriter(new FileOutputStream("book.pdf"));
        // PdfWriter -> PdfDocument 객체를 생성
        PdfDocument pdf = new PdfDocument(writer);
        // PdfDocumnet -> Document
        Document document = new Document(pdf);

        //Font 설정 : PdfFontFactory 폰트객체를 생성
        PdfFont font = PdfFontFactory.createFont("NanumYaGeunHaNeunGimJuIm.ttf", PdfEncodings.IDENTITY_H);
        //Document font에 위에서 객체 생성 PdfFont를 세팅합니다.
        document.setFont(font);
        //키꾸러미를 빼서 문자열 변수 key에 대입 key 값이 없을 때까지 반복
        for(String key : bookInfo.keySet()){
            // key -> value를 추출해서 Paragraph 객체 생성 시 매개변수로 대입합니다.
            // "title : 한글자바"
            Paragraph paragraph = new Paragraph(key + ":" + bookInfo.get(key));
            //Paragraph 객체를 Document에 추가
            document.add(paragraph);
        }
        //Document 종료
        document.close();
        System.out.println("pdf 파일이 생성되었습니다.");

    }
}
