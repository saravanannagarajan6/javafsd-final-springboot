package com.fse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fse.bean.ProjectManagerBean;
import com.fse.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
    @RequestMapping(
            value = "/addUser", method = RequestMethod.POST)
	public ResponseEntity<Object> addUser(@RequestBody ProjectManagerBean projectManagerBean) {
		ProjectManagerBean projectManagerBean1 = null;
		projectManagerBean1 = new ProjectManagerBean();
		projectManagerBean1.setEmployeeId(projectManagerBean.getEmployeeId());
		projectManagerBean1.setFirstName(projectManagerBean.getFirstName());
		projectManagerBean1.setLastName(projectManagerBean.getLastName());
		userService.addUser(projectManagerBean1);
		return new ResponseEntity<>("User is created successfully", HttpStatus.CREATED);
    }
    
    @RequestMapping(
            value = "/editUser", method = RequestMethod.PUT)
	public ResponseEntity<Object> editUser(@RequestBody ProjectManagerBean projectManagerBean) {
    	ProjectManagerBean projectManagerBean1 = null;
			projectManagerBean1 = new ProjectManagerBean();
			projectManagerBean1.setEmployeeId(projectManagerBean.getUserId());
			projectManagerBean1.setFirstName(projectManagerBean.getFirstName());
			projectManagerBean1.setLastName(projectManagerBean.getLastName());
			userService.editUser(projectManagerBean1);
			return new ResponseEntity<>("User is updated successsfully", HttpStatus.OK);
	}

    @RequestMapping(
            value = "/deleteUser/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteUser(@PathVariable("id") int userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<>("User is deleted successsfully", HttpStatus.OK);
	}
    
    @RequestMapping(
            value = "/viewUser", method = RequestMethod.GET)
	public ResponseEntity<Object> viewUser() {
		return new ResponseEntity<>(userService.listUser(), HttpStatus.OK);
	}

}
