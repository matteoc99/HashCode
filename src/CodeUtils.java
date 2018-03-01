import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author Matteo Cosi
 * @since 01.03.2018
 */
public class CodeUtils {
    public static void hello() {
        System.out.println("hi");
    }

    public static String readInString(String file){
        String ret = "";
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            ret = sb.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ret;
    }
}
