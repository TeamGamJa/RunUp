package team.spring.runup.running.dao;

import java.util.List;

import team.spring.runup.running.vo.CategoryBig;
import team.spring.runup.running.vo.CategoryMedium;
import team.spring.runup.running.vo.Running;

public interface RunningDao {

	List<CategoryBig> selectCategoryBigAll();
	
	List<CategoryMedium> selectCategoryMediumAll();
	
	List<Running> selectRunningList(Running run);
	
	List<Running> selectRunningByKeyword(String keyword);
	
	int createRunning(Running run);
	
	int deleteRunning(Running run);
	
	int updateRunning(Running run);

}
