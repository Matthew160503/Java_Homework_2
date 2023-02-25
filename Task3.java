public class Task3 {
    public static void main(String[] args) {
        String text = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}, {\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}, {\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
        String[] students_info = (text.replace("[", "").replace("]", "").replace("\"", "")).split(", ");
        for(int i = 0; i < students_info.length; i++){
            students_info[i] = students_info[i].replace("{", "").replace("}", "");

            String[] categories_info = students_info[i].split(",");
            String firstname = "";
            String grade = "";
            String lesson = "";

            for(int j = 0; j < categories_info.length; j++){
                String[] keys_and_values = categories_info[j].split(":");
                String key = keys_and_values[0];
                String value = keys_and_values[1];

                if (key.equals("фамилия")) firstname = value;
                else if (key.equals("оценка")) grade = value;
                else  if (key.equals("предмет")) lesson = value;
            }

            System.out.format("Студент %s получил %s по предмету %s\n", firstname, grade, lesson);
        }
    }
}
