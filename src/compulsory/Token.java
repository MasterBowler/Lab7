package compulsory;

public class Token {
    private int number;
    private boolean blank;

    public Token(int number, boolean blank) {
        this.number = number;
        this.blank = blank;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isBlank() {
        return blank;
    }

    public void setBlank(boolean blank) {
        this.blank = blank;
    }
}
