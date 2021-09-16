@SuppressWarnings("serial")
public class InvalidSequenceException extends Exception {
public InvalidSequenceException()
{
}
public InvalidSequenceException(String password)
{
super(password);
}
}