package com.n1books.pilot.nlu;

import java.io.Serializable;

//Mysql DB 연동해서 JAVA로 가져올 VO 클래스
public class SentimentVO implements Serializable {
	private String name;
	private String price;
	private String yst;
	private String updn;
	private String updn2;
	private String trade;
	private String per;
	private String pbr;
	private String forein;
	private String date;
	private String issue;
	private int recom;
	private int rank;
	private int start;
	private int end;
	private int high;
	private int low;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getYst() {
		return yst;
	}

	public void setYst(String yst) {
		this.yst = yst;
	}

	public String getUpdn() {
		return updn;
	}

	public String getUpdn2() {
		return updn2;
	}

	public void setUpdn2(String updn2) {
		this.updn2 = updn2;
	}

	public void setUpdn(String updn) {
		this.updn = updn;
	}

	public String getTrade() {
		return trade;
	}

	public void setTrade(String trade) {
		this.trade = trade;
	}

	public String getPer() {
		return per;
	}

	public void setPer(String per) {
		this.per = per;
	}

	public String getPbr() {
		return pbr;
	}

	public void setPbr(String pbr) {
		this.pbr = pbr;
	}

	public String getForein() {
		return forein;
	}

	public void setForein(String forein) {
		this.forein = forein;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public int getRecom() {
		return recom;
	}

	public void setRecom(int recom) {
		this.recom = recom;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		this.high = high;
	}

	public int getLow() {
		return low;
	}

	public void setLow(int low) {
		this.low = low;
	}

	@Override
	public String toString() {
		return "sentimentVO [name=" + name + ", price=" + price + ",yester=" + yst + ",updown=" + updn + ",trade="
				+ trade + "," + "per=" + per + ",pbr=" + pbr + ",forein=" + forein + ",date=" + date + "," + "issue="
				+ issue + ",rank=" + rank + ",recom=" + recom + ",start=" + start + ",end=" + end + ",high=" + high
				+ ",low=" + low + "]";
	}
}// end class
