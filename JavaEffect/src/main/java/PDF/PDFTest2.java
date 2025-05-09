package PDF;


import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.UnitValue;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class PDFTest2 {
    public static void main(String[] args) throws IOException {
        String dest = "book_table.pdf"; // 문자열 변수 -> 파일명
        new PDFTest2().createPdf(dest); // PDFTest2 객체 -> 메소드 createPdf 매개변수 dest
    }

    public void createPdf(String dest) throws IOException{
        List<Map<String, String>> books = createDummyData();
        //PDF 생성
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf, PageSize.A4); //A4 사이즈

        //Font Set
        PdfFont headerFont = null;
        PdfFont bodyFont = null;

        headerFont = PdfFontFactory.createFont("NanumYaGeunHaNeunGimJuIm.ttf","Identity-H");
        bodyFont = PdfFontFactory.createFont("NanumYaGeunHaNeunGimJuIm.ttf","Identity-H");


        //실수 배열 생성 -> 테이블 생성
        float[] columnWidths = {1, 2, 2, 2, 2, 2}; // 컬럼 넓이 비율
        Table table = new Table(UnitValue.createPercentArray(columnWidths)); // 테이블 넓이 위에 배열 참조
        table.setWidth(UnitValue.createPercentValue(100));

        // 테이블 헤더 -> 셀
        Cell hCell1 = new Cell().add(new Paragraph("순번")).setFont(headerFont);
        Cell hCell2 = new Cell().add(new Paragraph("제목")).setFont(headerFont);
        Cell hCell3 = new Cell().add(new Paragraph("저자")).setFont(headerFont);
        Cell hCell4 = new Cell().add(new Paragraph("출판사")).setFont(headerFont);
        Cell hCell5 = new Cell().add(new Paragraph("출판일")).setFont(headerFont);
        Cell hCell6 = new Cell().add(new Paragraph("이미지")).setFont(headerFont);

        table.addHeaderCell(hCell1);
        table.addHeaderCell(hCell2);
        table.addHeaderCell(hCell3);
        table.addHeaderCell(hCell4);
        table.addHeaderCell(hCell5);
        table.addHeaderCell(hCell6);

        //테이블 본문에 값 넣기
        int rowNum = 1;
        for(Map<String, String> book : books) {
            String title = book.get("title");
            String authors = book.get("authors");
            String publisher = book.get("publisher");
            String publishedDate = book.get("publishedDate");
            String thumbnail = book.get("thumbnail");

            // cell 1번
            Cell rowNumCell = new Cell().add(new Paragraph(String.valueOf(rowNum))).setFont(bodyFont);
            // table 추가
            table.addCell(rowNumCell);

            // cell 2번
            Cell titleCell = new Cell().add(new Paragraph(title)).setFont(bodyFont);
            //table 추가
            table.addCell(titleCell);

            Cell authorsCell = new Cell().add(new Paragraph(authors)).setFont(bodyFont);
            table.addCell(authorsCell);

            Cell publisherCell = new Cell().add(new Paragraph(publisher)).setFont(bodyFont);
            table.addCell(publisherCell);

            Cell publishedDateCell = new Cell().add(new Paragraph(publishedDate)).setFont(bodyFont);
            table.addCell(publishedDateCell);

            ImageData imageData = ImageDataFactory.create(new File(thumbnail).toURI().toURL());
            Image img = new Image(imageData);
            Cell imageCell = new Cell().add(img.setAutoScale(true));
            table.addCell(imageCell);

            rowNum++;

        }
        document.add(table); // 문서에 추가 table(모든 정보)
        document.close(); // close() 문서가 진짜 써짐
    }
    public List<Map<String, String>> createDummyData(){
        List<Map<String, String>> books = new ArrayList<>(); // ArrayList 객체 생성 -> MAP -> <String, String>
        Scanner scanner = new Scanner(System.in);
        System.out.print("책 개수를 입력하세요 : ");
        int bookCount = scanner.nextInt(); // 숫자 입력
        scanner.nextLine(); // 개행 문자 제거

        for(int i = 1 ; i <= bookCount ; i++){
            Map<String, String> book = new HashMap<>(); // map 객체를 생성
            System.out.printf("\n[ %d번째 책 정보 입력 ]\n", i);
            System.out.print("제목 : ");
            book.put("title",scanner.nextLine()); // map에 추가
            System.out.print("저자 : ");
            book.put("authors",scanner.nextLine()); // map에 추가
            System.out.print("출판사 : ");
            book.put("publisher",scanner.nextLine()); // map에 추가
            System.out.print("출판일(YYYY-MM-DD) : ");
            book.put("publishedDate",scanner.nextLine()); // map에 추가
            System.out.print("썸네일 URL : ");
            book.put("thumbnail",scanner.nextLine()); // map에 추가
            books.add(book); // List에 추가
        }
        scanner.close();
        return books;
    }
}
