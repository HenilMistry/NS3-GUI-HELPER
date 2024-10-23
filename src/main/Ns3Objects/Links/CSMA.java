package Ns3Objects.Links;

import Ns3Objects.UdpEchoCommunication.UdpEchoServer;
import StatusHelper.LinkType;

import java.util.UUID;

/**
 * to store the link of type CsmaHelper in terms of NS-3 Script
 * */
public class CSMA implements NetworkLink{

    /**
     * for unique identity
     * */
    private final String id;
    /**
     * for alias name
     * */
    public String name;
    /**
     * for delay in "ms"
     * */
    public String delay;
    /**
     * for data rate
     * */
    public String dataRate;
    /**
     * for speed modifier of link
     * */
    public String speedModifier;
    /**
     * for link type
     * */
    private LinkType linkType;
    /**
     * for enabling packet capture of entire link
     * */
    private boolean enablePcap;
    /**
     * for selecting as default link
     * */
    private boolean isDefault;
    /**
     * for marking as used link
     * */
    private boolean isUsed;

    /**
     * to instantiate the object of type CSMA
     *
     * @param name alias name
     * @param delay delay value in ms
     * @param dataRate for data rate
     * @param speedModifier for speed modifier
     * @param enablePcap for enabling packet capture of entire link
     * @see P2P
     * @see NetworkLink
     * @since 1.1.0
     * */
    public CSMA(String name,String delay,String dataRate,String speedModifier, boolean enablePcap) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.delay = delay;
        this.dataRate = dataRate;
        this.speedModifier = speedModifier;
        this.enablePcap = enablePcap;
        this.linkType = LinkType.LINK_CSMA;
        this.isDefault = false;
        this.isUsed = false;
    }

    // new constructor will support previous once...
    /**
     * to instantiate the object of type CSMA
     *
     * @param name for alias
     * @param delay for delay in ms
     * @param dataRate for data rate of the link
     * @param speedModifier for speed modifier
     * @param enablePcap for enabling packet capture of entire link
     * @param isDefault for setting as default link
     * @see CSMA#CSMA(String, String, String, String, boolean)
     * @see CSMA#CSMA(String, String, String, String, boolean, boolean, boolean)
     * @since 1.1.0
     * */
    public CSMA(String name,String delay,String dataRate,String speedModifier, boolean enablePcap, boolean isDefault) {
        this(name,delay,dataRate,speedModifier,enablePcap);
        this.isDefault = isDefault;
    }

    /**
     * to instantiate the object of type CSMA
     *
     * @param name for alias
     * @param delay for delay in ms
     * @param dataRate for data rate of the link
     * @param speedModifier for speed modifier
     * @param enablePcap for enabling packet capture of entire link
     * @param isDefault for setting as default link
     * @param isUsed for marking as used link
     * @see CSMA#CSMA(String, String, String, String, boolean)
     * @see CSMA#CSMA(String, String, String, String, boolean, boolean)  CSMA
     * @since 1.1.0
     * */
    public CSMA(String name,String delay,String dataRate,String speedModifier, boolean enablePcap, boolean isDefault, boolean isUsed) {
        this(name,delay,dataRate,speedModifier,enablePcap,isDefault);
        this.isUsed = isUsed;
    }

    /**
     * To compare two objects of type CSMA
     *
     * @since 2.0.0
     * @param obj Object to be compared
     * @return boolean value indicating whether these two objects are same
     * */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CSMA that = (CSMA) obj;
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
     * to render the link information
     *
     * @return the link information
     * @since 1.1.0
     * */
    @Override
    public String toString() {    
        return this.name+" (CSMA) - "+this.delay+"ms,"+this.dataRate+this.speedModifier;
    }

    // for storing in file for settings...
    /**
     * to generate the storage format in settings file
     *
     * @return storage format for settings file
     * @since 1.1.0
     * */
    @Override
    public String forSettings() {
        return this.name+"|"+this.delay+"|"+this.dataRate+"|"+this.speedModifier+"|"+((this.enablePcap)?"Y":"N")+"|CSMA";
    }

    @Override
    public boolean isDefault() {
        return isDefault;
    }

    @Override
    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    @Override
    public boolean isUsed() {
        return isUsed;
    }

    @Override
    public void setUsed(boolean used) {
        isUsed = used;
    }

    /**
     * <p>
     *     to generate the link configuration code
     * </p>
     * <p>
     *     <pre>
     *         {@code
     * Example:
     *  CsmaHelper csma;
     *  csma.SetChannelAttribute("DataRate", StringValue("500Mbps"));
     *  csma.SetChannelAttribute("Delay", TimeValue(NanoSeconds(6560)));
     *  }
     *  </pre>
     *</p>
     *
     * @return the link configuration code
     * @since 1.1.0
     * */
    @Override
    public String toCode() {
        String line1, line2, line3;
        line1 = "CsmaHelper csma"+this.getName().replace(" ", "_")+";";
        line2 = "csma"+getName().replace(" ", "_")+".SetChannelAttribute(\"DataRate\",StringValue(\""+(this.dataRate+this.speedModifier)+"\"));";
        line3 = "csma"+getName().replace(" ", "_")+".SetChannelAttribute(\"Delay\",StringValue(\""+this.delay+"ms\"));";
        return line1+"\n"+line2+"\n"+line3;
    }

    /**
     * <p>
     *     to generate the code for
     *     packet capture of entire link
     * </p>
     * <p>
     *     <pre>
     *         {@code
     * Example:
     * csmaName.EnablePcapAll("Name");
     * }
     * </pre>
     * </p>
     *
     * @return Equivalent code for ".EnablePcapAll()" method
     * @since 1.1.0
     */
    @Override
    public String getPacketCaptureAllCode() {
        String name = getName().replace(" ","_");
        String code = "csma"+name+".EnablePcapAll(\""+name+"\");";
        return code;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDelay() {
        return this.delay;
    }

    @Override
    public void setDelay(String delay) {
        this.delay = delay;
    }

    @Override
    public String getDataRate() {
        return this.dataRate;
    }

    @Override
    public void setDataRate(String dataRate) {
        this.dataRate = dataRate;
    }

    @Override
    public String getSpeedModifier() {
        return this.speedModifier;
    }

    @Override
    public void setSpeedModifier(String speedModifier) {
        this.speedModifier = speedModifier;
    }

    @Override
    public LinkType getLinkType() {
        return this.linkType;
    }

    @Override
    public void setLinkType(LinkType linkType) {
        this.linkType = linkType;
    }

    @Override
    public boolean getEnablePcap() {
        return enablePcap;
    }

    @Override
    public void setEnablePcap(boolean enablePcap) {
        this.enablePcap = enablePcap;
    }
}
