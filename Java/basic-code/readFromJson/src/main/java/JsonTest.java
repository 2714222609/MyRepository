import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;

public class JsonTest {
    public static String readJsonFile(String fileName){
        String jsonStr;
        try{
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"UTF-8");
            int ch;
            StringBuffer sb = new StringBuffer();
            while((ch = reader.read()) != -1){
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args){
        String path = "readFromJson\\src\\main\\java\\Movie.json";
        String s = readJsonFile(path);
        JSONObject jobj = JSON.parseObject(s);
        JSONArray movies = jobj.getJSONArray("RECORDS");
        for(int i = 0; i < movies.size(); i++){
            JSONObject key = (JSONObject)movies.get(i);
            String name = (String)key.get("name");
            String director = (String)key.get("director");
            String scenarist = ((String)key.get("scenarist"));
            String actors = ((String)key.get("actors"));
            String type = ((String)key.get("type"));
            String ratingNum = ((String)key.get("ratingNum"));
            String tags = ((String)key.get("tags"));
            System.out.println(name);
            System.out.println(director);
            System.out.println(scenarist);
            System.out.println(actors);
            System.out.println(type);
            System.out.println(director);
            System.out.println(ratingNum);
            System.out.println(tags);
        }
    }
}
