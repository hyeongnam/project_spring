package com.n1books.pilot.nlu;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface NLUDAO {

	void insertSentiment(SentimentVO vo) throws Exception;

	List<SentimentVO> getIT(String now) throws Exception;

	List<SentimentVO> getBIO(String now) throws Exception;

	List<SentimentVO> getEDU(String now) throws Exception;
	
	List<SentimentVO> getFLEX(String now) throws Exception;
	
	List<SentimentVO> getELB(String now) throws Exception;

	List<SentimentVO> getANAL_IT(String name) throws Exception;
	
	List<SentimentVO> getANAL_BIO(String name) throws Exception;
	
	List<SentimentVO> getANAL_EDU(String name) throws Exception;
	
	List<SentimentVO> getANAL_FLEX(String name) throws Exception;
	
	List<SentimentVO> getANAL_ELB(String name) throws Exception;

	List<SentimentVO> getGRAPH_IT(String name) throws Exception;
	
	List<SentimentVO> getGRAPH_BIO(String name) throws Exception;
	
	List<SentimentVO> getGRAPH_EDU(String name) throws Exception;
	
	List<SentimentVO> getGRAPH_FLEX(String name) throws Exception;
	
	List<SentimentVO> getGRAPH_ELB(String name) throws Exception;
	
}// endclass
