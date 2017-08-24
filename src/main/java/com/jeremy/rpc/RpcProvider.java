package com.jeremy.rpc;

import com.jeremy.dubbo.impl.DemoServiceImpl;
import com.jeremy.dubbo.intf.DemoService;

/**
 * Created by jeremy on 2017/8/17.
 */
public class RpcProvider {

    public static void main(String[] args) throws Exception{
        DemoService service = new DemoServiceImpl();
        RpcFramework.export(service, 1234);
    }
}
