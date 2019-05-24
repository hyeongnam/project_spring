package com.n1books.pilot.nlu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletRequest;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Features;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.SentimentOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.SentimentResult;

@Controller
public class NLUController {
	private static Logger logger = LoggerFactory.getLogger(NLUController.class);
	// servlet-context.xml에서 세팅 되었음
	// system.propertie에서 값 가져옴
	@Value("${nlu.username}")
	private String username;
	@Value("${nlu.password}")
	private String password;

	@Autowired
	private NLUService nluService;

	// home화면에서 셀렉트문 실행중간단계
	@RequestMapping("middle")
	public String middle(@RequestParam("theme") String theme) throws Exception {
		String result = "";
		if (theme.equals("1")) {
			result = "redirect:it";
		} else if (theme.equals("2")) {
			result = "redirect:bio";
		} else if (theme.equals("3")) {
			result = "redirect:edu";
		} else if (theme.equals("4")) {
			result = "redirect:flex";
		} else if (theme.equals("5")) {
			result = "redirect:elb";
		} else {
			result = "redirect:home";
		}//end if
		return result;
	}// end middel

	// 전에 입력된 내용 출력
	@GetMapping("it")
	public void it(Model model) throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.DATE, -1);	
//		if (cal.get(Calendar.DAY_OF_WEEK) == 1){
//			cal.add(Calendar.DATE, -2);
//		}
		String now = dateFormat.format(cal.getTime());
		List<SentimentVO> it = new ArrayList<SentimentVO>();
		it = nluService.getIT(now);
		model.addAttribute("IT", it);
	}// end it

	@GetMapping("bio")
	public void bio(Model model) throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.DATE, -1);	
//		if (cal.get(Calendar.DAY_OF_WEEK) == 1){
//			cal.add(Calendar.DATE, -2);
//		}
		String now = dateFormat.format(cal.getTime());
		List<SentimentVO> bio = new ArrayList<SentimentVO>();
		bio = nluService.getBIO(now);
		model.addAttribute("BIO", bio);
	}// end bio

	@GetMapping("edu")
	public void edu(Model model) throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.DATE, -1);	
//		if (cal.get(Calendar.DAY_OF_WEEK) == 1){
//			cal.add(Calendar.DATE, -2);
//		}
		String now = dateFormat.format(cal.getTime());
		List<SentimentVO> edu = new ArrayList<SentimentVO>();
		edu = nluService.getEDU(now);
		model.addAttribute("EDU", edu);
	}// end edu

	@GetMapping("flex")
	public void flex(Model model) throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.DATE, -1);	
//		if (cal.get(Calendar.DAY_OF_WEEK) == 1){
//			cal.add(Calendar.DATE, -2);
//		}
		String now = dateFormat.format(cal.getTime());
		List<SentimentVO> flex = new ArrayList<SentimentVO>();
		flex = nluService.getFLEX(now);
		model.addAttribute("FLEX", flex);
	}// end flex

	@GetMapping("elb")
	public void elb(Model model) throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.DATE, -1);	
//		if (cal.get(Calendar.DAY_OF_WEEK) == 1){
//			cal.add(Calendar.DATE, -2);
//		}
		String now = dateFormat.format(cal.getTime());
		List<SentimentVO> elb = new ArrayList<SentimentVO>();
		elb = nluService.getELB(now);
		model.addAttribute("ELB", elb);
	}// end elb

	@GetMapping("name_analysis_it")
	public void name_analysis_it(@RequestParam String name, Model model) throws Exception {
		List<SentimentVO> analysis_it = new ArrayList<SentimentVO>();
		analysis_it = nluService.getANAL_IT(name);
		model.addAttribute("ANALYSIS_IT", analysis_it);
		List<SentimentVO> graph_it = new ArrayList<SentimentVO>();
		graph_it = nluService.getGRAPH_IT(name);
		model.addAttribute("GRAPH_IT", graph_it);
	}// end name_analysis_it

	@GetMapping("name_analysis_bio")
	public void name_analysis_bio(@RequestParam String name, Model model) throws Exception {
		List<SentimentVO> analysis_bio = new ArrayList<SentimentVO>();
		analysis_bio = nluService.getANAL_BIO(name);
		model.addAttribute("ANALYSIS_BIO", analysis_bio);
		List<SentimentVO> graph_bio = new ArrayList<SentimentVO>();
		graph_bio = nluService.getGRAPH_BIO(name);
		model.addAttribute("GRAPH_BIO", graph_bio);
	}// end name_analysis_bio

	@GetMapping("name_analysis_edu")
	public void name_analysis_edu(@RequestParam String name, Model model) throws Exception {
		List<SentimentVO> analysis_edu = new ArrayList<SentimentVO>();
		analysis_edu = nluService.getANAL_EDU(name);
		model.addAttribute("ANALYSIS_EDU", analysis_edu);
		List<SentimentVO> graph_edu = new ArrayList<SentimentVO>();
		graph_edu = nluService.getGRAPH_EDU(name);
		model.addAttribute("GRAPH_EDU", graph_edu);
	}// end name_analysis_edu

	@GetMapping("name_analysis_flex")
	public void name_analysis_flex(@RequestParam String name, Model model) throws Exception {
		List<SentimentVO> analysis_flex = new ArrayList<SentimentVO>();
		analysis_flex = nluService.getANAL_FLEX(name);
		model.addAttribute("ANALYSIS_FLEX", analysis_flex);
		List<SentimentVO> graph_flex = new ArrayList<SentimentVO>();
		graph_flex = nluService.getGRAPH_FLEX(name);
		model.addAttribute("GRAPH_FLEX", graph_flex);
	}// end name_analysis_flex

	@GetMapping("name_analysis_elb")
	public void name_analysis_elb(@RequestParam String name, Model model) throws Exception {
		List<SentimentVO> analysis_elb = new ArrayList<SentimentVO>();
		analysis_elb = nluService.getANAL_ELB(name);
		model.addAttribute("ANALYSIS_ELB", analysis_elb);
		List<SentimentVO> graph_elb = new ArrayList<SentimentVO>();
		graph_elb = nluService.getGRAPH_ELB(name);
		model.addAttribute("GRAPH_ELB", graph_elb);
	}// end name_analysis_elb

}// end class
