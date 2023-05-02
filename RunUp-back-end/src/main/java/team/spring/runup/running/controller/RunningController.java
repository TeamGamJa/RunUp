package team.spring.runup.running.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import team.spring.runup.question.service.QuestionService;
import team.spring.runup.question.vo.Question;
import team.spring.runup.running.service.RunningService;
import team.spring.runup.running.vo.Category;
import team.spring.runup.running.vo.RunCalender;
import team.spring.runup.running.vo.Running;
import team.spring.runup.running.vo.Runup;
import team.spring.runup.user.service.UserService;
import team.spring.runup.user.vo.User;



@RestController
@RequestMapping(value="running",produces="application/json; charset=UTF-8")
@CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
public class RunningController {

Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private RunningService runningservice;
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private QuestionService questionservice;
	
	@GetMapping(value="category")
	public HashMap<Object, Object> searchCategoryAll() throws JsonProcessingException {
		
		List<String> categoryBig = runningservice.getCategoryBigAll();
		List<String> categoryMedium = runningservice.getCategoryMediumAll();
		
		log.debug(categoryBig);
		log.debug(categoryMedium);
		
		HashMap<Object, Object> hashmap = new HashMap<Object, Object>();
		hashmap.put("categoryBig", categoryBig);
		hashmap.put("categoryMedium", categoryMedium);
		
		
		return hashmap;
	}
	
	@GetMapping(value="categorybig")
	public HashMap<Object, Object> searchCategoryBig() throws JsonProcessingException {
		
		List<String> categoryBig = runningservice.getCategoryBigAll();
		
		log.debug(categoryBig);
		
		HashMap<Object, Object> hashmap = new HashMap<Object, Object>();
		hashmap.put("categoryBig", categoryBig);
		
		return hashmap;
	}
	
	@GetMapping(value="categorymedium")
	public HashMap<Object, Object> searchCategoryMedium(@RequestParam(value="categoryBig", 
			required=false) String categoryBig) throws JsonProcessingException {
		
		List<String> categoryMedium = runningservice.getCategoryMediumList(categoryBig);
		
		log.debug(categoryMedium);
		HashMap<Object, Object> hashmap = new HashMap<Object, Object>();
		hashmap.put("categoryMedium", categoryMedium);
		
		return hashmap;
	}
	
	@GetMapping(value="bar")
	public HashMap<Object, Object> barSearch(@RequestParam(value="keyword", required=false) String keyword) throws JsonProcessingException {
		
		List<Running> runninglist = runningservice.getRunningByKeyword(keyword); 
		List<User> userlist = userservice.getUserByNickname(keyword);
		List<Question> questionlist = questionservice.getQuestionByKeyword(keyword); 
		log.debug(runninglist);
		log.debug(userlist);
		log.debug(questionlist);
		HashMap<Object, Object> hashmap = new HashMap<Object, Object>();
		hashmap.put("runningList", runninglist);
		hashmap.put("userList", userlist);
		hashmap.put("questionList", questionlist);
		return hashmap;
	}
	
	@GetMapping(value="mentor")
	public ResponseEntity<List<User>> searchMentor(@RequestParam(value="keyword", required=false) String keyword) throws JsonProcessingException {
		
		log.debug(keyword);
		List<User> userList = userservice.getUserByNickname(keyword);
		log.debug(userList);
		
		return ResponseEntity.ok(userList);
	}
	
	@GetMapping(value="bycategorybig")
	public ResponseEntity<List<Runup>> searchRunningByCategoryBig(@RequestParam(value="categoryBig", required=false) String categoryBig) throws JsonProcessingException {
		
		List<Runup> runningList = runningservice.getRunningBycategoryBig(categoryBig); 
		log.debug(runningList);
		return ResponseEntity.ok(runningList);
	}
	
	@GetMapping(value="bycategorymedium")
	public ResponseEntity<List<Runup>> searchRunningByCategoryMedium(@RequestParam(value="categoryBig", required=false) String categoryBig,
			@RequestParam(value="categoryMedium", required=false) String categoryMedium) throws JsonProcessingException {
		
		List<Runup> runningList = runningservice.getRunningBycategoryMedium(categoryMedium); 
		log.debug(runningList);
		return ResponseEntity.ok(runningList);
	}
	
