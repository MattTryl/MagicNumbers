public class IncorrectExtensionException extends Exception{
    public IncorrectExtensionException(String extension)
    {
        super (extension + " cannot be handled");
    }
}
