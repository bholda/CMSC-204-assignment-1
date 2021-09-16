@SuppressWarnings("serial")
public class NoSpecialCharacterException extends Exception {
public NoSpecialCharacterException()
{
}
public NoSpecialCharacterException(String password)
{
super(password);
}
}