	@GetMapping(value="all")
	public ResponseEntity<List<Runup>> searchRunningAll() throws JsonProcessingException {
		
		List<Runup> runningList = runningservice.getRunningList(); 
		log.debug(runningList);
		return ResponseEntity.ok(runningList);
	}
	
	@GetMapping(value="alltake")
	public ResponseEntity<List<RunCalender>> takeRunningAll(@RequestParam(value="participateNum", required=false) int participateNum) throws JsonProcessingException {
		
		List<RunCalender> runningGreen = runningservice.getRunningByParticipateNum(participateNum); 
		log.debug(runningGreen);
		return ResponseEntity.ok(runningGreen);
	}
	
	@GetMapping(value="allgive")
	public HashMap<Object, Object> giveRunningAll(@RequestParam(value="userNum", required=false) int userNum) throws JsonProcessingException {
		
		
		List<RunCalender> runningOrange = runningservice.getRunningByRunningAble(userNum); 
		List<RunCalender> runningBlue = runningservice.getRunningByRunningAbleTrue(userNum);  
		List<RunCalender> runningGray = runningservice.getRunningByRunningShow(userNum); 
		
		log.debug(runningOrange);
		log.debug(runningBlue);
		log.debug(runningGray);
		HashMap<Object, Object> hashmap = new HashMap<Object, Object>();
		hashmap.put("runningOrange", runningOrange);
		hashmap.put("runningBlue", runningBlue);
		hashmap.put("runningGray", runningGray);
		return hashmap;
	}
	
	@GetMapping
	public ResponseEntity<Running> searchRunning(@RequestParam(value="runningNum", required=false) int runningNum) throws JsonProcessingException {
		
		Running run = new Running();
		run.setRunningNum(runningNum);
		runningservice.updateViewNum(run);
		Running runningOne = runningservice.getRunning(run); 
		log.debug(runningOne);
		return ResponseEntity.ok(runningOne);
	}
	
	@PostMapping
	public ResponseEntity<Integer> createRunning(@RequestBody Running run)  {

		log.debug(run);
		//log.debug(okay);
		int result = runningservice.createRunning(run);
		log.debug(result);
		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping
	public ResponseEntity<Integer> deleteRunning(@RequestBody Running run) {
		
		log.debug(run);
		int result = runningservice.deleteRunning(run);
		log.debug(result);
		return ResponseEntity.ok(result);
	}
	
	@PutMapping
	public ResponseEntity<Integer> updateRunning(@RequestBody Running run) {
		
		log.debug(run);
		int result = runningservice.updateRunning(run);
		log.debug(result);
		
		return ResponseEntity.ok(result);
	}
	
	@PutMapping(value="participation")
	public ResponseEntity<Integer> participateRunning(@RequestBody Running run) {
		
		log.debug(run);
		//int mypoint = runningservice.getRunningPoint(run);
		//if (mypoint >= 30) {
			
		int registerresult=runningservice.createRegister(run);
		int result = runningservice.updateRunningAble(run);
		//}
		return ResponseEntity.ok(result);
	}
	
	@PutMapping(value="cancellation")
	public ResponseEntity<Integer> participateCancel(@RequestBody Running run) {
		
		log.debug(run);
		int registerresult=runningservice.deleteRegister(run);
		int result = runningservice.updateRunningAble(run);
				
		return ResponseEntity.ok(result);
	}
	
	@PutMapping(value="salt")
	public ResponseEntity<Integer> saltRunning(@RequestBody Map<Object,Object> salt) {
		
		int runningnum = (int) salt.get("runningNum");
		int usercolor = (int) salt.get("userLuxColor");
		int usernum = runningservice.getUserNumByRunningNum(runningnum);
		User user = new User();
		user.setUserNum(usernum);
		user.setUserLuxColor(usercolor);
		int result = runningservice.updateSalt(user);
		log.debug(result);
		
		return ResponseEntity.ok(result);
	}
}
