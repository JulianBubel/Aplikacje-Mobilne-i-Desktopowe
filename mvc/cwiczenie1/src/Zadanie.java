public class Zadanie {
    private int id;
    private String tresc;
    private boolean status;

    public Zadanie(int id, String tresc, boolean status) {
        this.id = id;
        this.tresc = tresc;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getTresc() {
        return tresc;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    @Override
    public String toString() {
        return id + ". " + tresc + " (status: " + (status ? "Zrobione" : "Nie zrobione") + ")";
    }
}
