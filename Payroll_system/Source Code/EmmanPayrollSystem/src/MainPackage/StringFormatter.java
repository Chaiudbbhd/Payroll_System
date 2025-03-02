 //made by lakshmi prasanna kumar//
package MainPackage;

/**
 *
 * @author G. Lakshmi Prasanna kumar
 */
public class StringFormatter {
    public static String capitalizeWord(String str) {
        String words [] = str.split("\\s");
        String capitalizeWord = "";
        
        for(String w:words) {
            String first = w.substring(0,1);
            String afterfirst = w.substring(1);
            capitalizeWord+=first.toUpperCase()+afterfirst+" ";
        }
        
        return capitalizeWord.trim();
    }
}
