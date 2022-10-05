package lesson8.ads;

import java.util.Date;

public class Massage extends BaseEntity {

    User userFrom;
    User userTo;
    Date dateSent;
    Date dateRead;
    String massage;

    public Massage(long id,User userFrom, User userTo, String massage) {
        super(id);
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.dateSent = new Date();
        this.massage = massage;
    }

    void setDateRead() {
        dateRead = new Date();
    }
    boolean isRead() {
        return dateRead == null;
    }
}
