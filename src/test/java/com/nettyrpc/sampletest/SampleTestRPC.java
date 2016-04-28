/**
 * <p>Title: TODO </p>
 * <p>Description: TODO </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: MicroStrategy, Inc.</p>
 * @author Chen Tao
 * @version
 */
package com.nettyrpc.sampletest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;

import com.nettyrpc.client.RPCFuture;
import com.nettyrpc.client.RpcClient;
import com.nettyrpc.client.proxy.IAsyncObjectProxy;
import com.nettyrpc.registry.ServiceDiscovery;
import com.nettyrpc.test.client.HelloService;

/**
 * @author tachen
 * @date Apr 15, 2016
 */
public class SampleTestRPC {

	public static void main(String [] args){
		ExecutorService exc=Executors.newCachedThreadPool();
		for(int i=0;i<10;i++){
			PvClientThread p=new PvClientThread();
			exc.execute(p);
		}
		
		
	}
	
	
	@Test
	public void testAdd() throws InterruptedException, ExecutionException, TimeoutException{
		ServiceDiscovery serviceDiscovery = new ServiceDiscovery("127.0.0.1:2181");
		final RpcClient rpcClient = new RpcClient(serviceDiscovery);
		// Sync call
		CalculateService helloService = rpcClient.create(CalculateService.class);
		int result = helloService.add(1,2);
		System.out.println(result);
		while(true);
		
		// Async call
//		IAsyncObjectProxy client = rpcClient.createAsync(CalculateService.class);
//		RPCFuture helloFuture = client.call("hello", "World");
//		result = (String) helloFuture.get(3000, TimeUnit.MILLISECONDS);
	}
}
