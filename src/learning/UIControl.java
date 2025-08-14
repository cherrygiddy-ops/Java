package learning;

public abstract  class UIControl {
    private  boolean isEnable =true;

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    public abstract void render();
}
