import java.io.FileReader;
import java.io.IOException;

/**
 В файле содержится строка с исходными данными в такой форме:
{"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";
Для разбора строки используйте String.split. Сформируйте новую строку, используя StringBuilder. Значения null не включаются в запрос.
 */

public class Sql_Request {
    public static void main(String[] args) {
        String file_content = ReadFile();
        System.out.println(file_content);
        if (file_content.contains("Произошла ошибка!")) {
            System.out.println("Для продолжения работы необходимо исправить ошибку: " + file_content.substring(16));
        } else{
            System.out.println(Create_Sql_Request(file_content));
            
        }
    }

    private static String ReadFile(){
        try(FileReader reader = new FileReader("file_for_task1.txt")){
            int c;
            StringBuffer file_string = new StringBuffer();
            while((c=reader.read())!=-1){
                file_string.append((char)c);
            }
            return file_string.toString(); 
        }
        catch(IOException ex){    
            return "Произошла ошибка!" + ex.getMessage();
        }
    }

    private static String Create_Sql_Request(String file_str){
        String[] res = (file_str.replace("{","").replace("}","")
        .replace("\"","").replace(":", " = ")).split(", ");
        StringBuilder sql_str_request = new StringBuilder();
        sql_str_request.append("SELECT * FROM students WHERE");
        for (int i = 0; i < res.length; i++){
            if (res[i].contains("null")){
                continue;
            } else{
                sql_str_request.append(" " + res[i] + " AND");
            }
        }
        sql_str_request.delete(sql_str_request.length() - 4,sql_str_request.length());
        
        return sql_str_request.toString();
    }
}