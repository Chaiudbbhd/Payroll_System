 //made by lakshmi prasanna kumar//
package MainPackage;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author  lakshmi prasanna kumar
 */
public class JTextFieldLimitAPI extends PlainDocument {
   final private int limit;
   JTextFieldLimitAPI(int limit) {
      super();
      this.limit = limit;
   }
   JTextFieldLimitAPI(int limit, boolean upper) {
      super();
      this.limit = limit;
   }
   @Override
   public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
       if (str == null)
         return;
      if ((getLength() + str.length()) <= limit) {
         super.insertString(offset, str, attr);
      }
   }
}
