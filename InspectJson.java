import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

public class InspectJson {

    public ArrayList getTablesArray(String pathJson){
        ArrayList<String> tablesArray = new ArrayList<String>();

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(pathJson));

            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);
            getListTables(jsonObject, tablesArray);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tablesArray;
    }

    private void getListTables(JSONObject jsonObject, ArrayList<String> tablesArray){
        for(Iterator iterator = jsonObject.keySet().iterator(); iterator.hasNext();) {
            String key = (String) iterator.next();
            if(!tablesArray.contains(key))
                tablesArray.add(key);
            JSONObject jsonObject_items = (JSONObject) jsonObject.get(key);
            JSONArray childList = (JSONArray) jsonObject_items.get("child");
            Iterator<JSONObject> iterator_child = childList.iterator();
            while (iterator_child.hasNext()) {
                getListTables(iterator_child.next(), tablesArray);
            }
        }
    }
}
