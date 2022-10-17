package ru.job4j.oodtheory.isp;

public interface Phone {

    /*
     *
     * Нарушение принципа ISP в том, что не все телефоны могут писать смс или делать снимки.
     *
     * */

    boolean call();

    boolean incomeCall();

    void sendSMS();

    void takePhoto();
}
