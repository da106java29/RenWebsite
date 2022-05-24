package idv.export.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@WebServlet("/WebController")
public class WebController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Just Print Somthing 
		System.out.println("Request URL is : " + req.getRequestURL().toString());
		System.out.println("Request CharacterEnocoding is : " + req.getCharacterEncoding());
		System.out.println("Request Content-type is :" + req.getContentType());
		System.out.println("Request Params is : " + req.getParameter("dataUrl"));
		ShowJsonData(req);
		
		doExportExcel(req);
		
		req.setAttribute("status", "OK");
		
		resp.setStatus(HttpServletResponse.SC_OK);
		
		//req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
	private void doExportExcel(HttpServletRequest request) {
		
		/**
		 * table class="bd"	 : 全部的table
		 * td class="gTitle" > div 內容 : 全部的主標題(one)
		 * td class="gBody" > ul > li > table > tbody > 多個 tr (包含:副標題 URL)
		 * 		> if(td){內容是副標題}
		 * 		> if(a){a href = 超連結； a	內容 = 超連結文字)
		 */
		
		try {
		
		String webUrl = request.getParameter("dataUrl");
		
		Document doc = Jsoup.connect(webUrl).get();
		
		Elements items = doc.getElementsByClass("bd");
		
		for(Element item : items) {
			
			//大標題
			String BitTitle = item.getElementsByClass("gTitle").get(0).getElementsByTag("div").get(0).html();
			
			//副標題 + 文字內容
			List<String> subTitleList = new ArrayList<String>();
			
			//內容 文字+超鏈結
			List<Map> contentList = new ArrayList<Map>();
			
			Elements subItems = item.getElementsByClass("gBody").get(0).getElementsByTag("ul").get(0)
				.getElementsByTag("li").get(0)
				.getElementsByTag("table").get(0)
				.getElementsByTag("tbody").get(0)
				.getElementsByTag("tr");
			
			for(Element subItem : subItems) {
				
				Element contextItem = subItem.getElementsByTag("td").get(0);
				
				if(contextItem.isBlock()) {
					
					
					//抓出 a TAG 內容 未完。
					contentList.stream().filter( bean -> {
						return !contextItem.getElementsByTag("a").isEmpty();
					}).forEach( contextItems -> {
						
						
					});
					
					
					String aName = contextItem.getElementsByTag("a").get(0).html();
					String aHref = contextItem.getElementsByTag("a").attr("href");
					
					//String : text； String url
					HashMap<String, String> contextMap	= new HashMap<String, String>();
					
					contextMap.put(aName, aHref);
				}else {
					String subTitle = subItem.getElementsByTag("td").get(0).html();
					subTitleList.add(subTitle);
				}
			}
			
			
			
			
			
			
			
			List<Map<String, List<Map<String, String>>>> productList = new ArrayList<>();
			
			
			
			
		}
		
		
		
		
		
		
		}catch(IOException ioe) {
			ioe.printStackTrace();
			System.out.println("Jsoup Conntect has some problems!");
		}
		
	}
	
	/**
	 * @param req
	 * Just Test Content-Type is "application/json",
	 * When reader what ?.
	 * If You Use the Content-Type is "application/x-www-form-urlencoded",
	 * It will print nothing.
	 */
	private void ShowJsonData(HttpServletRequest req) {
		try {
			
			StringBuffer sb = new StringBuffer();
			
			String line = null;
			
			BufferedReader br = req.getReader();
			
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			
			System.out.println("The Json Object is : \r\n" + sb.toString());
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("The JsonData Read Error!!");
		}
		
	}
}
