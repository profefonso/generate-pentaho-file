import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        InspectJson inspectJson = new InspectJson();
        ArrayList listTables = inspectJson.getTablesArray("D:\\acaropo\\descargas\\data.json");
        listTables.forEach((n) -> System.out.println(n));
    }
}
