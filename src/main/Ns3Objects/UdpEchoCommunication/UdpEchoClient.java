package Ns3Objects.UdpEchoCommunication;

import java.util.Objects;
import java.util.UUID;

/**
 * To store and manage UdpEchoClientHelper Object from NS3
 *
 * @since 2.0.0
 * */
public class UdpEchoClient implements Communication {

    private final String id;
    int index;
    int startTime;
    int upTime;
    int mtu;
    int interval;
    int packets;
    int serverIndex;
    int deviceIndex;

    public UdpEchoClient(int index, int startTime, int upTime, int mtu, int interval, int packets, int serverIndex, int deviceIndex) {
        this.id = UUID.randomUUID().toString();
        this.index = index;
        this.startTime = startTime;
        this.upTime = upTime;
        this.mtu = mtu;
        this.interval = interval;
        this.packets = packets;
        this.serverIndex = serverIndex;
        this.deviceIndex = deviceIndex;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        UdpEchoClient that = (UdpEchoClient) obj;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public int getIndex() {
        return this.index;
    }

    @Override
    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    @Deprecated
    public int getPortNo() {
        return 0;
    }

    @Override
    @Deprecated
    public void setPortNo(int portNo) {

    }

    @Override
    public int getStartTime() {
        return this.startTime;
    }

    @Override
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    @Override
    public int getUpTime() {
        return this.upTime;
    }

    @Override
    public void setUpTime(int upTime) {
        this.upTime = upTime;
    }

    public int getMtu() {
        return this.mtu;
    }

    public void setMtu(int mtu) {
        this.mtu = mtu;
    }

    public int getInterval() {
        return this.interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public int getPackets() {
        return this.packets;
    }

    public void setPackets(int packets) {
        this.packets = packets;
    }

    public int getServerIndex() {
        return this.serverIndex;
    }

    public void setServerIndex(int serverIndex) {
        this.serverIndex = serverIndex;
    }

    public int getDeviceIndex() {
        return this.deviceIndex;
    }

    public void setDeviceIndex(int deviceIndex) {
        this.deviceIndex = deviceIndex;
    }
}
