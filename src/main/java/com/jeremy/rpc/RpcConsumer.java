package com.jeremy.rpc;

import com.jeremy.dubbo.intf.DemoService;

/**
 * Created by jeremy on 2017/8/17.
 */
public class RpcConsumer {

    public static void main(String[] args) throws Exception{
        DemoService service = RpcFramework.refer(DemoService.class, "127.0.0.1", 1234);
        System.out.println(service.sayHello("Jeremy"));
    }
}
