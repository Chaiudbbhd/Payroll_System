 //made by lakshmi prasanna kumar//
package JFileChooser_Locations_API;
import java.util.prefs.Preferences;

/**
 *
 * @author lakshmi prasanna kumar
 */
public enum FileLastLocation2 {
  FileLocation;
  private static final Preferences prefs2 = Preferences.userRoot()
                                        .node(FileLastLocation2.class.getName());

  public String get(String defaultValue) {
      return prefs2.get(this.name(), defaultValue);
  }

  public void put(String value) {
      prefs2.put(this.name(), value);
  }
}
