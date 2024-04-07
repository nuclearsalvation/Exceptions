import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {

    }
    public static void parseString(String string){
        String[] strParsed = null;
        try{
            strParsed = string.split(" ");
            if (strParsed.length != 6){
                throw new CounterException("");
            }
            Date date = new SimpleDateFormat("dd.mm.yyyy").parse(strParsed[3]);
            Long phone = Long.parseLong(strParsed[4]);
            if (!(strParsed[5].equals("f") || strParsed[5].equals("m"))){
                throw new GenderException("");
            }
            FileWriter writer = new FileWriter(strParsed[0]+ ".txt", true);
            writer.write(string);
            writer.write("\n");
            writer.close();
        }
        catch (CounterException e){
            System.out.println("Количество данных не совпадает с требуемым");
        }
        catch (ParseException e){
            System.out.println("Дата введена неверно");
        }
        catch(NumberFormatException e){
            System.out.println("Неверно введен номер телефона");
        }
        catch(GenderException e){
            System.out.println("Неверно введен пол");
        }
        catch(IOException e){
            System.out.println("Ошибка записи файла");
            e.printStackTrace();
        }


    }

}
