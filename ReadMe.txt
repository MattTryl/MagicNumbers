This is a program for matching file signature with it's extension

Rundown of important files:
>Main.java is handling user interaction and gets the path to file we want to check
>ExtensionCheck.java is class file that handles checking of the actual signature
>fileSignatures.txt contains all of the data for supported extensions and their signatures
>IncorrectExtensionException.java is exception class that is thrown when extension is not contained in fileSignatures.txt
>ExtensionCheckTest.java is JUnit test class file
