package com.n1books.pilot.nlu;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NLUServiceImpl implements NLUService {
	@Autowired
	private NLUDAO nluDAO;

	@Override
	public void insertSentiment(SentimentVO vo) throws Exception {
		nluDAO.insertSentiment(vo);
	}

	@Override
	public List<SentimentVO> getIT(String now) throws Exception {
		return nluDAO.getIT(now);
	}

	@Override
	public List<SentimentVO> getBIO(String now) throws Exception {
		return nluDAO.getBIO(now);
	}

	@Override
	public List<SentimentVO> getEDU(String now) throws Exception {
		return nluDAO.getEDU(now);
	}

	@Override
	public List<SentimentVO> getFLEX(String now) throws Exception {
		return nluDAO.getFLEX(now);
	}
	
	@Override
	public List<SentimentVO> getELB(String now) throws Exception {
		return nluDAO.getELB(now);
	}

	@Override
	public List<SentimentVO> getANAL_IT(String name) throws Exception {
		return nluDAO.getANAL_IT(name);
	}

	@Override
	public List<SentimentVO> getANAL_BIO(String name) throws Exception {
		return nluDAO.getANAL_BIO(name);
	}

	@Override
	public List<SentimentVO> getANAL_EDU(String name) throws Exception {
		return nluDAO.getANAL_EDU(name);
	}

	@Override
	public List<SentimentVO> getANAL_FLEX(String name) throws Exception {
		return nluDAO.getANAL_FLEX(name);
	}
	
	@Override
	public List<SentimentVO> getANAL_ELB(String name) throws Exception {
		return nluDAO.getANAL_ELB(name);
	}
	@Override
	public List<SentimentVO> getGRAPH_IT(String name) throws Exception {
		return nluDAO.getGRAPH_IT(name);
	}
	
	@Override
	public List<SentimentVO> getGRAPH_BIO(String name) throws Exception {
		return nluDAO.getGRAPH_BIO(name);
	}
	
	@Override
	public List<SentimentVO> getGRAPH_EDU(String name) throws Exception {
		return nluDAO.getGRAPH_EDU(name);
	}

	@Override
	public List<SentimentVO> getGRAPH_FLEX(String name) throws Exception {
		return nluDAO.getGRAPH_FLEX(name);
	}

	@Override
	public List<SentimentVO> getGRAPH_ELB(String name) throws Exception {
		return nluDAO.getGRAPH_ELB(name);
	}

}// end class