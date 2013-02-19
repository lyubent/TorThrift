package org.apache.thrift.tor;

import org.silvertunnel.netlib.adapter.java.JvmGlobalUtil;
import org.silvertunnel.netlib.adapter.socket.SocketGlobalUtil;
import org.silvertunnel.netlib.api.NetFactory;
import org.silvertunnel.netlib.api.NetLayer;
import org.silvertunnel.netlib.api.NetLayerIDs;

import java.io.IOException;
import java.net.Socket;

// @author lyubentodorov
// @licence - MIT
// Available at http://lyuben.herokuapp.com/casstor/
// Source at https://github.com/lyubent/TorThrift/
//
public class BuildAnonConn {

    public BuildAnonConn(){

    }

    public static boolean useTor() {
        try{
//            System.out.println("USINGTOR");
//            SocketGlobalUtil.initSocketImplFactory();
//            NetLayer netLayer = NetFactory.getInstance().getNetLayerById(NetLayerIDs.TOR);
//            netLayer.waitUntilReady();
//            SocketGlobalUtil.setNetLayerUsedBySocketImplFactory(netLayer);
//            System.out.println("NOW USING TOR!");

            JvmGlobalUtil.init();
            System.out.println("perpareAnonymousCommunication() initialization done");
            NetLayer nextNetLayer = NetFactory.getInstance().getNetLayerById(NetLayerIDs.TOR);
            nextNetLayer.waitUntilReady();
            JvmGlobalUtil.setNetLayerAndNetAddressNameService(nextNetLayer, true);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public static boolean removeTor() {
        try{
//            System.out.println("REMOVINGTOR");
//            SocketGlobalUtil.initSocketImplFactory();
//            NetLayer netLayer = NetFactory.getInstance().getNetLayerById(NetLayerIDs.TCPIP);
//            netLayer.waitUntilReady();
//            SocketGlobalUtil.setNetLayerUsedBySocketImplFactory(netLayer);
//            System.out.println("NOW NOT USING TOR!");

            JvmGlobalUtil.init();
            System.out.println("perpareAnonymousCommunication() initialization done");
            NetLayer nextNetLayer = NetFactory.getInstance().getNetLayerById(NetLayerIDs.TCPIP);
            nextNetLayer.waitUntilReady();
            JvmGlobalUtil.setNetLayerAndNetAddressNameService(nextNetLayer, true);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }
}
