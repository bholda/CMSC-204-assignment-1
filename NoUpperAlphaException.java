@SuppressWarnings("serial")
public class NoUpperAlphaException extends Exception {
public NoUpperAlphaException()
{
}
public NoUpperAlphaException(String password)
{
super(password);
}
}