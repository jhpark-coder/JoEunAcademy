package Excel;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcelReadTest {
    public static void main(String[] args){
        try{
            //파일을 받기 위한 FileInputStream 객체 생성
            FileInputStream file = new FileInputStream(new File("example.xlsx"));
            // WorkbookFactory 생성 -> FileInputStream 객체를 받아서 생성 -> Workbook
            Workbook workbook = WorkbookFactory.create(file);
            // workbook -> 0번째 Sheet의 객체를 생성해서 Sheet 변수에 대입
            Sheet sheet = workbook.getSheetAt(0);

            for(Row row : sheet){
                for(Cell cell : row){
                    switch (cell.getCellType()){
                        case NUMERIC: // 숫자
                            // cell의 값의 날짜이면 실행
                            if (DateUtil.isCellDateFormatted(cell)){
                                Date dateValue = cell.getDateCellValue(); // 날짜 데이터로 받습니다.
                                // 양식 yyyy-MM-dd로 세팅을 합니다.
                                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                // 날짜 데이터를 양식에 맞게 변경해서 문자열로 리턴해줍니다.
                                String formattedDate = dateFormat.format(dateValue);
                                System.out.print(formattedDate + "\t");
                            }
                            else { // 날짜가 아니면 실행
                                // getNumericCellValue 값을 받으면 실수 값이 나옵니다.
                                double numericValue = cell.getNumericCellValue();
                                //실수 값 numericValue == Math.floor(numericValue) 소숫점 값 버림
                                if (numericValue == Math.floor(numericValue)) {
                                    int intValue = (int) numericValue; // 정수로 형변환
                                    System.out.print(intValue + "\t"); // 출력
                                } else {
                                    //실수 값으로 출력
                                    System.out.print(numericValue + "\t");
                                }
                            }
                            break;
                        case STRING: //문자열
                            String stringValue = cell.getStringCellValue();
                            System.out.print(stringValue + "\t");
                            break;
                        case BOOLEAN: // 참거짓
                            boolean booleanValue = cell.getBooleanCellValue();
                            System.out.print(booleanValue + "\t");
                            break;
                        case FORMULA: // 엑셀 공식이 있는 경우
                            String formulaValue = cell.getCellFormula();
                            System.out.print(formulaValue + "\t");
                            break;
                        case BLANK : // 비어있는 경우
                            System.out.print("\t");
                            break;
                        default: // 위에 조건에 맞는 게 없는 경우
                            System.out.print("\t");
                            break;
                    }
                }
                System.out.println();
            }
            file.close();
            System.out.println("엑셀에서 데이터 읽어 오기 성공");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
