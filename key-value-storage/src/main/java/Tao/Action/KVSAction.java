package Tao.Action;

import java.util.HashMap;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;



@RestController
@RequestMapping(value="/kvs")
public class KVSAction {
 public static final HashMap<String,Object> hm=new HashMap<String,Object>();
 
 
 @RequestMapping(value="/{msg}",method=RequestMethod.PUT,produces="application/json;charset=UTF-8")
 public JSONObject putValue(@PathVariable String msg){
	 String[] strs=msg.split(" ");
	 String key=strs[0];
	 int index=strs[2].indexOf('=');
	 String value=strs[2].substring(index+1, strs[2].length()-1);
	 JSONObject jo=new JSONObject();
	 if(hm.containsKey(key)){
		 hm.put(key, value);
		 jo.put("replace", "1");
		 jo.put("msg", "success");
	 }else{
		 hm.put(key, value);
		 jo.put("replace", "1");
		 jo.put("msg", "success");
	 }
	 return jo;
 }
 @RequestMapping(value="/{msg}",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
 public @ResponseBody JSONObject getValue(@PathVariable String msg) {
	 JSONObject jo=new JSONObject();
	 /*
	 if(msg==null||msg.length()==0){
		 jo.put("msg", "error");
		 jo.put("error", "key does not exist");
		 return jo;
	 }
	 */
	 if(hm.containsKey(msg)){
		 Object object=hm.get(msg);
		 jo.put("msg", "success");
		 jo.put("value", object);
		 
	 }else{
		 jo.put("msg", "error");
		 jo.put("error", "key does not exist");
	 }
	 return jo;
 }
 @RequestMapping(value="/{msg}",method=RequestMethod.DELETE,produces="application/json;charset=UTF-8")
 public JSONObject deleteValue(@PathVariable String msg) {
	 JSONObject jo=new JSONObject();
	 if(!hm.containsKey(msg)){
		 jo.put("msg", "error");
		 jo.put("error", "key does not exist");
		 
	 }else{
		 hm.remove(msg);
		 jo.put("msg", "success");
	 }
	 return jo;
 }
 
}
