package com.fzrj.schedule.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fzrj.schedule.bean.job.JobBean;
import com.fzrj.schedule.service.schedule.ScheduleService;
import com.rabbitmq.client.Channel;

/**
 * @className:com.fzrj.schedule.server.DeleteJobReceiver
 * @description:删除定时任务消息接收类
 * @version:v1.0.0
 * @date:2016年12月19日 下午7:31:03
 * @author:WangHao
 */
public class DeleteJobReceiver implements ChannelAwareMessageListener
{
	private static Logger logger = LogManager.getLogger(DeleteJobReceiver.class);

	@Autowired
	private ScheduleService scheduleService;

	@Override
	public void onMessage(Message message, Channel channel) throws Exception
	{
		String msg = new String(message.getBody(), "UTF-8");
		logger.debug("删除定时任务消息接收msg:" + msg);
		ObjectMapper mapper = new ObjectMapper(); // 转换器
		JobBean jobBean = mapper.readValue(msg, JobBean.class);
		int result = scheduleService.deleteJob(jobBean);
		if (0 == result)
		{
			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		}
	}

}