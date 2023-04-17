package team.spring.runup.running.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.spring.runup.running.dao.RunningDao;
import team.spring.runup.running.vo.CategoryBig;
import team.spring.runup.running.vo.CategoryMedium;
import team.spring.runup.running.vo.Running;

@Service
public class RunningService {
	
	@Autowired
	private RunningDao dao;
	
	public List<CategoryBig> selectCategoryBigAll() {
		List<CategoryBig> list = dao.selectCategoryBigAll();
		return list;
	}
	
	public List<CategoryMedium> selectCategoryMediumAll() {
		List<CategoryMedium> list = dao.selectCategoryMediumAll();
		return list;
	}
	
	public List<Running> selectRunningList(Running run) {
		List<Running> list = dao.selectRunningList(run);
		return list;
	}
	
	public List<Running> selectRunningByKeyword(String keyword) {
		List<Running> list = dao.selectRunningByKeyword(keyword);
		return list;
	}
	
	public int createRunning(Running run) {
		int result = dao.createRunning(run);
		return result;
	}
	
	public int deleteRunning(Running run) {
		int result = dao.deleteRunning(run);
		return result;
	}
	
	public int updateRunning(Running run) {
		int result = dao.updateRunning(run);
		return result;
	}
}
