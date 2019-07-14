public class chatHistory {
    private String usernamesend ;
    private String usernameresive ;
    private String pmsend ;
    private String pmresive;
    private String date ;


    public chatHistory(String usernamesend, String usernameresive, String pmsend, String pmresive, String date) {
        this.usernamesend = usernamesend;
        this.usernameresive = usernameresive;
        this.pmsend = pmsend;
        this.pmresive = pmresive;
        this.date = date;
    }

    public String getUsernamesend() {
        return usernamesend;
    }

    public void setUsernamesend(String usernamesend) {
        this.usernamesend = usernamesend;
    }

    public String getUsernameresive() {
        return usernameresive;
    }

    public void setUsernameresive(String usernameresive) {
        this.usernameresive = usernameresive;
    }

    public String getPmsend() {
        return pmsend;
    }

    public void setPmsend(String pmsend) {
        this.pmsend = pmsend;
    }

    public String getPmresive() {
        return pmresive;
    }

    public void setPmresive(String pmresive) {
        this.pmresive = pmresive;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
