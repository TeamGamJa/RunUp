package team.spring.runup.running.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.spring.runup.running.dao.RunningDao;
import team.spring.runup.running.vo.Category;
import team.spring.runup.running.vo.Running;
import team.spring.runup.running.vo.Runup;
import team.spring.runup.user.dao.UserDao;
import team.spring.runup.user.vo.User;

@Service
public class RunningService {
	
	@Autowired
	private RunningDao dao;
	
	@Autowired
	private UserDao udao;
	
	public List<String> getCategoryBigAll() {
		List<String> list = dao.getCategoryBigAll();
		return list;
	}
	
	public List<String> getCategoryMediumAll() {
		List<String> list = dao.getCategoryMediumAll();
		return list;
	}
	
	public List<String> getCategoryMediumList(String categoryBig) {
		List<String> list = dao.getCategoryMediumList(categoryBig);
		return list;
	}
	
	public List<Runup> getRunningList() {
		int i=0 ;
		List<Running> list = dao.getRunningList();
		List<Runup> resultList = new ArrayList<>();
		while (i<list.size()) {
			Running running = list.get(i);
			User user = udao.getUserByNum(running.getUserNum());
			int num = running.getUserNum();
			int cnt = dao.getMentorByUserNum(num);
			Runup runup = new Runup();
			runup.setRunningNum(running.getRunningNum());
			runup.setRunningTitle(running.getRunningTitle());
			runup.setUserNickname(user.getUserNickname());
			runup.setRunningCategoryMedium(running.getRunningCategoryMedium());
			runup.setUserLuxColor(user.getUserLuxColor());
			runup.setUserMentorCnt(cnt);
			SimpleDateFormat newDtFormat = new SimpleDateFormat("yyyy-MM-dd");
			String newrunningdate = newDtFormat.format(running.getRunningDate());
			runup.setRunningDate(newrunningdate);
			runup.setRunningAble(running.isRunningAble());
			resultList.add(runup);
			i++;
		}
		return resultList;
	}
	
	public Running getRunning(Running run) {
		Running running = dao.getRunning(run);
		return running;
	}
	
	public List<Runup> getRunningBycategoryBig(String categoryBig) {
		int i=0;
		List<Running> list = dao.getRunningBycategoryBig(categoryBig);
		List<Runup> resultList = new ArrayList<>();
		while (i<list.size()) {
			Running running = list.get(i);
			User user = udao.getUserByNum(running.getUserNum());
			int num = running.getUserNum();
			int cnt = dao.getMentorByUserNum(num);
			Runup runup = new Runup();
			runup.setRunningNum(running.getRunningNum());
			runup.setRunningTitle(running.getRunningTitle());
			runup.setUserNickname(user.getUserNickname());
			runup.setRunningCategoryMedium(running.getRunningCategoryMedium());
			runup.setUserLuxColor(user.getUserLuxColor());
			runup.setUserMentorCnt(cnt);
			SimpleDateFormat newDtFormat = new SimpleDateFormat("yyyy-MM-dd");
			String newrunningdate = newDtFormat.format(running.getRunningDate());
			runup.setRunningDate(newrunningdate);
			runup.setRunningAble(running.isRunningAble());
			resultList.add(runup);
			i++;
		}
		return resultList;
	}
	
	public List<Runup> getRunningBycategoryMedium(String categoryMedium) {
		int i=0;
		List<Running> list = dao.getRunningBycategoryMedium(categoryMedium);
		List<Runup> resultList = new ArrayList<>();
		while (i<list.size()) {
			Running running = list.get(i);
			User user = udao.getUserByNum(running.getUserNum());
			int num = running.getUserNum();
			int cnt = dao.getMentorByUserNum(num);
			Runup runup = new Runup();
			runup.setRunningNum(running.getRunningNum());
			runup.setRunningTitle(running.getRunningTitle());
			runup.setUserNickname(user.getUserNickname());
			runup.setRunningCategoryMedium(running.getRunningCategoryMedium());
			runup.setUserLuxColor(user.getUserLuxColor());
			runup.setUserMentorCnt(cnt);
			SimpleDateFormat newDtFormat = new SimpleDateFormat("yyyy-MM-dd");
			String newrunningdate = newDtFormat.format(running.getRunningDate());
			runup.setRunningDate(newrunningdate);
			runup.setRunningAble(running.isRunningAble());
			resultList.add(runup);
			i++;
		}
		return resultList;
	}
	
	public List<Running> getRunningByKeyword(String keyword) {
		List<Running> list = dao.getRunningByKeyword(keyword);
		return list;
	}
	
	public int getUserNumByRunningNum(int runningnum) {
		int num = dao.getUserNumByRunningNum(runningnum);
		return num;
	}
	
	public int createRunning(Running run) {
		int result = dao.createRunning(run);
		return result;
	}
	
	public int createRegister(Running run) {
		int result = dao.createRegister(run);
		return result;
	}
	
	public int deleteRegister(Running run) {
		int result = dao.deleteRegister(run);
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
	
	public int updateRunningAble(Running run) {
		int result = dao.updateRunningAble(run);
		return result;
	}
	
	public int updateViewNum(Running run) {
		int result = dao.updateRunningView(run);
		return result;
	}
	
	public int updateSalt(User user) {
		int result = udao.updateUserLuxColor(user);
		return result;
	}

}
