import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        InspectJson inspectJson = new InspectJson();
        ArrayList<String> listTables = inspectJson.getTablesArray("D:\\acaropo\\descargas\\data.json");
        for (String temp : listTables) {
            System.out.println(temp);
        }
    }
}
