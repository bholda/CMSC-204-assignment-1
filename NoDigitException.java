@SuppressWarnings("serial")
public class NoDigitException extends Exception {
public NoDigitException()
{
}
public NoDigitException(String password)
{
super(password);
}
}