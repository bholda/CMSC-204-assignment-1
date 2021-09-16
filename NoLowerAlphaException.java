@SuppressWarnings("serial")
public class NoLowerAlphaException extends Exception {
public NoLowerAlphaException()
{
}
public NoLowerAlphaException(String password)
{
super(password);
}
}