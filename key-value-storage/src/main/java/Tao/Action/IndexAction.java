package Tao.Action;

import java.util.Date;
import java.util.HashMap;
import Tao.Model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/")
public class IndexAction {

	@RequestMapping
	public String index(){
		
		return "hello world";
	}
	@RequestMapping(value="/hello")
	public String hello(){
		return "hello world";
	}
	@RequestMapping(value="/echo")
	public String echo(@RequestParam String msg){
		String res=msg;
		return res;
		
	}
	@RequestMapping(value="/get")
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
