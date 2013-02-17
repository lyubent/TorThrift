package org.apache.thrift.tor;

import org.silvertunnel.netlib.adapter.socket.SocketGlobalUtil;
import org.silvertunnel.netlib.api.NetFactory;
import org.silvertunnel.netlib.api.NetLayer;
import org.silvertunnel.netlib.api.NetLayerIDs;

// @author lyubentodorov
// @licence - MIT
// Available at http://lyuben.herokuapp.com/casstor/
// Source at https://github.com/lyubent/TorThrift/
//
public class BuildAnonConn {

    public BuildAnonConn(){

    }

    public static boolean useTor(){
        try{
            SocketGlobalUtil.initSocketImplFactory();
            NetLayer netLayer = NetFactory.getInstance().getNetLayerById(NetLayerIDs.TOR);
            netLayer.waitUntilReady();
            SocketGlobalUtil.setNetLayerUsedBySocketImplFactory(netLayer);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }
}
