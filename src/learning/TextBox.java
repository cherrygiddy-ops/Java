package learning;

import java.util.Objects;

public class TextBox extends UIControl {
    private  String text;

    public TextBox(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "TextBox{" +
                "text='" + text + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TextBox textBox = (TextBox) o;
        return Objects.equals(text, textBox.text);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(text);
    }

    @Override
    public void render() {
        System.out.println("hello");
    }
}

