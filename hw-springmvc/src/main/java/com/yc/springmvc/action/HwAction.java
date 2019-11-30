package com.yc.springmvc.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.springmvc.bean.Result;

@Controller
public class HwAction {

	@RequestMapping("index")
	public String index() {
		return "index";
	}
	
//////////////////////////////////////////////////////////////////
//////////////////第一关 ////////////////////////////////////////
//////////////////////////////////////////////////////////////////
	@RequestMapping("toTaobao")
	public String openTaoBaoDefault() {
		return "taobao";
	}
	
	@RequestMapping("toBaidu")
	public String opBaiDuDefault() {
		return "baidu";
	}
	
	@RequestMapping("taobao/**")
	public String openTaoBaoPage() {
		return "taobao";
	}
	
	@RequestMapping("baidu/**")
	public String opBaiDuPage() {
		return "baidu";
	}
	
	
	@RequestMapping("?aobao")
	public String openTaoBaoFirst() {
		return "taobao";
	}
	
	@RequestMapping("**aobao")
	public String openTaoBaoBefore() {
		return "taobao";
	}
	
	
	@RequestMapping("*/taobao")
	public String openTaoBaoBeforeMenu() {
		return "taobao";
	}
	
	@RequestMapping("**/taobao")
	public String openTaoBaoBeforeMoreMenu() {
		return "taobao";
	}
	
	
	@RequestMapping(value="toPage",params= "flag=")
	public String toPageOpenTaoBao() {
		return "taobao";
	}
	@RequestMapping(value="toPage",params= "flag=1")
	public String toPageOpenTaoBao1() {
		return "taobao";
	}
	@RequestMapping(value="toPage",params= "flag=2")
	public String toPageOpenTaoBao2() {
		return "taobao";
	}
	@RequestMapping(value="toPage",params= "flag=3")
	public String toPageOpenTaoBao3() {
		return "taobao";
	}
	@RequestMapping(value="toPage",params= "type=1")
	public String toPageOpenTaoBao4() {
		return "taobao";
	}
	
	@RequestMapping(value="toPage",params= "type=2")
	public String toPageOpenBaiDu() {
		return "baidu";
	}
	@RequestMapping(value="toPage",params= "type=3")
	public String toPageOpenBaiDu1() {
		return "baidu";
	}
	@RequestMapping(value="toPage",params= "type=4")
	public String toPageOpenBaiDu2() {
		return "baidu";
	}
	
	@RequestMapping(value="index",params="order=1")
	public String next() {
		return "index1";
	}
	
//////////////////////////////////////////////////////////////////
////////////////// 第二关 ////////////////////////////////////////
//////////////////////////////////////////////////////////////////
	
	@RequestMapping("form.do")
	public String form() {
		return "baidu";
	}
	
	@RequestMapping(value="form.do",method=RequestMethod.POST)
	public String form1() {
		return "taobao";
	}
	
	@RequestMapping(value="call.do",params= {"type=1"})
	public String callToBaiDu(String type) {
		return "baidu";
	}
	
	@RequestMapping(value="call.do",params= {"type=2"},method=RequestMethod.POST)
	public String callToTaoBao(String type) {
		return "taobao";
	}
	
	@ResponseBody
	@RequestMapping(value="call1.do",params= {"type=1"})
	public Result call1ToBaiDu(String type) {
		return new Result("baidu", "打开百度");
	}
	
	@ResponseBody
	@RequestMapping(value="call1.do",params= {"type=2"},method=RequestMethod.POST)
	public Result call1ToTaoBao(String type) {
		return new Result("taobao", "打开淘宝");
	}
	
	@ResponseBody
	@RequestMapping(value="exec.do",method=RequestMethod.POST)
	public Result execToBaiDu() {
		return new Result("baidu", "打开百度");
	}
	
	@ResponseBody
	@RequestMapping(value="exec.do",method=RequestMethod.GET)
	public Result execToTaoBao() {
		return new Result("taobao", "打开淘宝");
	}
	
	@RequestMapping(value="toPage",params= "flag=5")
	public String toPageOpenTaoBao5() {
		return "taobao";
	}
	
	@RequestMapping(value="toPage",params= "flag=6")
	public String toPageOpenTaoBao6() {
		return "taobao";
	}
	
	@RequestMapping(value="toPage",params= "flag=7")
	public String toPageOpenTaoBao7() {
		return "taobao";
	}
	
	@RequestMapping(value="toPage",params= "flag=8")
	public String toPageOpenTaoBao8() {
		return "taobao";
	}
	
	@RequestMapping(value="toPage",params= "flag=9")
	public String toPageOpenTaoBao9() {
		return "taobao";
	}
	
	@RequestMapping(value="toPage",params= "flag=10")
	public String toPageOpenTaoBao10() {
		return "taobao";
	}
	
	@RequestMapping(value="index",params="order=2")
	public String next1() {
		return "index2";
	}
}
