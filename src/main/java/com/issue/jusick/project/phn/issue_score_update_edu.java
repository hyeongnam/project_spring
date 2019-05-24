package com.issue.jusick.project.phn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Features;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.SentimentOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.SentimentResult;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class issue_score_update_edu {

	public void edu() throws Exception {
		double score = 0;
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.DATE, -1);
//		if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
//			cal.add(Calendar.DATE, -2);
//		}
		String date = dateFormat.format(cal.getTime());
		String username = "cc4a6f20-b87b-4538-93dc-4bad303209a7";
		String password = "pTEKMPkN76dW";
		// IBM Watson 인스턴스 생성
		NaturalLanguageUnderstanding service = new NaturalLanguageUnderstanding("2017-02-27");
		service.setUsernameAndPassword(username, password);
		// NLU 옵션 세팅
		SentimentOptions sentiment = new SentimentOptions.Builder().build();
		Features features = new Features.Builder().sentiment(sentiment).build();
		ArrayList<String> issue_data = new ArrayList<String>();
		issue_data.add("메가스터디교육");
		issue_data.add("디지털대성");
		issue_data.add("와이비엠넷");
		issue_data.add("웅진씽크빅");
		issue_data.add("메가스터디");
		issue_data.add("대교");
		issue_data.add("코너스톤네트웍스");
		issue_data.add("비상교육");
		issue_data.add("정상제이엘에스");
		issue_data.add("이퓨쳐");
		issue_data.add("NE능률");
		issue_data.add("멀티캠퍼스");
		issue_data.add("청담러닝");
		issue_data.add("더블유에프엠");
		issue_data.add("예림당");
		for (int i = 0; i < issue_data.size(); i++) {
			FileReader fr = new FileReader("C:\\Users\\student\\Desktop\\쥬식뉴스데이터\\" + date
					+ issue_data.get(i) + ".text");
			BufferedReader br = new BufferedReader(fr);
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line + ".");
			} // end while
			line = sb.toString();
			br.close();
			// nluForm.jsp페이지에서 가져온 값이용 분석
			AnalyzeOptions parameters = new AnalyzeOptions.Builder().text(line).features(features).build();
			// 분석 결과 담기
			AnalysisResults response = service.analyze(parameters).execute();
			score = response.getSentiment().getDocument().getScore();

			// score UPDATE
			PreparedStatement pstmt = null;
			Statement stmt = null;
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/jusick";
			String user = "root";
			String pw = "oracle";
			String issue = "";
			Class.forName(driver);
			Connection con = (Connection) DriverManager.getConnection(url, user, pw);
			stmt = (Statement) con.createStatement();
			String name = issue_data.get(i);
			if (score >= 0.5) {
				issue = "매수강력추천";
			}else if (score < 0.5 && score > 0.0) {
				issue = "매수추천";
			}else if (score == 0.0) {
				issue = "매수중립";
			} else {
				issue = "매수비추천";
			} // end if문
			String SQL = " update edu set issue= '" + issue + "'  " + " where name= '" + name + "' " + " and date = '"
					+ date + "'";
			pstmt = (PreparedStatement) con.prepareStatement(SQL);
			int cnt = pstmt.executeUpdate(SQL);
			con.close();
			stmt.close();
			pstmt.close();
		} // end for문

	}// end main
}// end class
