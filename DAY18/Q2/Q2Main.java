/*

package WEEK05.DAY18.Q2;

public class Q2Main {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        solution(id_list, report, k);

    }


    public static int[] solution(String[] id_list, String[] report, int k) {
        String[][] splitReport = new String[report.length][2];

        String eliDupReport="";

        for(int i = 0 ; i < report.length ; i++){
            String temp = report[i];
            if(!eliDupReport.contains(temp)){
                eliDupReport+=temp;
            }
        }

        String[] eliDupReportArray = new String[eliDupReport.length()];

        for(int i = 0 ; i < eliDupReport.length() ; i++){
            eliDupReportArray = eliDupReport.split(" ");
        }
    }

}
*/