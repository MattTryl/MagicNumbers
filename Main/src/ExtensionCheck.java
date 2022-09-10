import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExtensionCheck {
    private final String filename;
    private byte[] m_num;
    private String fileHEX = "";

    public ExtensionCheck(String filepath)
    {
        if(filepath.contains("\\"))
        {
            filename = filepath.substring(filepath.lastIndexOf("\\") + 1);
        }
        else
        {
            filename = filepath.substring(filepath.lastIndexOf("/") + 1);
        }
        setM_num(filepath);
    }

    private void setM_num(String path)
    {
        try
        {
            Path file = Paths.get(path);
            m_num = Files.readAllBytes(file);

        } catch (IOException e) {
            System.out.println("Cannot read the file");
            e.printStackTrace();
        }

    }

    private String correctExt()
    {
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\nekro\\repo\\Main\\src\\fileSignatures.txt")))
        {
            for(String line; (line = br.readLine()) != null; )
            {
                String[] signatures = line.split(", ");
                for(int i = 1; i < signatures.length; i++)
                {
                    if(fileHEX.startsWith(signatures[i]))
                    {
                        return ("Actually " + signatures[0] + " is the extension");
                    }
                }
            }


        }catch (IOException e)
        {
            System.out.println("Problem with list of signatures");
            e.printStackTrace();
        }

        return "This signature is not a supported extension";

    }

    public String Check()
    {
        String[] signatures = null;
        String extension = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();
        boolean extSupported = false;

        if(!extension.equals(filename))
        {
            try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\nekro\\repo\\Main\\src\\fileSignatures.txt")))
            {
                for(String line; (line = br.readLine()) != null; )
                {
                    signatures = line.split(", ");
                    if(signatures[0].equals(extension))
                    {
                        extSupported = true;
                        break;
                    }
                }
                if(!extSupported)
                {
                    throw new IncorrectExtensionException(extension);
                }
            }catch (IOException e)
            {
                System.out.println("Problem with list of signatures");
                e.printStackTrace();
            } catch (IncorrectExtensionException e) {
                e.printStackTrace();
                return "Extension not supported";
            }


            StringBuilder sb = new StringBuilder();
            for (byte b : m_num) {
                sb.append(String.format("%02X ", b));
            }
            fileHEX = sb.toString();

            for(int i = 1; i < signatures.length; i++)
            {
                if (fileHEX.startsWith(signatures[i]))
                {
                    return (filename + " has a proper extension");
                }
            }
        }else
        {
            return "no extension";
        }

        if (!extension.equals("txt"))
        {
            return ("Extension for " + filename + " is incorrect. " + correctExt());
        }else
        {
            return (filename + " does not contain BOM(Byte order mark) so it can't be checked");
        }
    }
}
