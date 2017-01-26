package Tao.Action;

import java.util.Date;
import java.util.HashMap;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Tao.Model.User;


@RestController
@RequestMapping(value="/")
public class IndexAction {

	@RequestMapping
	public String index(){
		
		return "Hello world!";
	}
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String hello(){
		return "Hello world!";
	}
	@RequestMapping(value="/echo",method=RequestMethod.GET)
	public String echo(@RequestParam(value="msg",required=false) String msg){
		if(msg==null||msg==""){
			return "";
		}
		String res=msg;
		return res;
		
	}
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public HashMap<String, Object> get(@RequestParam String name){
		HashMap<String, Object> map=new HashMap<String,Object>();
		map.put("title", "hello world");
		map.put("name", name);
		return map;
	}
	
	@RequestMapping(value="/get/{id}/{name}")
	public User getUser(@PathVariable int id,@PathVariable String name){
		User user=new User();
		user.setId(id);
		user.setName(name);
		user.setDate(new Date());
		return user;
	}
	
}
