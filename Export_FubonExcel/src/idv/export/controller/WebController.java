package idv.export.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import idv.export.po.MainContext_VO;
import idv.export.po.SubContext_VO;
import idv.export.po.Url_Bean;

@WebServlet("/WebController")
public class WebController extends HttpServlet{
	
	/**
	 * 邏輯停更。
	 * 原USER表示沒要用了。
	 */
	
	private String fileName;
	
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
		
		this.fileName = req.getParameter("filename") + ".xlsx";
		
		List<MainContext_VO> okContextList = sort_WebContext(req);
		
		doExportExcel(okContextList);
		
		req.setAttribute("status", "OK");
		
		resp.setStatus(HttpServletResponse.SC_OK);
		
		//req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
	private List<MainContext_VO> sort_WebContext(HttpServletRequest request) {
		
		/**
		 * table class="bd"	 : 全部的table
		 * td class="gTitle" > div 內容 : 全部的主標題(one)
		 * td class="gBody" > ul > li > table > tbody > 多個 tr (包含:副標題 URL)
		 * 		> if(td){內容是副標題}
		 * 		> if(a){a href = 超連結； a	內容 = 超連結文字)
		 */
		
		//所有資料的List
		List<MainContext_VO> okList = new ArrayList<MainContext_VO>();
		
		//完成資料整理過後的Map,內含 : 大標題、副標題、副標題內的URL
		//Map<String, ArrayList> okContextMap = new HashMap<String, ArrayList>();
		
		try {
		
		String webUrl = request.getParameter("dataUrl");
		
		Document doc = Jsoup.connect(webUrl).get();
		
		Elements items = doc.getElementsByClass("bd");
		
		for(Element item : items) {
			
			//大標題
			String bigTitle = item.getElementsByClass("gTitle").get(0).getElementsByTag("div").get(0).html();
			System.out.println(bigTitle);
			
			//副標題 + 文字內容
			ArrayList<SubContext_VO> subContextList = new ArrayList<SubContext_VO>();
			
			Elements subItems = item.getElementsByClass("gBody").get(0).getElementsByTag("ul").get(0)
				.getElementsByTag("li").get(0)
				.getElementsByTag("table").get(0)
				.getElementsByTag("tbody").get(0)
				.getElementsByTag("tr");
			
			for(Element subItem : subItems) {
				
				Elements contextItems = subItem.getElementsByTag("td").get(0).getElementsByTag("a");
				
				//副標題
				String subTitle = null;
				
				//內容 文字+超鏈結
				ArrayList<Url_Bean> contentList = new ArrayList<Url_Bean>();
				
				if(contextItems.isEmpty()) {
					
					if(!subItem.getElementsByTag("td").get(0).html().equals("<br>")) {
						//加入副標題list
						subTitle = subItem.getElementsByTag("td").get(0).html();
						System.out.println("－" + subTitle);
					}else{
						System.out.println("－No Data");
					}
					
				}else {
					
					for(Element aContextItem : contextItems) {
						
						//String : text； String url
						//HashMap<String, String> contextMap = new HashMap<String, String>();
						
						String baseURL = "http://www.top8889.com.tw/AccPlate/";
						String aName = aContextItem.getElementsByTag("a").get(0).html();
						
						String aHref = aContextItem.getElementsByTag("a").attr("href");
						
						Url_Bean urlBean = new Url_Bean();
						
						if(!StringUtils.equals(aHref, "")) {
							aHref = baseURL + aHref;
						}else{
							aHref = "";
						}
						 
						//contextMap.put(aName, aHref);
						urlBean.setUrlName(aName);
						urlBean.setUrl(aHref);
						
						contentList.add(urlBean);
						
						if("".equals(aHref)) {
							System.out.println("－－" + aName);
						}else {
							System.out.println("－－－" + aName + " : " + aHref);
						}
					}
				}
				
				//Map<String, ArrayList> subContextMap = new HashMap<String, ArrayList>();
				SubContext_VO subVo = new SubContext_VO();
				subVo.setSubTitle(subTitle);
				subVo.setSubContextList(contentList);
				
				//subContextMap.put(subTitle, contentList);
				
				subContextList.add(subVo);
			}
			
			//okContextMap.put(bigTitle, subContextList);
			MainContext_VO mainVO = new MainContext_VO();
			
			mainVO.setBigTitle(bigTitle);
			mainVO.setSubList(subContextList);
			okList.add(mainVO);			
		}
		
		}catch(IOException ioe) {
			ioe.printStackTrace();
			System.out.println("Jsoup Conntect has some problems!");
		}
		
		return okList;
	}
	
	/**
	 * @param List<Map<String, ArrayList>> dataList
	 * Apache.POI :
	 * 	You Need A Workbook, some sheet, some row, some cells.
	 */
	private void doExportExcel(List<MainContext_VO> dataList) {
		
		//建立Excel.xlsx
		XSSFWorkbook workbook = new XSSFWorkbook();
		//建立style設定物件
		DataFormat dfObj = workbook.createDataFormat();
		//建立修改Cell欄位style物件
		CellStyle textStyle = workbook.createCellStyle();
		textStyle.setDataFormat(dfObj.getFormat("@"));
		
		for(MainContext_VO mainVO : dataList) {
			
			//為Excel sheet 命名(以大標題命名)
			XSSFSheet sheet = workbook.createSheet(mainVO.getBigTitle());
			//設定第一列(row)文字style.
			sheet.setDefaultColumnStyle(0, textStyle);
			
			//取出副標題+超連結名稱、URL
			ArrayList<SubContext_VO> subVoList = mainVO.getSubList();
			
			//需要幾列(以副標題數量決定)
			int rowCnt = 0;
			int cellCnt = 0;
			XSSFRow row = sheet.createRow(1);
			
			for(SubContext_VO subVO : subVoList) {
				//需要幾行(副標題:作為title佔第一行； 名稱網址佔第二行開始 + 超連結的數量
				
				XSSFCell cell_sub = row.createCell(++cellCnt);
				cell_sub.setCellValue(subVO.getSubTitle());
				
				cell_sub.setCellStyle(textStyle);
				
				
				ArrayList<Url_Bean> urlBeanList = subVO.getSubContextList();
				
				for(Url_Bean bean : urlBeanList) {
					XSSFCell cell_url = row.createCell(++cellCnt);
					cell_url.setCellValue(bean.getUrlName() + " : " + bean.getUrl());
				}
				
			}
			
			//ListUtils.partition(null, cellCnt);
		}
		
		String excelFilePath = "D:\\" + fileName;
		
		try {
			FileOutputStream os = new FileOutputStream(excelFilePath);
			workbook.write(os);
			os.flush();
			os.close();
		}catch(FileNotFoundException fnfe){
			System.out.println("File Is not Exsit!");
			fnfe.printStackTrace();
		}catch(IOException ioe) {
			System.out.println("Excel Exporting has Error!");
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
