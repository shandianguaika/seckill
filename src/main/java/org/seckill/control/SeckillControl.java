package org.seckill.control;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.common.enums.Enums;
import org.common.exception.RepeatKillException;
import org.common.exception.SeckillCloseException;
import org.common.exception.SeckillException;
import org.common.utils.Result;
import org.common.utils.StringHelper;
import org.seckill.dto.Expose;
import org.seckill.dto.SeckillExecution;
import org.seckill.model.Seckill;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 秒杀控制层
 * 
 * @author 小宇宙
 * @date 2018年10月31日
 */
@Controller
@RequestMapping("/seckill")
public class SeckillControl {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private SeckillService seckillService;

	/**
	 * 列表信息查询
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getlist", method = RequestMethod.GET)
	public String getList(Model model) {
		List<Seckill> lists = seckillService.getAll();
		model.addAttribute("lists", lists);
		return "list";
	}

	/**
	 * 商品的详细信息
	 * @param model
	 * @param seckillId
	 * @return
	 */
	@RequestMapping(value = "{seckillId}/getdetail", method = RequestMethod.GET)
	public String getDetail(Model model, @PathVariable(name = "seckillId") String seckillId) {
		if (StringHelper.isNullOrEmpty(seckillId)) {
			return "redirect:/seckill/getlist";
		}
		Seckill seckill = seckillService.getSeckill(seckillId);
		if (seckill == null) {
			return "forward:/seckill/getlist";
		}
		model.addAttribute("seckill", seckill);
		return "detail";
	}

	/**
	 * 获取秒杀地址
	 * consumes： 指定处理请求的提交内容类型（Content-Type），例如application/json, text/html;
	 * produces: 指定返回的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回；
	 * 
	 * @param seckillId
	 * @return
	 */
	@RequestMapping(value = "{seckillId}/exposer", method = RequestMethod.POST, consumes = {
			"application/json;charset=UTF-8" }, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public Result<Expose> exposer(@PathVariable(name = "seckillId") String seckillId) {
		try {
			if (StringHelper.isNullOrEmpty(seckillId)) {
				return null;
			}
			Result<Expose> result;
			Expose expose = seckillService.getSeckillUrl(seckillId);
			result = new Result<Expose>(true, expose);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
			return new Result<Expose>(false, "系统内部错误");
		}
	}

	/**
	 * 执行秒杀行为
	 * @param seckillId
	 * @param md5
	 * @param phone
	 * @return
	 */
	@RequestMapping(value = "{seckillId}/{md5}/execute", method = RequestMethod.POST, produces = {
			"application/json;charset=UTF-8" })
	public Result<SeckillExecution> execute(@PathVariable("seckillId") String seckillId,
			@PathVariable("md5") String md5, @CookieValue(name = "phone", required = false) String phone) {
		if (StringHelper.isNullOrEmpty(phone)) {
			return new Result<SeckillExecution>(false, "请先登入");
		}
		if (StringHelper.isNullOrEmpty(seckillId)) {
			return null;
		}
		try {
			SeckillExecution model = seckillService.executeSeckill(seckillId, phone, md5);
			return new Result<SeckillExecution>(true, model);
		} catch (SeckillCloseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
			SeckillExecution seckillExecution = new SeckillExecution(seckillId,Enums.END,null);
			return new Result<SeckillExecution>(false, seckillExecution);
		} catch (RepeatKillException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
			SeckillExecution seckillExecution = new SeckillExecution(seckillId,Enums.REPEATKILL,null);
			return new Result<SeckillExecution>(false, seckillExecution);
		} catch (SeckillException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
			SeckillExecution seckillExecution = new SeckillExecution(seckillId,Enums.INNERERROR,null);
			return new Result<SeckillExecution>(false, seckillExecution);
		}
	}

	/**
	 * 获取系统当前时间
	 * @return
	 */
	@RequestMapping(value = "gettime",method=RequestMethod.GET)
	public Result<Long> getTime() {
		Date now = new Date();
		return new Result<Long>(true,now.getTime());
	}
}
