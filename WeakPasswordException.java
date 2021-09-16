@SuppressWarnings("serial")
public class WeakPasswordException extends Exception {
public WeakPasswordException()
{
}
public WeakPasswordException(String password)
{
super(password);
}
}