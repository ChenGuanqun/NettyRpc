/**
 * <p>Title: TODO </p>
 * <p>Description: TODO </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: MicroStrategy, Inc.</p>
 * @author Chen Tao
 * @version
 */
package com.nettyrpc.sampletest;

import com.nettyrpc.client.RpcClient;
import com.nettyrpc.registry.ServiceDiscovery;

/**
 * @author tachen
 * @date Apr 20, 2016
 */
public class PvClientThread implements Runnable{

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		ServiceDiscovery serviceDiscovery = new ServiceDiscovery("127.0.0.1:2181");
		final RpcClient rpcClient = new RpcClient(serviceDiscovery);
		CalculateService helloService = rpcClient.create(CalculateService.class);
		for(int i=0;i<10;i++){
			getLock(serviceDiscovery);
			int result = helloService.getCurrentPV(0);
			removeLock(serviceDiscovery);
			System.out.println(Thread.currentThread().getName()+"result="+result);
		}
		
	}
	
	private void getLock(ServiceDiscovery serviceDiscovery){
		
		while(!serviceDiscovery.getRemoteLock()) System.out.println(Thread.currentThread().getName()+" try to get lock..");
		System.out.println(Thread.currentThread().getName()+" Get lock..");
		
	}
	
	private void removeLock(ServiceDiscovery serviceDiscovery){
		serviceDiscovery.removeRemoteLock();
		System.out.println(Thread.currentThread().getName()+" realse lock..");
	}

}
