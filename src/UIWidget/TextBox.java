package UIWidget;

public class TextBox {
    private final UIWidget widget;

    public TextBox(UIWidget widget) {
        this.widget = widget;
    }

    public void render(){
        widget.render();
    }
    public void resize(){
        widget.resize();
    }
    public void drag(){
        widget.drag();
    }
}
