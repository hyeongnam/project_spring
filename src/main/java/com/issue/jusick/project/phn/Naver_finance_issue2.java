package com.issue.jusick.project.phn;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;

public class Naver_finance_issue2 {

	public static void main(String[] args) throws Exception {
		// 애플리케이션 클라이언트 아이디값";
		String clientId = "NCLHT0u1TYVN5VdXUg2V";
		// 애플리케이션 클라이언트 시크릿값";
		String clientSecret = "ES_wwe5MOy";
		ArrayList<String> finance = new ArrayList<String>();
		finance.add("디지털대성");
		finance.add("와이비엠넷");
		finance.add("웅진씽크빅");
		finance.add("메가스터디");
		finance.add("대교");
		finance.add("코너스톤네트웍스");
		finance.add("비상교육");
		finance.add("정상제이엘에스");
		finance.add("이퓨쳐");
		finance.add("NE능률");
		finance.add("멀티캠퍼스");
		finance.add("청담러닝");
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.DATE, -1);
//		if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
//			cal.add(Calendar.DATE, -2);
//		}
		String date = dateFormat.format(cal.getTime());
		for (int tmp = 0; tmp < finance.size(); tmp++) {
			try {
				String text = URLEncoder.encode(finance.get(tmp), "UTF-8");
				// naver json 결과 요청 OPEN API
				String apiURL = "https://openapi.naver.com/v1/search/news.json?query=" + text
						+ "&display=30&start=1&sort=sim";

				// Naver OPen API 요구 사항
				URL url = new URL(apiURL);
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				con.setRequestProperty("X-Naver-Client-Id", clientId);
				con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
				int responseCode = con.getResponseCode();
				BufferedReader br;
				if (responseCode == 200) { // 정상 호출
					// 인코딩 설정
					br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
				} else { // 에러 발생
					br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				} // end if

				// 네이버 검색 결과 자바로 가져오기
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = br.readLine()) != null) {
					response.append(inputLine);
				} // end while
				br.close();

				// 기본 출력
				String result = response.toString();

				// HTML 태그 제거
				result = result.replace("<b>", "");
				result = result.replace("</b>", "");
				result = result.replace("&quot", "");
				result = result.replace("`", "");

				// JSON 객체 생성
				JSONObject resBody = new JSONObject(result);
				String result_sum = "";
				if (resBody.has("items")) {
					JSONArray list = resBody.getJSONArray("items");
					for (int i = 0; i < list.length(); i++) {
						JSONObject o = list.getJSONObject(i);
						// 특정 태그 검출후 출력
						String result2 = o.get("title").toString();
						result2 = result2 + "\n";
						result2 = result2 + o.get("description").toString();
						// 정규표현식 적용
						// result2 = result2.replaceAll("\\d", "");
						System.out.println(result2);
						System.out.println("");
						result_sum += result2;
					} // end for
					FileWriter file_writer = new FileWriter("C:\\Users\\student\\Desktop\\쥬식뉴스데이터\\"
							+ date + finance.get(tmp) + ".text");
					file_writer.write(result_sum);
					file_writer.close();
				} // end if
			} catch (Exception e) {
				System.out.println(e);
			} // end try
		} // end for
	}// end main\
}// end class