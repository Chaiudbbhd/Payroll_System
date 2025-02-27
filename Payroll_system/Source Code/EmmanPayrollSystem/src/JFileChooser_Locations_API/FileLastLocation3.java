 //made by lakshmi prasanna kumar//
package JFileChooser_Locations_API;
import java.util.prefs.Preferences;

/**
 *
 * @author  lakshmi prasanna kumar
 */
public enum FileLastLocation3 {
  FileLocation;
  private static final Preferences prefs3 = Preferences.userRoot()
                                        .node(FileLastLocation3.class.getName());

  public String get(String defaultValue) {
      return prefs3.get(this.name(), defaultValue);
  }

  public void put(String value) {
      prefs3.put(this.name(), value);
  }
}
