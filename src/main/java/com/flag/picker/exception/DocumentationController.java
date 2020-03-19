package com.flag.picker.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
/**
 * @author Rajeev kumar
 *
 */
@RestController
@RequestMapping(value = "/documentation")
public class DocumentationController {

	// Wrapper for swagger API handler
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public RedirectView documentation(HttpServletRequest request) {
		return new RedirectView(request.getContextPath() + "/swagger-ui.html");
	}

}
