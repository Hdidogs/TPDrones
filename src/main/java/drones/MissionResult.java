package drones;

public enum MissionResult {
    OK(true),
    KO(false);

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    private boolean value;
    MissionResult(boolean value) {
        this.value = value;
    }

}
