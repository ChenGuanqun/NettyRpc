/**
 * <p>Title: TODO </p>
 * <p>Description: TODO </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: MicroStrategy, Inc.</p>
 * @author Chen Tao
 * @version
 */
package com.nettyrpc.sampletest;

import org.springframework.asm.commons.StaticInitMerger;

import com.nettyrpc.server.RpcService;

/**
 * @author tachen
 * @date Apr 15, 2016
 */
@RpcService(CalculateService.class)
public class CalculateServiceImpl  implements CalculateService{

	public static int pv=0;
	/* (non-Javadoc)
	 * @see com.nettyrpc.sampletest.CalculateService#add(int, int)
	 */
	@Override
	public int add(int a, int b) {
		return a+b;
	}
	/* (non-Javadoc)
	 * @see com.nettyrpc.sampletest.CalculateService#getCurrentPV()
	 */
	@Override
	public int getCurrentPV(int a) {
		int i=pv;
		try {
			Thread.sleep(10); //估计产生冲突
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i++;
		pv=i;
		return pv;
	}
	
	
	

}
