/**
 * <p>
 *     The following package includes the storage type, for Network configuration
 *     in NS-3, it will be responsible to store the data and generate the code
 *     for Network configuration
 * </p>
 * */
package Ns3Objects.Netoworks;

import Ns3Objects.UdpEchoCommunication.UdpEchoServer;

import java.util.UUID;

/**
 * a storage type for network settings in NS-3
 * */
public class Network {
    /**
     * for unique identity
     * */
    private final String id;
    /**
     * for net id of the network settings
     * */
    public String netId;
    /**
     * for netmask of the network settings
     * */
    public String netMask;
    /**
     * for name alias name
     * */
    public String name;
    /**
     * for selecting as default network settings
     * */
    public boolean isDefault;

    /**
     * to make the object of type Network
     *
     * @param netId net id of the network
     * @param netMask subnet mask for the network
     * @param name alias name of the network
     * @since 0.3.0
     * */
    public Network(String netId, String netMask, String name) {
        this.id = UUID.randomUUID().toString();
        this.netId = netId;
        this.netMask = netMask;
        this.name = name;
        this.isDefault = false;
    }

    /**
     * to make the object of type Network
     *
     * @param netId net id of the network
     * @param netMask subnet mask for the network
     * @param name alias name of the network
     * @param isDefault select as default link
     * @since 0.3.0
     * */
    public Network(String netId, String netMask, String name, boolean isDefault) {
        this(netId,netMask,name);
        this.isDefault = isDefault;
    }

    /**
     * To compare two objects of type Network
     *
     * @since 2.0.0
     * @param obj Object to be compared
     * @return boolean value indicating whether these two objects are same
     * */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Network that = (Network) obj;
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
     * To get the Id of this object
     *
     * @since 2.0.0
     * @return Unique String value as identity of this object
     * */
    public String getId() {
        return this.id;
    }

    /**
     * to render the network settings
     *
     * @return the network settings information
     * @since 0.3.0
     * */
    @Override
    public String toString() {
        return this.name+" - "+this.netId+"/"+this.netMask;
    }

    // for storing in file for settings...
    /**
     * to generate the storage format in settings file
     *
     * @return storage format for settings file
     * @since 0.3.0
     * */
    public String forSettings() {
        return this.netId+"|"+this.netMask+"|"+this.name;
    }
}
