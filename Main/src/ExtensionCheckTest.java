import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExtensionCheckTest {

    @Test void txt()
    {
        var obj = new ExtensionCheck("C:\\Users\\nekro\\repo\\Main\\testFilesDir\\file.txt");
        assertEquals("file.txt does not contain BOM(Byte order mark) so it can't be checked", obj.Check());
    }
    @Test void gif()
    {
        var obj = new ExtensionCheck("C:\\Users\\nekro\\repo\\Main\\testFilesDir\\file.gif");
        assertEquals("file.gif has a proper extension" , obj.Check());
    }
    @Test void jpg()
    {
        var obj = new ExtensionCheck("C:\\Users\\nekro\\repo\\Main\\testFilesDir\\file.jpg");
        assertEquals("file.jpg has a proper extension" , obj.Check());
    }
    @Test void pdf()
    {
        var obj = new ExtensionCheck("C:\\Users\\nekro\\repo\\Main\\testFilesDir\\file.pdf");
        assertEquals("file.pdf has a proper extension" , obj.Check());
    }
    @Test void noExt()
    {
        var obj = new ExtensionCheck("file");
        assertEquals("no extension" , obj.Check());
    }
    @Test void badFile()
    {
        var obj = new ExtensionCheck("C:\\Users\\nekro\\repo\\Main\\testFilesDir\\badfile.pdf");
        assertEquals("Extension for badfile.pdf is incorrect. Actually jpg is the extension" , obj.Check());
    }

}