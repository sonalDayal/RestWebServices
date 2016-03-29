package spring.restful.controller;


import java.io.FileNotFoundException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import spring.restful.dao.GetProductDetailsDAO;
import spring.restful.model.ProductDetails;

@RestController
public class GetProductDetailsService {
	
    @RequestMapping(value="/getProduct")
    public @ResponseBody ResponseEntity<String> getProductMethod1(@RequestParam(value="itemcode", defaultValue="#1234") String itemcode,HttpServletRequest req,ModelMap model,@ModelAttribute("prDetails") ProductDetails prDetails) throws FileNotFoundException {
    	
    	System.out.println("Hi inside the service call");
    	/*GetProductDetailsDAO pdDao=new GetProductDetailsDAO("#1234");
    	prDetails=pdDao.getProductDetails(itemcode);
    	System.out.println(prDetails.getDescription());
    	model.addAttribute("prDetails",prDetails);
    	//return "ViewCart";
    	//ModelAndView mav = new ModelAndView("ViewCart");
		//return mav;
*/    	return new ResponseEntity<String>("Success", HttpStatus.OK);
   	  
    } 
    
    @RequestMapping(value = "/*", method = RequestMethod.GET)
    public ModelAndView index() {
    	System.out.println("hi in login");
    	ModelAndView mav = new ModelAndView("login");
    	
  	  return mav;
    }
    
    @RequestMapping(value = "/Success", method = RequestMethod.GET)
    public ModelAndView showProductDetails(@RequestParam(value="itemcode", defaultValue="#1234") String itemcode,HttpServletRequest req,ModelMap model) throws FileNotFoundException {
    	
    	System.out.println("inside /success");
    	GetProductDetailsDAO pdDao=new GetProductDetailsDAO();
    	Map<String, ProductDetails> prDetails = pdDao.getProductDetails();
    	System.out.println("prDetails size......"+prDetails.size());
    	model.addAttribute("prDetails",prDetails);
    	ModelAndView mav = new ModelAndView("ViewCart");
    	
  	  return mav;
    }
    
  /*  @RequestMapping("/getProduct/{itemcode}")
    public @ResponseBody ModelAndView getProductMethod2(@PathVariable(value="itemcode")  String itemcode) throws Exception {
    	GetProductDetailsDAO pdDao=new GetProductDetailsDAO();
    	
    	ModelAndView mav = new ModelAndView("ViewCart");
    	
  	  return mav;
    }
  */
    
}