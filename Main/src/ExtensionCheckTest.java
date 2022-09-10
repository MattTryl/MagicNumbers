import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class ExtensionCheckTest {

    @Test void txt()
    {
        Path path = Paths.get("testFilesDir/file.txt");
        var obj = new ExtensionCheck(path.toString());
        assertEquals("file.txt does not contain BOM(Byte order mark) so it can't be checked", obj.Check());
    }
    @Test void gif()
    {
        Path path = Paths.get("testFilesDir/file.gif");
        var obj = new ExtensionCheck(path.toString());
        assertEquals("file.gif has a proper extension" , obj.Check());
    }
    @Test void jpg()
    {
        Path path = Paths.get("testFilesDir/file.jpg");
        var obj = new ExtensionCheck(path.toString());
        assertEquals("file.jpg has a proper extension" , obj.Check());
    }
    @Test void pdf()
    {
        Path path = Paths.get("testFilesDir/file.pdf");
        var obj = new ExtensionCheck(path.toString());
        assertEquals("file.pdf has a proper extension" , obj.Check());
    }
    @Test void noExt()
    {
        Path path = Paths.get("testFilesDir/file");
        var obj = new ExtensionCheck(path.toString());
        assertEquals("no extension" , obj.Check());
    }
    @Test void badFile()
    {
        Path path = Paths.get("testFilesDir/badfile.pdf");
        var obj = new ExtensionCheck(path.toString());
        assertEquals("Extension for badfile.pdf is incorrect. Actually jpg is the extension" , obj.Check());
    }
    @Test void extensionNotHandled()
    {
        Path path = Paths.get("testFilesDir/file.html");
        var obj = new ExtensionCheck(path.toString());
        assertEquals("Extension not supported" , obj.Check());
    }

}