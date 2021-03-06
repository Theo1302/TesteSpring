package br.com.view;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.control.AlunoControler;
import br.com.dao.AlunoDao;

@Controller
public class Principal {

	@Autowired
	private AlunoControler alunoControler;

	@Autowired
	private AlunoDao alunoDao;



	@RequestMapping("/")
	public String welcolme() {
		// ModelAndView model = new ModelAndView("index");
		// new ConJdbc();
		// model.addObject("aluno", new Aluno());
		return "index";
	}



	@RequestMapping(value = {"/lista"}, method = RequestMethod.GET)
	public ModelAndView add() {

		return new ModelAndView("private/lista");
	}

	/** Upload single file using Spring Controller */

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody
	String uploadFileHandler(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) {

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists()) {
					dir.mkdirs();
				}

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				/*
				 * AlunoDao alunoDao = new AlunoDao(); alunoDao.salvarArquivo(serverFile);
				 */

				System.out.println("new de AlunoDao>>>>" + this.alunoDao);
				this.alunoDao.salvarArquivo(serverFile);
				serverFile.delete();
				System.out.println("Server File Location=" + serverFile.getAbsolutePath());

				return "You successfully uploaded file=" + name;
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + name + " because the file was empty.";
		}
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ModelAndView download(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FileCopyUtils.copy(this.alunoDao.find(1), response.getOutputStream());
		return null;

	}
	/*
	 * @RequestMapping(value = "/login") public String login() { return "login.jsp"; }
	 */
}
