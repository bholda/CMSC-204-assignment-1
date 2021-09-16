@SuppressWarnings("serial")
public class LengthException extends Exception {
public LengthException()
{
}
public LengthException(String password)
{
super(password);
}
}