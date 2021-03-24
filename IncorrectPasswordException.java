public class IncorrectPasswordException extends Exception{
    String password;
    public IncorrectPasswordException(String password) {
        this.password = password;
    }

    public String toString() {
        return "Incorrect Password: " + password;
    }
}
