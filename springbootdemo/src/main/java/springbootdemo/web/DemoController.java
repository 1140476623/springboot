package springbootdemo.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;

import springbootdemo.bean.Demo;
import springbootdemo.service.DemoService;

@RestController
@RequestMapping("/demo")
public class DemoController {

	@Resource
	private DemoService demoServier;
	
	@RequestMapping("/getDemo")
	public Demo getDemo(){
		Demo demo = new Demo();
		demo.setId(1L);
		demo.setName("Tom");
		/*demo.setTime(new Date());*/
		return  demo;
	}
	
	@RequestMapping("/getFastJson")
	public String getFastJson(){
		Demo demo = new Demo();
		demo.setId(2L);
		demo.setName("JACK");
		return JSONObject.toJSONString(demo);
	}
	
	@RequestMapping("/zeroException")
	public int Exception(){
		return 100/0;
	}
	
	@RequestMapping("/save")
	public String save(){
		Demo demo = new Demo();
		demo.setName("Tom");
		/*demo.setTime(new Date());*/
		demoServier.sava(demo);
		return "保存成功！";
	}
	
	@RequestMapping("/getById")
	public String getById(){
		Demo demo = demoServier.getById(1);
		System.out.println(demo);
		return JSONObject.toJSONString(demo);
	}
	
	
	@RequestMapping("/getAll")
	public Iterable<Demo> getAll(){
		return demoServier.getAll();
	}
	
	@RequestMapping("/findById")
	public String findById(Long id){
		Demo demo = demoServier.findById(id);
		System.out.println(demo);
		return JSONObject.toJSONString(demo);
	}
	
	@RequestMapping("/findMyId")
	public Demo findMyId(Long id){
		Demo demo = demoServier.findMyId(id);
		System.out.println(demo);
		//return JSONObject.toJSON(demo);
		return demo;
	}
	
	@RequestMapping("/findMyName")
	public List<Demo> findMyName(String name){
		PageHelper.startPage(1, 2);
		return demoServier.findByName(name);
	}
	@RequestMapping("/findMybatisId")
	public Demo findMybatisId(long id){
		return demoServier.findById(id);
	}
	
	@PostMapping("/saveDemo")
	public Demo saveDemo(@RequestBody Demo demo){
		/*Demo demo = new Demo();
		demo.setName("张三");
		demo.setTime(new Date());*/
		System.out.println(demo);
		demoServier.saveDemo(demo);
		return demo;
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable String id){
		System.out.println(id);
		return "删除成功！！！";
	}
}
