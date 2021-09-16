@SuppressWarnings("serial")
public class UnmatchedException extends Exception {
public UnmatchedException()
{
}
public UnmatchedException(String password)
{
super(password);
}
}