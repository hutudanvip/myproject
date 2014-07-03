package com.deppon.fssc.module.quartz.common.demo;

import com.deppon.fssc.module.quartz.common.model.Msg;
import com.deppon.fssc.module.quartz.common.model.QuartzModel;
import com.deppon.fssc.module.quartz.common.util.QuartzUtils;

/**
 * 
 * <pre>
 * 功能:测试用的demo
 * 作者：谢玉良
 * 日期：2013-4-12下午9:28:50
 * </pre>
 */
public class QuartzTest {
	/**
	 * 设置静态变量
	 */
	private static int i = 0;

	/**
	 * 
	 * <pre>
	 * 方法体说明：测试方法 ,主要用于
	 * 提供给程序进行测试时的中转
	 * 作者：谢玉良
	 * 日期： 2013-4-12 下午9:29:09
	 * </pre>
	 */
	public void quartzMain() {
		//方法体的开始
		System.out.println("进来了，你懂的。。。");
		if (i == 0) {// 方法第一次调用就进入
			// 新增定时任务计划
			QuartzModel qm = new QuartzModel();
			//是否为bean设置
			qm.setIsbean("0");
			//是否启用设置
			qm.setState("1");
			//是否同步设置
			qm.setConcurrent("0");
			//方法名设置
			qm.setMethod("test1");
			//时间表达式设置
			qm.setCronexpression("0/3 * * * * ?");
			//目标类或者bean名
			qm.setTargetobject(test.class.getName());
			// 调用工具类新增定时任务计划
			Msg m1 = QuartzUtils.addJob(qm);
			// 输出新增结果
			System.out.println(m1.isSuccess() + ":" + m1.getMessage());

			// 新增定时任务计划
			QuartzModel qm1 = new QuartzModel();
			//是否为bean设置
			qm1.setIsbean("0");
			//是否启用设置
			qm1.setState("1");
			//是否同步设置
			qm1.setConcurrent("0");
			//方法名设置
			qm1.setMethod("test2");
			//时间表达式设置
			qm1.setCronexpression("0/4 * * * * ?");
			//目标类或者bean名
			qm1.setTargetobject(test.class.getName());
			// 调用工具类新增定时任务计划
			Msg m2 = QuartzUtils.addJob(qm1);
			// 输出新增结果
			System.out.println(m2.isSuccess() + ":" + m2.getMessage());

			i++;
		}
	}

}
