If the code's are not working in vscode then try lo run in eclipse javaEE
this error is beacuae of vscode can't handle few dependenices so we willl uae eclipse and this eclipse can handle dependencies easily without any errors
////**** Mostly this error occurs***////
The error "FlatLightLaf cannot be resolved to a type" suggests that your Java program is trying to use the FlatLightLaf look-and-feel (from the FlatLaf library), but the necessary library is either:

Not imported in the project
Not added to the classpath/build path
Not correctly installed
Steps to Fix:
✅ 1. Add the FlatLaf Library to Your Project
If you're using Maven, add this dependency to your pom.xml:

xml:
<dependencies>
    <dependency>
        <groupId>com.formdev</groupId>
        <artifactId>flatlaf</artifactId>
        <version>3.1</version>
    </dependency>
</dependencies>
Then run:

mvn clean install
If you're using Gradle, add this to build.gradle:

gradle:
dependencies {
    implementation 'com.formdev:flatlaf:3.1'
}
If you're not using Maven/Gradle, download the JAR file from: FlatLaf Releases

Then, manually add the JAR to your classpath.

✅ 2. Import the Library in Your Code
Ensure that you import FlatLaf in your LoginFrame.java file:

java:
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
Then, in your main() method, set the theme:

java:
public static void main(String[] args) {
    try {
        UIManager.setLookAndFeel(new FlatLightLaf());
    } catch (UnsupportedLookAndFeelException e) {
        e.printStackTrace();
    }
    
    // Launch the application
    new LoginFrame();
}
✅ 3. Clean and Rebuild Your Project
After adding the library, clean and rebuild your project:

If using VS Code, click Terminal → Run Build Task (Ctrl+Shift+B).
If using Eclipse, click Project → Clean.
If using IntelliJ, go to File → Invalidate Caches / Restart.
Final Check
Try running the program again:

/usr/bin/env java -cp /path/to/your/classpath MainPackage.LoginFrame

If the issue persists, let me know! 🚀
