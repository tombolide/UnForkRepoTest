package ie.gmit.open;

import java.util.List;

public class ISPSubscriber extends Subscriber {

    private long freeUsage;

    public ISPSubscriber()
    {

    }

    public double calculateBill()
    {
        List<InternetSessionHistory.InternetSession> sessions = InternetSessionHistory.getCurrentSessions(subscriberId);
        long totalData = sessions.stream().mapToLong(InternetSessionHistory.InternetSession::getDataUsed).sum();
        long chargeableData = totalData - freeUsage;
        return chargeableData * ((double) baseRate / 100);
    }

    /**
     * @return the freeUsage
     */
    public long getFreeUsage()
    {
        return freeUsage;
    }

    /**
     * @param freeUsage the freeUsage to set
     */
    public void setFreeUsage(long freeUsage)
    {
        this.freeUsage = freeUsage;
    }


}
