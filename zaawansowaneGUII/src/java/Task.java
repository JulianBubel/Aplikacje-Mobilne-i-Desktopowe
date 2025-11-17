public class Task {
    private String nazwa;
    private boolean ukonczone;
    private String priorytet;

    public Task(String nazwa, boolean ukonczone, String priorytet) {
        this.nazwa = nazwa;
        this.ukonczone = ukonczone;
        this.priorytet = priorytet;
    }

    public String getNazwa() { return nazwa; }
    public boolean isUkonczone() { return ukonczone; }
    public String getPriorytet() { return priorytet; }

    public void setUkonczone(boolean ukonczone) { this.ukonczone = ukonczone; }
}
