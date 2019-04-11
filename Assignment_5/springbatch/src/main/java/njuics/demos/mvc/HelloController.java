package njuics.demos.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Controller
public class HelloController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		model.addAttribute("message", "Spring MVC Hello World");
		return "hello";

	}

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		ModelAndView model = new ModelAndView();
		model.setViewName("hello");
		model.addObject("msg", name);

		return model;

	}

	@RequestMapping(value = "/batch/csv2xml/{name:.+}", method = RequestMethod.GET)
	public ModelAndView csv2xml(@PathVariable("name") String name) {

		ModelAndView model = new ModelAndView();

		String[] springConfig = {"spring/batch/jobs/job-hello-world-csv2xml.xml"};

		ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("helloWorldJob");

		try{

			JobExecution execution = jobLauncher.run(job, new JobParameters());
			System.out.println("Exit Status : " + execution.getStatus());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}

		System.out.println("Job Done");
		model.setViewName("hello");
		model.addObject("msg", name + "(csv2xml Job Done)");


		return model;

	}

	@RequestMapping(value = "/batch/csv2json/{name:.+}", method = RequestMethod.GET)
	public ModelAndView csv2json(@PathVariable("name") String name) {

		ModelAndView model = new ModelAndView();

		String[] springConfig = {"spring/batch/jobs/job-hello-world-csv2json.xml"};

		ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("helloWorldJob");


		try {

			JobExecution execution = jobLauncher.run(job, new JobParameters());
			System.out.println("Exit Status : " + execution.getStatus());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}

		System.out.println("Job Done");
		model.setViewName("hello");
		model.addObject("msg", name+ "(csv2json Job Done)");


		return model;

	}


}