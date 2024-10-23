package Ns3Objects.UdpEchoCommunication;

import java.util.UUID;

/**
 * To store and manage the UdpEchoServerHelper Objects in NS3...
 *
 * @since 2.0.0
 * */
public class UdpEchoServer implements Communication {

    /**
     * ID (identity) of this object
     * */
    private final String id;
    /**
     * The index of the node
     * */
    int index;
    /**
     * The port no. for the server
     * */
    int portNo;
    /**
     * start time of the server...
     * */
    int startTime;
    /**
     * total uptime of the server...
     * */
    int upTime;

    /**
     * Constructor to create the object of type UdpEchoServer...
     *
     * @since 2.0.0
     * */
    public UdpEchoServer(int index, int portNo, int startTime, int upTime) {
        this.index = index;
        this.portNo = portNo;
        this.startTime = startTime;
        this.upTime = upTime;
        this.id = UUID.randomUUID().toString();
    }

    /**
     * To get the ID no. of this object...
     *
     * @since 2.0.0
     * @return ID no. of this object!
     * */
    public String getID() {
        return this.id;
    }

    /**
     * To compare two objects of type UdpEchoServer
     *
     * @since 2.0.0
     * @param obj Object to be compared
     * @return boolean value indicating whether these two objects are same
     * */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        UdpEchoServer that = (UdpEchoServer) obj;
        return id.equals(that.id);
    }

    /**
     * To get the hashcode of this object
     *
     * @since 2.0.0
     * @return integer value of hash code for this object
     * */
    @Override
    public int hashCode() {
        return id.hashCode();
    }

    /**
     * To get the node index...
     *
     * @since 2.0.0
     * @return Integer value of the node index
     * */
    @Override
    public int getIndex() {
        return this.index;
    }

    /**
     * To set the node index...
     *
     * @param index The node index
     * @since 2.0.0
     * */
    @Override
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * To get the port no...
     *
     * @since 2.0.0
     * @return Integer value of the port no.
     * */
    @Override
    public int getPortNo() {
        return this.portNo;
    }

    /**
     * To set the port no...
     *
     * @param portNo The port number
     * @since 2.0.0
     * */
    @Override
    public void setPortNo(int portNo) {
        this.portNo = portNo;
    }

    /**
     * To get the start time...
     *
     * @since 2.0.0
     * @return Integer value of the start time
     * */
    @Override
    public int getStartTime() {
        return this.startTime;
    }

    /**
     * To set the start time...
     *
     * @param startTime The start time
     * @since 2.0.0
     * */
    @Override
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    /**
     * To get the uptime...
     *
     * @since 2.0.0
     * @return Integer value of the uptime
     * */
    @Override
    public int getUpTime() {
        return this.upTime;
    }

    /**
     * To set the uptime...
     *
     * @param upTime The uptime
     * @since 2.0.0
     * */
    @Override
    public void setUpTime(int upTime) {
        this.upTime = upTime;
    }

    /**
     * To get the string format for directly printing...
     *
     * @return String format information for the Server Configuration...
     * @since 2.0.0
     * */
    @Override
    public String toString() {
        return "Server Index "+this.index+" - Port:"+this.portNo;
    }
}
