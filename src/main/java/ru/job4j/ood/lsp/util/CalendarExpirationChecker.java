package ru.job4j.ood.lsp.util;

import java.util.Calendar;

public class CalendarExpirationChecker implements ExpirationChecker<Calendar> {

    @Override
    public long getExpirationPercentage(Calendar start, Calendar end) {
        var y = end.getTimeInMillis() - start.getTimeInMillis();
        var x = end.getTimeInMillis() - Calendar.getInstance().getTimeInMillis();
        return 100 - (x * 100 / y);
    }
}
